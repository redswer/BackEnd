package j03_forWhile;

//** Continue 
//=> Continue 문 이하의 구문을 실행하지 않고 다음 반복문 진행

//** Break
//=> 반복문 탈출

//** Label
//=> continue, break 가 적용될 반복문을 지정할 수 있도록 해줌
//=> 위치를 표시함
//  반드시 ":" 표시,
// 반드시 반복문 바로 위에 위치함.
// -> Label 다음에 반복문외의 문장이 오면 break, continue 에서 인식안됨 오류

// ** 과제
// => 5층건물에 각 층마다 7개의 방이 있고 이것을 [층,호실] 출력하기
// => 4층 4호 는 창고이기 때문에 출력하지 않는다.

public class Ex05_ContinueBreak {

	public static void main(String[] args) {

		// ** 1. 모든 방 번호 출력
		System.out.println("** 모든 방 번호 출력 **");

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 8; j++) {
				System.out.printf("[%d, %d] ", i, j);
			}

			System.out.println("");
		}
		System.out.println("\n==========================\n");

//		========================================

		// ** 2. 4층 4호 출력하지 않기
		System.out.println("** 4층 4호 출력하지 않기 **");

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 8; j++) {

				if (i == 4 && j == 4)
					continue;

				System.out.printf("[%d, %d] ", i, j);
			}

			System.out.println("");
		}
		System.out.println("\n==========================\n");

//		===========================================

		// ** 3. 3층은 5호까지만 있다
		System.out.println("** 3층은 5호까지만 **");

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 8; j++) {

				if (i == 3 && j == 6)
					break;

				System.out.printf("[%d, %d] ", i, j);
			}

			System.out.println("");
		}
		System.out.println("\n==========================\n");

//		===========================================

		// ** 4. Label 적용
		System.out.println("** Label 적용 **");

		apple:
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 8; j++) {

				if (i == 4 && j == 4)
					continue apple;
				// => 반복문의 나머지 구문을 수행하지 않고 Labeling 된 반복문의 다음 증가값 진행

				System.out.printf("[%d, %d] ", i, j);
			}

			System.out.println("");
		}
		System.out.println("\n==========================\n");

//		===========================================

		// 5. break
		System.out.println("** break ** ");

		apple:
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 8; j++) {

				if (i == 4 && j == 4)
					break apple;
				// => 반복문의 나머지 구문을 수행하지 않고 Labeling 된 반복문을 무조건 탈출

				System.out.printf("[%d, %d] ", i, j);
			}

			System.out.println("");
		}

	} // main

} // class