package completablefuture.reactor;

import completablefuture.common.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springreactive.reactivestreams.UserReactorService;
import springreactive.reactivestreams.repository.ArticleReactorRepository;
import springreactive.reactivestreams.repository.FollowReactorRepository;
import springreactive.reactivestreams.repository.ImageReactorRepository;
import springreactive.reactivestreams.repository.UserReactorRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserReactorServiceTest {
    UserReactorService userReactorService;
    UserReactorRepository userRepository;
    ArticleReactorRepository articleRepository;
    ImageReactorRepository imageRepository;
    FollowReactorRepository followRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserReactorRepository();
        articleRepository = new ArticleReactorRepository();
        imageRepository = new ImageReactorRepository();
        followRepository = new FollowReactorRepository();

        userReactorService = new UserReactorService(
                userRepository, articleRepository, imageRepository, followRepository
        );
    }

    @Test
    void getUserEmptyIfInvalidUserIdIsGiven() {
        // given
        String userId = "invalid_user_id";

        // when
        Optional<User> user = userReactorService.getUserById(userId).blockOptional();

        // then
        assertTrue(user.isEmpty());
    }

    @Test
    void testGetUser() {
        // given
        String userId = "1234";

        // when
        Optional<User> optionalUser = userReactorService.getUserById(userId).blockOptional();

        // then
        assertFalse(optionalUser.isEmpty());
        var user = optionalUser.get();
        assertEquals(user.getName(), "taewoo");
        assertEquals(user.getAge(), 32);

        assertFalse(user.getProfileImage().isEmpty());
        var image = user.getProfileImage().get();
        assertEquals(image.getId(), "image#1000");
        assertEquals(image.getName(), "profileImage");
        assertEquals(image.getUrl(), "https://dailyone.com/images/1000");

        assertEquals(2, user.getArticleList().size());

        assertEquals(1000, user.getFollowCount());
    }
}