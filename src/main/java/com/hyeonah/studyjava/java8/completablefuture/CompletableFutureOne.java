package com.hyeonah.studyjava.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hyeonahlee on 2020-10-27.
 *
 * @link https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html
 *
 * CompletableFuture: 자바 비동기 프로그래밍을 가능하게 하는 인터페이스!
 *
 * Future로 하기 힘들었던 작업들
 *  - 외부에서 완료 시킬 수 없고, 취소하거나 get()에 타임아웃을 설정할 수는 있다.
 *  - blocking code(get())를 사용하지 않고서는 작업이 끝났을 때 롤백을 실행할 수 없다.
 *  - 여러 Future를 조합할 수 없다. ex) Event 정보를 가져온 다음 Event에 참석하는 회원 목록 가져오기..
 *  - 예외 처리용 API를 제공하지 않는다.
 *
 * 비동기 작업 실행
 *  - return 값이 없는 경우: runAsync()
 *  - return 값이 잇는 경우: supplyAsync()
 *  - 원하는 Executor(thread pool)을 사용해서 실행할 수 있다. (기본, ForkJoinPool.commonPool)
 *
 * CallBack 제공
 *  - thenApply(Function): return 값을 받아서 다른 값으로 바꾸는 콜백
 *  - thenCombine(Consumer): return 값을 또 다른 작업을 처리하는 콜백 (return 없이!)
 *  - thenRun(Runnable): return 값 받지 다른 작업을 처리하는 콜백
 */
public class CompletableFutureOne {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(4);

//        Future<String> future = executorService.submit(() -> "hello");
//        future.get(); // get(): blocking call이기 때문에 get전에 작업들을 해야함!

        // 1. constructor
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("hyeonah");

        System.out.println(future.get());

        // 2. static factory method and `return이 없는 작업` runAysnc
        CompletableFuture<Void> notExistReturnFuture = CompletableFuture.runAsync(() ->{
            System.out.println("Hello, " + Thread.currentThread().getName());
        });
        System.out.println(notExistReturnFuture.get());

        // 2-1. static factory method and `return이 있는 작업` supplyAsync
        CompletableFuture<String> existReturnFuture = CompletableFuture.supplyAsync(() ->{
            System.out.println("Hello, " + Thread.currentThread().getName());
            return "Hello";
        });
        System.out.println(existReturnFuture.get());

        CompletableFuture<String> callBackFuture = CompletableFuture.supplyAsync(() ->{
            System.out.println("Hello, " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(callBackFuture.get());

        CompletableFuture<Void> nonCallBackFuture = CompletableFuture.supplyAsync(() ->{
            System.out.println("Hello, " + Thread.currentThread().getName());
            return "HELLO";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        nonCallBackFuture.get();


        // callback을 실행할 다른 pool을 사 하고싶다. (ex. executorService)
        // pool-1-thread-1이 출력됨!
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> anotherThreadPoolCallBackFuture = CompletableFuture.supplyAsync(() ->{
            System.out.println("Hello, " + Thread.currentThread().getName());
            return "HELLO";
        }, executorService).thenRunAsync(() -> { // thenRunAsync를 쓰게되면 다른 Pool을 쓰게 된다. pool-1-thread-2
            System.out.println(Thread.currentThread().getName());
        }, executorService);
        anotherThreadPoolCallBackFuture.get();

        executorService.shutdown();
    }
}
