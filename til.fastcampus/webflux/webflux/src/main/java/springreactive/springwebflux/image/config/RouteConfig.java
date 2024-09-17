package springreactive.springwebflux.image.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import springreactive.springwebflux.image.handler.ImageHandler;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouteConfig {
    @Bean
    RouterFunction router(ImageHandler imageHandler) {
        return route()
                .path("/api", b1 -> b1
                        .path("/image", b2 -> b2.GET("/{imageId:[0-9]+}", imageHandler::getImageById)
                        )
                ).build();
    }
}
