package j14_Collection;

//ArrayList (ppt 18, 19 ~)

//** ArrayList<E> 의 저장용량  
// => 데이터가 증가하면 메서드 호출하지 않아도 저장용량은 자동증가 함
// => 필요시엔 미리 설정가능
//1) 생성자 
// => 초기값 지정 가능 :  new ArrayList<>(100) ;
//2) 메서드 이용
// => public void ensureCapacity(int minCapacity) : ArrayList 에 정의

//** 계층도
//=> Collection(i) -> List(i) -> LinkedList , ArrayList

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import j07_classExtends.Ex00_Car;

public class Ex01_ArrayList {

	public static void main(String[] args) {
		// 1. 정의
		// => Generic Type 을 지정하지 않으면 Object Type

		ArrayList list = new ArrayList();
//		List list = new ArrayList();
		// => 조상으로 부를 수 있음

		// ** 초기화
		list.add("홍길동");
		list.add(123);
		list.add(456);
		list.add('가');
		list.add(123.45f);
		list.add(new Integer(500));

		// ** size 와 용량(capacity) 비교
		// size : 리스트 요소의 수
		// 리스트 용량 : 잠재적으로 그 내부 구조를 재할당 없이 수용할 수 있는 요소의 수
		System.out.println("** list.size() 1 => " + list.size());
		list.ensureCapacity(20); // ArrayList 에 정의
		System.out.println("** list.size() 2 => " + list.size());

//		======================
		// 2. 사용
		// => get, set(수정), remove

		int sum = (int) list.get(1) + (int) list.get(2);
		list.set(0, sum); // => 수정 : list 의 0번째 값(홍길동)이 sum 의 값으로 수정됨
		list.add(1, sum); // => 추가 (끼워넣기)
		list.remove(5); // => 삭제

//		=======================
		// 3. 출력

		for (Object o : list) {
			System.out.println(o);
		}

		System.out.println("");
//		===================================================

//		ArrayList<Ex00_Car> list2 = new ArrayList<Ex00_Car>();
		List<Ex00_Car> list2 = new ArrayList<Ex00_Car>();
		// => 조상으로 부를 수 있음

		list2.add(new Ex00_Car(100, 500, "Silver"));
		list2.add(new Ex00_Car(200, 100, "Red"));
		list2.add(new Ex00_Car(300, 1000, "Blue"));

		for (Ex00_Car car : list2) {
			System.out.println(car);
		}

		// ** Car 의 color 만 출력
//		for (Ex00_Car car : list2) {
//			System.out.println(car.color);
//		}
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i).color);
		}
		// => list.size() 와 list.get() 으로 접근해야 함

		// ** Car 의 첫 번째 자료의 color 출력
		System.out.println(list2.get(0).color);

		System.out.println("");
//		======================================================
		// ** LinkedList 비교

//		LinkedList<Ex00_Car> list3 = new LinkedList<Ex00_Car>();
		List<Ex00_Car> list3 = new LinkedList<Ex00_Car>();
		// => 조상으로 부를 수 있음

		list3.add(new Ex00_Car(100, 500, "Silver_3"));
		list3.add(new Ex00_Car(200, 100, "Red_3"));
		list3.add(new Ex00_Car(300, 1000, "Blue_3"));

		for (Ex00_Car car : list3) {
			System.out.println(car);
		}

	}// main

}// class