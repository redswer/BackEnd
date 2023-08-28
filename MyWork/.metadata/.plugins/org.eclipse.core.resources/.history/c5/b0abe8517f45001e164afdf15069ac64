package j01_basic;

// 기본 자료형의 치환, Wrapper Class, Overflow
public class Ex03_Variable02 {

	public static void main(String[] args) {
		// ** 치환
		// => 값의 맞교환 (cup1 의 값과 cup2의 값을 교환)
		// => box 내에 여러값이 들어있는데 그중 어떤값이 cup1 , cup2 의 값이 될지 모른다고 가정
		// => 중간 보관을 위한 같은 타입의 임시 변수가 필요함
		// => "=" 동일성을 의미하는것이 아니고 대입연산자
		String cup1 = "사이다";
		String cup2 = "콜라";

		// cup1 = "콜라"; cup2 = "사이다"; // XXX
		String temp = cup1;
		cup1 = cup2;
		cup2 = temp;

		System.out.println("cup1 : " + cup1);
		System.out.println("cup2 : " + cup2);

		// ** Wrapper Class
		// => 기본 자료형을 지원해주는 클래스 (모든 기본자료형에 있음)
		// 해당 클래스명은 기본 자료형의 첫글자를 대문자로 하면됨
		System.out.println("\n** 정수형의 Literal 의 범위 **");
		System.out.println("byte : " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
		System.out.println("short : " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
		System.out.println("int : " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		System.out.println("long : " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);

		System.out.println("\n** 실수형의 Literal 의 범위 **");
		System.out.printf("float : %f ~ %f\n", Float.MIN_VALUE, Float.MAX_VALUE);
		System.out.printf("double : %f ~ %f\n", Double.MIN_VALUE, Double.MAX_VALUE);

		// ** Overflow / Underflow
		// 1) 정수형
		short sMax = Short.MAX_VALUE;
		short sMin = Short.MIN_VALUE;

		System.out.println("\n** Overflow / Underflow **");
		System.out.printf("Overflow 1 : sMax = %d, sMax+1 = %d \n", sMax, (sMax + 1));
		System.out.printf("Overflow 2 : sMax = %d, sMax+1 = %d \n", sMax, (short) (sMax + 1));
		// 최댓값(32767)을 2byte 2진수로 표현하면 1111 1111 1111 1111 이고 여기에 + 1 을 하면
		// => 1 0000 0000 0000 0000 이 됨
		// => short 는 2byte 만 남게 되므로 0000 0000 0000 0000 만 표현됨
		// => 따라서 (short) sMax + 1 = sMin

		System.out.printf("Underflow 1 : sMin = %d, sMin-1 = %d \n", sMin, (sMin - 1));
		System.out.printf("Underflow 2 : sMin = %d, sMin-1 = %d \n", sMin, (short) (sMin - 1));
		// => Overflow 와 동일함
		// => (short) sMin - 1 = sMax

		// => 출력 시 overflow, underflow 가 일어나면 기본적으로 int 연산이 일어나지만,
		// type 을 지정해주면 overflow 는 최솟값으로, underflow 는 최댓값으로 연산됨

		// 2) 실수형
		// => by zero Test
		float f = 1234.567f;
		System.out.println("** 실수형 by 0, 나누기 (f / 0) : " + (f / 0));
		// => overflow 시 infinity
		System.out.println("** 실수형 by 0, 나머지 (f % 0) : " + (f % 0));
		// => overflow 시 NaN(Not a Number)

		// ** 비교
		System.out.println("** 비교 : 정수형 by 0, 나누기 (sMax / 0)" + (sMax / 0));
		System.out.println("** 비교 : 정수형 by 0, 나머지 (sMax % 0)" + (sMax % 0));
		// => 정수형에서 by zero 의 결과
		// => 컴파일 요류는 없지만 런타임 오류 발생 (java.lang.ArithmeticException)
	}

}
