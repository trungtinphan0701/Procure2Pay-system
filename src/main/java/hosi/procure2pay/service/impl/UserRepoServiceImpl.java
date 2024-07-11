package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.repository.UserRepository;
import hosi.procure2pay.service.repo.UserRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRepoServiceImpl implements UserRepoService {
    private final UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity findById(Integer id) {
        if (id == null) {
            throw new ResponseException(BadRequestError.USER_ID_NULL);
        } else {
            Optional<UserEntity> user = userRepository.findById(id);
            if (user.isPresent()) {
                return user.get();
            } else throw new ResponseException(BadRequestError.USER_NOT_FOUND);
        }

    }

    @Override
    public UserEntity findByEmail(String email) {
        if (email == null) {
            throw new ResponseException(BadRequestError.USER_EMAIL_NULL);
        } else {
            Optional<UserEntity> user = userRepository.findByEmail(email);
            if (user.isPresent()) {
                return user.get();
            } else throw new ResponseException(BadRequestError.USER_NOT_FOUND);
        }
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            throw new ResponseException(BadRequestError.USER_ID_NULL);
        }
        userRepository.deleteById(id);
    }
}
