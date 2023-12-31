package j06_packageTest;

import j05_classMethod.Ex10_CallByRefLotto;

//** Access Modifier (접근 한정자_제어자)
//=> private : 해당 클래스내부 에서만
//=> default : 같은 Package 내
//=> protected : package + 자손
//=> public : 프로젝트내의 모든 Class 접근 가능
//(단, 다른 package 에서는 import 해야함)

public class Ex01_AccessTest {

	public static void main(String[] args) {

//		==============================================
		// 1) public

		// 1-1) public 으로 정의된 Ex10_CallByRefLotto
		int[] numbers = { 3, 6, 9, 2, 1, 9, 10 };
		Ex10_CallByRefLotto.lottoSort(numbers, 'c');

//		==================

		// 1-2) j05_classMethod 패키지의 Ex10_CallByRefLotto 의 변수 호출
		System.out.println("ex10, static sss = " + Ex10_CallByRefLotto.sss);

		Ex10_CallByRefLotto ex10 = new Ex10_CallByRefLotto();
		System.out.println("ex10, instance iii = " + ex10.iii);
//		System.out.println(ex10.ddd);
		// => instance 변수도 public 만 접근 가능

//		==================
		// ** 결론
		// 클래스 수준에서 허용해도, 멤버 수준에서 허용하지 않으면 접근 불가

//		================================================
		// 2) default 클래스

		// 2-1) default 로 정의된 Student 클래스
//		Student student = new Student();
		// => Student 는 default 로 선언된 클래스이므로 호출 불가능

		// 2-2) default 클래스 안의 public 멤버
//		Student student = new Student();
//		Student.ddd;
		// => 클래스 수준에서 허용되지 않으므로 맴버 수준의 접근범위(public) 는 무시됨

//		==================================================
		// 3) 같은 package 의 Car 호출

		System.out.println("Car ddd = " + Car.ddd);
		Car car = new Car();
		car.color = "Red";
		car.mileage = 12345;
		car.speed = 9000;
		System.out.println("car = " + car);

	} // main

} // class