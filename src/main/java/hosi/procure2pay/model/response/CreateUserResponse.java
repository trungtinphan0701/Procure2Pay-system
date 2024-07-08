package hosi.procure2pay.model.response;

import lombok.Data;

@Data
public class CreateUserResponse {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    // how to show enum type?
    private String role;
}
