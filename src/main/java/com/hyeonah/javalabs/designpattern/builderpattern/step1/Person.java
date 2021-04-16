package com.hyeonah.javalabs.designpattern.builderpattern.step1;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String addressDetail;
    private Integer age;
    private String sex;
    private LocalDate birthDay;

//    public Person(final String firstName, final String lastName, final String phoneNumber, final String address, final String addressDetail, final Integer age, final String sex, final LocalDate birthDay) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//        this.addressDetail = addressDetail;
//        this.age = age;
//        this.sex = sex;
//        this.birthDay = birthDay;
//    }

//    public Person(final String firstName, final String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(final String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(final String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(final LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
