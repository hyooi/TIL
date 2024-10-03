package r2dbc.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import r2dbc.user.common.EmptyImage;
import r2dbc.user.common.Image;
import r2dbc.user.common.User;
import r2dbc.user.common.UserEntity;
import r2dbc.user.repository.UserR2dbcRepository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private WebClient webClient = WebClient.create("http://localhost:8081");
    private final UserR2dbcRepository userReactorRepository;

    public Mono<User> findById(String id) {
        return userReactorRepository.findById(Long.valueOf(id))
                .flatMap(userEntity -> {
                    var imageId = userEntity.getProfileImageId();
                    var uriVariables = Map.of("imageId", imageId);
                    return webClient.get()
                            .uri("/api/image/{imageId}", uriVariables)
                            .retrieve()
                            .toEntity(ImageResponse.class)
                            .map(HttpEntity::getBody)
                            .map(imageResp -> new Image(
                                    imageResp.getId(),
                                    imageResp.getName(),
                                    imageResp.getUrl()
                            )).switchIfEmpty(Mono.just(new EmptyImage()))
                            .map(image -> {
                                Optional<Image> profileImage = Optional.empty();
                                if (!(image instanceof EmptyImage)) {
                                    profileImage = Optional.of(image);
                                }

                                return map(userEntity, profileImage);
                            });
                });
    }

    public Mono<User> createUser(String name, Integer age, String password, String profileImageId) {
        var newUser = new UserEntity(name, age, profileImageId, password);
        return userReactorRepository.save(newUser)
                .map(userEntity -> map(userEntity, Optional.of(new EmptyImage())));
    }

    private User map(UserEntity entity, Optional<Image> profileImage) {
        return new User(entity.getId(), entity.getName(), entity.getAge(), profileImage, List.of(), 0L);
    }
}