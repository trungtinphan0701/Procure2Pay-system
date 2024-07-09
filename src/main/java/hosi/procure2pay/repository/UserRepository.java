package hosi.procure2pay.repository;

import hosi.procure2pay.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByFirstName(String firstName);
    Optional<UserEntity> findByLastName(String lastName);
    boolean existsByEmail(String email);
}
