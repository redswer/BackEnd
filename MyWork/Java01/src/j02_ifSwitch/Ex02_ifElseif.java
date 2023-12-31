package j02_ifSwitch;

import java.util.Scanner;

public class Ex02_ifElseif {

	public static void main(String[] args) {

		// ** 등급 처리
		// => score 90이상:A , 80이상:B, 70이상:C, 60이상:D, 아니면 "F" 출력
		// => 이상 / 이하 (포함)
		// => 초과 / 미만 (불포함)

		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();

		char grade = 'A';

		// 1) grade 확인
		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else if (score >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}

		// 2) grade 출력
		System.out.printf("score = %d, grade = %s \n", score, grade);

//		===========================================

		// ** 비교1
		if (score >= 90)
			grade = 'A';
		if (score >= 80)
			grade = 'B';
		if (score >= 70)
			grade = 'C';
		if (score >= 60)
			grade = 'D';
		else
			grade = 'F';

		System.out.printf("** 비교1 : score = %d, grade = %s \n", score, grade);

//		===========================================

		// ** 비교2 : 중첩 if
		if (score >= 90) {
			grade = 'A';
		} else {
			if (score >= 80) {
				grade = 'B';
			} else {
				if (score >= 70) {
					grade = 'C';
				} else {
					if (score >= 60) {
						grade = 'D';
					} else {
						grade = 'F';
					}
				} // 70 else
			} // 80 else
		} // 90 else

		System.out.printf("** 비교2 : score = %d, grade = %s \n", score, grade);

		sc.close();
	} // main

} // class
