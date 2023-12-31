package j02_ifSwitch;

//** 숫자 맞추기 게임
//=> 1~10 범위에서 숫자 하나를 입력받아
//=> Random 클래스의 추출번호와 일치하면 금메달
//=> 차이가 1 이면 은메달, 차이가 2면 동메달, 아니면 꽝
//=> Math 클래스를 이용하세요 ~~

import java.util.Scanner;
import java.util.Random;

public class Ex05_RandomGame {

	public static void main(String[] args) {

		// ** 1. random number 구하기
		Random random = new Random();
		int happyNum = random.nextInt(10) + 1; // 1 ~ 10 내의 임의의 정수

		// ** 2. number 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.println("1에서 10 사이의 수를 입력하세요");
		int myNum = Integer.parseInt(sc.nextLine());

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

		System.out.println(medal);

		sc.close();
	} // main

} // class