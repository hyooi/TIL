package r2dbc.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import r2dbc.user.common.User;
import r2dbc.user.controller.dto.ProfleImageResponse;
import r2dbc.user.controller.dto.SignupUserRequest;
import r2dbc.user.controller.dto.UserResponse;
import r2dbc.user.service.UserService;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public Mono<UserResponse> getUserById(@PathVariable(value = "userId") String userId) {
        return ReactiveSecurityContextHolder.getContext()
                .flatMap(context -> {
                    var name = context.getAuthentication().getName();
                    if (!name.equals(userId)) {
                        return Mono.error(new ResponseStatusException(HttpStatus.UNAUTHORIZED));
                    }

                    return userService.findById(userId)
                            .map(this::getUserResponse)
                            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
                });
    }

    private UserResponse getUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getAge(),
                user.getFollowCount(),
                user.getProfileImage().map(image ->
                        new ProfleImageResponse(
                                image.getId(),
                                image.getName(),
                                image.getUrl())
                )
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public Mono<UserResponse> signupUser(@RequestBody SignupUserRequest request) {
        log.info("request: {}", request);
        return userService.createUser(request.getName(), request.getAge(), request.getPassword(),
                request.getProfileImageId())
                .map(this::getUserResponse);
    }

}
