package j14_Collection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//** HashMap 의 순차처리 ( Iterator , Entry ) 
//=> HashMap 의 주요 메서드 ( Set Type 으로 return ) 활용
//- entrySet() : key+value 를 Entry Type 으로 묶어 Set 으로
//- keySet() : key 값들만 Set 으로
//- values() : value 들만 Set 으로
//1) 키와 값 같이 읽어 순차처리
//2) 키와 값을 따로 읽어 순차처리

//** Entry -------------------------------------------
//Map 인터페이스는 내부에 내부인터페이스 Entry를 가지고 있고, 
//Object key, Object value는 Entry 인터페이스에 선언되어 있음.
//그러므로 Map의 key와 value는 각각의 Object 이며 Map.Entry타입으로 저장됨. 
//그래서 Map의 key와 value에 접근 할때는
//=> 먼저 Map의 인스턴스에서 entrySet으로 키와 value를 둘다 가져온다. 
//=> entrySet은 Set타입이므로 Set타입 인스턴스에 저장
//=> Set타입으로 가져온 인스턴스에서 iterator()메소드 호출해서 iterator가져옴
//=> 얻어온 iterator에서 hasNext메소드를 호출하여 HashMap 내부 요소에 접근.
//=> HashMap의 각 key와 value값은 결국 Map.Entry 타입의 배열에 들어있으므로    
//  HashMap에서 각 key와 value값에 접근하기위해서는  
//  Map.Entry 타입 인스턴스에 iterator의 next()메소드로 key와 value값 가져온다.
//------------------------------------------------------

public class Ex09_MapIterator {

	public static void main(String[] args) {
		// 1. HashMap 정의
		// => <이름, 점수>

		HashMap<String, Integer> hMap = new HashMap<>();

		hMap.put("구준표", 90);
		hMap.put("금잔디", 90);
		hMap.put("홍길동", 50);
		hMap.put("유지희", 80);
		hMap.put("구영표", 70);

		System.out.println("** hMap 원본 => " + hMap);

		System.out.println("");
//		==================================================
		// 2. 순차 처리

		// 2.1) entrySet
		// => HashMap 의 entrySet() -> Set -> Iterator
		// 키와 값을 같이읽어 하나의 데이터(entry) 로 Set에 저장

		Set<?> set = hMap.entrySet();
		// <?> => 모든 자료형 을 의미 , 내부적으로는 Object

		System.out.println("** hMap.entrySet() => " + set);

		// ** Set -> Iterator
		Iterator<?> iSet = set.iterator();

		while (iSet.hasNext()) {
//			System.out.println("** iSet.next() => " + iSet.next());
			// => key, value 구분 없음
			// => 구분하려면 Entry 객체 활용해야 함

			Map.Entry<?, ?> e = (Map.Entry<?, ?>) iSet.next();
			System.out.printf("** Entry : key = %s, value = %d\n", e.getKey(), e.getValue());
		}

		System.out.println("");
//		=========================
		// 2.2) keySet
		// => HashMap 의 keySet() -> Set -> Iterator

		set = hMap.keySet();

		System.out.println("** keySet => " + set);

		iSet = set.iterator();

		// ** while
		while (iSet.hasNext()) {
			// System.out.println("** key = " + iSet.next());
			// => key 값 출력
			// System.out.println("** value = " + hMap.get(iSet.next()));
			// => key 값을 이용하여 value 값 출력
			// => next()를 이용하면 커서가 다음으로 이동하므로 next() 2회 사용은 바람직하지 않음

			String hMapKey = (String) iSet.next();
			System.out.printf("** while_KeySet : key = %s, value = %d\n", hMapKey, hMap.get(hMapKey));
		}

		// ** for
		for (String s : hMap.keySet()) {
			System.out.printf("** for_KeySet : key = %s, value = %d\n", s, hMap.get(s));
		}

		System.out.println("");
//		=========================
		// 2.3) values

		Collection<Integer> cv = hMap.values();
		// = Collection<?> cv = hMap.values();

		iSet = cv.iterator();

		int sum = 0;
		while (iSet.hasNext()) {
			sum += (int) iSet.next();
		}
		System.out.println("** while_values : 총 합계 = " + sum + ", " + "평균 = " + sum / hMap.size());

		System.out.println("** Collections : 최고점 = " + Collections.max(cv) + ", " + "최저점 = " + Collections.min(cv));

	}// main

}// class