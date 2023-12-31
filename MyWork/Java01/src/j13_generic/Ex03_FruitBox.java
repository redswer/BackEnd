package j13_generic;

//** Generic Class Test 
//** FruitBox 만들기
//=> Apple, Banana 등 모든 과일을 담을수 있는 Generic FruitBox class 를 만들어 보세요.
// 단 과일들만 담을 수 있어야 함.
// ( 자율적으로 해보시면 됩니다. )
// 힌트: Apple, Banana 등 각종 과일들이 class 이고, 
//      이들은 과일(Fruit) 로 구분 될 수 있어야함.   
//=> 실습
// -> 1) Fruit 만들기
// -> 2) 과일 클래스들 만들기 (3개)
// -> 3) FruitBox 만들기 : 과일들담기_setter, 과일들출력메서드_fruitPrint()
// -> 4) main 완성하기

class Fruit {
	public String toString() {
		return "과일";
	}
}// Fruit

class Apple extends Fruit {
	public String toString() {
		return "Apple";
	}
}// Apple

class Banana extends Fruit {
	public String toString() {
		return "Banana";
	}
}// Banana

class Grape extends Fruit {
	public String toString() {
		return "Grape";
	}
}// Grape

class Tomato {
	public String toString() {
		return "Tomato";
	}
}// Tomato

class FruitBox<T extends Fruit> {
	private T[] FruitBox;

	public void setFruitBox(T[] arr) {
		this.FruitBox = arr;
	}

	public T[] getFruitBox() {
		return this.FruitBox;
	}

	public void fruitPrint() {
		for (T a : FruitBox) {
			System.out.println(a);
		}
	}
}// FruitBox

public class Ex03_FruitBox {

	public static void main(String[] args) {

		Apple apple = new Apple();
		Banana banana = new Banana();
		Grape grape = new Grape();
		Tomato tomato = new Tomato();

		Fruit[] farr = { apple, banana, grape };
		// Fruit[] arr = { apple, banana, grape, tomato };
		// => Tomato 는 Fruit 을 상속받지 않았으므로 Fruit 타입이 아님 -> 오류

		FruitBox<Fruit> fruit = new FruitBox<Fruit>();
		fruit.setFruitBox(farr);
		fruit.fruitPrint();

	}// main

}// class