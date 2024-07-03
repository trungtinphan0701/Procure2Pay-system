package hosi.procure2pay.controller;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.model.response.Response;
import hosi.procure2pay.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/add")
    public Response<UserEntity> addUser(@RequestBody UserEntity user) {
        return new Response<>(userService.addUser(user));
    }
}
