package a01_homework;

class Car {
	// 7-7
	String color;
	int door;

	void drive() {
		System.out.println("drive, Brrrr~");
	}

	void stop() {
		System.out.println("Stop!!!");
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("Water!!!");
	}
}

//=======================================
// 7-8

class Product {
	int price;
	int bonusPoint;

	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}
}

class Tv1 extends Product {
	Tv1() {
		super(100);
	}

	public String toString() {
		return "Tv";
	}
}

class Computer extends Product {
	Computer() {
		super(200);
	}

	public String toString() {
		return "Computer";
	}
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;

	void buy(Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}

		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p + "을/를 구입하셨습니다.");
	}
}

// ==============================================
// 7-11

class Parent3 {
	public void method2() {
		System.out.println("method2() in Parent3");
	}
}

interface MyInterface {
	default void method1() {
		System.out.println("method1() in MyInterface");
	}

	default void method2() {
		System.out.println("method2() in MyInterface");
	}

	static void staticMethod() {
		System.out.println("staticMehtod() in MyInterface");
	}
}

interface MyInterface2 {
	default void method1() {
		System.out.println("method1() in MyInterface2");
	}

	static void staticMethod() {
		System.out.println("statcieMethod() in MyInterface2");
	}
}

class Child3 extends Parent3 implements MyInterface, MyInterface2 {
	public void method1() {
		System.out.println("method1() in Child3");
	}
}

public class Ex04_230911 {

	public static void main(String[] args) {
		// 7-7
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;

		fe.water();

		car = fe;
		// car.water();

		fe2 = (FireEngine) car;
		fe2.water();
		System.out.println("");

//	================================
		// 7-8

		Buyer b = new Buyer();

		b.buy(new Tv1());
		b.buy(new Computer());

		System.out.println("현재 남은 돈은 " + b.money + "만원 입니다.");
		System.out.println("현재 보너스 점수는 " + b.bonusPoint + "점 입니다.");
		System.out.println("");

//	=====================================
		// 7-11

		Child3 c = new Child3();
		c.method1();
		c.method2();
		MyInterface.staticMethod();
		MyInterface2.staticMethod();

	}// main

}// class