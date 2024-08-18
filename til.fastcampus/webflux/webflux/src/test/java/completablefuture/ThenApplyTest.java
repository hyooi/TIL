package completablefuture;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThenApplyTest {

    @Test
    void thenApplyTest() throws InterruptedException {
        var stage = Helper.finishedStage();
        stage.thenApplyAsync(value -> {
            var next = value+1;
            log.info("in thenApplyAsync: {}", next);

            return next;
        }).thenApplyAsync(value -> {
            var next = "result: " + value;
            log.info("in thenApplyAsync2: {}", next);

            return next;
        }).thenApplyAsync(value -> {
            var next = value.equals("result: 2");
            log.info("in thenApplyAsync3: {}", next);

            return next;
        }).thenAcceptAsync(value -> log.info("{}", value));

        Thread.sleep(100);
    }
}
