package hosi.procure2pay.service.User;

import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.model.request.User.SearchUserRequest;
import org.springframework.data.domain.Page;

// functions: save user, find user by id, find user by email (forget password)
// check existed user (email)
public interface UserRepoService {
    UserEntity save(UserEntity user);
    UserEntity findById(Integer id);
    UserEntity findByEmail(String email);
    boolean existsByEmail(String email);
    void deleteById(Integer id);
    Page<UserEntity> search(SearchUserRequest request);
}
