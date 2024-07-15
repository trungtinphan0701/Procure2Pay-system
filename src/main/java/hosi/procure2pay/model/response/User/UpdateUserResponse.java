package hosi.procure2pay.model.response.User;

import hosi.procure2pay.model.enums.UserRole;
import lombok.Data;

@Data
public class UpdateUserResponse {
    private String firstName;
    private String lastName;
    private String email;
//    private String password;
    private UserRole role;
}
