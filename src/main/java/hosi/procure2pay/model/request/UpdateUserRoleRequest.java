package hosi.procure2pay.model.request;

import hosi.procure2pay.model.enums.UserRole;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UpdateUserRoleRequest {
    private Integer id;
    private UserRole role;
}
