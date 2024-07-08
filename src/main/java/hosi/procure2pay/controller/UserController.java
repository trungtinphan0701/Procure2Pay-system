package hosi.procure2pay.controller;

import hosi.procure2pay.model.request.CreateSupplierItemRequest;
import hosi.procure2pay.model.request.CreateUserRequest;
import hosi.procure2pay.model.response.CreateSupplierItemResponse;
import hosi.procure2pay.model.response.CreateUserResponse;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
