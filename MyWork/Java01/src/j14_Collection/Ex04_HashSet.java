package j14_Collection;

import java.util.HashSet;
import java.util.Iterator;

//** Set : ppt 30 p
//=> 원소의 중복을 허용하지 않고, 순서가 없음
//=> HashSet, TreeSet, LinkedHashSet

//** HashSet
//=> HashSet은 해쉬 테이블에 원소를 저장하기 때문에 성능면에서 가장 우수,
// 하지만 원소들의 순서가 일정하지 않은 단점이 있다.

//** Iterator 클래스 를 이용한 처리 (출력등..)
//=> 배열 -> Set
//=> Set -> Iterator : 순차 처리 적용

public class Ex04_HashSet {

	public static void main(String[] args) {
		// 1. 정의
		// => 중복 허용하지 않음 (값이 같지만 타입이 다르면 다른 데이터로 취급)

		// 1.1) Object
		Object[] ob = { "가나다", "Green", "123", 123, new Integer(123), "Green", 123.456 };
		HashSet<Object> oSet = new HashSet<>();
		for (Object o : ob) {
			if (!oSet.add(o)) {
				System.out.println("** 실패 => " + o);
			}
		}
		System.out.println("** oSet => " + oSet);
		// => toString()이 오버라이딩 되어있기 때문에 oSet 만 호출해도 출력됨

		// 1.2) String
		HashSet<String> sSet = new HashSet<>();

		System.out.println("");
//		=========================================
		// 2. 초기화

		sSet.add("Java");
		sSet.add("MySql");
		sSet.add("Web");
		sSet.add("Spring");
		sSet.add("Mybatis");
		sSet.add("JPA");
		// sSet.add(123.456); // => String 만 허용
		sSet.add("Spring"); // => 중복 시 오류는 없지만 허용하지 않음

//		===========================================
		// 3. 출력

		// ** 삭제
		System.out.println("** sSet Spring 삭제결과 => " + sSet.remove("Spring"));
		System.out.println("** sSet Test 삭제결과 => " + sSet.remove("Test"));

		System.out.println("** sSet => " + sSet);
		// => toString()이 오버라이딩 되어있기 때문에 sSet 만 호출해도 출력됨
		System.out.println("** sSet.size => " + sSet.size());

		System.out.println("");
//		============================================
		// 4. 반복처리
		// => 삭제시 필요, 반복처리가 가능하도록 해줘야함 (즉, Iterator 를 사용해야함)
		// => Iterator 활용
		// - 순차적으로 비교하면서 원하는 값 찾기, 삭제하기
		// - 변경된 사항들은 set 에 반영됨

		Iterator<String> iSet = sSet.iterator();

		while (iSet.hasNext()) {
//			if (iSet.next().equals("Web")) {
//				// sSet.remove(); // => 컴파일 오류
//				// sSet.remove("Web"); // => 런타임 오류
//				// sSet.add("Oracle"); // => 런타임 오류
//				// => 반복문 내부에서 원본(sSet) 접근 불가
//
//				iSet.remove();
//				// => 지금 당장은 반복문이 없어도 sSet.remove("Web") 나 iSet 조건문으로 삭제 가능하지만,
//				// => "a" 가 포함된 자료를 삭제 등의 조건이 붙으면 반복문이 필요함
//			}
			if (iSet.next().contains("a")) {
				iSet.remove();
			}
		}
		System.out.println("** sSet toString() => " + sSet);
		// => iSet 의 remove 결과가 sSet(원본) 에 반영됨

		System.out.println("");
//		========================================================
		// ** iSet 재사용

		while (iSet.hasNext()) { // => iSet.hasNext() 가 false 이기 때문에 출력 x
			System.out.println("iSet while => " + iSet.next());
		}
		// => Iterator 는 한번 사용을 마치면 자료를 포인트하는 커서가 끝에 가 있어
		// hasNext()가 false 를 return 하기 떄문에 재할당해야 한다

		iSet = sSet.iterator();
		while (iSet.hasNext()) {
			System.out.println("iSet while => " + iSet.next());
		}

		System.out.println("** 프로그램 종료 **");

	}// main

}// class