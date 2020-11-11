package com.hyeonah.studyjava.java8.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * Created by hyeonahlee on 2020-10-27.
 *
 * 조합하기
 *  - thenCompose(): 두 작업이 서로 이어서 실행하도록 조합
 *  - thenCombine(): 두 작업을 독립적으로 실행하고 둘 다 종료했을 때 콜백 실행
 *  - allOf(): 여러 작업을 모두 실행하고 모든 작업 결과에 콜백 실행
 *  - anyOf(): 여러 작업 중에 가장 빨리 끝난 하나의 결과에 콜백 실행
 *
 * 예외처리
 *  - exceptionally(Function)
 *  - handle(BiFunction)
 */
public class CompletableFutureTwo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() ->{
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        // 1. thenCompose 두 작업이 서로 연관관계가 있을 때, Hello World 출력!
        CompletableFuture<String> future = hello.thenCompose(CompletableFutureTwo::getWorld);
//        System.out.println(future.get());

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() ->{
            System.out.println("World" + Thread.currentThread().getName());
            return "World";
        });

        // anyOf 먼저 도착하는 것 아무거나 먼저 출력된다.
        CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);
        future.get();

        // 2. 두개 각각 독립적으로 실행하고, 두개의 실행 결과를 받을 때
        // world, (h, w) -> h + " " + w BiFunction에 해당하는 람다가 실행함.
//        CompletableFuture<String> future1 = hello.thenCombine(world, (h, w) -> h + " " + w);
//        System.out.println(future1.get());

        // 3. 여러 작업이 모두 끝났을 때...
//        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(hello, world)
//            .thenAccept(System.out::println); // null
//
//        System.out.println(allOfFuture.get()); // null

//        List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
//        CompletableFuture[] futuresArray = futures.toArray(futures.toArray(new CompletableFuture[futures.size()]));
//
//        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
//            .thenApply(v -> futures.stream()
//                    .map(CompletableFuture::join)
//                    .collect(Collectors.toList()));
//
//        results.get().forEach(System.out::println);

    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() ->{
            System.out.println(message + Thread.currentThread().getName());
            return message + " World";
        });
    }
}
