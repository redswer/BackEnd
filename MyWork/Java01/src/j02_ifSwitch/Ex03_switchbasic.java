package j02_ifSwitch;

import java.util.Scanner;

//** switch - case - break 문
//1. => switch(key) 문 인자의 Type은 int, char, String 만 가능
//2. => break : 무조건 탈출 (없으면 아래로 계속 default 까지 진행)
//3. => case 블럭에 구문이 없어도 됨 (아래 구문으로 진행됨)
//4. => case 블럭에는 복합구문에도 {....} 사용하지 않음 
//5. => case 값으로 변수 사용은 불가 그러나 변수를 사용하지 않은 수식은 허용

public class Ex03_switchbasic {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("** 정수를 입력하세요 **");

		// ** 1. int
		int i = Integer.parseInt(sc.nextLine());

		switch (i) {
		case 1:
			System.out.println("** 1 **");
			break;

		case 2:
			System.out.println("** 2 **");
			break;

		case 3:
			System.out.println("** 3 **");
			// break;
			// => break; 가 없으면 입력된 값 아래의 case 를 break; 가 나올때까지 전부 실행함

		case 4:

		case 13:
			// => 각 case 의 순서는 상관없음
			System.out.println("** 13 **");

			// ** i 값 = 짝수 / 홀수 출력
//			if (i % 2 == 0) {
//				System.out.println("i = 짝수");
//			} else {
//				System.out.println("i = 홀수");
//			}
			System.out.println("i = " + i + ", " + (i % 2 == 0 ? "짝수" : "홀수"));

			break;
		// => 각 case 안의 break; 는 항상 맨 마지막에

		case 5:
			System.out.println("** 5 **");

		default:
			System.out.println("default");
		}

		System.out.println("\n=================\n");
//		====================================================

		// ** 2. char
		// char code = sc.nextLline(); -> nextLine은 String 을 의미하기 때문에 오류
		System.out.println("** 코드를 입력하세요 **");
		char code = sc.nextLine().toUpperCase().charAt(0);

		switch (code) {
		case 'A':
			System.out.println("예술가");
			break;

		case 'P':
			System.out.println("개발자");
			break;

		case 'C':
			System.out.println("요리사");
			break;

		default:
			System.out.println("학생");
		}

		System.out.println("\n=================\n");
//		=====================================================

		// ** 3. String
		System.out.println("** color 를 입력하세요 **");
		String color = sc.nextLine().toLowerCase();

		switch (color) {
		case "red":
			System.out.println("빨강");
			break;

		case "black":
			System.out.println("검정");
			break;

		case "white":
			System.out.println("흰");
			break;

		default:
			System.out.println("?");
		}

//		===================================================

		// ** 4. Switch 구문 중첩
		// => 위 '2. char' 구문을 이용하여 코드가 예술가일 경우에만 color 선택하도록

		System.out.println("** 코드를 입력하세요 **");
		code = sc.nextLine().toUpperCase().charAt(0);

		switch (code) {
		case 'A':
			System.out.println("예술가");

			System.out.println("** color 를 입력하세요 **");
			color = sc.nextLine().toLowerCase();
			switch (color) {
			case "red":
				System.out.println("빨강");
				break;
			case "black":
				System.out.println("검정");
				break;
			case "white":
				System.out.println("흰");
				break;
			default:
				System.out.println("?");
			}

			break;

		case 'P':
			System.out.println("개발자");
			break;

		case 'C':
			System.out.println("요리사");
			break;

		default:
			System.out.println("학생");
		}

		System.out.println("\n** 프로그램 정상 종료됨 **");

//		==========================================

		// ** Ex02 의 '비교2 : 중첩 if' 를 switch 로 바꿔보기
//		if (score >= 90) {
//			grade = 'A';
//		} else {
//			if (score >= 80) {
//				grade = 'B';
//			} else {
//				if (score >= 70) {
//					grade = 'C';
//				} else {
//					if (score >= 60) {
//						grade = 'D';
//					} else {
//						grade = 'F';
//					}
//				} // 70 else
//			} // 80 else
//		} // 90 else
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();

		char grade = 'A';

		switch (score / 10) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'F';
			break;
		}

		System.out.println(grade);

		sc.close();
	} // main

}
// class