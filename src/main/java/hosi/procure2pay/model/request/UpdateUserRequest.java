package hosi.procure2pay.model.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UpdateUserRequest {
    private Integer id;
    private String firstName;
    private String lastName;
    private String password;
}
