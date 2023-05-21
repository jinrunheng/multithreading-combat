package chapter1;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author Dooby Kim
 * @Date 2023/5/21 8:44 下午
 * @Version 1.0
 */
@Slf4j
public class MapExample {

    private static Map<Integer, Integer> map = Maps.newHashMap();

    private static int threadNum = 200;
    private static int clientNum = 5000;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadNum);
        for (int i = 0; i < clientNum; i++) {
            final int finalI = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    func(finalI);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("error", e);
                }
            });
        }
        executorService.shutdown();
        log.info("size : {}", map.size());
    }

    private static void func(int threadNum) {
        map.put(threadNum, threadNum);
    }
}
