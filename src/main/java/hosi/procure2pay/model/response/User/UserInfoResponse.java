package hosi.procure2pay.model.response.User;

import hosi.procure2pay.model.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoResponse {
    private String firstName;
    private String lastName;
    private String email;
    private UserRole role;
}
