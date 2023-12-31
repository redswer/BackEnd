package j10_exception;

//** Exception 계층구조 
//=> Object -> Throwable -> Exception, Error, 
//               Exception -> RuntimeException, IOException 

//=> Error: 프로그램 코드에 의해 수습될 수 없는 심각한 오류
//=> Exception
//-> 프로그램 코드에 의해 수습될 수 있는 오류로, 프로그래머가 예외 처리를 할 수 있음
//-> 반드시 예외 처리를 해야하는 Checked Exception과,
//   예외 처리를 하지 않아도 되는 Unchecked Exception으로 나뉜다.
//=> IOException
//-> Checked Exception
//-> 파일 및 입출력 작업에서 발생하는 Exception
//=> RuntimeException
//-> Unchecked Exception
//-> 개발자의 실수로 발생하는 Exception.

// ** Exception test

// 1) Exception 처리하지 않는 경우
// => Exception 발생 위치에서 비정상 종료

// 2) Exception 처리하는 경우
// => Exception 발생 시 대응을 하여 정상적인 진행

public class Ex01_Basic {

	public static void main(String[] args) {
		int x = 6, y = 3, result = 0;
		String s = "123000";
		String[] names = { "Apple", "Banana", "Coffee" };

		// Test 1 : Exception 처리하지 않는 경우 -> 비정상 종료

//		result = x / 0;

		System.out.println("** result 1 : " + result);
		// => Exception in thread "main" java.lang.ArithmeticException: / by zero

//		==================================
		// Test 2 : Exception 처리하는 경우

		try {
//			y = 0;
			result = x / y;
			System.out.println("** result 2 : " + result);

//			s = "123aaa";
			System.out.println("** result 3 : " + (result += Integer.parseInt(s)));

//			System.out.println("** 배열 Test : " + names[3]);
			System.out.println("** 배열 Test : " + names[2]);

//			names = new String[-1];
			names = new String[5];
			System.out.println("** result 4 : " + names.length);

//			s = null;
			System.out.println("** NullPointerException test : " + s.length());

			// ** Exception 에 다형성 적용
			// => Exception e = new 후손()
			// => 즉, Exception 의 모든 후손 Exception 들이 catch 블럭으로 전달됨
			// => 그러므로 각 Exception 별로 처리하는 것도 가능함
		} catch (ArithmeticException e) {
			System.out.println("** ArithmeticException => " + e.toString());
		} catch (NumberFormatException e) {
			System.out.println("** NumberFormatException => " + e.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("** ArrayIndexOutOfBoundsException => " + e.toString());
		} catch (Exception e) {
			System.out.println("** Exception : " + e.toString());
			// => Exception 이 모든 후손 Exception 을 포함하고 있으므로 가장 마지막에 정의해야 함

		} finally {
			System.out.println("** finally : 무조건 실행 **");
		}

		System.out.println("** 정상 종료 **");

	}// main

}// class