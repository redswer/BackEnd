package j07_classExtends;

// ** final
// => class, 메서드, 필드(변수) 등에 붙일 수 있음

// => final class : 상속 불가능 (종단 클래스)
// => final method : 오버라이딩 불가능 / 오버로딩은 허용
// => final 필드 (변수) : 상수

// public final class Ex00_Car { // => 상속 불가능하므로 CarTest(SportsCar)는 오류
public class Ex00_Car {
	public int speed;
	public int mileage;
	public String color = "Yellow";

	public static final String COUNTRY = "Korea"; // => 상수명은 모두 대문자로
	// => 상수는 변경할 수 없고 대부분의 자손에서 사용하기 때문에 주로 static 으로 정의함

	public Ex00_Car() {
		System.out.println("** Car 의 default 생성자 **");
	}

	public Ex00_Car(int speed, int mileage, String color) {
		this.speed = speed;
		this.mileage = mileage;
		this.color = color;
		System.out.println("** Car 의 초기화 생성자 **");

		// COUNTRY = "한국"; // => 상수는 수정 불가능
	}

	public void speedUp() {
		speed += 10;
	}

	public final void speedDown() {
		speed -= 10;
	}
	// => final 이 붙으면 speedDown 메서드는 더 이상 변경 불가 = 오버라이딩 불가능

	public String toString() {
		return "[ speed = " + speed + ", mileage = " + mileage + ", color = " + color + " ]";
	}
}
// class