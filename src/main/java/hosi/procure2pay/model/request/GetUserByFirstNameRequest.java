package hosi.procure2pay.model.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GetUserByFirstNameRequest {
    private String firstName;
}
