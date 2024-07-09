package hosi.procure2pay.service;

import hosi.procure2pay.model.request.AuthenticationRequest;
import hosi.procure2pay.model.request.RegisterRequest;
import hosi.procure2pay.model.response.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
