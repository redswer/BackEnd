package j05_classMethod;

public class Ex05_2_StaticTest {

	public static void main(String[] args) {
// ** 다른 클래스에 있는 static, instance 접근하기

		// 1. static 변수 출력하기

		System.out.println("total : " + Ex05_1_Static.total);

//		========================================
		// 2. instance(non_static) 변수 출력하기

		Ex05_1_Static ex05 = new Ex05_1_Static();

		ex05.instanceAll(10, 3, ex05);
		Ex05_1_Static.staticAll(10, 3, ex05);

//		=========================================
		// 3. instance 추가 후 test

		System.out.println("\n========================");
		System.out.println("** total | instanceTotal 비교 **");

		Ex05_1_Static ex055 = new Ex05_1_Static();

		ex055.instanceAll(10, 3, ex055);
		Ex05_1_Static.staticAll(10, 3, ex055);

	} // main

} // class