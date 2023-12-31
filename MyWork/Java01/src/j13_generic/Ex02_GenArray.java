package j13_generic;

import j07_classExtends.Ex00_Car;

//** 과제
//=> 배열을 출력해주는 제네릭 클래스 만들기
// 배열정의, setter/getter, arrayPrint()
//=> 실행시에 원하는 타입을 결정 & 출력
//=> 배열 타입 Generic

class GenArray<T> {
	private T[] arr;

	public void setArr(T[] arr) {
		this.arr = arr;
	}

	public T[] getArr() {
		return this.arr;
	}

	public void arrayPrint() {
		for (T a : arr) {
			System.out.println(a);
		}
	}
}// GenArray

public class Ex02_GenArray {

	public static void main(String[] args) {
		// 1. String
		String[] st = { "가", "나", "Do", "Re", "Mi" };
		GenArray<String> ga1 = new GenArray<String>();
		ga1.setArr(st);
		ga1.arrayPrint();

		// 2. Integer
		Integer[] ii = { 1, 2, 3, 4, 5 };
		GenArray<Integer> ga2 = new GenArray<Integer>();
		ga2.setArr(ii);
		ga2.arrayPrint();

		// 3. Character
		Character[] cc = { 'A', 'B', 'C', '디', '이' };
		GenArray<Character> ga3 = new GenArray<Character>();
		ga3.setArr(cc);
		ga3.arrayPrint();

		// 4. Car
		Ex00_Car[] rr = { new Ex00_Car(100, 500, "Silver"), new Ex00_Car(200, 300, "Red"),
				new Ex00_Car(1000, 2500, "Blue") };

		GenArray<Ex00_Car> ga4 = new GenArray<Ex00_Car>();
		ga4.setArr(rr);
		ga4.arrayPrint();

	}// main

}// class