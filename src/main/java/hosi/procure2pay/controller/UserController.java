package hosi.procure2pay.controller;

import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.model.request.Authentication.ChangePasswordRequest;
import hosi.procure2pay.model.request.User.*;
import hosi.procure2pay.model.response.*;
import hosi.procure2pay.model.response.User.CreateUserResponse;
import hosi.procure2pay.model.response.User.UserInfoResponse;
import hosi.procure2pay.service.Authentication.AuthenticationService;
import hosi.procure2pay.service.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AuthenticationService authService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Response<CreateUserResponse> addUser(@RequestBody CreateUserRequest user) {
        return new Response<>(userService.addUser(user));
    }

    @PostMapping("/add-many")
    @PreAuthorize("hasRole('ADMIN')")
    public Response<List<CreateUserResponse>> addUserMany(@RequestBody List<CreateUserRequest> users) {
        List<CreateUserResponse> responses = new ArrayList<>();

        for (CreateUserRequest user  : users) {
            responses.add(userService.addUser(user));
        }

        return new Response<>(responses);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Response<UserInfoResponse> getUser(@PathVariable Integer id) {
        return new Response<>(userService.getUser(id));
    }

    @PostMapping("/profile")
    @PreAuthorize("hasAnyRole('ADMIN','APPROVER','PURCHASER', 'SUPPLIER_MANAGER')")
    public Response<GetUserByEmailResponse> getUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        return new Response<>(userService.getUserByEmail(
                GetUserByEmailRequest.builder()
                        .email(currentUsername)
                        .build())
        );
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyRole('ADMIN','APPROVER','PURCHASER')")
    public Response<UserInfoResponse> updateUser(@RequestBody UpdateUserRequest user) {
        return new Response<>(userService.updateUser(user));
    }

    @PutMapping("/update/role")
    @PreAuthorize("hasRole('ADMIN')")
    public Response<UserInfoResponse> updateUserRole(@RequestBody UpdateUserRoleRequest userRole) {
        return new Response<>(userService.updateUserRole(userRole));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Response<CreateUserResponse> deleteUser(@PathVariable Integer id) {
        return new Response<>(userService.deleteUser(id));
    }

    @PostMapping("/change-password")
    @PreAuthorize("hasAnyRole('ADMIN','APPROVER','PURCHASER')")
    public Response<?> changePassword(
            @RequestBody ChangePasswordRequest changePasswordRequest
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();

        // Authenticate with old password
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            currentUsername,
                            changePasswordRequest.getCurrentPassword()
                    )
            );
        } catch (AuthenticationException e) {
            return new Response<>(new ResponseException(BadRequestError.INVALID_CREDENTIALS));
        }

        //Check confirmation password is the same as new password
        if (!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmationPassword())) {
            return new Response<>(new ResponseException(BadRequestError.PASSWORD_MISMATCH));
        }

        //Change password
        AuthenticationResponse authResponse = authService.changePassword(currentUsername, changePasswordRequest.getNewPassword());
        return new Response<>(authResponse);
    }

    @PostMapping("/search")
    @PreAuthorize("hasRole('ADMIN')")
    public Response<PagedResult<UserInfoResponse>> search(@RequestBody SearchUserRequest request) {
        return new Response<>(userService.searchUsers(request));
    }

}
