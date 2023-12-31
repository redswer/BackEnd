package j03_forWhile;

//** 반복문의 중첩
//1) if 와의 중첩
//=> 자전거를 10바퀴를 돌리면 0.2Kg 감량 (if)
// 만약 자전거를 200바퀴를 돌렸을때의 감량 출력하기 (for)

//2) for , for 중첩
//=> 자전거를 1번 돌릴때마다 , 줄넘기를 10번 한다.
//=> 자전거 5회 돌릴때 까지 매번 과정의 횟수를 출력한다.
// 자전거 1 : 줄넘기 1,2,3,4,5,6,7,...10
// 자전거 2 : 줄넘기 1,2,3,4,5,6,7,...10
// [1,1] [1,2] [1,3] [1,4]......[1,10]
// [2,1] [2,2] [2,3] [2,4]......
//=> 전체 줄넘기 횟수 출력하기

public class Ex02_MultiLoop {

	public static void main(String[] args) {
		// 1) if 와의 중첩
		double result = 0;
		int i;
		for (i = 1; i < 201; i++) {
			if (i % 10 == 0) {
				result += 0.2;
			}
		}
		System.out.println("총 감량 : " + result);
		System.out.println("\n===========================\n");

//		========================================

		// ** 응용
		// => 1~100 까지의 정수중 3의 배수의 합을 출력하세요 ~~
		result = 0;
		for (i = 1; i < 101; i++) {
			if (i % 3 == 0) {
				result += i;
			}
		}
		System.out.println("1부터 100사이의 3의 배수의 합 : " + result);
		System.out.println("\n===========================\n");

//		=========================================

		// ** 2) for 중첩
		result = 0;
		for (i = 1; i < 6; i++) {
			for (int l = 1; l < 11; l++) {
				System.out.printf("[%d,%d] ", i, l);
				result++;
			}
			System.out.println("");
		}
		System.out.println("전체 줄넘기 횟수 : " + result);

	} // main

} // class