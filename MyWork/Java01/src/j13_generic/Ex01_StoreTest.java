package j13_generic;

import j07_classExtends.Ex00_Car;

//** Generic
//=> 컬렉션(Collection:자료구조) 을 보강해준 기능
//=> 컴파일 단계에서 객체의 자료형을 선언(정의) 해주면
// 다른 타입의 자료가 저장될수 없도록 해주는 기능

//** Generic 클래스 정의
//=> 클래스 이름 옆에 <> 사이에 알파벳 1글자를 사용하여 
// Generic Type 명을 선언해줌 
// ex : <T> 처럼 "<" 와 ">" 사이에 선언 
//=> 대문자로 T, E 등을 많이 사용 
// Type 의미로 "T" 를 주로 사용
//=> Generic 타입으로 클래스를 사용한다는 의미 
//=> 제네릭으로 기본 자료형(int, float, double....)은 사용할 수 없지만
// 기본자료형의 wrapper 클래스를 이용할 수있다. 

//** Generic 타입제한 (Wildcards_와일드카드타입 이용으로)

// <?>
// => Unbounded Wildcards (제한없음_모든 클래스나 인터페이스 타입 가능)

// <? extends ...>
// => Upper Bounded Wildcards (상위클래스 제한_같거나 하위 타입 가능)

// <? super ...>
// => Lower Bounded Wildcards (하위클래스 제한_ 같거나 상위타입 가능)

// ===================================
// 1. Object 이용한 기존 방식
// => 모든 클래스는 Object 의 후손이므로
// => Object data = new String("Generic_Test"); 처럼 Object 타입으로 우측에 정의될 수 있음
// => 즉, 모든 클래스는 setData 의 매개변수가 될 수 있음

class Store {
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}// Store

//========================================================
// 2. Generic 방식
// => 다양한 클래스에 적용할 수 있는 다목적용 기능을 만들기 위해 클래스 맴버변수의 타입을 T(임의의 알파벳)
// 	  로 표현 해놓고 실행코드에서 결정해서 사용하는 프로그래밍 기법
// => 결정된 타입 이외에는 사용불가 ( Exception 발생 )

class StoreG<T> {
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}// StoreG<T>

public class Ex01_StoreTest {

	public static void main(String[] args) {
		// 1. Object 를 이용한 기존 방식
		// => 다양한 클래스에 적용할 수 있는 다목적용 기능을 만드기 위해 Object 타입을 사용하면
		// 형변환이 불가능한 경우에도 컴파일 오류가 없음
		// => 이를 방지하기 위한 프로그래밍 기법이 Generic 프로그래밍

		Store s1 = new Store();
		s1.setData("짜장면");
		s1.setData(123); // int 는 Object 의 후손이 아니지만, Integer 로 자동 형변환되어 가능함
		s1.setData(123.456); // double 도 마찬가지로 Double 로 자동 형변환됨
		s1.setData(new Ex00_Car(100, 500, "Silver")); // => 위에 import 필요함
		// => 모든 클래스는 Object 의 후손이므로 setData 의 매개변수가 될 수 있음

		s1.setData(123.456f);
		Float f = (Float) s1.getData();
		System.out.println("Test 1 => " + f);

//		String s = (String) s1.getData();
//		System.out.println("Test 2 => " + s);
		// => float 를 String 으로 변환할 수 없으므로 런타임 오류 (ClassCastException)
		// => 즉, 컴파일 타임에서는 오류의 여부를 알 수 없음

//		===========================================
		// 2. Generic StoreG

		StoreG<String> g1 = new StoreG<String>(); // => 이 인스턴스에서는 String 타입만 사용 가능
		g1.setData("Generic Store");
		// g1.setData(123.456); // => String 타입만 가능하므로 double 타입은 불가

		StoreG<Integer> g2 = new StoreG<Integer>();
		g2.setData(12345);
		// g2.setData(123.456); // => Integer 타입만 가능하므로 double 타입은 불가

		StoreG<Ex00_Car> g3 = new StoreG<Ex00_Car>();
		g3.setData(new Ex00_Car(100, 500, "Silver"));

		// StoreG<int> g4 = new StoreG<int>();
		// => 객체형만 가능, 기본자료형은 불가능(Wrapper_Class 사용하면 됨)

	}// main

}// class