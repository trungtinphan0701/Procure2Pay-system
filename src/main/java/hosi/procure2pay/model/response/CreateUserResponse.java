package hosi.procure2pay.model.response;

import hosi.procure2pay.model.enums.UserRole;
import lombok.Data;

@Data
public class CreateUserResponse {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
}
