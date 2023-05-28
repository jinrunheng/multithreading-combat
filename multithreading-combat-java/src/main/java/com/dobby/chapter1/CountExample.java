package com.dobby.chapter1;

import com.dobby.annotations.UnSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author Dooby Kim
 * @Date 2023/5/21 8:11 下午
 * @Version 1.0
 * @Desc 计数器
 */
@Slf4j
@UnSafe
public class CountExample {

    private static int threadTotal = 200;
    private static int clientTotal = 5000;

    private static long count = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("error", e);
                }
            });
        }
        executorService.shutdown();
        log.info("count : {}", count);
    }

    private static void add() {
        count++;
    }
}
