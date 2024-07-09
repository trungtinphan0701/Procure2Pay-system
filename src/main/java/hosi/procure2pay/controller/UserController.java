package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.*;
import hosi.procure2pay.model.response.*;
import hosi.procure2pay.service.UserService;
import lombok.RequiredArgsConstructor;
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

//    @GetMapping("/first-name")
//    public Response<List<GetUserByFirstNameResponse>> getUserByFirstName(@RequestBody List<GetUserByFirstNameRequest> request) {
//        List<GetUserByFirstNameResponse> responses = new ArrayList<>();
//
//        for (GetUserByFirstNameRequest user : request) {
//            responses.add(userService.getUserByFirstName(user));
//        }
//
//        return new Response<>(responses);
//    }
//
//    @GetMapping("/last-name")
//    public Response<GetUserByLastNameResponse> getUserByLastName(@RequestBody GetUserByLastNameRequest request) {
//        return new Response<>(userService.getUserByLastName(request));
//    }
}
