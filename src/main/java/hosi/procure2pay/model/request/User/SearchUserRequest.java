package hosi.procure2pay.model.request.User;

import hosi.procure2pay.model.enums.UserRole;
import hosi.procure2pay.utils.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchUserRequest {
    private String firstName;
    private String lastName;
    private UserRole role;

    private Integer pageSize = Constants.DEFAULT_PAGE_SIZE;
    private Integer pageNumber = Constants.DEFAULT_PAGE_NUMBER;
}
