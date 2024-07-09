package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.model.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    public UserInfoResponse toUserInfoResponse(UserEntity user) {
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setFirstName(user.getFirstName());
        userInfoResponse.setLastName(user.getLastName());
        userInfoResponse.setEmail(user.getEmail());
        userInfoResponse.setRole(user.getRole().getRoleName());
        return userInfoResponse;
    }

    public CreateUserResponse toCreateUserResponse(UserEntity user) {
        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setUserId(user.getId());
        createUserResponse.setFirstName(user.getFirstName());
        createUserResponse.setLastName(user.getLastName());
        createUserResponse.setEmail(user.getEmail());
        createUserResponse.setRole(user.getRole().getRoleName());
        createUserResponse.setPassword(user.getPassword());
        return createUserResponse;
    }

    public GetUserByEmailResponse toGetUserByEmailResponse(UserEntity user) {
        GetUserByEmailResponse getUserByEmailResponse = new GetUserByEmailResponse();
        getUserByEmailResponse.setUserId(user.getId());
        getUserByEmailResponse.setFirstName(user.getFirstName());
        getUserByEmailResponse.setLastName(user.getLastName());
        getUserByEmailResponse.setRole(user.getRole().getRoleName());
        getUserByEmailResponse.setPassword(user.getPassword());
        getUserByEmailResponse.setEmail(user.getEmail());
        return getUserByEmailResponse;
    }

    public GetUserByFirstNameResponse toGetUserByFirstNameResponse(UserEntity user) {
        GetUserByFirstNameResponse getUserByFirstNameResponse = new GetUserByFirstNameResponse();
        getUserByFirstNameResponse.setUserId(user.getId());
        getUserByFirstNameResponse.setFirstName(user.getFirstName());
        getUserByFirstNameResponse.setLastName(user.getLastName());
        getUserByFirstNameResponse.setRole(user.getRole().getRoleName());
        getUserByFirstNameResponse.setPassword(user.getPassword());
        getUserByFirstNameResponse.setEmail(user.getEmail());
        return getUserByFirstNameResponse;
    }

    public GetUserByLastNameResponse toGetUserByLastNameResponse(UserEntity user) {
        GetUserByLastNameResponse getUserByLastNameResponse = new GetUserByLastNameResponse();
        getUserByLastNameResponse.setUserId(user.getId());
        getUserByLastNameResponse.setFirstName(user.getFirstName());
        getUserByLastNameResponse.setLastName(user.getLastName());
        getUserByLastNameResponse.setRole(user.getRole().getRoleName());
        getUserByLastNameResponse.setPassword(user.getPassword());
        getUserByLastNameResponse.setEmail(user.getEmail());
        return getUserByLastNameResponse;
    }
}
