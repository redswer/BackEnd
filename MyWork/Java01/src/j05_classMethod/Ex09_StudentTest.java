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
	private String name;
	private int ban;
	private int no;
	private int kor;
	private int eng;
	private int math;

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

	int getTotal() {
		return kor + eng + math;
	}

	float getAverage() {
		return (float) getTotal() / 3f;
	}

	public String toString() {
		return "[ 이름 : " + name + ", 반 : " + ban + ", 번호 : " + no + ", 국어 : " + kor + ", 영어 : " + eng + ", 수학 : " + math
				+ ", 총점 : " + getTotal() + ", 평균 : " + getAverage() + " ]";
	}

} // Student

public class Ex09_StudentTest {

	public static void main(String[] args) {
		Student s1 = new Student("가나다", 1, 1, 100, 96, 88);
		Student s2 = new Student("라마바", 1, 2, 56, 65, 67);
		Student s3 = new Student("사아자", 2, 10, 52, 64, 28);
		Student s4 = new Student("차카타", 3, 72, 68, 96, 87);
		Student s5 = new Student("파하가", 3, 13, 12, 50, 65);

		Student[] st = { s1, s2, s3, s4, s5 };
		
		int classTotal = 0;
		float classAverage = 0;

		for (int i = 0; i < st.length; i++) {
			classTotal += st[i].getTotal();
			classAverage += (float) st[i].getAverage() / st.length;

			System.out.println("student " + (i + 1) + " " + st[i]);
		}
		System.out.println("\n클래스 총점 : " + classTotal + ", 클래스 평균 : " + classAverage);

	} // main
}
// class