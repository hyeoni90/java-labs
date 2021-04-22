package com.hyeonah.javalabs.designpattern.builderpattern.step2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class PersonBuilderTest {

    private Person person;

    @Test
    void all_params_builderTest() {
        // given
        final String firstName = "FirstName";
        final String lastName = "LastName";
        final String phoneNumber = "01022223333";
        final String address = "Address";
        final String addressDetail = "AddressDetail";
        final int age = 20;
        final String sex = "WOMAN";
        final LocalDate birthDay = LocalDate.of(2001, 4, 16);

        // when
        person = new Person
                .PersonBuilder(firstName, lastName, phoneNumber, address, addressDetail, birthDay)
                .age(age)
                .sex(sex)
                .build();

        // then
        assertThat(person.getFirstName()).isEqualTo(firstName);
        assertThat(person.getAddress()).isEqualTo(address);
        assertThat(person.getAge()).isEqualTo(age);
        assertThat(person.getSex()).isEqualTo(sex);
    }

    @Test
    void Specified_param_builderTest() {
        // given
        final String firstName = "FirstName";
        final String lastName = "LastName";
        final String phoneNumber = "01022223333";
        final String address = "Address";
        final String addressDetail = "AddressDetail";
        final LocalDate birthDay = LocalDate.of(2001, 4, 16);

        // when
        person = new Person
                .PersonBuilder(firstName, lastName, phoneNumber, address, addressDetail, birthDay)
                .build();

        // then
        assertThat(person.getFirstName()).isEqualTo(firstName);
        assertThat(person.getAddress()).isEqualTo(address);
        assertThat(person.getAge()).isZero();
        assertThat(person.getSex()).isEqualTo("MAN");
    }
}
