package com.hyeonah.javalabs.designpattern.singletonpattern.ex1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SystemSpeakerTest {

    final SystemSpeaker speaker1 = SystemSpeaker.getInstance();
    final SystemSpeaker speaker2 = SystemSpeaker.getInstance();

    @Test
    @DisplayName("볼륨 초기화 테스트")
    void getInstanceTest() {
        // when, then
        assertThat(speaker1.getVolume()).isEqualTo(5);
        assertThat(speaker2.getVolume()).isEqualTo(5);
        assertThat(speaker1.getVolume()).isEqualTo(speaker2.getVolume());
    }

    @Test
    @DisplayName("speaker1 볼륨 세팅 시 speaker2도 동일하게 볼륨 변경되는지 테스트")
    void speaker1_setVolumeTest() {
        // when
        speaker1.setVolume(12);

        // then
        assertThat(speaker1.getVolume()).isEqualTo(12);
        assertThat(speaker2.getVolume()).isEqualTo(12);
        assertThat(speaker1.getVolume()).isEqualTo(speaker2.getVolume());
    }

    @Test
    @DisplayName("speaker2 볼륨 세팅 시 speaker2도 동일하게 볼륨 변경되는지 테스트")
    void speaker2_setVolumeTest() {
        // when
        speaker2.setVolume(33);

        // then
        assertThat(speaker1.getVolume()).isEqualTo(33);
        assertThat(speaker2.getVolume()).isEqualTo(33);
        assertThat(speaker1.getVolume()).isEqualTo(speaker2.getVolume());
    }

    @Test
    @DisplayName("speaker1, speaker2 같은 인스턴스 인지 테스트 ")
    void test() {
        /* speaker1, speaker2의 인스턴스의 주소값이 같다는 것을 확인할 수 있다. */
        System.out.println(speaker1);
        System.out.println(speaker2);

        // then
        assertThat(speaker1).isEqualTo(speaker2);
    }
}