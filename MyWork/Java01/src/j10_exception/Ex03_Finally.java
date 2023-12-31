package j10_exception;

//** try ~ catch ~ finally
//=> finally 블럭은 무조건 시행

public class Ex03_Finally {

	public static void main(String[] args) {

		int[] price = { 100, 200, 300 };

		// 1) 정상 실행
//		for (int i = 0; i < price.length; i++) {

		// 2) Exception
		for (int i = 0; i <= price.length; i++) {

			try {

				// 3) 반복문 제어할 수 있는 구문 : return, break, continue
//				if (i == 3) continue; // => 나머지 문장 실행하지 않고 다음 반복문 진행
//				if (i == 2) break; // => 무조건 반복문 종료
				if(i == 1) return; // => void 메서드에서 사용하면 메서드 무조건 종료
				// => try 블럭에 진입하면 무조건 finally 는 실행됨
				// => continue, break, return 모두 finally 실행

				System.out.printf("** price[%d] = %d\n", i, price[i]);
			} catch (Exception e) {
				System.out.println("** Exception => " + e.toString());
			} finally {
				System.out.println("** finally_무조건 실행, i => " + i);
			}

			System.out.println("** for_endLine, i => " + i + "\n");
		} // for

		System.out.println("** Program 정상 종료 **");

	}// main

}
// class