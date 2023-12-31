package j15_enum;

//(정석기초 475p)
//** 열거형(enum) 상수 사용
//=> 정의 : 열거형은 서로 연관된 상수들의 집합
//=> interface 와 비교

//** 열거형의 특징
//=> 상수의 사용을 편리하게 지원.
//=> 의미가 있는 단어를 상수로 사용하기 편리함.
//=> 값과 타입을 동시에 확인하기때문에 안전한 코딩 가능
//=> 열거형 내부에 생성자, 필드, 메소드를 가질 수 있어서 단순히 상수가 아니라 더 많은 역할이 가능함. 

interface ScaleI {
	// ** 상수 정의
	// => public static final (type) (Name) = (value);
	// => 상수만 정의 가능하므로 생략

	int DO = 0;
	int RE = 1;
	int MI = 2;
	int FA = 3;
	int SO = 4;
	int RA = 5;
	int SI = 6;

}// interface

enum ScaleE {
	DO, RE, MI, FA, SO, RA, SI
}

public class Ex01_InterfaceConst {

	public static void main(String[] args) {
		// 1. interface 에 정의된 상수 사용
		// => switch 문 적용
		int key = ScaleI.MI;

		switch (key) {
		case 0:
			System.out.println("도");
			break;
		case 1:
			System.out.println("레");
			break;
		case 2:
			System.out.println("미");
			break;
		case 3:
			System.out.println("파");
			break;
		case 4:
			System.out.println("솔");
			break;
		case 5:
			System.out.println("라");
			break;
		case 6:
			System.out.println("시");
			break;
		default:
			System.out.println("도, 레, 미, 파, 솔, 라, 시");
			break;
		}

		System.out.println("");
//		=====================================================
		// 2. enum 사용

		ScaleE eKey = ScaleE.RA;
		System.out.println("** eKey => " + eKey);

		// eKey = null;
		// => 컴파일 오류는 없지만 런타임 오류

		switch (eKey) {
		case DO:
			System.out.println("도");
			break;
		case RE:
			System.out.println("레");
			break;
		case MI:
			System.out.println("미");
			break;
		case FA:
			System.out.println("파");
			break;
		case SO:
			System.out.println("솔");
			break;
		case RA:
			System.out.println("라");
			break;
		case SI:
			System.out.println("시");
			break;
		default:
			System.out.println("도, 레, 미, 파, 솔, 라, 시");
			break;
		}

	}// main

}// class