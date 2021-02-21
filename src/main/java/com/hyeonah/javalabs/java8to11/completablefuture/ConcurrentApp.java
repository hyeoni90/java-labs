package com.hyeonah.javalabs.java8to11.completablefuture;

/**
 * Created by hyeonahlee on 2020-10-27.
 */
public class ConcurrentApp {

    public static void main(final String[] args) throws InterruptedException {
        // 3. java 8 부터는 람다식 으로 사용할 수 있게 되었다.
        final Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5000L);
                } catch (final InterruptedException e) {
                    System.out.println("Thread exit!");
                    return;     // Thread 종료
                }
            }
        });
        thread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
//        Thread.sleep(3000L);

        thread.join();
        System.out.println(thread + "is finished");

        /* 2. Runnable 구현, java 8이전에는 익명 클래스로 Thread 생성자를 구현해서 사용했었다. */
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread: " + Thread.currentThread().getName());
//            }
//        });
//        thread.start();
//        System.out.println("Hello: " + Thread.currentThread().getName());

        /* 1. Thread를 상속받아서 사용할 경우 */
//        MyThread myThread = new MyThread();
//        myThread.start();
//
//        System.out.println("Hello: " + Thread.currentThread().getName());
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }
}
