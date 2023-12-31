package j17_Lamda;

import java.util.function.Function;

public class Lm04_FunctionTest {

	public static void main(String[] args) {
		// 1. String 의 길이 return

		Function<String, Integer> f1 = s -> s.length();

//		======================
		// 2. Double return
		// => Double 입력받아 inch 로, inch 를 cm 로 출력

		Function<Double, Double> CtoI = d -> d * 0.393701;
		Function<Double, Double> ItoC = d -> d * 2.54;

//		=====================================
		// 출력

		System.out.println("** 1) \"가나다라마\" 의 길이 => " + f1.apply("가나다라마"));

		System.out.println("** 2-1) CtoI: 123cm => " + CtoI.apply(123.0));
		System.out.println("** 2-2) ItoC: 123inch => " + ItoC.apply(123.0));

	}// main

}// class