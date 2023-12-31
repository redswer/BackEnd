package j03_forWhile;

import java.util.Random;
import java.util.Scanner;

// 반복문 적용해서 당첨될때까지

public class Ex04_RandomGame {

	public static void main(String[] args) {

		// ** 1. random number 구하기
		Random random = new Random();
		int happyNum = random.nextInt(10) + 1; // 1 ~ 10 내의 임의의 정수

		// ** 2. number 입력받기
		// => 당첨될때까지
		Scanner sc = new Scanner(System.in);
		int myNum = 0;

		while (true) {
			System.out.println("1에서 10 사이의 수를 입력하세요");
			myNum = Integer.parseInt(sc.nextLine());

			// ** 3. 결과 처리
			// => 차이 : happyNum - myNum 의 절대값
			// => Math.abs(happyNum - myNum)
			int result = Math.abs(happyNum - myNum);
			String medal = "금메달";

			switch (result) {
			case 0:
				medal = "금메달";
				break;

			case 1:
				medal = "은메달";
				break;

			case 2:
				medal = "동메달";
				break;

			default:
				medal = "꽝";
			}

			System.out.println("당첨번호: " + happyNum + ", " + medal);

			if (medal != "꽝") {
				break;
			}
		}
		sc.close();
	} // main

} // class
