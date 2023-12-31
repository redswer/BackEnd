package j02_ifSwitch;

public class Ex01_ifBasic {

	public static void main(String[] args) {
		// ** 삼항식
		boolean rain = true;
		String doing = (rain == true) ? "Study_Java" : "그래도 공부함";

//		===================================================

		// ** if : 단일구문
		if (rain == true)
			doing = "Study_Java";
		else
			doing = "그래도 공부함";
		// => else 구문을 생략 가능 (필요시에만 사용)

//		===================================================

		// ** if : 복합구문 (compound statement)
		// => 여러 문장의 경우 중괄호를 이용하여 문장들을 그룹핑
		if (rain) {
			int i = 100; // 지역변수

			System.out.println("** 비오면");
			System.out.println(doing);
			System.out.println("** 우산 필요함, i = " + i);
		} else {
			System.out.println("** 비 안오면");
			System.out.println(doing);
			System.out.println("** 우산 필요 없음");
		}
		// System.out.println("** 우산 필요 없음 **" + i);
		// => i 는 지역변수이기 때문에 정의된 중괄호 블럭 안에서만 사용 가능 -> 오류

//		=================================================

		// ** 복합조건식
		// => 날씨가 좋고 공휴일이면 공원에 산책을 가고 아니면 요리를 한다
		// => rain 은 false, day 는 "Red" 이면
		String day = "Red";

//			if (!rain && day == "Red")
//				System.out.println("공원에 산책을 간다");
//			else
//				System.out.println("요리를 한다");

		if (!rain && day == "Red")
			doing = "공원에 산책을 간다";
		else
			doing = "요리를 한다";

		System.out.println(doing);

//		=================================================

		// ** 중첩 if 구문
		if (!rain) {
			if (day == "Red") {
				System.out.println("공원에 산책을 간다");
			} else {
				System.out.println("요리를 한다");
			}
		} else {
			System.out.println("요리를 한다");
		}

	} // main
} // class
