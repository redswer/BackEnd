package j09_innerClass;

//** 실습
//추상 메서드가 2개 있는 interface 를 정의하고 
//이를  main 메서드에서 익명 클래스를 이용해서 구현하고
//실행 시켜 보세요 ~~ 

interface Inter {
	public abstract void inter1();

	void inter2(); // => public abstract 생략 가능
}

public class Ex06_Test {

	public static void main(String[] args) {
		Inter in = new Inter() {
			@Override
			public void inter1() {
				System.out.println("** main : 추상 메서드 1 **");
			}

			@Override
			public void inter2() {
				System.out.println("** main : 추상 메서드 2 **");
			}
		};

		in.inter1();
		in.inter2();

	}// main

}// class