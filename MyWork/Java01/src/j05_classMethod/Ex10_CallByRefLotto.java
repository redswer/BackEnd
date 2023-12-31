package j05_classMethod;

import java.util.Arrays;

public class Ex10_CallByRefLotto {

	// ** j06_packageTest 패키지의 Ex01_AccessTest 를 위한 변수선언
	int ddd = 100; // -> default
	public int iii = 200; // -> public instance
	public static int sss = 300; // -> public static

//	==========================================================

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

//		===================================================

		lottoSort(lotto, 'c'); // => A 이면 ascending(오름차순) 아니면 내림차순(descending)
		System.out.println("\n정렬 매서드");
		System.out.println(Arrays.toString(lotto));

	} // main

	public static void lottoSort(int[] lotto, char c) {
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if ((c == 'A' ? (lotto[i] > lotto[j]) : (lotto[i] < lotto[j]))) {
					int l = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = l;
				}
			}
		}
	}

} // class
