package j05_classMethod;

//** 생성과정
//=> new 연산자가 해당되는 클래스를 메모리에 로드해서 생성함.
//=> 이때 생성직후 생성자메서드를 호출함

//** 생성자(Constructor) 메서드
//=> 클래스와 이름 동일하고, return 값이 없음. (void 조차도 생략됨)
//그러나 매개변수는 갯수, Type 제한 없음
//=> 생성시에 단한번 호출가능 
//=> 한 클래스의 생성자는 여러개 가능 (생성자 오버로딩) 
//=> 생성자를 작성하지 않으면 컴파일러가 자동으로 기본생성자를 만들어줌(Default Constructor)
//(단, 하나라도 생성자 메서드를 작성하면 Default 생성자는 자동으로 만들어지지않음)

//** 생성자 메서드에서 생성자 메서드 호출 가능 
//=> this(?,?,...)
//=> this(...) 은 반드시 생성자 메서드 내에서 첫줄에 위치해야함.

class Phone {
	String company;
	String number;
	int price;

	static int count;

	public int dataUp(int i) {
		return i * 100;
	}

	public String toString() {
		return "[ company = " + company + ", number = " + number + ", price = " + price + " ]\n";
	}

//	============================================================
	// ** company 변수를 초기화하는 생성자 + static count 확인
	// => 클래스와 이름이 동일하고 return 값 없음 (void 도 생략)

	public Phone(String company, int count) {
		// this(company, null, 0, 100);
		// => String, String, int, int 타입인 생성자 호출 -> 밑의 p3에 해당하는 생성자 Phone
		// => 반드시 첫 줄에 위치해야 하고, 한 번만 사용 가능함

		this.company = company;

		// this.count = count;
		Phone.count = count;
		// => this 는 instance 종속이고 static 은 class 종속이기 때문에 Phone.count 가 맞는 표현

		System.out.println("** company 변수만 초기화된 생성자");
	}

	// public Phone(String number) { }
	// => 매개변수가 같은 타입, 같은 갯수이면 허용하지 않음

	// public Phone(int price) { }
	// => 같은 갯수라도 타입이 다르면 허용

//	=============================================================
	// ** 디폴트 생성자
	// => 위에서 생성자를 추가하게 되면 default 생성자가 자동 생성되지 않기 때문에 필요하다면 직접 생성해 줘야 함
	// => 밑의 Phone p1 = new Phone() 을 사용하기 위해 추가함
	// public Phone() { } => 내용이 없어도 추가해야 함
	public Phone() {
		System.out.println("** 디폴트 생성자");
	}

//	====================================
	// ** 변수를 모두 초기화하는 생성자 + static count

	public Phone(String company, String number, int price, int count) {
		this.company = company;
		this.price = price;
		this.number = number;
		Phone.count = count;
		System.out.println("** 모든 변수 초기화된 생성자");
	}

	// public Phone(String company, int price, String number) { }
	// => 변수가 같아도 순서가 다르면 추가 가능함

} // Phone

public class Ex07_Constructor {

	public static void main(String[] args) {
		// 1) default 생성자 확인

		Phone p1 = new Phone(); // => 위에서 생성자를 추가하게 되면 오류 (default 생성자 자동 생성되지 않음)

		p1.company = "삼성";
		p1.number = "010-1234-5678";
		p1.price = 20000;

		System.out.println("p1 : " + p1);

//		===========================================
		// 2) 생성자 호출

		Phone p2 = new Phone("애플", 5);

		p2.number = "010-2345-6789";
		p2.price = p2.dataUp(640);

		System.out.println("p2 : " + p2);

//		============================================
		// 3) 변수를 모두 초기화한 생성자 호출
		Phone p3 = new Phone("노키아", "011-1111-1111", p1.dataUp(100), 5);

		System.out.println("p3 : " + p3);
		System.out.println("count = " + Phone.count);

	} // main

}
// class