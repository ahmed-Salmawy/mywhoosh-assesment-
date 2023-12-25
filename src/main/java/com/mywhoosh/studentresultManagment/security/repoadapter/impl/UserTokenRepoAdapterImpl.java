package com.mywhoosh.studentresultManagment.security.repoadapter.impl;

import com.mywhoosh.studentresultManagment.base.AbstractBaseRepoAdapter;
import com.mywhoosh.studentresultManagment.presistance.entity.TokenEntity;
import com.mywhoosh.studentresultManagment.security.dto.TokenDto;
import com.mywhoosh.studentresultManagment.security.mapper.TokenMapper;
import com.mywhoosh.studentresultManagment.security.repo.TokenRepository;
import com.mywhoosh.studentresultManagment.security.repoadapter.UserTokenRepoAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class UserTokenRepoAdapterImpl extends
        AbstractBaseRepoAdapter<TokenEntity, TokenDto, TokenMapper, TokenRepository> implements
        UserTokenRepoAdapter {
    protected UserTokenRepoAdapterImpl(TokenMapper mapper, TokenRepository repository) {
        super(mapper, repository);
    }

    @Override
    public String create(TokenDto dto) {
        TokenEntity tokenEntity = mapper.toEntity(dto);
        repository.save(tokenEntity);
        return repository.save(tokenEntity).getId();
    }

    @Override
    public void update(TokenDto dto) {

    }

    @Override
    public void delete(TokenDto dto) {

    }

    @Override
    public TokenDto retrieve(String id) {
        return null;
    }

    @Override
    public List<TokenDto> findAllValidTokenByUser(String userId) {
        return null;
    }

    @Override
    public void saveAll(List<TokenDto> validUserTokens) {

    }

    @Override
    public Optional<TokenDto> findByToken(String token) {
        return repository.findByToken(token).map(mapper::toDto);
    }
}
