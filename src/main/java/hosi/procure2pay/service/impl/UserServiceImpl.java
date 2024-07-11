package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.UserMapper;
import hosi.procure2pay.model.enums.UserRole;
import hosi.procure2pay.model.request.*;
import hosi.procure2pay.model.response.*;
import hosi.procure2pay.service.repo.UserRepoService;
import hosi.procure2pay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepoService userRepoService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CreateUserResponse addUser(CreateUserRequest request) {
        if (userRepoService.existsByEmail(request.getEmail()))  {
            throw new ResponseException(BadRequestError.USER_EMAIL_ALREADY_EXISTS);
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userEntity.setRole(request.getRole());
        userRepoService.save(userEntity);

        CreateUserResponse response = userMapper.toCreateUserResponse(userEntity);
        return response;
    }

    @Override
    public GetUserByEmailResponse getUserByEmail(GetUserByEmailRequest request) {
        UserEntity userEntity = userRepoService.findByEmail(request.getEmail());

        GetUserByEmailResponse response = userMapper.toGetUserByEmailResponse(userEntity);
        return response;
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest request) {
        UserEntity userEntity = userRepoService.findById(request.getId());
        if (request.getFirstName() != null) {
            userEntity.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null) {
            userEntity.setLastName(request.getLastName());
        }
        if (request.getPassword() != null) {
            userEntity.setPassword(request.getPassword());
        }
        userRepoService.save(userEntity);
        UpdateUserResponse updateUserResponse = userMapper.toUpdateUserResponse(userEntity);
        return updateUserResponse;
    }

    @Override
    public CreateUserResponse deleteUser(Integer id) {
        UserEntity userEntity = userRepoService.findById(id);
        userRepoService.deleteById(id);
        return userMapper.toCreateUserResponse(userEntity);
    }

    @Override
    public UpdateUserResponse updateUserRole(UpdateUserRoleRequest request) {
        UserEntity user = userRepoService.findById(request.getId());
        if (request.getRole() != null) {
            user.setRole(request.getRole());
        }
        userRepoService.save(user);
        return userMapper.toUpdateUserResponse(user);
    }
}
