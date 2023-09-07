package j07_classExtends;

public class Ex00_Student {
	// ** 변수

	private String no;
	private String name;
	private int score;

//	===================================
	// ** 집합(has a) : Student 와 Car 의 관계 -> Car 가 Student 에 포함

	Ex00_Car car = new Ex00_Car(1000, 5000, "Blue");
	// => classNclass 에서 아래와 같은 형식으로 Student 안의 car 를 호출할 수 있음
	// Ex00_Student s1 = new Ex00_Student("0001", "홍길동", 99);
	// System.out.println("car color : " + s1.car.color);

	static Ex00_Car myCar = new Ex00_Car(1000, 2000, "Red");
	// => static이기 때문에 classNclass에서 호출하기 위해서는 s1 대신 class 를 사용
	// System.out.println("myCar color : " + Ex00_Student.myCar.color);

//	===================================
	// ** 생성자

	Ex00_Student() {
	}

	Ex00_Student(String no, String name, int score) {
		this.no = no;
		this.name = name;
		this.score = score;
	}

//	====================================
	// 생성 시 한 번만 초기화하고 readOnly 로 사용하려면 -> setter 없이 getter 만 생성

	public String getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

//	==================================
	// ** toString
	public String toString() {
		return "[ 번호 : " + no + ", 이름 : " + name + ", 점수 : " + score + " ]";
	}

} // class