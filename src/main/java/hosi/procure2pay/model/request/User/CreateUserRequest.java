package hosi.procure2pay.model.request.User;

import hosi.procure2pay.model.enums.UserRole;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String password;
    private UserRole role;
    private String email;
}
