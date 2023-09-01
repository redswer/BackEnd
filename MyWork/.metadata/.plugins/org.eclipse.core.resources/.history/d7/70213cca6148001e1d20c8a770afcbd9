package a01_homework;

import java.util.Scanner;

public class Ex01_230831 {

	public static void main(String[] args) {

		// 4-6
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				if (i + j == 6) {
					System.out.println(i + "+" + j + "=" + (i + j));
				}
			}
		}

//		=======================================
		System.out.println("");

		// 4-7
		String str = "12345";
		int sum = 0;

		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		System.out.println("sum = " + sum);

//		=======================================
		System.out.println("");

		// 4-9
		int num = 12345;
		sum = 0;

		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		System.out.println("sum = " + sum);

//		=======================================
		System.out.println("");

		// 4-10
		int answer = (int) (Math.random() * 100) + 1;
		int input = 0;
		int count = 0;

		Scanner sc = new Scanner(System.in);

		do {
			count++;
			System.out.println("1과 100 사이의 정수를 입력하세요");
			;
			input = sc.nextInt();

			if (answer > input) {
				System.out.println("더 큰 수를 입력하세요");
			} else if (answer < input) {
				System.out.println("더 작은 수를 입력하세요");
			} else {
				System.out.println("맞췄습니다");
				System.out.println("시도 횟수는 " + count + " 번 입니다");
				break;
			}
		} while (true);
		sc.close();
	} // main

} // class