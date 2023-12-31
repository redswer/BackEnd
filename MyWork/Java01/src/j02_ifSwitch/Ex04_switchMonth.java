package j02_ifSwitch;

import java.util.Scanner;

//** 실습 : 
//1. 월을 입력 받아서 
//2. 몇일까지 인지,  
// => 1,3,5,7,8,10,12월 => ?월은 31일 까지 입니다.
// => 4,6,9,11 월 => ?월은 30일 까지 입니다.
// => 2 월 => ?월은 29일 까지 입니다.
//3. 무슨 계절인지 출력 하기
//  => 3~5:봄 , 6~8:여름, 9~11:가을, 12~2:겨울

//** switch case 구문으로 작성 하세요 ~~

public class Ex04_switchMonth {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// ** 1. 입력받기
		System.out.println("연도를 입력하세요");
		int year = Integer.parseInt(sc.nextLine());

		System.out.println("월을 입력하세요");
		int month = Integer.parseInt(sc.nextLine());

		int days = 31;
		String season = "봄";

//		================================================

		// ** 2. 일
		switch (month) {
		case 2:
			// ** 윤달 추가
			if (((year % 4) == 0 && (year % 100) != 0 || (year % 400) == 0))
				days = 29;
			else
				days = 28;

			season = "겨울";
			break;

		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;

		default:
			days = 31;
		} // switch day

//		=================================================

		// ** 3. 계절
		switch (month) {
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;

		case 6:
		case 7:
		case 8:
			season = "여름";
			break;

		case 9:
		case 10:
		case 11:
			season = "가을";
			break;

		default:
			season = "겨울";
			break;
		} // switch season

//		==========================================

		// ** 4. 출력
		if (month >= 1 && month <= 12) {
			System.out.println(year + "년 " + month + "월은 " + days + "일까지 입니다.");
			System.out.println(month + "월은 " + season + "입니다");
		} else {
			System.out.println("Error : 1부터 12까지의 숫자만 입력하세요");
		}

		sc.close();
	} // main

} // class
