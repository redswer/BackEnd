package j08_AbsInterface;

//** 추상클래스 와 interface 의 활용 
//=> 일반적인 경우 사례
//=> 실무에서는 interface가 많이 사용되고 (다중구현의 장점) ,  
// API 의 계층도에서는 추상클래스도 많이 이용됨 

//** 과제
//=> 게시판을 종류별로 10개 이상 만든다고 가정.
//=> 기본 기능 (interface) : insert, update, delete, listPrint, detail, replyInsert
//=> 게시판 종류별로 : 일반게시판(i,u,d,l,detail,r), QnA(i,r,l), 공지사항(i,l,detail)
//=> 모든 게시판은 interface 를 구현해야한다면
// 게시판 종류에 따라 필요없는 메서드도 오버라이딩 해야함.
// 이런 경우 interface 를 구현하는 추상 클래스를 작성하고
// 게시판은 이 추상클래스를 구현한다면 의무적 구현에서 벗어나 필요한 메서드만 구현 할 수 있음.

interface Boardi {
	void insert();

	void update();

	void delete();

	void listPrint();

	void detail();

	void replyInsert();
}

// ** 추상클래스 : 일반메서드, 추상메서드
// => 추상 클래스는 추상메서드를 포함 할 수 있으므로 오버라이딩 의무는 없음
// => 선택적으로 오버라이딩 가능
// => 의무구현 메서드(i,l)는 추상메서드로 두고, 선택적 구현메서드 들은 미리 구현해놓음
//	    그러므로 구현 클래스들의 의무구현 코드를 줄여줌
abstract class BoardA implements Boardi {
	@Override
	public void replyInsert() {
	}

	@Override
	public void delete() {
	}

	@Override
	public void update() {
	}

	@Override
	public void detail() {
	}
}// BoardA

class MyBoard implements Boardi {
	public void insert() {
		System.out.println("** QnA Insert **");
	}

	@Override
	public void listPrint() {
		System.out.println("** QnA List **");
	}

	@Override
	public void replyInsert() {
		System.out.println("** QnA replyInsert **");
	}

	@Override
	public void delete() {
	}

	@Override
	public void update() {
	}

	@Override
	public void detail() {
	}
}// MyBoard

// => 위의 MyBoard 처럼 implements 로 받으면 모든 override 필수로 작성해야 함
// => 따라서 밑의 QnABoard 처럼 추상 클래스를 상속(extends) 받도록 하여 의무를 줄여줌 

// class QnABoard implements Boardi {
class QnABoard extends BoardA {
	@Override
	public void insert() {
		System.out.println("** QnABoard Insert **");
	}

	@Override
	public void listPrint() {
		System.out.println("** QnABoard ListPrint **");
	}

	@Override
	public void replyInsert() {
		System.out.println("** QnABoard ReplyInsert **");
	}
}// QnABoard

class NoticeBoard extends BoardA {
	@Override
	public void insert() {
		System.out.println("** NoticeBoard Insert **");
	}

	@Override
	public void listPrint() {
		System.out.println("** NoticeBoard ListPrint **");
	}
}

public class Ex06_AbsInter {

	public static void main(String[] args) {

		Boardi bi = new QnABoard();
		// => interface 보다 적은 메서드 구현했지만, interface 의 모든 메서드를 오버라이딩한 추상 클래스를 상속 받았음

		bi.update();
		bi.listPrint();
		// => update 는 오버라이딩 하지 않았기 때문에 출력되지 않지만, 추상 클래스에 정의되어 있기 때문에 오류는 없음

		BoardA ba = new QnABoard();
		// => BoardA 를 상속받지 않은 new MyBoard 로는 생성할 수 없음
		// => 상속받은 QnABoard 나 NoticeBoard 는 가능

		ba.listPrint();
		ba.delete();
		// => QnABoard 에는 정의되어 있지 않지만 조상 클래스인 BoardA에는 정의되어 있기 때문에 오류 없음
		// => 그러나 BoardA 에는 없고 QnABoard 에만 정의한 메서드가 있다면 사용 불가

	}// main

}// class