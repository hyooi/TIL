package springreactive.springwebflux.user.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import springreactive.springwebflux.user.auth.IamAuthentication;
import springreactive.springwebflux.user.service.AuthService;

@RequiredArgsConstructor
@Component
public class SecurityWebFilter implements WebFilter {
    private final AuthService authService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        final var resp = exchange.getResponse();
        var iam = exchange.getRequest()
                .getHeaders()
                .getFirst("X-I-AM");
        if (iam == null) {
            resp.setStatusCode(HttpStatus.UNAUTHORIZED);
            return resp.setComplete();
        }

        return authService.getNameByToken(iam)
                .map(IamAuthentication::new)
                .flatMap(auth -> {
                    return chain.filter(exchange)
                            .contextWrite(context -> {
                                var newContext = ReactiveSecurityContextHolder.withAuthentication(auth);
                                return context.putAll(newContext);
                            });

                }).switchIfEmpty(Mono.defer(() -> {
                    resp.setStatusCode(HttpStatus.UNAUTHORIZED);
                    return resp.setComplete();
                }));
    }
}
