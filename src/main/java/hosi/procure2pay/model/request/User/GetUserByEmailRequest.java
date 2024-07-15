package hosi.procure2pay.model.request.User;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GetUserByEmailRequest {
    private String email;
}
