package j05_classMethod;

// ** MyClass
// => 멤버변수 3개, 메서드 2개 정의
// => MyClass 를 정의하고 Ex02_MyClassTest 에서 인스턴스 2개 만들어 출력하기

class Book {
	public String name = "개미";
	public String writer = "베르나르 베르베르";
	public int price = 20000;
	public int count = 1;

	public void countUp() {
		count += 1;
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
		myBook.countUp();
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
