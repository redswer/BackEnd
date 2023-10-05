package jdbc02;

//** VO (Value Object) , DTO (Data Transfer Object)
//=> 자료의 구조를 표현하는 클래스이며, 자료의 전달에 이용됨
//=> 대부분 Table별로 만들며, Table과 동일한 필드명을 사용한다.
//=> Table과 무관하게 자료전달용으로만 정의한 경우 DTO 라 함.

//=> 맴버변수 : private
//=> 외부에서는 setter/getter 로 접근

public class StudentVO {

	private int sno;
	private String name;
	private int age;
	private int jno;
	private String info;
	private double point;
	private String birthday;

// ** getter / setter
// => 자동 생성 : 마우스 오른쪽 클릭 -> source -> Generate getters and setters
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getJno() {
		return jno;
	}

	public void setJno(int jno) {
		this.jno = jno;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	// ** toString
	// => 자동 생성 : 마우스 오른쪽 클릭 -> source -> Generate toString()
	@Override
	public String toString() {
		return "StudentVO [sno=" + sno + ", name=" + name + ", age=" + age + ", jno=" + jno + ", info=" + info
				+ ", point=" + point + ", birthday=" + birthday + "]";
	}

}// class