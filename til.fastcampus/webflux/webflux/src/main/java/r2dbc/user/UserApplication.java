package r2dbc.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(UserApplication.class);
        app.setDefaultProperties(Map.of(
                "server.port", "8080",
                "spring.sql.init.schema-locations", "classpath*:schema.sql",
                "spring.sql.init.data-locations", "classpath*:data.sql",
                "spring.r2dbc.url", "r2dbc:h2:mem:///test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE",
                "spring.r2dbc.username", "sa",
                "spring.r2dbc.password", "",
                "h2.console.port", "8090"
        ));
        app.run(args);
    }
}
