package j05_classMethod;

//** 접근제어자
//=> 클래스 또는 클래스 멤버들의 접근 범위 제한 
//=> public(프로젝트전체) > protected(상속+default) > default(같은 패키지내) > private(해당 클래스내)

//** 설정자(mutator) 와 접근자(accessor)
//=> 외부클래스 에서 변수에 직접 접근하지 못하도록 하고, 
//메서드를 통해서만 접근하도록 함
//=> 그러면 변수에 값을 넣어주는 메서드 (설정자) 와
//변수의 값을 보여주는 메서드 (접근자) 가 필요함.
//=> 설정자: 맴버변수 write, setXXX() 형식 -> setter
//=> 접근자: 맴버변수 read, getXXX() 형식 -> getter

//=> 메서드를 통해 접근하므로 변수값에 대한 Control 이 가능함
//=> 필요에 따라서 setter , getter 를 적절하게 작성해서 외부에서의 접근을 조정 할 수 있음

class Member {
	// ** 접근제어로 Data 보호

	private String id;
	private String name;
	private int age;
	// => private : 해당 클래스만 접근 가능
	// => 클래스 외부에서는 메서드를 통해 접근하도록 함

//	==========================================
	// ** 생성자

	public Member() {
	}

	public Member(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

//	==========================================
	// ** 설정자(mutator) 와 접근자(accessor)

	// id
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	// name
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// age
	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

//	============================================
	// ** toString

	public String toString() {
		return "[ id = " + id + ", name = " + name + ", age = " + age + " ]";
	}
} // Member

public class Ex08_Accessor {

	public static void main(String[] args) {
		// ** 인스턴스 생성

		Member m1 = new Member();
		m1.setId("abc123");
		m1.setName("홍길동");
		m1.setAge(27);
		// => id, name, age 는 private 로 생성했기 때문에 Member 클래스 안에서만 접근 가능
		// => 따라서 setter 를 이용해서 접근해 초기화해야 함

		System.out.println("m1 : " + m1);
		System.out.println("id = " + m1.getId());
		System.out.println("name = " + m1.getName());
		System.out.println("age = " + m1.getAge());

//		===============================================
		// ** 생성자로 초기화
		Member m2 = new Member("def345", "바나나", 40);

		m2.setAge(100);

		System.out.println("");
		System.out.println("m2 : " + m2);
		System.out.println("id = " + m2.getId());
		System.out.println("name = " + m2.getName());
		System.out.println("age = " + m2.getAge());

	} // main

} // class