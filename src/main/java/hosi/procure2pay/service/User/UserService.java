package hosi.procure2pay.service.User;

import hosi.procure2pay.model.request.User.*;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.User.CreateUserResponse;
import hosi.procure2pay.model.response.User.UserInfoResponse;

public interface UserService {
    CreateUserResponse addUser(CreateUserRequest request);
    UserInfoResponse getUser(Integer id);
    UserInfoResponse getUserProfile(String username);
    UserInfoResponse updateUser(UpdateUserRequest request);
    UserInfoResponse updateUserRole(UpdateUserRoleRequest request);
    CreateUserResponse deleteUser(Integer id);
    PagedResult<UserInfoResponse> searchUsers(SearchUserRequest request);
}
