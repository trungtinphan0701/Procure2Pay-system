package hosi.procure2pay.service.Authentication;

import hosi.procure2pay.model.request.Authentication.AuthenticationRequest;
import hosi.procure2pay.model.request.Authentication.RegisterRequest;
import hosi.procure2pay.model.response.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse changePassword(String username, String newPassword);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
