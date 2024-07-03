package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.service.repo.UserRepoService;
import hosi.procure2pay.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepoService userRepoService;

    @Override
    public UserEntity addUser(UserEntity user) {
        return userRepoService.save(user);
    }
}
