package hosi.procure2pay.model.request.User;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUserByEmailRequest {
    private String email;
}
