package j10_exception;

public class Ex04_MessageNaN {

	public static void main(String[] args) {

		// ** by Zero ( 나누기 0 )
		// => 정수형 연산 : ArithmeticException
		// => 실수형 연산 : Exception 이 일어나지 않음
		// Wrapper 클래스의 메서드 활용

		try {
			// 실수형 연산
			double d1 = 1.5 / 0.0; // => Infinity
			double d2 = 1.5 % 0.0; // => NaN
			// => 그러므로 실수 zero 연산은 Exception 으로 대응할 수 없음

			System.out.printf("실수 by zero Test : d1 = %f, d2 = %f, d1 * 100 = %f\n", d1, d2, (d1 * 100));

			// 정수형 연산
			System.out.printf("정수 by zero Test : 100/0 = %f\n", (100 / 0));

			if (Double.isInfinite(d1) || Double.isNaN(d2)) {
				System.out.println("** Zero 연산 불가 **");
			} else {
				System.out.printf("실수 by zero Test : d1 = %f, d2 = %f, d1 * 100 = %f\n", d1, d2, (d1 * 100));
			}
		} catch (Exception e) {
			System.out.println("** Exception, toString => " + e.toString());
			System.out.println("** Exception, getMessage => " + e.getMessage());
			System.out.printf("** Exception, printStackTrace => ");
			e.printStackTrace(); // => 호출만으로도 출력됨 (toString 을 포함한 순차적인 실행경로 출력)
		} finally {
			System.out.println("** finally_무조건 실행 **");
		}
		System.out.println("** Program 정상 종료 **");
	}// main

}// class