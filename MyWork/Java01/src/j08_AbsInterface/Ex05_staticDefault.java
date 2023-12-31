package j08_AbsInterface;

//** interface 4.
//=> 상수, 추상메서드
//=> static, default 메서드 (구현부가 있는 메서드, Java8 부터 추가됨)

//** static, default
//=> 반드시 바디를 구현 해야함
//=> 구현클래스의 오버라이딩 의무 없음

interface NewInter {
	// ** 추상 메서드
	// => 반드시 헤더만 정의, 바디부(실행부)는 없어야 함

	void test(); // 앞에 public abstract 생략됨

//	=============
	// ** static
	// => 반드시 바디부(실행부)를 구현해야 함

	// static void staticTest(); // => 오류
	static void staticTest() {
		System.out.println("** interface staticTest() **");
	}

//	=============
	// ** default
	// => interface 에만 있음, 오버라이딩 의무 없지만 필요시에는 가능

	// default void defaultTest();
	default void defaultTest() {
		System.out.println("** interface defaultTest() **");
	}

}// NewInter

class NewTest implements NewInter {
	// 1) 추상 (abstract)
	// => 오버라이드 필수

	@Override
	public void test() {
		System.out.println("** NewTest test() Override**");
	}

//	==================
	// 2) static
	// => 클래스 또는 인터페이스 종속이므로 동일 메서드명 허용됨
	// static 또는 인스턴스 메서드 모두 가능
	// ( 비교: 조상이 클래스인 경우에는 인스턴스 메서드는 불가능 )

	static void staticTest() {
		System.out.println("** NewTest staticTest() **");
	}

//	====================
	// 3) default
	// => 의무는 아니지만 오버라이드 허용
	// => 오버라이드 시 default 사용 불가능하고 접근 범위는 조상과 같거나 더 넓어야 함

	@Override
	public void defaultTest() {
		// ** 조상의 메서드(default) 호출

		// super.defaultTest()
		NewInter.super.defaultTest();
		// => 조상이 interface 인경우 접근방법

		System.out.println("** NewTest defaultTest() Override **");
	}

	// 메서드 오버로딩
	public void defaultTest(int i) {
		System.out.println("** NewTest defaultTest() Override : i * i = " + (i * i));
	}

}// NewTest

public class Ex05_staticDefault {

	public static void main(String[] args) {
//		=========================
		// 1) 클래스 타입으로 생성

		NewTest n1 = new NewTest();

		n1.test();

		// n1.staticTest();
		NewTest.staticTest();
		NewInter.staticTest(); // interface 의 static 메서드 접근

		n1.defaultTest();
		n1.defaultTest(123);
		System.out.println("");

//		=========================
		// 2) 인터페이스 타입으로 생성

		NewInter n2 = new NewTest();

		n2.test();
		n2.defaultTest();
		// n2.defaultTest(123);
		// => 인터페이스에 정의된 멤버만 접근 가능함

		NewTest.staticTest();
		NewInter.staticTest();

	}// main

}// class