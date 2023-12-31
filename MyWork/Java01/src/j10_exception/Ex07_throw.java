package j10_exception;

//** 예외생성
//=> throw : 예외(Exception) 생성하기 (던지다)
//=> throws: 예외(Exception) 전달하기 (떠넘기기, 던지다)

//=> extends Exception => Checked Exception 
//=> extends RuntimeException => UnChecked 예외 (예외처리를 강제하지 않음)

public class Ex07_throw {

	public static void main(String[] args) {
		// 1) Exception 생성하기

		// 1-1) unChecked
//		throw new RuntimeException(); // => unChecked Exception

		// 1-2) checked
		// throw new Exception(); // => checked Exception 이므로 try 블럭 필요
//		try {
//			throw new Exception("** throw Test **");
//			// => 생성자 안에 String 을 주면 String 메세지 출력
//
//		} catch (Exception e) {
//			System.out.println("** Exception1 => " + e.toString());
//		}

//		======================================================		
		// 2) MyException
		// => 특정 상황에 대해 Exception 으로 정의할 수 있음
		// => 인스턴스를 정의할 수 있고, 일회적으로 사용한다면 인스턴스 없이 정의 가능

		try {
			double result = 1.5 / 0.0;

			if (Double.isInfinite(result)) {
				Exception myE = new Exception("** 의도적 Exception, result = " + result);
				throw myE;
			}

		} catch (Exception e) {
			System.out.println("** Exception2 => " + e.toString());
		}

		System.out.println("** Program 정상종료 **");
	}// main

}// class