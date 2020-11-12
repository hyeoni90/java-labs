package com.hyeonah.studyjava.java8to11.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by hyeonahlee on 2020-11-12.
 *
 * CompletableFuture 예외 처리
 *
 *  - exceptionally(Function)
 *  - handle(BiFunction)
 */
public class CompletableFutureError {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        boolean throwError = true;

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if(throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error";
        });

        System.out.println(hello.get());

        CompletableFuture<String> hello2 = CompletableFuture.supplyAsync(() -> {
            if(throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, ex) -> {
            if(ex != null) {
                System.out.println(ex);
                return "ERROR";
            }
            return result;
        });

        System.out.println(hello2.get());
    }
}
