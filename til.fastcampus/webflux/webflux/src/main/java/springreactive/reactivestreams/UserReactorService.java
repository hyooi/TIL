package springreactive.reactivestreams;

import completablefuture.common.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;
import springreactive.reactivestreams.repository.ArticleReactorRepository;
import springreactive.reactivestreams.repository.FollowReactorRepository;
import springreactive.reactivestreams.repository.ImageReactorRepository;
import springreactive.reactivestreams.repository.UserReactorRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class UserReactorService {
    private final UserReactorRepository userRepository;
    private final ArticleReactorRepository articleRepository;
    private final ImageReactorRepository imageRepository;
    private final FollowReactorRepository followRepository;

    @SneakyThrows
    public Mono<User> getUserById(String id) {
        return userRepository.findById(id)
                .flatMap(this::getUser);
    }

    @SneakyThrows
    private Mono<User> getUser(UserEntity userEntity) {
        var context = Context.of("user", userEntity);
        var imageMono = imageRepository.findWithContext()
                .map(imageEntity -> {
                    return new Image(imageEntity.getId(), imageEntity.getName(), imageEntity.getUrl());
                }).onErrorReturn(new EmptyImage())
                .contextWrite(context);

        var articlesMono = articleRepository.findAllWithContext()
                .skip(5)
                .take(2)
                .map(articleEntity -> {
                    return new Article(articleEntity.getId(), articleEntity.getTitle(), articleEntity.getContent());
                }).collectList()
                .contextWrite(context);

        var followCountMono = followRepository.countWithContext()
                .contextWrite(context);

        return Mono.zip(imageMono, articlesMono, followCountMono)
                .map(resultTuple -> {
                    var image = resultTuple.getT1();
                    var articles = resultTuple.getT2();
                    long followCount = resultTuple.getT3();

                    Optional<Image> imageOptional = Optional.empty();
                    if (!(image instanceof  EmptyImage)) {
                        imageOptional = Optional.of(image);
                    }

                    return new User(
                            userEntity.getId(),
                            userEntity.getName(),
                            userEntity.getAge(),
                            imageOptional,
                            articles,
                            followCount
                    );
                });
    }
}