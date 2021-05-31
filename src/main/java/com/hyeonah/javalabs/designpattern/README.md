# Design Patterns

## 디자인 패턴이 무엇인가?
설계시 반복적으로 나타나는 설계 방법 또는 구조들을 말합니다.
디자인패턴은 대표적으로 GoF 23가지 패턴이 있습니다.
패턴들의 대부분의 공통점은 `추상클래스`나 `인터페이스`로부터 상속받은 클래스를 사용하며, 
이는 **객체지향의 다형성**을 이용한 방법입니다.

## 왜 디자인패턴을 알아야 하고, 적용하는 이유는 무엇일까? 
디자인패턴을 이용하게 되면 코딩이 명확하고 단순하며 모듈을 세분화 시킬 수 있고, **재사용성이 높으며 유지보수가 쉬워진다.**

<u> 다양한 추가 요구사항에 대해 보다 쉽게 대응 하기 위해서이다. </u> 
즉, 쉽게 코드를 수정할 수 있도록 하기 위함.


## 디지인 패턴을 어떻게 적용해야 할까?

같은 상황에 하나의 패턴만이 정답은 아니기 때문에, 여러 상황에 따라 적절한 패턴을 적용 하는 것이 중요하다.

## 디자인 패턴 분류
- 생성 (Creational) pattern: 객체의 생성과 조합을 캡슐화해 특정 객체가 생성되거나 변경되어도 프로그램 구조에 영향을 크게 받지 않도록 유연성을 제공하는 패턴 
- 구조 (Structural) pattern: 클래스나 객체를 조합해 더 큰 구조를 만드는 패턴 (예를 들어, 서로 다른 인터페이스를 지닌 2개의 객체를 묶어 단일 인터페이스를 제공하거나 객체들을 서로 묶어 새로운 기능을 제공)
- 행위 (Behavioural) pattern: 객체나 클래스 사이의 알고리즘이나 책임 분배와 관련된 패턴 (한 객체가 혼자 수행할 수 없는 작업을 여러개의 객체로 어떻게 분배하는지, 또 그렇게 하면서 객체 사이의 결합도를 최소화 하는 것에 중점을 둔다.)

## GoF 디자인 패턴 분류
|-|패턴 이름
|----|--------------------------------------------------------|
|생성 패턴 | 추상 팩토리 (Abstract Factory) / 팩토리 메서드 (Factory Method) / 빌더(Builder) / 싱글턴 (Singleton) / 프로토타입(Prototype) |
|구조 패턴 | 어댑터 (Adapter) / 브릿지 (Bridge) / 컴퍼지트 (Composite) / 데커레이터 (Decorator) / 퍼사드 (facade) / 플라이웨이트 (Flyweight) / 프록시 (Proxy) |
|행위 패턴 | 커맨드 (Command) / 옵저버 (Observer) / 스트래티지 (Strategy) / 템플릿 메서드 (Template Method) / 메멘토 (Memento) / 스테이트 (State) / 인터프리터 (Interpreter) / 이터레이터 (Iterator) / 미디에이터 (Mediator) / 책임 연쇄 (Chain of Responsibility) |

## 디자인 패턴 종류 
* [Strategy Pattern (전략 패턴)](https://github.com/hyeoni90/java-labs/tree/main/src/main/java/com/hyeonah/javalabs/designpattern/strategypattern)
* [Builder Pattern (빌더 패턴)](https://github.com/hyeoni90/java-labs/tree/main/src/main/java/com/hyeonah/javalabs/designpattern/builderpattern)

# References
- [자바 객체지향 디자인 패턴 : UML과 GoF 디자인 패턴 핵심 10가지로 배우는](http://www.yes24.com/Product/Goods/12501269?OzSrank=5)
- [자바 디자인 패턴의 이해 - Gof Design Pattern](https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4/dashboard)
- [디자인 패턴 with JAVA (GoF)](https://www.inflearn.com/course/Design-pattern-java)
- https://www.youtube.com/watch?v=vNHpsC5ng_E&list=PLF206E906175C7E07
