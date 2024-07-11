package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.*;
import hosi.procure2pay.model.response.*;
import hosi.procure2pay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public Response<CreateUserResponse> addUser(@RequestBody CreateUserRequest user) {
        return new Response<>(userService.addUser(user));
    }

    @PostMapping("/add-many")
    public Response<List<CreateUserResponse>> addSupplierItemMany(@RequestBody List<CreateUserRequest> users) {
        List<CreateUserResponse> responses = new ArrayList<>();

        for (CreateUserRequest user  : users) {
            responses.add(userService.addUser(user));
        }

        return new Response<>(responses);
    }

    @GetMapping("/email")
    public Response<GetUserByEmailResponse> getUserByEmail(@RequestBody GetUserByEmailRequest request) {
        return new Response<>(userService.getUserByEmail(request));
    }

    @PutMapping("/update")
    public Response<UpdateUserResponse> updateUser(@RequestBody UpdateUserRequest user) {
        return new Response<>(userService.updateUser(user));
    }

    @PutMapping("/update/role")
    public Response<UpdateUserResponse> updateUserRole(@RequestBody UpdateUserRoleRequest userRole) {
        return new Response<>(userService.updateUserRole(userRole));
    }

    @DeleteMapping("/delete/{id}")
    public Response<CreateUserResponse> deleteUser(@PathVariable Integer id) {
        return new Response<>(userService.deleteUser(id));
    }
}
