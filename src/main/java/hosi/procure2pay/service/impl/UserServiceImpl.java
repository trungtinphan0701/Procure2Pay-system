package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.UserMapper;
import hosi.procure2pay.model.enums.UserRole;
import hosi.procure2pay.model.request.CreateUserRequest;
import hosi.procure2pay.model.request.GetUserByEmailRequest;
import hosi.procure2pay.model.request.GetUserByFirstNameRequest;
import hosi.procure2pay.model.request.GetUserByLastNameRequest;
import hosi.procure2pay.model.response.CreateUserResponse;
import hosi.procure2pay.model.response.GetUserByEmailResponse;
import hosi.procure2pay.model.response.GetUserByFirstNameResponse;
import hosi.procure2pay.model.response.GetUserByLastNameResponse;
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
        if (userRepoService.existsByEmail(request.getEmail()))  {
            throw new ResponseException(BadRequestError.USER_EMAIL_ALREADY_EXISTS);
        }
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

    @Override
    public GetUserByEmailResponse getUserByEmail(GetUserByEmailRequest request) {
        UserEntity userEntity = userRepoService.findByEmail(request.getEmail());

        GetUserByEmailResponse response = userMapper.toGetUserByEmailResponse(userEntity);
        return response;
    }

//    @Override
//    public GetUserByFirstNameResponse getUserByFirstName(GetUserByFirstNameRequest request) {
//        UserEntity userEntity = userRepoService.findByFirstName(request.getFirstName());
//
//        GetUserByFirstNameResponse response = userMapper.toGetUserByFirstNameResponse(userEntity);
//        return response;
//    }
//
//    @Override
//    public GetUserByLastNameResponse getUserByLastName(GetUserByLastNameRequest request) {
//        UserEntity userEntity = userRepoService.findByLastName(request.getLastName());
//
//        GetUserByLastNameResponse response = userMapper.toGetUserByLastNameResponse(userEntity);
//        return response;
//    }
}
