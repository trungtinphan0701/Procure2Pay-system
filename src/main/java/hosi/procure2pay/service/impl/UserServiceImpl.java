package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.service.UserRepoService;
import hosi.procure2pay.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepoService userRepoService;

    @Override
    public UserEntity addUser(UserEntity user) {
        return userRepoService.save(user);
    }
}
