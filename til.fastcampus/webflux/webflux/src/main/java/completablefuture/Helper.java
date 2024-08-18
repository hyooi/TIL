package completablefuture;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Slf4j
@UtilityClass
public class Helper {

    @SneakyThrows
    public CompletionStage<Integer> finishedStage() {
        var future = CompletableFuture.supplyAsync(() -> {
            log.info("return in future");

            return 1;
        });

        Thread.sleep(100);
        return future;
    }

    public CompletionStage<Integer> runningStage() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                log.info("I'm running!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 1;
        });
    }
}
