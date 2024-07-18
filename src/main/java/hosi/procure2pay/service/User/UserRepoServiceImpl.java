package hosi.procure2pay.service.User;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import hosi.procure2pay.entity.QUserEntity;
import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.model.request.User.SearchUserRequest;
import hosi.procure2pay.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRepoServiceImpl implements UserRepoService {
    private final UserRepository userRepository;

    // save user entity to database
    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    // find user by id
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

    // find user by email
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

    // check if email input already exists in database (user is unique with each email)
    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    // delete user by id
    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            throw new ResponseException(BadRequestError.USER_ID_NULL);
        }
        userRepository.deleteById(id);
    }

    // search function (can search by first name, last name, role)
    @Override
    public Page<UserEntity> search(SearchUserRequest request) {
        Predicate predicate = buildPredicateSearchUser(request);

        Sort sort = Sort.by(List.of(
                new Sort.Order(Sort.Direction.ASC, "firstName")
        ));

        PageRequest pageRequest = PageRequest.of(request.getPageNumber(), request.getPageSize(), sort);

        return userRepository.findAll(predicate, pageRequest);
    }

    private Predicate buildPredicateSearchUser(SearchUserRequest request) {
        BooleanBuilder builder = new BooleanBuilder();

        if (request.getFirstName() != null && !request.getFirstName().isEmpty()) {
            builder.and(QUserEntity.userEntity.firstName.like("%" + request.getFirstName() + "%"));
        }

        if (request.getLastName() != null && !request.getLastName().isEmpty()) {
            builder.and(QUserEntity.userEntity.lastName.like(request.getLastName() + "%"));
        }

        if (request.getRole() != null) {
            builder.and(QUserEntity.userEntity.role.eq(request.getRole()));
        }

        return builder;
    }
}
