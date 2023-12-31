package j05_classMethod;

// ** 복습
// => 207p 연습문제 6-1, 6-2, 6-3 구현
// => 6-1
//	-> 맴버변수는 private 으로 정의
//	-> setter/getter, toString 추가
// => 6-2 : info() 는 만들지 않아도 됨.
// => 6-3
//	-> Student 의 인스턴스를 5개 만들어서 배열에 담기
//	-> 배열을 이용해서 위 5개 인스턴스의 정보와 
//     Total, Average 출력하기

class Student {
	// 1) 멤버변수 선언

	private String name;
	private int ban;
	private int no;
	private int kor;
	private int eng;
	private int math;

//	===========================================================
	// ** j06_packageTest 패키지의 Ex01_AccessTest 를 위한 변수 선언
	int ddd = 100;

//	============================================================
	// 2) 메서드

	// 2-1) 생성자
	public Student() {
	}

	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

//	==================================

	// 2-2) setter / getter
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getBan() {
		return ban;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getKor() {
		return kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getEng() {
		return eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getMath() {
		return math;
	}

//	================================

	// 2-3) 사용자 정의 메서드
	public int getTotal() {
		return kor + eng + math;
	}

//	public float getAverage() {
//		return (float) getTotal() / 3f;
//	}
//	=> 소수점 이하 2자리로
	public float getAverage() {
		return Math.round(((kor + eng + math) / 3f) * 100) / 100.0f;
	}

//	======================================

	// 2-4) toString
	public String toString() {
		return "[ 이름 : " + name + ", 반 : " + ban + ", 번호 : " + no + ", 국어 : " + kor + ", 영어 : " + eng + ", 수학 : " + math
				+ ", 총점 : " + getTotal() + ", 평균 : " + getAverage() + " ]";
	}

//	=====================================

	// 3-4) 석차순 정렬
	public String stSort(Student[] st) {
		String print = "";

		for (int i = 0; i < st.length; i++) {
			for (int j = i + 1; j < st.length; j++) {
				if (st[i].getTotal() < st[j].getTotal()) {
					Student temp = st[i];
					st[i] = st[j];
					st[j] = temp;
				}
			}
			print += (i + 1) + "등 " + st[i] + "\n";
		}
		return print;
	}

} // Student
//	=====================================================================
// 3) 인스턴스 / 출력

public class Ex09_StudentTest {

	public static void main(String[] args) {

		// 3-1) Student 의 인스턴스를 5개 만들어서 배열에 담기
		Student s1 = new Student();
		s1.setName("가나다");
		s1.setBan(1);
		s1.setNo(1);
		s1.setKor(100);
		s1.setEng(96);
		s1.setMath(88);
		// => Student s1 = new Student("가나다", 1, 1, 100, 96, 88);

		Student s2 = new Student("라마바", 1, 2, 56, 65, 67);
		Student s3 = new Student("사아자", 2, 10, 52, 64, 28);
		Student s4 = new Student("차카타", 3, 12, 68, 96, 87);

		Student[] st = { s1, s2, s3, s4, new Student("파하가", 3, 13, 12, 50, 65) };
		// => 인스턴스를 직접 배열에 담는 것도 가능

//		================================

		int classTotal = 0;
		float classAverage = 0;

		// 3-2) 배열을 이용해서 위 5개 인스턴스의 정보와 Total, Average 출력하기
//		for (Student ss : st) {
//			System.out.println(ss);
//		}
		// => 간단한 for 문 (forEach)으로도 출력 가능
		for (int i = 0; i < st.length; i++) {
			System.out.println("student " + (i + 1) + " " + st[i]);

//		============================

			// 3-3) 전체 점수, 전체 평균 추가
			classTotal += st[i].getTotal();
			classAverage += (float) st[i].getAverage() / st.length;
		}
		System.out.println("\n클래스 총점 : " + classTotal + ", 클래스 평균 : " + classAverage);

//		=============================

		// 3-4) 석차순 출력(정렬)
//		System.out.println("\n석차 순 출력");
//		for (int i = 0; i < st.length; i++) {
//			for (int j = i + 1; j < st.length; j++) {
//				if (st[i].getAverage() < st[j].getAverage()) {
//					Student s = st[i];
//					st[i] = st[j];
//					st[j] = s;
//				}
//			}
//			System.out.println(st[i]);
//		}

		// => 메서드로 만들기 (Student 클래스의 메서드로)
		System.out.println("\n석차 순 출력");
		System.out.println(new Student().stSort(st));

	} // main
} // class