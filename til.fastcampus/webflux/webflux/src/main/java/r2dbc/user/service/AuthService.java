package r2dbc.user.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class AuthService {
    private static final Map<String, String> tokenMap = Map.of("abcd", "1234");

    public Mono<String> getNameByToken(String token) {
        return Mono.justOrEmpty(tokenMap.get(token));
    }
}
