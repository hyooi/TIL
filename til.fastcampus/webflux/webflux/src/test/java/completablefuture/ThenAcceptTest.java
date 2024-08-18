package completablefuture;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ThenAcceptTest {

    @Test
    void finished_thenAcceptTest() throws InterruptedException {
        log.info("start main");

        var stage = Helper.finishedStage();
        stage.thenAccept(i -> { //done상태에서는 caller스레드에서 하위 메소드를 실행함
            log.info("{} in thenAccept", i);
        }).thenAccept(i -> {
            log.info("{} in thenAccept2", i);
        });

        log.info("after thenAccept");

        Thread.sleep(100);
    }

    @Test
    void finished_thenAcceptAsyncTest() throws InterruptedException {
        log.info("start main");

        var stage = Helper.finishedStage();
        stage.thenAcceptAsync(i -> { //callee스레드에서 하위 메소드를 실행함
            log.info("{} in thenAcceptAsync", i);
        }).thenAcceptAsync(i -> {
            log.info("{} in thenAcceptAsync2", i);
        });

        log.info("after thenAcceptAsync");

        Thread.sleep(100);
    }

    @Test
    void running_thenAcceptTest() throws InterruptedException {
        log.info("start main");

        var stage = Helper.runningStage();
        stage.thenAccept(i -> { //실행중이면 동일한 callee스레드에서 실행
            log.info("{} in thenAccept", i);
        }).thenAccept(i -> {
            log.info("{} in thenAccept2", i);
        });

        log.info("after thenAccept");

        Thread.sleep(2000);
    }

    @Test
    void running_thenAcceptAsyncTest() throws InterruptedException {
        log.info("start main");

        var stage = Helper.runningStage();
        stage.thenAcceptAsync(i -> { //서로다른 callee스레드에서 실행
            log.info("{} in thenAcceptAsync", i);
        }).thenAcceptAsync(i -> {
            log.info("{} in thenAcceptAsync2", i);
        });

        log.info("after thenAcceptAsync");

        Thread.sleep(2000);
    }


}