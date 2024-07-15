package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.model.response.User.CreateUserResponse;
import hosi.procure2pay.model.response.User.GetUserByEmailResponse;
import hosi.procure2pay.model.response.User.UpdateUserResponse;
import hosi.procure2pay.model.response.User.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {
    public UserInfoResponse toUserInfoResponse(UserEntity user) {
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setFirstName(user.getFirstName());
        userInfoResponse.setLastName(user.getLastName());
        userInfoResponse.setEmail(user.getEmail());
        userInfoResponse.setRole(user.getRole());
//        userInfoResponse.setRole(user.getRole().getRoleName());
        return userInfoResponse;
    }

    public CreateUserResponse toCreateUserResponse(UserEntity user) {
        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setUserId(user.getId());
        createUserResponse.setFirstName(user.getFirstName());
        createUserResponse.setLastName(user.getLastName());
        createUserResponse.setEmail(user.getEmail());
        createUserResponse.setRole(user.getRole());
//        createUserResponse.setRole(user.getRole().getRoleName());
        createUserResponse.setPassword(user.getPassword());
        return createUserResponse;
    }

    public GetUserByEmailResponse toGetUserByEmailResponse(UserEntity user) {
        GetUserByEmailResponse getUserByEmailResponse = new GetUserByEmailResponse();
        getUserByEmailResponse.setUserId(user.getId());
        getUserByEmailResponse.setFirstName(user.getFirstName());
        getUserByEmailResponse.setLastName(user.getLastName());
        getUserByEmailResponse.setRole(user.getRole());
//        getUserByEmailResponse.setRole(user.getRole().getRoleName());
//        getUserByEmailResponse.setPassword(user.getPassword());
        getUserByEmailResponse.setEmail(user.getEmail());
        return getUserByEmailResponse;
    }

    public UpdateUserResponse toUpdateUserResponse(UserEntity requestUser) {
        UpdateUserResponse updateUserResponse = new UpdateUserResponse();
        updateUserResponse.setFirstName(requestUser.getFirstName());
        updateUserResponse.setLastName(requestUser.getLastName());
//        updateUserResponse.setPassword(requestUser.getPassword());
        updateUserResponse.setRole(requestUser.getRole());
        updateUserResponse.setEmail(requestUser.getEmail());
        return updateUserResponse;
    }

    public List<UserInfoResponse> toUserInfoResponsesList(List<UserEntity> users) {
        List<UserInfoResponse> userInfoResponses = new ArrayList<>();
        for (UserEntity user : users) {
            UserInfoResponse userInfoResponse = this.toUserInfoResponse(user);
            userInfoResponses.add(userInfoResponse);
        }

        return userInfoResponses;
    }

}
