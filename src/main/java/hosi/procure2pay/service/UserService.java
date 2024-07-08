package hosi.procure2pay.service;

import hosi.procure2pay.model.request.CreateUserRequest;
import hosi.procure2pay.model.response.CreateUserResponse;

public interface UserService {
    CreateUserResponse addUser(CreateUserRequest request);
}
