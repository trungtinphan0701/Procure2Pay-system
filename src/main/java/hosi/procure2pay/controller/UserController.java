package hosi.procure2pay.controller;

import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.model.request.*;
import hosi.procure2pay.model.response.*;
import hosi.procure2pay.service.AuthenticationService;
import hosi.procure2pay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
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
    public Response<List<CreateUserResponse>> addSupplierItemMany(@RequestBody List<CreateUserRequest> users) {
        List<CreateUserResponse> responses = new ArrayList<>();

        for (CreateUserRequest user  : users) {
            responses.add(userService.addUser(user));
        }

        return new Response<>(responses);
    }

    @GetMapping("/email")
    @PreAuthorize("hasRole('ADMIN')")
    public Response<GetUserByEmailResponse> getUserByEmail(@RequestBody GetUserByEmailRequest request) {
        return new Response<>(userService.getUserByEmail(request));
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyRole('ADMIN','APPROVER','PURCHASER')")
    public Response<UpdateUserResponse> updateUser(@RequestBody UpdateUserRequest user) {
        return new Response<>(userService.updateUser(user));
    }

    @PutMapping("/update/role")
    @PreAuthorize("hasRole('ADMIN')")
    public Response<UpdateUserResponse> updateUserRole(@RequestBody UpdateUserRoleRequest userRole) {
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

}
