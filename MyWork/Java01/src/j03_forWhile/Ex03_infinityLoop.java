package j03_forWhile;

public class Ex03_infinityLoop {

	public static void main(String[] args) {
		// 1) for
		System.out.println("** 무한루프 (for) **");
		int count = 0;
		for (;;) {
			System.out.println("for -> " + count++);

			// 탈출
			if (count > 100000) {
				break;
			}
		}

//		========================================

		// 2) while
		System.out.println("무한루프 (while)");
		count = 0;
		while (true) {
			System.out.println("while -> " + count++);

			// 탈출
			if (count > 100000) {
				break;
			}
		}

//		===========================================

		// 3) do-while
		System.out.println("무한루프 (do-while)");
		count = 0;
		do {
			System.out.println("do-while -> " + count++);

			// 탈출
			if (count > 100000) {
				break;
			}
		} while (true);

	} // main

}
// class