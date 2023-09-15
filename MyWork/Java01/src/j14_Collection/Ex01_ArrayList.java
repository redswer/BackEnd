package j14_Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import j07_classExtends.Ex00_Car;

public class Ex01_ArrayList {

	public static void main(String[] args) {
		// 1. 정의
		// => Generic Type 을 지정하지 않으면 Object Type

//		ArrayList list = new ArrayList();
		List list = new ArrayList();
		// => 조상으로 부를 수 있음

		list.add("홍길동");
		list.add(123);
		list.add(123.456);
		list.add('가');
		list.add(123.45f);
		list.add(new Integer(500));

		// => 출력
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

		for (Ex00_Car car : list2) {
			System.out.println(car.color);
		}

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