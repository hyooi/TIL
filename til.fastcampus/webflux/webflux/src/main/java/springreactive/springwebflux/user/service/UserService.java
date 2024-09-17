package springreactive.springwebflux.user.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import springreactive.springwebflux.user.common.User;
import springreactive.springwebflux.user.repository.UserReactorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserReactorRepository userReactorRepository = new UserReactorRepository();

    public Mono<User> findById(String id) {
        return userReactorRepository.findById(id)
                .map(userEntity ->
                        new User(userEntity.getId(), userEntity.getName(), userEntity.getAge(),
                                Optional.empty(),
                                List.of(), 0L));
    }
}
