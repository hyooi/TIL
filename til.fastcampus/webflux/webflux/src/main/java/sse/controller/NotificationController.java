package sse.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import sse.service.NotificationService;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@RequestMapping("/api/notifications")
@RestController
@Slf4j
public class NotificationController {
    private static AtomicInteger lastEventId = new AtomicInteger(1);
    private final NotificationService notificationService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> getNotifications() {
        return notificationService.getMessageFromSink()
                .map(message -> {
                    var id = lastEventId.getAndIncrement() + "";
                    return ServerSentEvent.builder(message)
                            .event("notification")
                            .id(id)
                            .comment("this is notification")
                            .build();
                });
    }

    @PostMapping
    public Mono<String> addNotification(@RequestBody Event event) {
        var notificationMessage = event.getType() + ": " + event.getMessage();
        notificationService.tryEmitNext(notificationMessage);

        return Mono.just("ok");
    }
}
