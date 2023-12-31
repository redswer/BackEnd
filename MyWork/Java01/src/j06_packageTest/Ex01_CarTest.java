package j06_packageTest;

// ** Ex01_AccessTest 를 위해 j05_classMethod 패키지에서 복사함

class Car {
	public int speed;
	public int mileage;
	public String color = "Yellow";

	static int ddd = 100;

	public void speedUp() {
		speed += 10;
	}

	public void speedDown() {
		speed -= 10;
	}

	public String toString() {
		return "[ speed = " + speed + ", mileage = " + mileage + ", color = " + color + " ]";
	}

} // car

public class Ex01_CarTest {

	public static void main(String[] args) {
		System.out.println("** Car class test : ");

		Car myCar = new Car();
		myCar.color = "Gold";
		myCar.mileage = 1000;
		myCar.speed = 500;
		myCar.speedUp();
		System.out.println("myCar1 toString : " + myCar.toString());
		System.out.println("myCar2 : " + myCar);

		myCar = null;

		Car mCar = new Car();
		mCar.color = "Blue";
		mCar.mileage = 500;
		mCar.speed = 200;
		mCar.speedDown();
		System.out.println("\nmCar1 toString : " + mCar.toString());
		System.out.println("mCar2 : " + mCar);

		Car rCar = mCar;
		System.out.println("\nrCar1 toString : " + rCar.toString());
		System.out.println("rCar2 : " + rCar);

		Car fCar = new Car();
		fCar.color = "Black";
		fCar.mileage = 2000;
		fCar.speed = 1000;
		fCar.speedUp();
		System.out.println("\nfCar1 toString : " + fCar.toString());
		System.out.println("fCar2 : " + fCar);

	} // main

}
// class