package j17_Lamda;

//** @FunctionalInterface Test
//=> 이를 적용한 인터페이스는 한개의 추상메소드만을 선언할수있다.
//=> 그러나 static, default 선언이 붙은 메서드는 무관함.

@FunctionalInterface
interface Value {
	int num(int a, int b);

	// String myString(int a, int b);
	// => FuncitonalInterface 는 무조건 하나의 추상 메서드만 허용
}

class Compute {
	public void inValue(Value v) {
		int result = v.num(5, 10);
		// => num 메서드의 처리 내용은 구현되어있지 않음
		// => inValue 메서드를 호출 시 넣어주는 인자(Value 인터페이스 구현체)에 의해 결정됨

		System.out.println("** inValue_result => " + result);
	}
}// Compute

public class Lm03_Functional {

	public static void main(String[] args) {
		// 1. Lamda 식 사용하지 않는 경우
		System.out.println("** 1. Lamda 식 사용 x, 익명 클래스 (+ 연산) **");

		Compute cp = new Compute();
		cp.inValue(new Value() {
			@Override
			public int num(int a, int b) {
				return a + b;
			}
		});

		System.out.println("");
//		=========================================
		// 2. Lamda 식 사용하는 경우
		System.out.println("** Lamda 식 사용 (* 연산)");

		cp.inValue((a, b) -> {
			System.out.printf("** num : a = %d, b = %d\n", a, b);
			return a * b;
		});

		System.out.println("");
//		===========================================
		// 3. 생략형 Lamda 식
		System.out.println("** 생략형 Lamda 식 사용 (- 연산)");

		cp.inValue((a, b) -> a - b);

	}// main

}// class