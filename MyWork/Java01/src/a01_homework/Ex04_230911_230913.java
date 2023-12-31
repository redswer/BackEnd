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
// 7-3, 7-8

class Product {
	int price;
	int bonusPoint;

	Product() {
	}

	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}
}

class Tv extends Product {
	Tv() {
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

// =============================================
// 7-4
class MyTv {
	private boolean isPowerOn;
	private int channel;
	private int volume;
	private int prevChannel;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	public void setVolume(int volume) {
		if (volume > MAX_VOLUME || volume < MIN_VOLUME) {
			return;
		}
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}

	public void setChannel(int channel) {
		if (channel > MAX_CHANNEL || channel < MIN_CHANNEL) {
			return;
		}
		prevChannel = this.channel;
		this.channel = channel;
	}

	public int getChannel() {
		return channel;
	}

	public void gotoPrevChannel() {
		setChannel(prevChannel);
	}
}// MyTv

// =============================================
// 7-6
class Outer {
	class Inner {
		int iv = 100;
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

// =======================================================

public class Ex04_230911_230913 {

	public static void main(String[] args) {
		// 7-3
		Tv t = new Tv();

//		==========================
		// 7-4
		MyTv mt = new MyTv();
		mt.setChannel(10);
		System.out.println("CH : " + mt.getChannel());
		mt.setVolume(20);
		System.out.println("VOL : " + mt.getVolume());

		System.out.println("");
//		===========================
		// 7-5
		mt.gotoPrevChannel();
		System.out.println("CH : " + mt.getChannel());
		mt.gotoPrevChannel();
		System.out.println("CH : " + mt.getChannel());

		System.out.println("");
//		===========================
		// 7-6
		Outer o = new Outer();
		Outer.Inner ii = o.new Inner();
		System.out.println(ii.iv);

		System.out.println("");
//		===========================
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

		b.buy(new Tv());
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

}
// class