package springreactive.springwebflux.user.service;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import springreactive.springwebflux.user.common.EmptyImage;
import springreactive.springwebflux.user.common.Image;
import springreactive.springwebflux.user.common.User;
import springreactive.springwebflux.user.repository.UserReactorRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    private WebClient webClient = WebClient.create("http://localhost:8081");
    private final UserReactorRepository userReactorRepository = new UserReactorRepository();

    public Mono<User> findById(String id) {
        return userReactorRepository.findById(id)
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

                                return new User(userEntity.getId(), userEntity.getName(), userEntity.getAge(),
                                        profileImage,
                                        List.of(), 0L);
                            });
                });
    }
}