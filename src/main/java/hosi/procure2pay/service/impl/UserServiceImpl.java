package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.mapper.UserMapper;
import hosi.procure2pay.model.request.CreateUserRequest;
import hosi.procure2pay.model.response.CreateUserResponse;
import hosi.procure2pay.service.repo.UserRepoService;
import hosi.procure2pay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepoService userRepoService;
    private final UserMapper userMapper;

    @Override
    public CreateUserResponse addUser(CreateUserRequest request) {
        UserEntity userEntity = new UserEntity();

        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(request.getPassword());
        userEntity.setRole(request.getRole());
        userRepoService.save(userEntity);

        CreateUserResponse response = userMapper.toCreateUserResponse(userEntity);
        return response;
    }
}
