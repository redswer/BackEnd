package j05_classMethod;

//** 재귀적 호출 ( Recursive Call )
//=> 메서드가 메서드 내부에서 자신을 호출
//=> Factorial 연산에 주로 이용됨 
//=> 5! = 5*4*3*2*1
// n! = n*(n-1)*(n-1-1)*(n-1-1-1)...*1 

public class Ex04_Factorial {
	public int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
			// 메서드 내부에서 자신을 호출 : 재귀적 호출 (Recursive Call)
			// 5! => 5*factorial(4) -> 5*4*factorial(3) -> 5*4*3*factorial(2)
			// -> 5*4*3*2*factorial(1) -> 5*4*3*2*1
		}
	}

	// 3) static 메서드 test
	public static int factorial2(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial2(n - 1);
		}
	}

	public static void main(String[] args) {
		// 1. 인스턴스 정의
		Ex04_Factorial ex04 = new Ex04_Factorial();

		// 2. 출력
		System.out.println("5! = " + ex04.factorial(5));

		// 3. static 메서드 test
		// => 인스턴스 생성 불필요
		System.out.println("10! = " + factorial2(10));

	} // main

} // class