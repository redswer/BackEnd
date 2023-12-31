package j01_basic;

//** 2진수(Binary number), 8진수 , 16진수 표기
//=> 2진수 : 0b 로시작 -> 0b1111
//=> 8진수 : 0  Octal Number
//=> 16진수: 0x Hexadecimal Number
//=> 03_01~.ppt, 18page  

public class Ex05_BinOctHex {

	public static void main(String[] args) {
		int bin = 0b1111; // 10진수로 -> 1+2+4+8 = 15
		int oct = 017; // -> 8진수에서 8(10진수) = 10 -> 15 = 8+7 -> 017
		int hex = 0xf; // 1,2,3 ... 9, 10=A, 11=B, 12=C, ...15=F, 16=10

		System.out.printf("** bin = %d, oct = %d, hex = %d \n", bin, oct, hex);
		System.out.printf("** bin = %s, oct = %#o, hex = %#x \n", Integer.toBinaryString(bin), oct, hex);
		// => 2진수 출력 = Integer.toBinaryString() + string 이므로 %s
		// 8진수 출력 = %#o 또는 Integer.toOctalString() + %s
		// 16진수 출력 = %#x 또는 Integer.toHexString() + %s
		System.out.println("** 16진수 (Hexadecimal) : " + Integer.toHexString(hex));
		System.out.println("** 8진수 (Octal) : " + Integer.toOctalString(oct));

//		========================================================

		// int to String : 문자열에 연결되면 문자로 취급
		System.out.println("\n** int to String 1 : " + bin + oct + hex);
		System.out.println("** int to String 2 : " + (bin + oct + hex));
		System.out.println("** int to String 3 : " + (String.valueOf(bin) + 100));

//		========================================================

		// String to int
		String s = "123";
		System.out.println("\n** String to int 1 : " + (s + 100));

		System.out.println("** String to int 2 : " + (Integer.parseInt(s) + 100));
		// => 문자열이 숫자가 아니면(s = "일이삼";) 오류

		System.out.println("** String to int 3 : " + (Integer.valueOf(s) + 100));

//		========================================================

		// String to double
		s = "123.456";
		System.out.println("\n** String to double 1 : " + (s + 100));

		System.out.println("** String to double 2 : " + (Double.parseDouble(s) + 100));
		// => 마찬가지로 문자열이 숫자가 아니면(s = "abcd.456";) 오류;

		System.out.println("** String to double 3 : " + (Double.valueOf(s) + 100));
	}

}
