package com.hyeonah.javalabs.designpattern.builderpattern.step1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    /* 필요에 따라 다양한 파라미터 생성자를 만들어줘야 한다.*/
    private Person person;

    @Test
    void all_params_constructor() {
        // given
        final String firstName = "firstName";
        final String lastName = "lastName";
        final String phoneNumber = "01011112222";
        final String address = "address";
        final String addressDetail = "addressDetail";
        final int age = 20;
        final String sex = "WOMAN";
        final LocalDate birthDay = LocalDate.of(2001, 4, 16);

        // when
        // 1. 점층적 생성자 패턴
//        person = new Person("firstName",
//                "lastName",
//                "01011112222",
//                "address",
//                "addressDetail",
//                20,
//                "WOMAN",
//                LocalDate.of(2001,4,16));

        // 2. 자바빈 패턴
        person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPhoneNumber(phoneNumber);
        person.setAddress(address);
        person.setAddressDetail(addressDetail);
        person.setAge(age);
        person.setSex(sex);
        person.setBirthDay(birthDay);

        // then
        assertThat(person.getFirstName()).isEqualTo(firstName);
        assertThat(person.getLastName()).isEqualTo(lastName);
        assertThat(person.getAddress()).isEqualTo(address);
    }

    @Test
    void specific_param_constructor() {
        // given
        final String firstName = "first";
        final String lastName = "last";

        // when
        person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        // then
        assertThat(person.getFirstName()).isEqualTo(firstName);
        assertThat(person.getLastName()).isEqualTo(lastName);
        assertThat(person.getAddress()).isNull();
    }
}
