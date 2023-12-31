package j01_basic;

//** bit 연산
//=> 쉬프트 연산 , 논리 연산

public class Ex09_Operator02_bit {

	public static void main(String[] args) {

		int x = 10, y = 3; // 1010, 0011

		// 1) 쉬프트연산 : >> , <<
		System.out.println("** 쉬프트 연산");

		System.out.println("x >> y : " + (x >> y));
		// => x 를 오른쪽으로 y 만큼 이동 -> 1010 을 오른쪽으로 3만큼 이동
		// => 1010 -> 0101 -> 0010 -> 0001 -> 10진수 1

		System.out.println("x : " + x);
		System.out.println("y : " + y);

		System.out.println("x << y : " + (x << y));
		// => x 를 왼쪽으로 y 만큼 이동
		// => 1010 -> 1 0100 -> 10 1000 -> 101 0000 -> 1010000 -> 10진수 80

//		===================================================

		// 2) 논리연산
		// => AND &, OR |, XOR ^ (같으면 0)
		System.out.println("\n** 논리 연산");

		System.out.println("x & y : " + (x & y));
		// x = 1010
		// y = 0011
		// & = 0010 (둘 다 1인 경우에만 1) -> 10진수 2

		System.out.println("x | y : " + (x | y));
		// x = 1010
		// y = 0011
		// | = 1011 (둘 중 하나만 1이어도 1) -> 10진수 11

		System.out.println("x ^ y : " + (x ^ y));
		System.out.println("x ^ y : " + Integer.toBinaryString(x ^ y)); // 2진수로 출력
		// x = 1010
		// y = 0011
		// ^ = 1001 (둘이 다르면 1) -> 9

//		===================================================

		// 3) 활용
		System.out.println("\n** 활용");
		int pw = 1234567, d = 0;
		int s = 0x1A253B65;
		System.out.println("** 암호화 전 pw : " + pw);

		// 암호화 (Encryption)
		d = pw ^ s;
		System.out.println("** 암호화 된 pw : " + d);

		// 복호화 (Decryption)
		// => 암호화 된 pw 에 다시 XOR(^) 연산을 하면 원본이 됨
		d = d ^ s;
		System.out.println("** 복호화 된 pw : " + d);
	}

}
