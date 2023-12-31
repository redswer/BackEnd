package j05_classMethod;

//** 맴버메서드(Method)
//=> 함수(Function), 프로시져(Procedure)

//J06_  15,16 p
//1) 정의 , 실행

//2) return 값
//=> return 이 있으면 Type 을 지정, 없으면 무조건 void  
//=> 메서드 실행결과 return Type에 해당하는 결과값을 제공
//=> return 명령어를 void 메서드 에서 사용하면 메서드 종료

//3) 매개변수
//=> 매개변수(Argument, 인자), Parameter
//=> 메서드의 지역변수이며, 모든타입 정의 가능
//=> 매개변수의 값 전달방법
//CallByValue (기본자료형, String -> 매개변수의 값 전달)
//CallByReference (참조자료형: 배열, 인스턴스 -> 주소전달)   

//** 기본자료형 : Primitive Data Type (int, double, boolean....)
//** 참조자료형 : Reference Data Type (String, 배열 등 클래스타입) 

public class Ex03_Method {

	// 1. 메서드 종류별 4종 정의

	// 2. return Test
	// => return 값 활용 (main 에서 Test)
	// => void 메서드 에서 사용 : 메서드 종료

	// 3. 매개변수 전달방법
	// => CallByValue (기본자료형, String -> 매개변수의 값 전달됨)
	// => CallByReference (참조자료형, 주소값을 전달 -> 배열, 인스턴스)

	int price = 5000;

	// 1-1) 매개변수, return 값 없음
	public void juiceCafe1() {
		System.out.println("** 무슨 주스를 원하나요?");
	}

	// ** 메서드 명
	// => 일반적인 식별자 규칙을 준수 / 소문자로 시작
	// => 동일한 이름의 메서드명 허용 단, 매개변수의 타입이나 갯수가 달라야 함
	public void juiceCafe1(int n) {
		System.out.println("** 메서드 명 Test : " + n);
	}

	// 1-2) 매개변수 있음, return 값 없음
	public void juiceCafe2(String s, int n) {
		System.out.println("** 주문 내용 : ");
		System.out.printf("%s 주스, %d 잔\n", s, n);

		// 2. return Test
		// => 5잔 이하 주문 시 종료하기
		// => void 매서드에서 return 사용 시 종료
		if (n < 5) {
			System.out.println("5잔 이상 주문하세요");
			return;
		}

		// 3-1) 매개변수 전달 test
		// => 하단의 kind 에 의해 전달된 s의 값을 변경
		s = "바나나";
		System.out.println("CallByValue test : " + s);
	}

	// 1-3) 매개변수 없음, return 값 있음
	public String juiceCafe3() {
		return "주스 1잔은" + price + "입니다";
	}

	// 1-4) 매개변수, return 값 있음
	public int juiceCafe4(String s, int n) {
		System.out.printf("%s 주스, %d 잔 총액 \n", s, n);
		return price * n;
	}

	// 3-2) 참조자료형
	// 매개변수, return 값 있음
	public int carTest(Car car, int speed) {
		System.out.println("carTest 1 : " + car);

		car.color = "Pink";
		System.out.println("carTest 2 : " + car);

		return car.speed + speed;
	}

	public static void main(String[] args) {
		// ** 메서드 호출
		// juiceCafe1();
		// price = 9000;
		// => 같은 클래스 안에서라도 접근하기 위해서는 인스턴스가 필요함

		Ex03_Method ex03 = new Ex03_Method();
		// ex03.price = 9000;

		ex03.juiceCafe1();
		ex03.juiceCafe2("수박", 2);
		// ex03.juiceCafe2(2, "수박"); // 호출 시 반드시 인자(매개변수)가 일치해야 함
		System.out.println(ex03.juiceCafe3());
		System.out.println(ex03.juiceCafe4("오렌지", 2));

		// ** 메서드 명 test
		ex03.juiceCafe1(123); // 매개변수가 다르면 동일 메서드 명 호출 가능

		// 3-1) 매개변수 전달 test1 (Call By Value)
		String kind = "딸기";
		ex03.juiceCafe2(kind, 12);
		System.out.println("main kind : " + kind);

		// 3-2) 매개변수 전달 test2 (Call By Reference 참조지료형)
		Car c1 = new Car();
		c1.color = "Blue"; // 인스턴스
		c1.speed = 1000; // 인스턴스
		c1.mileage = 1000; // 인스턴스
		System.out.println("main before c1 : " + c1);
		ex03.carTest(c1, 500);
		System.out.println("main after c1 : " + c1);

		// ** 참조형 매개변수 사용 비교
		System.out.println("바로 생성 return 값 : " + ex03.carTest(new Car(), 999));
		// => 매개변수 위치에서 바로 생성가능하지만, 인스턴스로는 사용 불가능
		// => 따라서 Car 를 일회성 매개변수로만 사용하는 경우에만 적당함

	} // main

} // class