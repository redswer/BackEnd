package j14_Collection;

import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

//** List 인터페이스 (ppt 18, 23)
//=> List의 특징 : 순서가 있으며 중복된 원소를 가질 수 있다.
//=> 구현 클래스 : ArrayList, LinkedList

//** LinkedList<E>  
//=> ArrayList 및 배열의 단점을 보완하여 고안됨.   
//=> 장점 
// 1) 저장공간을 늘리는 과정이 간단.
// 2) 자료 입력 & 삭제 과정이 단순.
//=> 단점 : 순차처리의 access time 이 ArrayList 보다 느리다.
//=> 빈번하게 삽입과 삭제가 일어나는 경우에 사용 

//** ArrayList<E> 
//=> 순서를 유지하며 중복을 허용하는 자료구조  
//=> 배열(Array)의 향상된 버전 또는 가변 크기의 배열이라고 생각하면 된다. 
//=> 장점 : 자료구조가 간단하며 사용이 쉽고 순차처리의 access time이 가장 빠르다.
//=> 단점
//1) 크기 변경시 새로운 배열을 생성하고 모든자료를 복사해서 옮겨야 하므로 비효율적
//2) 비순차적인 자료의 추가,수정,삭제시에 복사 및 이동 때문에 비효율적
//=> 크기가 일정하고 비순차적인 자료 수정이 발생하지 않는 경우 유리

//** 계층도
//=> Collection(i) -> List(i) -> ArrayList
//=> Collection(i) -> List(i), Deque(i) -> LinkedList 

public class Ex02_LinkedList {

	public static void main(String[] args) {
		// 1. 정의
//		LinkedList<String> list = new LinkedList<String>();
		List<String> list = new LinkedList<String>();
		// => 다형성 적용

		// 2. 초기화
		list.add("Java");
		list.add("JavaScript");
		list.add("Servlet");
		list.add("JSP");
		list.add("Spring");
		list.add("MySql");

		// 3. 사용
		String ss = list.get(2) + list.get(3);
		list.set(1, ss); // => 1번을 수정
		list.add(ss); // => 맨 뒤에 추가
		list.add(5, "MyBatis"); // => 5번 위치에 끼워넣기
		list.remove(1);

		// 4. 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("");
//		==================================================
		// 5. 배열
		// => 배열 -> List -> Iterator(순차처리를 지원하는 클래스)

		String[] menu = { "칼국수", "쌀국수", "짜장면", "카레", "하이라이스" };
		list = Arrays.asList(menu);

		// list.add("탕수육");
		// list.remove(0);
		list.set(0, "마라탕");
		// => 변환 한 경우에는 추가, 삭제할 수 없음 (수정은 가능)
		// => 런타임오류 발생 : ava.lang.UnsupportedOperationException

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// ** List -> Iterator (hasNext(), next() 메서드 제공)
		Iterator<String> iMenu = list.iterator();
		while (iMenu.hasNext()) {
			System.out.println(iMenu.next());
		}
	}// main

}// class