# Builder Pattern (빌더 패턴)
> 

## 언제 적용할까? 
생성자 인자가 많을 때는 Builder Pattern 적용을 고려하라.

## 점층적 생성자 패턴 (telescoping constructor pattern)
```java
    /* 모든 파라미터 생성 */
    public Person(final String firstName, final String lastName, final String phoneNumber, final String address, final String addressDetail, final Integer age, final String sex, final LocalDate birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.addressDetail = addressDetail;
        this.age = age;
        this.sex = sex;
        this.birthDay = birthDay;
    }
    
    /* firstName, lastName 으로 만 생성 */
    public Person(final String firstName, final String lastName) { 
        this.firstName = firstName;
        this.lastName = lastName;
    }

```
* 단점)
  * 선택적 매개변수가 많을 때 적절히 대응하기 어렵다.
  * 매개변수 개수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다. 
  * 각 값의 의미를 헷갈릴 수 있으며, 실수로 매개변수의 순서를 바꿔 건네주게 되면 컴파일 시 알아채지 못하고 런타임에 엉뚱하게 동작할 우려가 있다.

## 자바 빈즈 패턴 (javaBeans pattern) 
선택적 매개변수가 많을 댸 활용할 수 있는 대안.
매개변수가 없는 생성자로 객체를 만들고 세터(setter) 메서드들을 호출하여 원하는 매개변수의 값을 설정하는 방식이다.

```java
    Person person = new Person();
    person.setFirstName(firstName);
    person.setLastName(lastName);
    person.setPhoneNumber(phoneNumber);
    person.setAddress(address);
    person.setAddressDetail(addressDetail);
    person.setAge(age);
    person.setSex(sex);
    person.setBirthDay(birthDay);
    
    /* 필요한 데이터만 setter로 만든다. */
    person = new Person();
    person.setFirstName(firstName);
    person.setLastName(lastName);
```
* 장점)
    * 인스턴스를 만들기 쉽고, 점층적 생성자 패턴 보다는 코드를 읽기 쉽다.
    * 필요에 따른 다양한 생성자를 만들지 않아도 된다.
* 단점)
    * 객체 하나를 만들기 위해서는 메서드를 여러개 호출해야하고, 객체가 완전히 생성되기 전까지는 일관성(consistency)이 무너진 상태에 놓인다.
      * 일관성이 깨진 객체가 만들어지면, 버그를 심은 코드와 그 버그 떄문에 런타임에 문제를 겪는 코드가... 디버깅이 어렵다!
    * 클래스를 불변으로 만들 수 없다. 
      * 스레드 안전성을 얻으려면 추가 작업을 해야한다.
      

## 빌더 패턴 (Effective Java 스타일)
파이썬과 스칼라에 있는 명명된 선택적 매개변수 (named optional parameters)를 흉내낸 것으로,
점층적 생성자 패턴의 안전성과 자바빈즈 패턴의 가독성을 겸비한 패턴.

```java
    final Person person1 = new Person
        .PersonBuilder("FirstName", "LastName", "01022223333", "Address", "AddressDetail", LocalDate.of(2001, 4, 16))
        .age(20)
        .sex("WOMAN")
        .build();
```
* 장점)
    * 각 클라이언트 코드는 읽고 쓰기 쉽다. 
    * 점층적 생성자 패턴의 안전성과 자바빈즈 패턴의 가독성을 겸비

## 정리
생성자나 정적 팩터리가 처리해야 할 매개변수가 많다면 빌더 패턴을 선택하는 것이 낫다.

매개 변수 중 다수가 필수가 아니거나 같은 타입이면 특히 더 더욱!

빌더 패턴은 점층적 생성자보다 클라이언트 코드를 읽고 쓰기가 훨씬 간결하고, 자바빈즈보다 훨씬 안전하다.

# Reference
* [이펙티브 자바 3/E](http://www.yes24.com/Product/Goods/65551284) 아이템2. 생성자에 매개변수가 많다면 빌더를 고려하라.
