package hosi.procure2pay.service.repo;

import hosi.procure2pay.entity.UserEntity;

public interface UserRepoService {
    UserEntity save(UserEntity user);
    UserEntity findById(Integer id);
}
