# Java 8

## CompletableFuture
자바에서 비동기(Asynchronous) 프로그래밍을 가능케하는 인터페이스.

기존에 Future로도 비동기 프로그래밍이 가능했다.
하지만, 
* Future를 외부에서 완료 시킬 수 없다. 취소하거나, get()에 타임아웃을 설정할 수는 있다.
● 블로킹 코드(get())를 사용하지 않고서는 작업이 끝났을 때 콜백을 실행할 수 없다.
● 여러 Future를 조합할 수 없다, 예) Event 정보 가져온 다음 Event에 참석하는 회원 목록
가져오기
● 예외 처리용 API를 제공하지 않는다.

  // get을 만나는 순간 결과 멈춘다!
  //        helloFuture.get();   // blocking Call!

        // true 현재 진행중인 작업을 interrupt 하면서 종료 한다.
        // false 는 기다린다.? cancel 하게 되면 done은 true가 되고, cancel하고 get하면 error!


* 비동기 작업 실행
  - return 값이 없는 경우: runAsync()
  - return 값이 잇는 경우: supplyAsync()
  - 원하는 Executor(thread pool)을 사용해서 실행할 수 있다. (ForkJoinPool.commonPool() 기본)

* CallBack 제공
  - thenApply(Function) : return 값을 받아서 다른 값으로 바꾸는 콜백
  - thenCombine(Consumer): return 값을 또 다른 작업을 처리하는 콜백 (return 없이!)
  - thenRun(Runnable): return 값 받지 다른 작업을 처리하는 콜백

* 조합하기
  - thenCompose(): 두 작업이 서로 이어서 실행하도록 조합
  - thenCombine(): 두 작업을 독립적으로 실행하고 둘 다 종료했을 때 콜백 실행
  - allOf(): 여러 작업을 모두 실행하고 모든 작업 결과에 콜백 실행
  - anyOf(): 여러 작업 중에 가장 빨리 끝난 하나의 결과에 콜백 실행


# 정리
Java 8 Feature
* 함수형 프로그래밍
    * 함수형 인터페이스
    * 람다표현식
    * 메소드 레퍼런스
* 비동기 프로그래밍
    * CompletableFuture
* 편의성개선
    * Optional
    * Date & Time
    * 인터페이스