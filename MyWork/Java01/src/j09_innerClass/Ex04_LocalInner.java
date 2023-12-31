package j09_innerClass;

//** LocalInner Class
//=> 메서드의 내부에 정의되는 InnerClass.
//=> 메서드내에 정의되는 지역변수와 같다 (즉, 메서드내에서만 사용됨)
//=> static Local_InnerClass는 허용 되지 않음
// 단, 상수는 허용

public class Ex04_LocalInner {

	int a = 100;

	Ex04_LocalInner() {
		System.out.println("** Ex04_LocalInner default 생성자 **");
	}

	public void innerTest(int n) {
		int b = 200;
		final int C = n;
		System.out.printf("** innerTest1() : a = %d, b = %d, C = %d\n", a, b, C);

		// ** Local Inner Class

		class Linner {
			int d = 400;

			Linner() {
				System.out.println("** Linner default 생성자 **");
			}

			public void printData() {
				System.out.printf("** Linner_printData() : a = %d, b = %d, C = %d, d = %d\n", a, b, C, d);
			}
		}

		System.out.printf("** innerTest2() : a = %d, b = %d, C = %d\n", a, b, C);

//		=====================================
		// ** Local Inner Class 사용

		Linner li = new Linner();
		// => 인스턴스 생성 후 접근 가능

		li.printData();

	}// innerTest

//	=========================================

	public static void main(String[] args) {
		// 1) OuterClass 인스턴스 생성

		Ex04_LocalInner Ex04 = new Ex04_LocalInner();
		Ex04.innerTest(300);
		// => 순서 : innerTest1 -> innerTest2 -> Linner 인스턴스 생성 -> printData()

	}// main

}// class