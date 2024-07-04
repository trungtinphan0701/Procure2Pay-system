package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.UserEntity;
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
        return userInfoResponse;
    }
}
