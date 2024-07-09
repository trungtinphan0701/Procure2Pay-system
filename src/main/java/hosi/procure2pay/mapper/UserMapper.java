package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.model.response.CreateUserResponse;
import hosi.procure2pay.model.response.UserInfoResponse;
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
//        userInfoResponse.setRole(user.getRole().getRoleName());
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
}
