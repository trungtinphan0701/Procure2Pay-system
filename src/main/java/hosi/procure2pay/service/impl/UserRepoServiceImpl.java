package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.repository.UserRepository;
import hosi.procure2pay.service.UserRepoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserRepoServiceImpl implements UserRepoService {
    private UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity findById(Integer userId) {
        if (userId == null) {
            throw new ResponseException(BadRequestError.USER_ID_NULL);
        }

        Optional<UserEntity> userEntity = userRepository.findById(userId);

        if (userEntity.isPresent()) {
            return userEntity.get();
        } else {
            throw new ResponseException(BadRequestError.USER_NOT_FOUND);
        }
    }


}
