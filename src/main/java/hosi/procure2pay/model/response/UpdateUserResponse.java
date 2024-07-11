package hosi.procure2pay.model.response;

import hosi.procure2pay.model.enums.UserRole;
import lombok.Data;
import org.apache.catalina.User;

@Data
public class UpdateUserResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole role;
}
