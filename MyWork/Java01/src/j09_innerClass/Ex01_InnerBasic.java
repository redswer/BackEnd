package j09_innerClass;

import j07_classExtends.Ex00_Car;
// import j09_innerClass.OuterClass.Inner;

//** 클래스 맴버
//=> 맴버(전역) 변수 : 선언문, 초기화 블럭
//=> 메서드 : 생성자, main, setter/getter, toString, 일반메서드
//=> 초기화블럭 : {   }  / static {   }
//=> 내부(inner) 클래스 : 클래스 내부에 다른 클래스를 정의

//** Inner Class 기본형식과 특성

class OuterClass {
	// 1) 멤버 변수

	int age = 100;
	private String name = "홍길동";
	static String grade = "A++";

	Ex00_Car car; // => 외부(j07_classExtends)의 class : import 해야 함
	// => 맴버변수로 클래스를 정의
	// => has-a 관계 : 재사용성이 많은경우
	// inner 클래스와 비교 : 현재클래스에서만 필요한 경우
	// (단, inner 클래스가 외부에서 접근 불가능한 맴버는 아님)

//	================================================
	// 2) 생성자 및 메서드

	OuterClass() {
		System.out.println("** OuterClass default 생성자 **");
	}

//	================================================
	// 3) 내부(inner) 클래스
	// => 일반적인 클래스의 특징을 모두 가짐
	// => 외부 클래스의 모든 멤버 (private 포함) 접근 가능

	// class Inner {
	static class Inner {
		// => 내부 클래스에 static 멤버가 하나라도 있으면 내부 클래스도 static 으로 선언해야 함

		String country = "Korea";
		static String company = "Green";

		Inner() {
			System.out.println("** Inner default 생성자 **");
		}

		// 원본 (내부 클래스가 non_static 인 경우)
//		public void printData() {
//			System.out.printf("** Inner printData : age = %d, name = %s, static_grade = %s, country = %s\n", age, name,
//					grade, country);
//		}
		// ver.1 : static 매서드로 작성
//		public static void printData(OuterClass out) {
//			System.out.printf("** Inner printData : age = %d, name = %s, static_grade = %s, country = %s\n", out.age,
//					out.name, grade, country);
//		}
		// ver.2 : 인스턴스를 매개변수로 전달
		public void printData(OuterClass out) {
			System.out.printf("** Inner printData : age = %d, name = %s, static_grade = %s, country = %s\n", out.age,
					out.name, grade, country);
		}
		// => static Inner 클래스인 경우 static 방법으로 접근 가능하도록 작성
	}// Inner

}// OuterClass

public class Ex01_InnerBasic {

	public static void main(String[] args) {
//		=======================================
		// ** 생성

		// 1) Outer 만 생성
		// => Outer 의 멤버만 접근 가능

		OuterClass out1 = new OuterClass();
		out1.age = 123;

		out1.car = new Ex00_Car(500, 500, "Brown");
		System.out.printf("** main : age = %d, grade = %s, car_color = %s\n", out1.age, OuterClass.grade,
				out1.car.color);
		// => class 타입 멤버면수 car 초기화 및 사용

		System.out.println("** main out1.car : " + out1.car);

		System.out.println("");
//		=============================================
		// 2) Inner 사용

		// 2-1) 원본 (내부 클래스가 non_static 인 경우)
//		// OuterClass.Inner in1 = out1.new Inner(); // => import 필요 없음
//		Inner in1 = out1.new Inner(); // => import 해야 함
//		in1.country = "대한민국";
//
//		in1.printData();
//
//		// ** 직접 생성
//		OuterClass.Inner in2 = new OuterClass().new Inner();
//
//		in2.printData();
//		// => in1 과는 다른, 별개의 인스턴스를 생성했기 때문에 in1 에서 변경한 값 적용되지 않음

//		=================
		// 2-2) static test

		// 2-2-1) static Inner 의 static 맴버접근
		// -> Inner 클래스 인스턴스는 필요 없지만, Outer 클래스를 통해 접근
		// ( 단, import 하면 Inner 단독으로 사용가능 )

		System.out.printf("** main : static_grade = %s, company = %s \n", OuterClass.grade, OuterClass.Inner.company);

		// 2-2-2) static Inner 의 non_static 맴버접근
		// -> Inner 의 non_static printData 메서드 호출
		// -> static Inner 클래스의 인스턴스가 필요함

		OuterClass.Inner in1 = new OuterClass.Inner();
		in1.printData(new OuterClass()); // 또는 in1.printData(out1);

	}// main

}// class