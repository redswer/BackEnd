package j08_AbsInterface;

//** interface 3.
//1) 인터페이스와 인터페이스 관계
//=> 인터페이스 간의 상속(extends) 가능.
//=> 다중상속(부모 여러개 허용), 계층적 상속 모두 가능 

//2) 클래스 와 인터페이스 관계
//=> 다중 구현(implements) 가능
//=> 클래스가 클래스를 상속(extends) 받으면서 동시에
// 인터페이스를 구현(implements, 다중구현도 포함) 하는것 가능 

//** 그러므로 자바는 다중상속이 안되는점을 극복 가능함

interface Inter1 {
	float PI = 3.14159f; // public static final 생략됨

	int getA(); // public abstract 생략
}

interface Inter2 {
	int getB();
}

interface Inter3 extends Inter1, Inter2 {
	float getC();
}

// 1) 복수의 interface 구현 (다중구현) 하는 클래스

class MultiInter implements Inter3 {
// = class MultiInter implements Inter1, Inter2, Inter3 {

	int a = 123, b = 100;

	@Override
	public int getA() {
		return a;
	}

	@Override
	public int getB() {
		return b;
	}

	@Override
	public float getC() {
		return (a + b) * PI;
	}
}

//	=================================================
// 2) 클래스 extends 와 interface implements 동시 구현

class Add {
	int addNum(int a, int b) {
		return a + b;
	}
}

class MultiExIm extends Add implements Inter1, Inter2, Inter3 {
	int a = 123, b = 100;

	@Override
	public int getA() {
		return a;
	}

	@Override
	public int getB() {
		return b;
	}

	@Override
	public float getC() {
		return addNum(a, b) * PI;
	}
}

//	=================================================

public class Ex04_MultiTest {

	public static void main(String[] args) {
		// 1) 출력

		MultiInter m1 = new MultiInter();
		System.out.printf("main m1 : getA = %d, getB = %d, getC = %f\n", m1.getA(), m1.getB(), m1.getC());

//		====================================
		// 2) 출력

		MultiExIm m2 = new MultiExIm();
		System.out.printf("main m2 : getA = %d, getB = %d, getC = %f\n", m2.getA(), m2.getB(), m2.getC());

		// 2-2) 다형성 적용

		Inter1 in1 = new MultiInter(); // Inter1 에 정의된 만큼만 접근 가능
		Inter2 in2 = new MultiExIm(); // Inter2 에 정의된 만큼만 접근 가능
		Inter3 in3 = new MultiInter(); // 모든 메서드 접근 가능
		// => MultiInter 대신 MultiExIm 도 가능
		System.out.printf("\nmain in1 : getA = %d", in1.getA());
		System.out.printf("\nmain in2 : getB = %d", in2.getB());
		System.out.printf("\nmain in3 : getA = %d, getB = %d, getC = %f\n", in3.getA(), in3.getB(), in3.getC());

//		=====================================
		// 3) instance of

		if (m1 instanceof Inter1)
			System.out.println("\n** m1 = Inter1 **");
		else
			System.out.println("\n** m1 != Inter1 **");
		if (m1 instanceof Inter3)
			System.out.println("** m1 = Inter3 **");
		else
			System.out.println("** m1 != Inter3 **");

		if (in1 instanceof Inter3)
			System.out.println("** in1 = Inter3 **");
		else
			System.out.println("** in1 != Inter3 **");
		if (in2 instanceof Inter3)
			System.out.println("** in2 = Inter3 **");
		else
			System.out.println("** in2 != Inter3 **");
		if (in3 instanceof Inter3)
			System.out.println("** in3 = Inter3 **");
		else
			System.out.println("** in3 != Inter3 **");

		// 3-2) 비교
		// => interface 와 무관한 Add 인스턴스

		Add add = new Add();
		if (add instanceof Inter3)
			System.out.println("** add = Inter3 **");
		else
			System.out.println("** add != Inter3 **");

		// => 비교 대상이 인터페이스 인 경우에는 컴파일 오류 없고, 런타임시에 비교 결과(적합성 여부) 알려줌
		// 그러므로 적합성의 확인이 필요한 경우 사용해야함.
	}// main

}// class