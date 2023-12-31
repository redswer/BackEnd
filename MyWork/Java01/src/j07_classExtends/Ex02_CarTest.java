package j07_classExtends;

// ** 상속 : extends
// => 기능을 확장해서 업그레이드 버젼 만듦.
// => 기존(조상) 클래스의 맴버들(필드와 메서드)을 재사용 & 일부 변경도 가능

// ** 생성순서
// => JVM은 extends 키워드가 있으면 조상 생성 후 후손 생성
// 이때 기본은 조상의 default 생성자를 실행하고,
// 특별히 후손 생성자에서 조상생성자_super(...)를 호출해 놓으면 그 생성자를 실행함.
// => 상속을 허용하는 클래스는 default 생성자를 반드시 작성하는 것이 바람직함.

// ** 조상 : Super (Parent, Base) class
// => super. : 조상의 인스턴스를 의미 (조상의 맴버에 접근 가능)
// => super()
// 조상의 생성자를 의미 (조상의 생성자에 접근 가능).
// this() 처럼 생성자 메서드 내에서 첫줄에 위치해야함.

// => 생성자메서드_super(), this() 호출은 생성자 내에서만 가능

// ** 후손 : Sub ( Child, Derived [diráivd] ) class
// => super class 를 포함

class SportsCar extends Ex00_Car {
	int turbo;
	int speed;

	SportsCar() {
		super(); // => 작성하지 않아도 컴파일러가 자동으로 넣어줌 -> 조상의 default 생성자를 의미
		System.out.println("** SportsCar 의 default 생성자 **");
	}

	SportsCar(int turbo) {
		this.turbo = turbo;
		System.out.println("** SportsCar 의 초기화 생성자 **");
	}

//	========================================
	// ** 조상의 멤버들도 모두 초기화하는 생성자

	SportsCar(int turbo, int speed, int mileage, String color) {
		super(speed, mileage, color); // => 조상의 생성자 호출 / 항상 첫 줄에 위치해야 함
		this.turbo = turbo;
		this.speed = speed;
		this.mileage = mileage;
		this.color = color;
		System.out.println("** SportsCar, Car 모두 초기화 생성자 **");
	}

//	=========================================
	// ** Car 클래스에 생성자를 추가하지 않고
	// => super(speed, mileage) -> 없음(호출 불가능)
	// => turbo, speed, mileage 를 초기화하는 생성자를 추가

	SportsCar(int turbo, int speed, int mileage) {
		this.turbo = turbo;
		super.speed = speed;
		super.mileage = mileage;
		System.out.println("**SportsCar의 turbo와 Car의 speed, mileage 만 초기화 **");
	}

//	============================================

	public int powerUp(int turbo) {
		return this.turbo += turbo;
	}

//	=================================================
	// 조상과 동일한 이름의 메서드 -> 메서드 오버라이딩
	// => 조상(super) / 자식(this) 구별 필요(멤버변수에도 동일하게 적용)
	// => 조상에 정의된 메서드의 기능을 업그레이드 하기 위해 주로 사용

	@Override // => 오버라이딩 표시
	public void speedUp() {
		super.speedUp();
		this.speed += 100;
	}

	// @Override // => 메서드 오버라이딩 아니고 메서드 오버로드 이므로 오류
	public void speedUp(int speed) {
		this.speed += speed;
		super.speed += speed;
		System.out.printf("speed = %d, this.speed = %d, super.speed = %d, COUNTRY = %s", speed, this.speed, super.speed,
				Ex00_Car.COUNTRY);
		// => static 한 변수는 상속에 관계없이 static 하게 사용
		// => 따라서 super.COUNTRY 가 아닌 Ex00_Car.COUNTRY
	}

//	===============
	// final 선언한 메서드 오버라이드 test

//	public void speedDown() {
//		speed -= 100;
//	}
	// => 오버라이딩 불가능

	public void speedDown(int i) {
		speed -= 100;
	}
	// => 매개변수가 다르므로 오버로딩 -> 오버로딩은 허용

//	===================================================

	@Override
	public String toString() {
		return super.toString() + "\n" + "SportsCar [ turbo : " + turbo + " ]";
	}

} // SportsCar

public class Ex02_CarTest {

	public static void main(String[] args) {
		// 1) 상속 Test
		// => 조상(Ex00_Car)의 멤버에 접근 가능함

		SportsCar sc1 = new SportsCar();
		sc1.color = "Blue";
		System.out.println("sc1 : " + sc1);
		System.out.println("SportsCar color : " + sc1.color + "\n");
		// => SportsCar class 의 멤버 추가 이전 / 이후 비교
		// => 추가 이전에는 sc1 = Car 의 멤버 출력
		// => 추가 이후에는 sc1 = SportsCar 의 멤버 출력

		// => 이름이 같은 경우 현재 클래스에 정의된 멤버 우선 출력됨

//		================
		// => 출력 콘솔에 Car 의 default 생성자 출력 후 SportsCar 의 default 생성자 출력됨
		// => 조상 생성자 -> 자식 생성자 순으로 실행

//		==================================================
		// 2) 생성자 test

		SportsCar sc2 = new SportsCar(100);
		System.out.println("** 생성자 test : " + sc2 + "\n");
		// => 사용자 클래스에서 조상 클래스의 생성자를 선택할 수 없음 -> default 생성자가 자동으로 호출됨
		// => default 생성자(Ex00_Car())가 없으면 자식 클래스(SportsCar)를 생성할 수 없음

//		==================================================
		// 3) super() (조상의 생성자 호출) / super. (생성자 추가하지 않고 초기화) Test

		SportsCar sc3 = new SportsCar(300, 1000, 2000, "Red");
		System.out.println("super() test : " + sc3 + "\n");

		SportsCar sc4 = new SportsCar(200, 1500, 2000);
		System.out.println("super. test : " + sc4 + "\n");

//		=====================================================
		// 4) 멤버 변수 test

		System.out.println("자식 클래스에 speed 추가 test : " + sc4.speed);
		// => SportsCar (자식 클래스)에 int speed 추가하기 전
		// => Car (부모 클래스)의 speed 값 출력
//		====================
		// => SpotsCar (자식 클래스)에 int speed 추가 후
		// => SportsCar (자식 클래스)의 speed 값 출력

//		====================================================
		// 5) 메서드 test
		// => 부모 클래스의 메서드와 동일한 이름의 메서드가 있을 때

		sc4.speedUp();
		System.out.println("동일한 이름의 메서드 추가 후 speed : " + sc4.speed + "\n");

		sc4.speedUp(20);

	} // main

} // class