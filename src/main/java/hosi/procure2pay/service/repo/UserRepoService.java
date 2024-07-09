package hosi.procure2pay.service.repo;

import hosi.procure2pay.entity.UserEntity;

import java.util.Optional;

// functions: save user, find user by id, find user by email (forget password)
// check existed user (email)
public interface UserRepoService {
    UserEntity save(UserEntity user);
    UserEntity findById(Integer id);
    UserEntity findByEmail(String email);
//    UserEntity findByFirstName(String firstName);
//    UserEntity findByLastName(String lastName);
    boolean existsByEmail(String email);
}
