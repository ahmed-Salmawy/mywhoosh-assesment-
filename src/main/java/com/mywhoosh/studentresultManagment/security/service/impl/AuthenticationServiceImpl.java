package com.mywhoosh.studentresultManagment.security.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mywhoosh.studentresultManagment.base.AbstractBaseService;
import com.mywhoosh.studentresultManagment.security.config.JwtService;
import com.mywhoosh.studentresultManagment.security.dto.AuthenticationRequest;
import com.mywhoosh.studentresultManagment.security.dto.AuthenticationResponse;
import com.mywhoosh.studentresultManagment.security.dto.TokenDto;
import com.mywhoosh.studentresultManagment.security.dto.UserDto;
import com.mywhoosh.studentresultManagment.security.repoadapter.UserRepoAdapter;
import com.mywhoosh.studentresultManagment.security.repoadapter.UserTokenRepoAdapter;
import com.mywhoosh.studentresultManagment.security.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@Slf4j
public class AuthenticationServiceImpl extends AbstractBaseService<TokenDto, UserTokenRepoAdapter> implements AuthenticationService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepoAdapter userRepoAdapter;

    private final UserDetailsService userDetailsService;
    private final UserTokenRepoAdapter tokenRepository;


    protected AuthenticationServiceImpl(UserTokenRepoAdapter tokenRepoAdapter, JwtService jwtService, AuthenticationManager authenticationManager, UserRepoAdapter userRepoAdapter, UserDetailsService userDetailsService, UserTokenRepoAdapter tokenRepository) {
        super(tokenRepoAdapter);
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userRepoAdapter = userRepoAdapter;
        this.userDetailsService = userDetailsService;
        this.tokenRepository = tokenRepository;
    }


    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var user = userRepoAdapter.getUser(request.getUsername());

        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    protected void saveUserToken(UserDto user, String jwtToken) {
        TokenDto token = TokenDto.builder()
                .user(user)
                .token(jwtToken)
                .expired(false)
                .revoked(false)
                .build();
        repoAdapter.create(token);

    }

    private void revokeAllUserTokens(UserDto user) {
        var validUserTokens = repoAdapter.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        repoAdapter.saveAll(validUserTokens);
    }

    @Override
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        Optional.ofNullable(jwtService.extractUsername(refreshToken))
                .ifPresent(username -> {
                    UserDto user = this.userRepoAdapter.getUser(username);
                    if (jwtService.isTokenValid(refreshToken, user)) {
                        var accessToken = jwtService.generateToken(user);
                        revokeAllUserTokens(user);
                        saveUserToken(user, accessToken);

                        var authResponse = AuthenticationResponse.builder()
                                .accessToken(accessToken)
                                .refreshToken(refreshToken)
                                .build();

                        try {
                            new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                });

    }


}
