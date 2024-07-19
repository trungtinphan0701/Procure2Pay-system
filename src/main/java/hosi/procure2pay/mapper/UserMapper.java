package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.model.response.User.CreateUserResponse;
import hosi.procure2pay.model.response.User.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public CreateUserResponse toCreateUserResponse(UserEntity user) {
        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setUserId(user.getId());
        createUserResponse.setFirstName(user.getFirstName());
        createUserResponse.setLastName(user.getLastName());
        createUserResponse.setEmail(user.getEmail());
        createUserResponse.setRole(user.getRole());
        createUserResponse.setPassword(user.getPassword());
        return createUserResponse;
    }

    public UserInfoResponse toUserInfoResponse(UserEntity user) {
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setId(user.getId());
        userInfoResponse.setFirstName(user.getFirstName());
        userInfoResponse.setLastName(user.getLastName());
        userInfoResponse.setEmail(user.getEmail());
        userInfoResponse.setRole(user.getRole());
        return userInfoResponse;
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
