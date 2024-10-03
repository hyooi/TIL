package r2dbc.user.config;

import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class H2ServerConfig {
    @Value("${h2.console.port}")
    private Integer port;
    private Server webServer;

    @EventListener(ContextRefreshedEvent.class)
    public void start() throws java.sql.SQLException {
        log.info("started h2 console at port {}.", port);
        this.webServer = Server.createWebServer("-webPort", port.toString()).start();
    }

    @EventListener(ContextClosedEvent.class)
    public void stop() {
        log.info("stopped h2 console at port {}.", port); this.webServer.stop();
    }
}