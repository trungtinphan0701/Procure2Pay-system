package hosi.procure2pay.model.response.User;

import hosi.procure2pay.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private UserRole role;
}
