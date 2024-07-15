package hosi.procure2pay.service.User;

import hosi.procure2pay.model.request.User.*;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.User.CreateUserResponse;
import hosi.procure2pay.model.response.User.GetUserByEmailResponse;
import hosi.procure2pay.model.response.User.UpdateUserResponse;
import hosi.procure2pay.model.response.User.UserInfoResponse;

public interface UserService {
    CreateUserResponse addUser(CreateUserRequest request);
    GetUserByEmailResponse getUserByEmail(GetUserByEmailRequest email);
    UpdateUserResponse updateUser(UpdateUserRequest request);
    CreateUserResponse deleteUser(Integer id);
    UpdateUserResponse updateUserRole(UpdateUserRoleRequest request);
    PagedResult<UserInfoResponse> searchUsers(SearchUserRequest request);
}
