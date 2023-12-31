package j01_basic;

//** Type Casting (형변환)
// 1. 자동 (프로모션 promotion , 확대 형변환)
// => 큰자료형에 작은자료형을 대입하면 : 자동으로 이루어짐

// 2. 강제 (디모션, demotion, 축소 형변환)
// => 작은자료형에 큰자료형을 대입 : 자동으로 이루어지지않음
//=> 자료의 Type이 다른경우
//=> 명시적 형변환

public class Ex04_Casting {

	public static void main(String[] args) {

		// 1. 자동 (프로모션 promotion , 확대 형변환)
		double d = 123.456; // 8 byte 크기
		int i = 123456; // 4 byte 크기
		d = i; // 프로모션
		// i = d; => Error : Type mismatch

		System.out.printf("** 프로모션 promotion : d = %f, i = %d \n", d, i);

//		===============================================

		// 2. 강제 (디모션, demotion, 축소 형변환)
		i = (int) d;

		System.out.printf("** 디모션 demotion : i = %d \n", i);

//		================================================

		// ** 같은 크기의 다른 Type (int, float)
		float f = 456.789f;
		int n = 100;
		// n = f; -> 오류, f = n; -> 허용
		n = (int) f;

		System.out.printf("** 디모션 2 : n = %d, f = %f \n", n, f);

//		=================================================

		// ** 정수형 연산
		short s1 = 10, s2 = 20, s3 = 0;

		// s3 = s1 + s2; -> Error : Type mismatch
		// => 4byte 이하 type 의 정수형 연산의 경우 무조건 그 결과는 int (4byte) 로 처리
		// => 따라서 s1 + s2 int 타입이고, s3 는 short 타입이므로 오류
		s3 = (short) (s1 + s2);

		System.out.printf("** 정수형 연산 : s3 = %d \n", s3);

//		==================================================

		// => char / int
		char c = 'C'; // 2 byte
		System.out.printf("** 디모션 char : c = %s, c 의 코드값 = %d \n", c, (int) c);

		n = c + 123; // 산술 연산 적용 (자동 형변환)
		System.out.printf("** char + int : n = %d, n의 char 값 = %s \n", n, (char) n);

	}

}