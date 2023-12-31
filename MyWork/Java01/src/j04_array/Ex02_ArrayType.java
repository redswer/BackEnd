package j04_array;

import java.util.Arrays;

public class Ex02_ArrayType {

	public static void main(String[] args) {
		// ** 타입별로 배열을 정의하고 출력하기
		// => 묵시적 정의, 출력은 eachFor 구문으로
		// => float, char, string
		// => data 갯수는 5개

		// 1. float

		System.out.println("** float\n");

		float[] f = { 1.1f, 2.2f, 3.3f, 4.4f, 5.5f };
		// => 기본적으로 실수는 double 타입이기 때문에 뒤에 f 를 붙여야 float 타입이 됨
		int sum = 0;

		for (float n : f) {
			System.out.print("[" + n + "] ");
			sum += n;
		}
		System.out.println(", float 배열의 합 : " + sum);

//		=====================================================
		// 2. char

		System.out.println("============================");
		System.out.println("** char\n");

		char[] a = { 'C', 'H', 'A', 'R' };
		String word = "";

		for (char alp : a) {
			System.out.print("[" + alp + "] ");
			word += alp;
		}
		System.out.println(", char 배열의 합 : " + word);

//		=====================================================
		// 3. string

		System.out.println("============================");
		System.out.println("** string\n");

		String[] w = { "have", "a", "nice", "day" };
		word = "";

		for (String hello : w) {
			System.out.print("[" + hello + "] ");
			word += hello + " ";
		}
		System.out.println(", string 배열의 합 : " + word);

//		=====================================================
		// 4. long

		System.out.println("============================");
		System.out.println("** long\n");

		long[] price = { 12345, 50000, 889000, 123456789012L };
		// => 정수는 기본적으로 int 타입으로 표기되기 때문에 long 타입으로 표기하려면 뒤에 L 을 붙여야 하지만,
		// int 로 표기할 수 있는 범위까지는 자동 형변환(long = 8byte, int = 4byte)이
		// 일어나기 때문에 생략 가능
		sum = 0;

		for (long l : price) {
			System.out.print("[" + l + "] ");
			sum += l;
		}
		System.out.println("long 배열의 합 : " + sum);

//		=====================================================
		// ** 배열 지원하는 wrapper class : Arrays

		System.out.println("============================");
		System.out.println("** Wrapper Class : Arrays\n");

		System.out.println(Arrays.toString(f));
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(w));
		System.out.println(Arrays.toString(price));

	} // main

} // class