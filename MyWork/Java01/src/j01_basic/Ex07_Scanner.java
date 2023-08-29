package j01_basic;

import java.util.Scanner;

// ** Console 입력 Scanner

public class Ex07_Scanner {

	public static void main(String[] args) {
		// 1. Scanner 정의(생성)
		Scanner sc = new Scanner(System.in);

//		==============================================

		// 2. 입력받기
		System.out.println("** 이름을 입력하세요 => ");

		String name = sc.nextLine();
		// => 입력완료(Enter_key) 까지 대기, 입력완료된 값을 return

		System.out.println("** 나이를 입력하세요 => ");
		// int age = sc.nextInt();
		// => 정상실행 : 입력된 Enter_key 값은 두고 숫자값만 가져감
		// => 따라서 nextLine을 주로 사용함
		int age = Integer.parseInt(sc.nextLine());

		System.out.println("** 포인트를 입력하세요 => ");
		// double point = sc.nextDouble();
		// => 정상실행 : 입력된 Enter_key 값은 두고 숫자값만 가져감
		// => 위의 경우와 마찬가지
		double point = Double.parseDouble(sc.nextLine());

		System.out.println("** 메뉴를 입력하세요 => ");
		String menu = sc.nextLine();
		// => 위에서 남겨진 Enter_key 값을 인식해서 입력된 것으로 취급하고 넘어감

//		===============================================

		// 3. 출력하기
		System.out.println("** 이름 : " + name);
		System.out.println("** 나이 : " + age);
		System.out.println("** 포인트 : " + point);
		System.out.println("** 메뉴 : " + menu);

		sc.close();
	}

}
