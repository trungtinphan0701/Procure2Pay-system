package hosi.procure2pay.model.request;

import hosi.procure2pay.model.enums.UserRole;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    // how to input enum type?
    private UserRole role;
}
