package hosi.procure2pay.service.repo;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.model.request.UpdateUserRequest;
import hosi.procure2pay.model.response.UpdateUserResponse;
import org.hibernate.sql.Update;

import java.util.Optional;

// functions: save user, find user by id, find user by email (forget password)
// check existed user (email)
public interface UserRepoService {
    UserEntity save(UserEntity user);
    UserEntity findById(Integer id);
    UserEntity findByEmail(String email);
    boolean existsByEmail(String email);
    void deleteById(Integer id);
}
