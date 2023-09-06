package j07_classExtends;

//** 클래스와 클래스 간의 관계
// 1) 집합(has-a): Student 와 Car
// 2) 사용(use)  : Ex01_classNclass 와 Car
// 3) 상속(is-a) : Person, Student

public class Ex01_classNclass {
	// ** 1) 집합 을 위한 초기화
	static Ex00_Car car = new Ex00_Car(100, 200, "Yellow");

	// ** 2) 사용(use)을 위한 선언
	public static void myCar(Ex00_Car car) {
		car.speedDown();
		System.out.println("myCar speed : " + car.speed);
	}

	public static void main(String[] args) {
		// 1) 집합 (has-a)
		// => Ex01_classNclass 클래스와 Ex00_Car 클래스의 관계
		System.out.println("** 1) 집합 (has-a)");
		System.out.println(car);

		// 2) 사용 (use)
		// => Ex01_classNclass 클래스가 Ex00_Car를 매서드 인자의 형식으로 사용한 경우
		System.out.println("\n** 2) 사용 (use)");
		myCar(car);

	} // main

} // class