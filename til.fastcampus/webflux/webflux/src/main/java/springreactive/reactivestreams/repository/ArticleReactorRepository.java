package springreactive.reactivestreams.repository;

import completablefuture.common.ArticleEntity;
import completablefuture.common.UserEntity;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.ContextView;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Slf4j
public class ArticleReactorRepository {
    private static List<ArticleEntity> articleEntities;

    public ArticleReactorRepository() {
        articleEntities = List.of(
                new ArticleEntity("1", "소식1", "내용1", "1234"),
                new ArticleEntity("2", "소식2", "내용2", "1234"),
                new ArticleEntity("3", "소식3", "내용3", "1234"),
                new ArticleEntity("4", "소식4", "내용4", "1234"),
                new ArticleEntity("5", "소식5", "내용5", "1234"),
                new ArticleEntity("6", "소식6", "내용6", "1234"),
                new ArticleEntity("7", "소식7", "내용7", "1234"),
                new ArticleEntity("8", "소식8", "내용8", "1234"),
                new ArticleEntity("9", "소식9", "내용9", "1234"),
                new ArticleEntity("10", "소식10", "내용10", "1234"),
                new ArticleEntity("11", "소식11", "내용11", "1234")
        );
    }

    @SneakyThrows
    public Flux<ArticleEntity> findAllByUserId(String userId) {
        return Flux.create(sink -> {
            log.info("ArticleRepository.findAllByUserId: {}", userId);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            articleEntities.stream()
                    .filter(articleEntity -> articleEntity.getUserId().equals(userId))
                    .forEach(sink::next);

            sink.complete();
        });
    }

    @SneakyThrows
    public Flux<ArticleEntity> findAllWithContext() {
        return Flux.deferContextual(contextView -> {
                Optional<UserEntity> userOptional = contextView.getOrEmpty("user");
                if (userOptional.isEmpty()) {
                    throw new RuntimeException("user not found");
                }

                return Mono.just(userOptional.get().getId());
        }).flatMap(this::findAllByUserId);
    }
}