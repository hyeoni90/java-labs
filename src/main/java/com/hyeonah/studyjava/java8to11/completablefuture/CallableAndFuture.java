package com.hyeonah.studyjava.java8to11.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by hyeonahlee on 2020-10-27.
 */
public class CallableAndFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> hyeonah = () -> {
            Thread.sleep(1000L);
            return "Hyeonah";
        };

        // invokeAll은 다 끝날 때까지 기다린다.
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, hyeonah));

        /*
        한꺼번에 출력된다.
        Hello
        Java
        Hyeonah
         */
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }

        executorService.shutdown();
    }

    /*
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());   // 끝났으면 T, 아직 끝나지 않았으면 F
        System.out.println("Started!");

        // get을 만나는 순간 결과 멈춘다!
//        helloFuture.get();   // blocking Call!

        // true 현재 진행중인 작업을 interrupt 하면서 종료 한다.
        // false 는 기다린다.? cancel 하게 되면 done은 true가 되고, cancel하고 get하면 error!
        helloFuture.cancel(true);

        System.out.println(helloFuture.isDone());
        System.out.println("End!!");
        executorService.shutdown();
    }
    */
}
