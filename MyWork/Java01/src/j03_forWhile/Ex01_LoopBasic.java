package j03_forWhile;

//** 반복문 의 3요소 : 반복자의 초기값, 조건식(true or false), 증감식
//=> for : for(초기값; 조건식; 증감식)
//=> while, do while : 초기값(before while_Loop), 
//                   조건식(true or false => while 조건문), 
//                   증감식(in while_Loop)

//** 반복자(iterator) 
//=> 반복문에서 횟수를 count 하는 변수

public class Ex01_LoopBasic {

	public static void main(String[] args) {
		// ** 과제
		// => 1~100 까지의 합 출력하기
		// => 1+2+3+.......+100
		// => int result = 1+2+3+.......+100 ;
		int result1 = 0;

		// 1) for
		for (int i1 = 1; i1 < 101; i1++) {
			result1 += i1;
		}

		System.out.println("** for result : " + result1);

//		========================================

		// 2) while
		int i2 = 0;
		int result2 = 0;

		while (i2 < 100) {
			i2++;
			result2 += i2;
		}

		System.out.println("** while result : " + result2);

//		=========================================

		// 3) do_while
		// => 조건에 맞지 않아도 최소한 1번은 무조건 실행함.
		int i3 = 1;
		int result3 = 0;

		do {
			result3 += i3;
			i3++;
		} while (i3 < 101);

		System.out.println("** do-while result : " + result3);
	} // main

} // class