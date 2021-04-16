package com.hyeonah.javalabs.designpattern.builderpattern.step2;

import java.time.LocalDate;

public class Person {
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String address;
    private final String addressDetail;
    private final Integer age;
    private final String sex;
    private final LocalDate birthDay;

    private Person(final PersonBuilder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        phoneNumber = builder.phoneNumber;
        address = builder.address;
        addressDetail = builder.addressDetail;
        age = builder.age;
        sex = builder.sex;
        birthDay = builder.birthDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public static class PersonBuilder {
        /**
         * required parameters
         */
        private final String firstName;
        private final String lastName;
        private final String phoneNumber;
        private final String address;
        private final String addressDetail;
        private final LocalDate birthDay;

        /**
         * optional parameters
         * initialized to default values(선택적 인자는 기본값으로 초기화)
         */
        private Integer age = 0;
        private String sex = "MAN";

        public PersonBuilder(final String firstName,
                             final String lastName,
                             final String phoneNumber,
                             final String address,
                             final String addressDetail,
                             final LocalDate birthDay) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.addressDetail = addressDetail;
            this.birthDay = birthDay;
        }

        public PersonBuilder age(final Integer age) {
            this.age = age;
            return this;
        }

        public PersonBuilder sex(final String sex) {
            this.sex = sex;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
