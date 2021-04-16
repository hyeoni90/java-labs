package com.hyeonah.javalabs.designpattern.singleton.ex1;

public class SystemSpeakerMain {

    public static void main(final String[] args) {
        final SystemSpeaker speaker1 = SystemSpeaker.getInstance();
        final SystemSpeaker speaker2 = SystemSpeaker.getInstance();

        /* 동일한 인스턴스 인지 볼륨 테스트 */
        System.out.println(speaker1.getVolume());   //5
        System.out.println(speaker2.getVolume());   //5

        speaker1.setVolume(12);
        System.out.println(speaker1.getVolume());   //12
        System.out.println(speaker2.getVolume());   //13

        speaker2.setVolume(33);
        System.out.println(speaker1.getVolume());   //33
        System.out.println(speaker2.getVolume());   //33

        /* speaker1, speaker2의 인스턴스의 주소값이 같다는 것을 확인할 수 있다. */
        System.out.println(speaker1);   // SystemSpeaker@27a8c74e
        System.out.println(speaker2);   // SystemSpeaker@27a8c74e
    }
}
