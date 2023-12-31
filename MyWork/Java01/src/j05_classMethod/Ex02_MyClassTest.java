package j05_classMethod;

// ** MyClass
// => 멤버변수 3개, 메서드 2개 정의
// => MyClass 를 정의하고 Ex02_MyClassTest 에서 인스턴스 2개 만들어 출력하기

class Book {

	// ** 멤버 변수 = 전역 변수 = global 변수
	// => 클래스 내에 있는 모든 메서드에서 사용 가능
	// => 다른 클래스에서도 접근 가능
	public String name = "개미";
	public String writer = "베르나르 베르베르";
	public int price = 20000;
	public int count = 1;

	public void countUp(int myCount) {
		count += 1;
		System.out.println(count);
		// => 전역변수 count 의 값 +1 = 2 출력됨 / 지역변수 count 가 위에 있으면 지역변수 count 값 출력

		// ** 지역변수 = local 변수
		// => 내부에 정의된 변수 / { } 내부에서만 적용 가능 / 클래스 외부에서 접근 불가능
		// => 전역변수와 동일한 이름의 지역변수를 정의하면 선언한 이후부터 지역변수가 우선 적용
		myCount += count;
		int delFee = 2000;
		int count = 10000;
		System.out.println("countUp 메서드 : " + count + ", " + delFee + ", " + myCount);
		// => 지역변수 count 의 값 = 10000 출력됨
	}

	public void countDown() {
		count -= 1;
	}

	public void priceUp() {
		price += 5000;
	}

	public void priceDown() {
		price -= 5000;
	}

	public String toString() {
		return "[ 제목 = " + name + ", 작가 = " + writer + ", 가격 = " + price + ", 수량 = " + count + ", 총 금액 = "
				+ (price * count) + " ]";
	}
}

public class Ex02_MyClassTest {

	public static void main(String[] args) {
		Book myBook = new Book();
		myBook.name = "1Q84 1권";
		myBook.writer = "무라카미 하루키";
		myBook.countUp(5);
		myBook.priceDown();
		System.out.println(myBook);

		myBook = null;

		Book bestBook = new Book();
		bestBook.name = "개미 전권 (1~5)";
		bestBook.writer = "베르나르 베르베르";
		bestBook.price = 60000;
		System.out.println("\n" + bestBook);

		bestBook = null;

		Book classicBook = new Book();
		classicBook.name = "동물농장";
		classicBook.writer = "조지 오웰";
		classicBook.priceDown();
		classicBook.priceDown();
		System.out.println("\n" + classicBook);

		classicBook = null;

	}

}
