package hosi.procure2pay.service.User;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.mapper.UserMapper;
import hosi.procure2pay.model.request.User.*;
import hosi.procure2pay.model.response.PagedResult;
import hosi.procure2pay.model.response.User.CreateUserResponse;
import hosi.procure2pay.model.response.User.UserInfoResponse;
import hosi.procure2pay.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepoService userRepoService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    // Add new user (Admin access only)
    @Override
    public CreateUserResponse addUser(CreateUserRequest request) {
        this.validateAddUserRequest(request);

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userEntity.setRole(request.getRole());
        userEntity.setCompanyAddress(request.getCompanyAddress());
        userRepoService.save(userEntity);

        CreateUserResponse response = userMapper.toCreateUserResponse(userEntity);
        return response;
    }

    // Get user by id (Admin access only)
    @Override
    public UserInfoResponse getUser(Integer id) {
        UserEntity userEntity = userRepoService.findById(id);
        return userMapper.toUserInfoResponse(userEntity);
    }

    @Override
    public UserInfoResponse getUserProfile(String username) {
        UserEntity userEntity = userRepoService.findByEmail(username);
        return userMapper.toUserInfoResponse(userEntity);
    }

    // Update user details (can only edit first name, last name)
    // for Admin, Approver and Purchaser
    @Override
    public UserInfoResponse updateUser(UpdateUserRequest request) {
        UserEntity userEntity = userRepoService.findById(request.getId());
        this.validateUpdateUserRequest(request);
        userRepoService.save(userEntity);
        UserInfoResponse updateUserResponse = userMapper.toUserInfoResponse(userEntity);
        return updateUserResponse;
    }

    // Update user role (Admin access only)
    @Override
    public UserInfoResponse updateUserRole(UpdateUserRoleRequest request) {
        UserEntity user = userRepoService.findById(request.getId());
        if (request.getRole() != null) {
            user.setRole(request.getRole());
        }
        userRepoService.save(user);
        return userMapper.toUserInfoResponse(user);
    }

    // Delete user (Admin access only)
    @Override
    public CreateUserResponse deleteUser(Integer id) {
        UserEntity userEntity = userRepoService.findById(id);
        userRepoService.deleteById(id);
        return userMapper.toCreateUserResponse(userEntity);
    }

    // Search function
    @Override
    public PagedResult<UserInfoResponse> searchUsers(SearchUserRequest request) {
        Page<UserEntity> userEntityPage = userRepoService.search(request);
        List<UserInfoResponse> userInfoResponseList = userMapper.toUserInfoResponsesList(userEntityPage.getContent());

        return new PagedResult<>(
                userInfoResponseList,
                userEntityPage.getTotalPages(),
                userEntityPage.getTotalElements(),
                request.getPageNumber(),
                request.getPageSize());
    }

    // Validate create user input
    private void validateAddUserRequest(CreateUserRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new ResponseException(BadRequestError.USER_EMAIL_NULL);
        }

        if (userRepoService.existsByEmail(request.getEmail()))  {
            throw new ResponseException(BadRequestError.USER_EMAIL_ALREADY_EXISTS);
        }

        if (request.getFirstName() == null || request.getFirstName().isEmpty()
                || request.getLastName() == null || request.getLastName().isEmpty() ) {
            throw new ResponseException(BadRequestError.NAME_MUST_NOT_BE_EMPTY);
        }

        if (!request.getFirstName().matches(Constants.NAME_REGEX) || !request.getLastName().matches(Constants.NAME_REGEX)) {
            throw new ResponseException(BadRequestError.NAME_MUST_NOT_CONTAIN_ANY_NUMBER_OR_SPECIAL_CHARACTER);
        }

        if (!request.getEmail().matches(Constants.EMAIL_REGEX)) {
            throw new ResponseException(BadRequestError.USER_EMAIL_INVALID);
        }
    }

    // Validate update user details input
    public void validateUpdateUserRequest(UpdateUserRequest request) {
        if (request.getFirstName() == null || request.getFirstName().isEmpty()
                || request.getLastName() == null || request.getLastName().isEmpty() ) {
            throw new ResponseException(BadRequestError.NAME_MUST_NOT_BE_EMPTY);
        }

        if (!request.getFirstName().matches(Constants.NAME_REGEX) || !request.getLastName().matches(Constants.NAME_REGEX)) {
            throw new ResponseException(BadRequestError.NAME_MUST_NOT_CONTAIN_ANY_NUMBER_OR_SPECIAL_CHARACTER);
        }
    }
}
