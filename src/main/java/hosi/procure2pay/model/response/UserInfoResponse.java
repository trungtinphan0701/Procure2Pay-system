package hosi.procure2pay.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String role;
}
