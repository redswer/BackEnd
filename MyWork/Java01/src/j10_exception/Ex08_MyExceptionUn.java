package j10_exception;

import java.util.Scanner;

// ** AgeException 1 : Unchecked
// => 즉, 컴파일러가 예외처리(try~catch~finally)를 확인하지 않음
//=> 주로 프로그래머의 실수로 발생 가능한 오류들
// => 나이의 값이 범위를 벗어나면 Exception 발생

class AgeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	AgeException() {
		super("나이값이 범위를 벗어남");
	}

	AgeException(String message) {
		super(message);
	}
}// AgeException

// ========================================================
// AgeException 2 : checked

class AgeExceptionCk extends Exception {
	private static final long serialVersionUID = 1L;

	AgeExceptionCk() {
		super("Age Error_CheckedException");
	}

	AgeExceptionCk(String message) {
		super(message);
	}

}// AgeExceptionCk

public class Ex08_MyExceptionUn {
	static Scanner sc = new Scanner(System.in);
// ========================================================
	// 1) Unchecked Exception
	// ** 나이 입력받아 return 하는 메서드 만들기
	// => 예외처리코드를 컴파일시에 확인하지않음

	public static int readAge() {
		System.out.println("나이를 입력하세요");
		int age = Integer.parseInt(sc.nextLine());

		if (age < 1 || age > 200) {
			throw new AgeException();
			// => UnChecked Exception 이기 때문에 오류 메세지 없음
		} else {
			return age;
		}
	}

//	==========================================================
	// 2) Checked Exception

	public static int readAgeCk() throws Exception {
		System.out.println("나이를 입력하세요");
		int age = Integer.parseInt(sc.nextLine());

		if (age < 1 || age > 200) {
			throw new AgeExceptionCk();
			// => Checked Exception 이기 때문에 try~catch 나 throws Exception 없이는 오류
		} else {
			return age;
		}
	}

	public static void main(String[] args) {
//		==================================================
		// Test 1) Unchecked Test
		// => 예외처리코드를 컴파일시에 확인하지않음 / 런타임시 오류 발생하면 비정상 종료

//		System.out.println("** main test 1 => age : " + readAge());
		// => 컴파일 오류 없지만 런타임 오류 발생

		// 예외처리 코드 적용
		try {
			System.out.println("** main test 1 => age : " + readAge());
		} catch (Exception e) {
			System.out.println("** main Exception => " + e.toString());
		}

//		==================================================
		// Test 2) Checked Test

		// System.out.println("** main test 2 => age : " + readAgeCk());
		// => 컴파일 오류 -> 반드시 예외처리 코드를 작성하거나 throws Exception 해야 함

		try {
			System.out.println("** main test 2 => age : " + readAgeCk());
		} catch (Exception e) {
			System.out.println("** main Exception 2 => " + e.toString());
		}

		sc.close();
		System.out.println("** Program 정상 종료 **");
	}// main

}// class