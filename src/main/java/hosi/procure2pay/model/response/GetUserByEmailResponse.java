package hosi.procure2pay.model.response;

import lombok.Data;

@Data
public class GetUserByEmailResponse {
    private Integer userId;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String role;
}
