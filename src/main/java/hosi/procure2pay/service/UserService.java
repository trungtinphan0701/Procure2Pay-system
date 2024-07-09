package hosi.procure2pay.service;

import hosi.procure2pay.model.request.CreateUserRequest;
import hosi.procure2pay.model.request.GetUserByEmailRequest;
import hosi.procure2pay.model.request.GetUserByFirstNameRequest;
import hosi.procure2pay.model.request.GetUserByLastNameRequest;
import hosi.procure2pay.model.response.CreateUserResponse;
import hosi.procure2pay.model.response.GetUserByEmailResponse;
import hosi.procure2pay.model.response.GetUserByFirstNameResponse;
import hosi.procure2pay.model.response.GetUserByLastNameResponse;

public interface UserService {
    CreateUserResponse addUser(CreateUserRequest request);
    GetUserByEmailResponse getUserByEmail(GetUserByEmailRequest email);
//    GetUserByFirstNameResponse getUserByFirstName(GetUserByFirstNameRequest request);
//    GetUserByLastNameResponse getUserByLastName(GetUserByLastNameRequest request);
}
