package j10_exception;

import java.util.Scanner;

//** 실습
//=> 두개의 정수를 입력 받아 4칙연산(+,-,*,/) 결과 출력하기
//=> 입력 정수는 1 ~ 99 까지 허용
//=> nextLine() 으로 입력 받기 -> try~catch 적용하기
//1) 범위를 벗어난 값를 입력하면 정상 값 입력 할때까지 반복
//2) 반복분 이용해서 종료하고 싶을때까지 Test 하기.

//** Scanner 사용시 주의 사항
//=> nextInt() , nextLine() 사용시 주의
// nextInt()는 개행문자 (\n) 가 뒤에 붙고, 숫자만 받아 처리한다. 
// 그래서 nextInt() 만 계속되면 문제가 없는데, 
// 뒤이어서 nextLine() 이 오면 앞 nextInt() 의 
// 남겨진 \n 을 한줄로 인식 받아 버린다.

public class Ex02_Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		num:
		for (;;) {
			try {
				System.out.println("1부터 99 사이의 정수를 입력하세요");
				int num1 = Integer.parseInt(sc.nextLine());
				if (num1 > 99 || num1 < 1) {
					System.out.println("** 1부터 99 사이의 숫자가 아닙니다. 다시 입력하세요 **");
					continue num;
				}

				System.out.println("1부터 99 사이의 정수를 입력하세요");
				int num2 = Integer.parseInt(sc.nextLine());
				if (num2 > 99 || num2 < 1) {
					System.out.println("** 1부터 99 사이의 숫자가 아닙니다. 다시 입력하세요 **");
					continue num;
				}

				System.out.println("덧셈 => " + (num1 + num2));
				System.out.println("뺄셈 => " + (num1 - num2));
				System.out.println("곱셈 => " + (num1 * num2));
				System.out.println("나눗셈 => " + ((float) num1 / (float) num2));

				sc.close();
				break;
				
			} catch (Exception e) {
				System.out.println("** 정수가 아닙니다. 다시 입력하세요 **");
			}
		}// for

	}// main

}// class