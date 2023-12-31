package j04_array;

import java.util.Arrays;

public class Ex05_Lotto02_Sort {

	public static void main(String[] args) {
		int[] lotto = new int[6];

		for (int i = 0; i < lotto.length; i++) {

			int random = (int) (Math.random() * 45) + 1;
			lotto[i] = random;

			for (int j = 0; j < i; j++) {

				if (lotto[i] == lotto[j]) {

					--i;
					break;
				}
			}

		}
		System.out.println("원본");
		System.out.println(Arrays.toString(lotto));

//		==============================

		// 5) 순서대로 정렬

		// 5-1) 오름차순 정렬
		// => 순차정렬 (Sequence Sort)
		// => 정렬 알고리즘에서 가장 간단하고 기본이 되는 알고리즘으로
		// 배열의 처음과 끝을 탐색하면서 차순대로 정렬하는 가장 기초적인 정렬 알고리즘
		// ** 정렬 알고리즘 : 삽입(insert)정렬, 합병(Merge)정렬, 퀵(Quick)정렬...
		// => https://blog.naver.com/tepet/221690306235

		System.out.println("\n오름차순");
		for (int i = 0; i < lotto.length; i++) {

			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					int l = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = l;
				}
			}
		}
		System.out.println(Arrays.toString(lotto));

//		==================================================

		// 5-2) 내림차순 정렬
		System.out.println("\n내림차순");
		for (int i = 0; i < lotto.length; i++) {

			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] < lotto[j]) {
					int l = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = l;
				}
			}
		}
		System.out.println(Arrays.toString(lotto));

//		===================================================

		// ** 배열 wrapper class : Arrays
		// => Arrays 의 주요 메서드 : equals(null, null), sort(null)

		// 6) myNumber 생성 후 비교하기
		// => 배열 정의, Random 추출, 중복 확인 후 배열에 담기
		// => 정렬, equals 비교
		int[] myNumber = new int[6];

		for (int i = 0; i < myNumber.length; i++) {

			int random = (int) (Math.random() * 45) + 1;
			myNumber[i] = random;

			for (int j = 0; j < i; j++) {
				if (myNumber[i] == myNumber[j]) {
					--i;
					break;
				}
			}
		}

		System.out.println("\n==========================");
		System.out.println("** Arrays.\n");
		System.out.println("당첨번호 " + Arrays.toString(lotto));
		System.out.println("내 번호 " + Arrays.toString(myNumber));
		if (Arrays.equals(lotto, myNumber)) {
			System.out.println("당첨");
		} else {
			System.out.println("꽝");
		}
	} // main

} // class