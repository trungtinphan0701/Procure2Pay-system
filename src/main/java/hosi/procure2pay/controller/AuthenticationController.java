package hosi.procure2pay.controller;

import hosi.procure2pay.configuration.JwtService;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.model.request.AuthenticationRequest;
import hosi.procure2pay.model.request.ChangePasswordRequest;
import hosi.procure2pay.model.request.RegisterRequest;
import hosi.procure2pay.model.response.AuthenticationResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.service.AuthenticationService;
import hosi.procure2pay.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public Response<AuthenticationResponse> register(
            @RequestBody RegisterRequest request) {
        return new Response<>(service.register(request));
    }

    @PostMapping("/authenticate")
    public Response<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request) {
        return new Response<>(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }

}
