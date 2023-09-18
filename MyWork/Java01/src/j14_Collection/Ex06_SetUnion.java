package j14_Collection;

import java.util.HashSet;

public class Ex06_SetUnion {

	public static void main(String[] args) {
		// 1. Set 을 2개 정의

		HashSet<String> set1 = new HashSet<>();

		set1.add("Red");
		set1.add("Blue");
		set1.add("Green");
		set1.add("Pink");
		set1.add("Black");

		System.out.println("** set1 => " + set1);

//		============

		HashSet<String> set2 = new HashSet<>();

		set2.add("Seoul");
		set2.add("Busan");
		set2.add("Green");
		set2.add("Paris");
		set2.add("Korea");

		System.out.println("** set2 => " + set2);

		System.out.println("");
//		===================================================
		// 2. 대량연산
		// => 합집합 : union / 교집합 : intersection / 부분집합 / 차집합 : difference of sets

		// addAll : 합집합
		set1.addAll(set2); // => set1 과 set2 의 합집합(union)
		System.out.println("set1.addAll(set2)" + set1); // => 중복 허용하지 않음 (Green 확인)

		// retainAll : 교집합
		set1.retainAll(set2); // => set1 과 set2의 교집합 (intersection)
		System.out.println("set1.retainAll(set2) => " + set1);
		// => 위에서 set1에 set2 가 합쳐졌으므로 set1 과 set2 의 교집합은 set2 와 같음

		// containsAll : 부분집합
		System.out.println("set1.containsAll(set2) => " + set1.containsAll(set2));
		// => 부분집합 : set2 가 set1 의 부분집합이면 true

		set1.add("Silver");
		set1.add("Gold");
		// => set1 과 set2 는 동일한 자료만 남아있으므로 차집합 테스트를 위해 추가

		// removeAll : 차집합
		set1.removeAll(set2); // => set1 과 set2 의 차집합
		System.out.println("set1.removeAll(set2) => " + set1);

	}// main

}// class