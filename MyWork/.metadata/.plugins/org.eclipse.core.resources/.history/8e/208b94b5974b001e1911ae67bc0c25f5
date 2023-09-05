package j05_classMethod;

/*
 ** static, instance 비교
 * static (클래스 종속)
 * 	=> static 키워드를 붙이게 되면, 변수 또는 메서드가, 해당 클래스 수준에 속하게 됨.
 * 	=> static 변수는 해당 클래스 수준에서 전역변수와 유사하게 동작하게 됨
 *  => 클래스 로드 시 한 번 할당되고, 모든 인스턴스가 static 변수를 공유하게 됨.
 * 
 * instance (non_static, 인스턴스 종속)
 * 	=> 따로 키워드를 붙이지 않고 사용하면 instance로 사용하게 되고, 객체 또는 인스턴스 수준에 속하게 됨.
 * 	=> instance 변수는 객체 또는 인스턴스 수준에서 인스턴스에 종속적으로 동작함
 *  => 각 인스턴스가 고유한 값을 가지므로, 한 인스턴스에서 변경해도 다른 인스턴스에 영향 주지 않음.
 */

/*
 ** 호출규칙
 * 	 => static 매서드 : static 만, 인스턴스 없이 호출 가능
 * 	 => instance(non_static) : static, instance 모두 인스턴스 없이 호출 가능
 */

// ** 사칙연산 계산기
public class Ex05_Static {

	// 1) 멤버변수 정의
	int result;
	static int total;
	int instanceTotal;

//	============================
	// 2) 멤버 메서드 정의

	// => static
	public static int plus(int i, int j, Ex05_Static ex05_2) {
		// result += (i + j); // => static 변수가 아니므로 인스턴스 없이 접근 불가능
		total += (i + j); // => static 메서드에서 static 은 인스턴스 없이 접근 가능
		ex05_2.instanceTotal += (i + j);
		return i + j;
	}

	public static int minus(int i, int j, Ex05_Static ex05_2) {
		total += (i - j);
		ex05_2.instanceTotal += (i - j);
		return i - j;
	}

	// => instance
	public int mul(int i, int j) {
		result = i * j;
		total += result;
		// => instance 메서드에서는 static, instance 모두 인스턴스 없이 호출 가능
		instanceTotal += result;
		return result;
	}

	public int div(int i, int j) {
		result = i / j;
		instanceTotal += result;
		total += result;
		return result;
	}

//	===============================
	// ** 모든 메서드 call

	// => static
	public static void staticAll(int i, int j, Ex05_Static ex05_2) {
		System.out.println("");
		System.out.println("staticAll plus = " + plus(i, j, ex05_2));
		System.out.println("staticAll minus = " + minus(i, j, ex05_2));

		System.out.println("staticAll mul = " + ex05_2.mul(i, j));
		System.out.println("staticAll div = " + ex05_2.div(i, j));
		// => 인스턴스 맴버에 접근하기 위해서는 인스턴스가 필요

		System.out.println("staticAll total = " + total);
		System.out.println("staticAll instanceTotal = " + ex05_2.instanceTotal);
		System.out.println("staticAll result = " + ex05_2.result);
	}

	// => instance
	public void instanceAll(int i, int j, Ex05_Static ex05_2) {
		System.out.println("");
		System.out.println("instanceAll plus = " + plus(i, j, ex05_2));
		System.out.println("instanceAll minus = " + minus(i, j, ex05_2));
		System.out.println("instanceAll mul = " + mul(i, j));
		System.out.println("instanceAll div = " + div(i, j));
		System.out.println("instanceAll total = " + total);
		System.out.println("instanceAll instanceTotal = " + instanceTotal);
		System.out.println("instanceAll result = " + result);
	}

//	================================================
	// 3) 호출 및 출력
	// ** static, instance(non_static) 모두 call
	// => 인스턴스 맴버에 접근하기 위해서는 인스턴스가 필요

	public static void main(String[] args) {
		Ex05_Static ex05 = new Ex05_Static();

		// 3-1) static call
		System.out.println("plus = " + plus(10, 3, ex05));
		System.out.println("minus = " + minus(10, 3, ex05));

		// 3-2) instance(non_static)
		System.out.println("mul = " + ex05.mul(10, 3));
		System.out.println("div = " + ex05.div(10, 3));

//		======================================
		// instanceTotal
		System.out.println("main total = " + total);
		System.out.println("main instanceTotal = " + ex05.instanceTotal);

//		==================================
		// ** 모든 메서드 call 호출

		// => static
		staticAll(30, 3, ex05);

		// => instance
		ex05.instanceAll(40, 4, ex05);

//		=======================================
		// ** 비교

		Ex05_Static ex055 = new Ex05_Static();
		System.out.println("");
		System.out.println("====================");
		System.out.println("** total | instanceTotal 비교 **");
		System.out.println("plus2 = " + plus(10, 3, ex055));
		System.out.println("minus2 = " + minus(10, 3, ex055));

		System.out.println("mul2 = " + ex055.mul(10, 3));
		System.out.println("div2 = " + ex055.div(10, 3));

		System.out.println("main total2 = " + total);
		System.out.println("main instanceTotal2 = " + ex055.instanceTotal);

		staticAll(30, 3, ex055);

		ex055.instanceAll(40, 4, ex055);

		// System.out.println("test1 : " + ex05.total);
		// => 경고, 바람직한 접근은 아님
		System.out.println("test2 : " + Ex05_Static.total);

	} // main

} // class