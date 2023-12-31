package j01_basic;

//** 변수(Variable) 정의
//=> type, 변수명, value
//=> type 은 불변, value 는 변경가능

//** 상수(Constant)
//=> type 불변, value도 불변
//=> 주로 고정값 에 사용 (pi = 3.141592)
//=> 전체 대문자로 표기

//** 기본자료형
//=> 예약어로 정의된 Type
//=> 더이상 나누어질수 없는 기본 자료형
//=> int, double, boolean, char
//=> 정수형 : byte(8_1), short(16_2), int(32_4byte), long(64_8byte)
//=> 실수형 : float(4byte), double(8byte)

//** 참조자료형
//=> String 
//=> 모든 클래스는 참조자료형이 될 수 있음

//=============================================

//** 용어정리
//=> identifier: 직접작명하는 식별자 (프로젝트, 클래스, 메서드, 변수, 상수 등의 이름)
//=> modifier: 특징을 제한하는 한정자 (public, static..등 예약어의 일종) 
//=> literal: 변수 우측의 값(Value)

//** identifier 작명의 일반적 규칙  
//=> project, class 명은 대문자로 시작.
//=> 상수명은 전체대문자로 작성. 
//=> 위 외에는 모두 소문자로 시작. ( 합성: setName ) 
//=> 한글: 허용은 되지만 권장하지 않음
//=> 연산자(+,-,*,/,%) 는 식별자에 포함할 수 없음
//=> 한번 선언된 변수명은 재선언 할수 없음 
//( 동일한 identifier 를 중복 선언할 수 없음 )

//=> 변수명 의 규칙 (ppt J03_01 , 8p)

public class Ex02_Variable01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ** 상수
		final double PI = 3.141592;
		// => final 을 앞에 붙여주면 상수 (변수와 달리 값이 바뀌지 않음)
		// PI = 3.333333; // PI 는 상수로 선언되었으므로 오류
		
//		===============================================

		// ** 변수
		// 1) 적합성
		String 이름 = "홍길동"; // 변수명을 한글로 하는 것은 권장하지 않음
		String irum = "홍길동"; // 한글 발음 그대로 영어로 표기하는 것도 바람직하지 않음
		// String Name; // name 과 Name 은 다르며, 변수 명의 첫 글자 대문자는 바람직하지 않음

		System.out.println(PI);
		System.out.println(이름);
		System.out.println(irum);

//		=================================================
		
		// 2) Type
		// 2.1) 정수형
		// => byte(8_1), short(16_2), int(32_4byte), long(64_8byte)
		byte b = 10;
		short s = 100;
		int i = 1234567890; // 선언과 동시에 초기화
		
//		================================================

		// ** 정수사용 주의사항
		// => Java 는 정수 literal 을 int 로 취급
		// => int 를 초과하는 정수 literal 을 표현못함
		// => L/l : 반드시 long Type literal 임을 표시해야함
		long l; // 선언
		l = 1234567890123456789L; // 값을 할당

		System.out.println("** 정수 : " + (b + s + i + l));
		
//		====================================================

		// 2.2) 실수형
		// => float(4byte), double(8byte)
		// => 실수 literal 의 기본형은 double;
		double d = 123.456;

		// float f = 123.456; // 4 byte = 8 byte : error
		// => 실수 literal 의 기본형이 double 이기 때문에 f 를 붙여야 함, f/F 모두 허용
		float f = 123.456f;

		System.out.println("** 실수 : " + (d + f));
		
//		====================================================

		// 2.3) boolean
		// true = 1 / false = 0
		// => 모든 관계식의 결과는 boolean type
		// boolean bool = true;

		System.out.println("** boolean : " + (b > s));
		
//		====================================================

		// 2.4) char
		// => 한글, 영문 모두 한 글자를 의미, 2byte
		// => 2byte int type 으로도 사용 가능
		// => ASCII Code
		char aa = 'A'; // char type 은 string type 과 구분하기 위해 작은따옴표 사용
		char bb = 'B';
		char cc = 'C';

		String ss = "Seoul, 한 글자 이상 가능";
		// String dd = "d";
		// => string type 은 한 글자라 하더라도 무조건 큰 따옴표 사용

		System.out.println("** char + char : " + aa + bb + cc);

		System.out.println("** (char + char) : " + (aa + bb + cc));
		// => 괄호로 묶으면 각각 맞는 아스키 코드값으로 int 연산 됨
		System.out.println("** (int) char : " + (int) aa);
		System.out.println("** (int) char : " + (int) bb);
		System.out.println("** (int) char : " + (int) cc);
		System.out.println("** (int) char + (int) char : " + (int) aa + (int) bb + (int) cc);

		System.out.printf("** A=%d, B=%d, C=%d\n", (int) aa, (int) bb, (int) cc);
		// => printf 는 자동 줄바꿈 적용되지 않으므로 \n(줄바꿈) 사용

		System.out.println("** char + String : " + (aa + bb + cc + ss));
		// => 괄호 내부에서 순서대로 연산되었기 때문에 int 연산 후 문자열 연산 됨

//		=======================================================================
		
		char k = '가', n = '나';
		System.out.printf("** k=%s, n=%s\n", k, n);
	}

}
