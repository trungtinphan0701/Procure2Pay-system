package hosi.procure2pay.model.request.User;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UpdateUserRequest {
    private Integer id;
    private String firstName;
    private String lastName;
}
