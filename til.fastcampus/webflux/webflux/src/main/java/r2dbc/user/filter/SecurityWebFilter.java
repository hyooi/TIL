package r2dbc.user.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import r2dbc.user.auth.IamAuthentication;
import r2dbc.user.service.AuthService;

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

        if (exchange.getRequest().getURI().getPath().equals("/api/users/signup")) {
            return chain.filter(exchange);
        }

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
