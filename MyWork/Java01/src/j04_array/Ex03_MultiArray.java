package j04_array;

//** 다차원 배열
//1차원 배열이 2개 모이면 2차원 배열
//1차원 배열이 3개 모이면 3차원 배열 ...2차원 이상은 거의 안쓰임

public class Ex03_MultiArray {

	public static void main(String[] args) {
		// mul = {{10, 20, 30}, {11, 22, 33 }}
		System.out.println("** 명시적 선언\n");

		// 1-1. 명시적 선언
		int[][] mul = new int[2][3];

		// 1-2. 초기화
		mul[0][0] = 10;
		mul[0][1] = 20;
		mul[0][2] = 30;
		mul[1][0] = 11;
		// mul[1][1] = 22;
		// => 배열에서 값을 할당하지 않으면 default 값을 가짐 -> int 의 디폴트값인 0
		mul[1][2] = 33;

		// ** 활용
		// => 연산 가능
		mul[0][0] = mul[0][1] + mul[1][0];

		// 1-3. 출력
		// => for 문 활용
		for (int i = 0; i < mul.length; i++) {
			for (int j = 0; j < mul[i].length; j++) {
				System.out.printf("mul[%d,%d] = %d\n", i, j, mul[i][j]);
			}
		}

//		====================================================
		System.out.println("========================");
		System.out.println("** 묵시적 선언\n");

		// 2-1. 묵시적 선언
		// => 선언과 동시에 초기화
		int[][] mul2 = { { 100, 200, 300 }, { 111, 222 }, { 999 } };
		// => 명시적으로 내부배열의 크기가 정의되어있지 않기 때문에 각각의 크기를 가짐

		// 2-2. 출력
		for (int i = 0; i < mul2.length; i++) {
			for (int j = 0; j < mul2[i].length; j++) {
				System.out.printf("mul2[%d,%d] = %d\n", i, j, mul2[i][j]);
			}
		}

		// ** 확인 : 없는 배열 data(index) 출력
		// System.out.println("확인 => " + mul2[1][2]);
		// => 런타임 오류

	} // main

} // class