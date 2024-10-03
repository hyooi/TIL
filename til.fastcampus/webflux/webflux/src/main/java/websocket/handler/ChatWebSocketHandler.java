package websocket.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RequiredArgsConstructor
@Component
public class ChatWebSocketHandler implements WebSocketHandler {
    private final ChatService chatService;

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        String iam = (String) session.getAttributes().get("iam");

        Flux<Chat> chatFlux = chatService.register(iam);
        chatService.sendChat(iam, new Chat("system", iam + "님 채팅방에 오신 것을 환영합니다."));

        session.receive()
                .doOnNext(webSocketMessage -> {
                    String payload = webSocketMessage.getPayloadAsText();

                    String[] splits = payload.split(":");
                    String to = splits[0].trim();
                    String message = splits[1].trim();

                    boolean result = chatService.sendChat(to, new Chat(iam, message));
                    if (!result) {
                        chatService.sendChat(iam, new Chat("system", "대화상대가 없습니다."));
                    }

                }).subscribe();

        return session.send(subscriber -> chatFlux.delayElements(Duration.ofMillis(100))
                .map(chat -> session.textMessage(chat.getFrom() + ":" + chat.getMessage())).subscribe());
    }
}
