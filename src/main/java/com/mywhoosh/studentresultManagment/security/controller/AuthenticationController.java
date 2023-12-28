package com.mywhoosh.studentresultManagment.security.controller;

import com.mywhoosh.studentresultManagment.base.AbstractBaseController;
import com.mywhoosh.studentresultManagment.security.dto.AuthenticationRequest;
import com.mywhoosh.studentresultManagment.security.dto.AuthenticationResponse;
import com.mywhoosh.studentresultManagment.security.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController extends AbstractBaseController<AuthenticationService> {


    public AuthenticationController(AuthenticationService service) {
        super(service);
    }

    /*  @PostMapping("/register")
      public ResponseEntity<AuthenticationResponse> register(
          @RequestBody RegisterRequest request
      ) {
        return ResponseEntity.ok(service.register(request));
      }*/
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }


}
