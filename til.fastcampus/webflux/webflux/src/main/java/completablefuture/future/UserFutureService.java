package completablefuture.future;

import completablefuture.common.Article;
import completablefuture.common.Image;
import completablefuture.common.User;
import completablefuture.common.UserEntity;
import completablefuture.future.repository.ArticleFutureRepository;
import completablefuture.future.repository.FollowFutureRepository;
import completablefuture.future.repository.ImageFutureRepository;
import completablefuture.future.repository.UserFutureRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class UserFutureService {
    private final UserFutureRepository userRepository;
    private final ArticleFutureRepository articleRepository;
    private final ImageFutureRepository imageRepository;
    private final FollowFutureRepository followRepository;

    @SneakyThrows
    public CompletableFuture<Optional<User>> getUserById(String id) {
        return userRepository.findById(id)
                .thenComposeAsync(this::getUser);
    }

    @SneakyThrows
    private CompletableFuture<Optional<User>> getUser(Optional<UserEntity> user) {
        if (user.isEmpty()) {
            return CompletableFuture.completedFuture(Optional.empty());
        }

        var userEntity = user.get();
        var imageFuture = imageRepository.findById(userEntity.getProfileImageId())
                .thenApplyAsync(imageEntityOptional -> {
                    return imageEntityOptional.map(imageEntity -> {
                        return new Image(imageEntity.getId(), imageEntity.getName(), imageEntity.getUrl());
                    });
                });

        var articlesFuture = articleRepository.findAllByUserId(userEntity.getId())
                .thenApplyAsync(articleEntities -> {
                    return articleEntities.stream().map(articleEntity ->
                                    new Article(articleEntity.getId(), articleEntity.getTitle(), articleEntity.getContent()))
                            .collect(Collectors.toList());
                });

        var followCountFuture = followRepository.countByUserId(userEntity.getId());

        return CompletableFuture.allOf(imageFuture, articlesFuture, followCountFuture)
                .thenAcceptAsync(unused -> {
                    log.info("Three futures are completed.");
                })
                .thenRunAsync(() -> {
                    log.info("Three futures are completed.");
                })
                .thenApplyAsync(v -> {
                    try {
                        var image = imageFuture.get();
                        var articles = articlesFuture.get();
                        var followCount = followCountFuture.get();
                        return Optional.of(new User(
                                userEntity.getId(),
                                userEntity.getName(),
                                userEntity.getAge(),
                                image,
                                articles,
                                followCount
                        ));
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }

                });
    }
}