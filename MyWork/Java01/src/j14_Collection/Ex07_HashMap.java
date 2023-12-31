package j14_Collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

//*** 해싱과 해시함수 => 정석 651p
//해싱 => 해시 함수를 이용해서 데이터를 해시 테이블에 저장하고
//     검색하는 기법

//*** Map < Key, Value >
//=> HashMap (Key 값의 중복을 허용하지 않고, 순서 유지를 보장받지 못한다.) 
//=> TreeMap (Key 값의 중복을 허용하지 않고, 키값으로 오름차순 정렬이 된다.)
//=> LinkedHashMap (Key 값의 중복을 허용하지 않고, 입력순서 유지를 보장받는다.)

//*** HashMap : Key, Value 정보 지정
//=> key 는 유일, Value 는 중복 허용 
//=> null 값 허용 map.put(null, null) 또는 map.get(null) 가능

public class Ex07_HashMap {

	public static void main(String[] args) {
		// 1. HashMap

		Map<Integer, String> hMap = new HashMap<>();

		hMap.put(1, "Java");
		hMap.put(10, "Java"); // => key 값이 다르면 중복 허용
		hMap.put(2, "Spring");
		hMap.put(20, "SpringMVC");
		hMap.put(new Integer(3), "MySQL"); // => 3 = new Integer(3)
		hMap.put(4, "Mybatis");
		hMap.put(4, "JPA"); // => 똑같은 key 값을 가지면 나중값이 적용됨(오버라이드 됨)
		hMap.put(5, "그린");
		hMap.put(null, "NULL");

		System.out.println("** HashMap 1 => " + hMap);
		System.out.println("** hMap.size() => " + hMap.size());

		// ** get, remove : key 로 접근해야 함
		System.out.println("** hMap.get(20) => " + hMap.get(20));
		System.out.println("** hMap.remove(20) => " + hMap.remove(20));
		// => 삭제하고 value return
		System.out.println("** hMap.remove(5,'그린') => " + hMap.remove(5, "그린"));
		// => 삭제하고 boolean return

		System.out.println("** HashMap 2 => " + hMap);

		System.out.println("");
//		=================================================
		// 2. Map 종류(구현 클래스) 비교
		// => 생성자 매개변수로 위의 HashMap 을 사용
		// => 단, key 값이 null 인 경우에는 전달 과정에서 런타임 오류 (NullPointerException) 발생

		hMap.remove(null, "NULL"); // => 밑의 TreeMap 을 위해 key 값이 null 인 데이터 지움

		Map<Integer, String> tMap = new TreeMap<>(hMap); // => key 순 오름차순

		// System.out.println("** TreeMap => " + tMap);
		// => key 값이 null 인 데이터가 있으므로 NullPointerException 발생

		System.out.println("** TreeMap => " + tMap);

		Map<Integer, String> lhMap = new LinkedHashMap<>(hMap);
		System.out.println("** LinkedHashMap => " + lhMap);
		// => 입력 순을 유지 단, 위 경우에는 처리 과정에서 전달된 순서를 유지함

		lhMap = new LinkedHashMap<>();

		lhMap.put(1, "Java");
		lhMap.put(10, "Java");
		lhMap.put(5, "그린");
		lhMap.put(2, "Spring");
		lhMap.put(20, "SpringMVC");

		System.out.println("** new LinkedHashMap => " + lhMap);

	}// main

}// class