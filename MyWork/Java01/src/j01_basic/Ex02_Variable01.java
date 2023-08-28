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

public class Ex02_Variable01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ** 상수
		final double PI = 3.141592;
		// => final 을 앞에 붙여주면 상수 (변수와 달리 값이 바뀌지 않음)
		// PI = 3.333333; // PI 는 상수로 선언되었으므로 오류

		// ** 변수
		// 1) 적합성
		String 이름 = "홍길동"; // 변수명을 한글로 하는 것은 권장하지 않음
		String irum = "홍길동"; // 한글 발음 그대로 영어로 표기하는 것도 바람직하지 않음
	}

}
