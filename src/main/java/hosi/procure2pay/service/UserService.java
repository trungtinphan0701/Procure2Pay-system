package hosi.procure2pay.service;

import hosi.procure2pay.model.request.*;
import hosi.procure2pay.model.response.*;

public interface UserService {
    CreateUserResponse addUser(CreateUserRequest request);
    GetUserByEmailResponse getUserByEmail(GetUserByEmailRequest email);
    UpdateUserResponse updateUser(UpdateUserRequest request);
    CreateUserResponse deleteUser(Integer id);
    UpdateUserResponse updateUserRole(UpdateUserRoleRequest request);
}
