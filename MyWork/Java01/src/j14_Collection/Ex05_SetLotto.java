package j14_Collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.Collections;

//** Set 구현 클래스
//=> HashSet
// HashSet은 해쉬 테이블에 원소를 저장하기 때문에 성능면에서 가장 우수하다.
// 하지만 원소들의 순서가 일정하지 않은 단점이 있다.
//=> TreeSet
// 레드-블랙 트리(red-black tree)에 원소를 저장한다. 
// 따라서 값에 의해 순서가 결정되지만 HashSet보다는 느리다.
//=> LinkedHashSet
//  해쉬 테이블과 링크드 리스트를 결합한 것으로
//  원소들의 순서는 삽입되었던 순서와 같다. 

//** Set 을 이용한 로또번호 생성하기
//=> 중복자료가 허용안되는 Set 의 특징을 이용하여 로또 번호 생성하기
//=> Random 또는 Math 로 1 ~ 45 범위내의 정수를 중복되지 않도록 
// 6개를 추출후 오름차순으로 출력하기   

public class Ex05_SetLotto {

	public static void main(String[] args) {
		TreeSet<Integer> tSet = new TreeSet<Integer>();

		for (;;) {
			tSet.add((int) (Math.random() * 45) + 1);

			if (tSet.size() == 6) {
				break;
			}
		}

//		while (tSet.size() < 6) {
//			tSet.add((int) (Math.random() * 45) + 1);
//		}

		System.out.println("TreeSet => " + tSet);

		System.out.println("");
//		==================
		// 비교 : HashSet -> 중복 확인은 하지만, 정렬은 되지 않음

		HashSet<Integer> hSet = new HashSet<Integer>();

		while (hSet.size() < 6) {
			hSet.add((int) (Math.random() * 45) + 1);
		}

		System.out.println("HashSet => " + hSet);

		System.out.println("");
//		==================
		// Arrays.sort() 이용한 정렬

		Object[] oSet = hSet.toArray();
		Arrays.sort(oSet);
		System.out.println("HashSet + Arrays.sort() => " + Arrays.toString(oSet));

		System.out.println("");
//		=====================================================
		// ** Collections
		// => Collection 들의 WrapperClass
		// => Collection 과 관련된 편리한 메서드를 제공
		// => 단, interface Collection 과 구별
		// => interface Collector 의 구현클래스 Collectors 와 구별
		// => Collections.sort(List<T> list) : 인자로 List 타입이 필요함

		// ** 오름차순 출력
		// => Set -> 순차구조 (Iterator , List)
		// => Set -> List
		// LinkedList 의 생성자중에 set을 매개변수로 사용하면 이 set 을 list 생성해주는 생성자가 있음.

		List<Integer> list = new LinkedList<>(hSet);
		Collections.sort(list);

		System.out.println("Collections.sort() => " + list);

	}// main

}// class