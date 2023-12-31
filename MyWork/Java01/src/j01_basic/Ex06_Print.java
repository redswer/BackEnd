package j01_basic;

import java.util.Date;

public class Ex06_Print {

	public static void main(String[] args) {
		// ** Escape 문자 : 역활이 정해져 있는 문자
		// => \n 줄바꿈, \t 탭간격, ...

		// => 출력형식
		// % : 출력형식을 의미하는 문자열은 반드시 %로 시작,
		// %d : 정수 , %f 실수, %s 문자
		// %,d : 정수에 3자리마다 , 표시
		// %n , \n : 줄바꿈

		String path = "JinHyuk_Ahn\\BackEnd\\MyWork\\src\\jo1_basic";
		System.out.println("** path : " + path);
		// => 경로 출력
		// \ : 뒤의 문자도 출력 -> JinHyuk_Ahn\BackEnd\MyWork\src\jo1_basic 출력됨

		System.out.println("** 따옴표 출력 : " + "'ABC',\"ABC\"");
		// => 마찬가지로 \ 뒤의 문자도 출력 -> 'ABC', "ABC" 처럼 따옴표까지 포함해서 출력

		System.out.println("abcd\tefghi\tjk123\n"); // println + \n 이므로 줄바꿈 2번
		// => \t : tab 간격만큼 띄움

		System.out.println("\n"); // println + \n 이므로 줄바꿈 2번
		System.out.println('\n'); // println + \n 이므로 줄바꿈 2번

		System.out.println('\'');
		// => 한 문자만(char) 출력하는 경우 작은따옴표 허용 -> ' 출력

		System.out.println('A');
		System.out.println('가');

//		===============================================

		// ** print, println, printf
		System.out.print("\n** print 1 : 줄바꿈 x");
		System.out.print("** print 2 : 줄바꿈 o \n");
		System.out.print("** print 3 : tab1 \t tab2 \t tab3");
		System.out.println("");
		System.out.print("** print 4 : 줄바꿈 x \n");

		System.out.printf("** 반지름이 %d 인 원의 넓이 = %10.2f \n", 10, 10 * 10 * Math.PI);
		// => %10.2f -> 전체 10자리 중 소숫점 2자리까지 표시

		System.out.printf("** %s 는(은) %d 학년 %d 반, 학점은 %s \n", "안진혁", 2, 2, 'A');

		// System.out.printf("** %s 는(은) %d 학년 %d 반, 학점은 %s \n", "안진혁", 1.2, 2, 'A');
		// => 출력 Data 와 Format의 Type 이 일치하지 않으면 -> 컴파일오류 없고 런타임오류

//		===============================================

		// ** 날짜출력
		// => java.util.Date 풀네임 사용
		// => 혹은 상단에 import

		Date now = new Date();
		System.out.printf("오늘은 %tY 년 %tm 월 %td 일 입니다. \n", now, now, now);
		System.out.printf("오늘은 %1$tY 년 %1$tm 월 %1$td 일 입니다. \n", now);
		System.out.printf("지금은 %1$tH 시 %1$tM 분 %1$tS 초 입니다. \n", now);
		// => %t : 날짜 시간을 (년: %tY, 월: %tm, 일: %td, 시: %tH, 분: %tM, 초: %tS)
		// $ 사용하면 매개변수의 갯수를 줄일 수 있음
		// => %2$d : 2번째 매개변수 정수
		
//		===============================================

		//**  - 는 왼쪽정렬 방식
		System.out.printf("%3d %10s %8s %5d %n", 1, "jang", "장희정", 20);
		System.out.printf("%3d %10s %8s %-5d %n", 22, "hee", "정효욱", 30);
	}

}