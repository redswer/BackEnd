package a01_homework;

public class Ex02_230901 {

	public static void main(String[] args) {
		// ** 5-3
		int[] arr = { 10, 20, 30, 40, 50 };
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		System.out.println("sum = " + sum);

//		============================================

		// ** 5-4
		int[][] arr2 = { { 5, 5, 5, 5, 5 }, { 10, 10, 10, 10, 10 }, { 20, 20, 20, 20, 20 }, { 30, 30, 30, 30, 30 } };

		int total = 0;
		float avg = 0;

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				total += arr2[i][j];
			}
		}
		avg = total / (float) (arr2.length * arr2[0].length);
		System.out.println("total = " + total);
		System.out.println("avg = " + avg);

	} // main

} // class