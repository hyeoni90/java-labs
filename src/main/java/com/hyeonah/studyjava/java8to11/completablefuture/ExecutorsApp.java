package com.hyeonah.studyjava.java8to11.completablefuture;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by hyeonahlee on 2020-10-27.
 */
public class ExecutorsApp {

    public static void main(String[] args) {
        // newSingleThreadExecutor: Thread 1개로 동작
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // newFixedThreadPool(2): Thread는 2개 지만 작업을 5개로 한다면, Thread 2개로 번갈아가면서 처리 한다.
        /*
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnable("Hello"));
        executorService.submit(getRunnable("Hyeonah"));
        executorService.submit(getRunnable("Java"));
        executorService.submit(getRunnable("World"));
        executorService.submit(getRunnable("Thread"));

        executorService.submit(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        });


        // graceful shutdown
        // executorService는 다른 작업이 들어오기 전까지 대기하기 때문에 process가 죽지 않기 때문에 명시적으로 shutdown 시켜줘야한다.
        executorService.shutdown();
//        executorService.shutdownNow();

        */

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
