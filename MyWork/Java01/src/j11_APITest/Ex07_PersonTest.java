package j11_APITest;

import java.util.Calendar;

//** Person
//=> 주민등록번호, 이름을 전달받으면
//=> 주민등록번호를 이용해서, age, 성별을 set 하고
//=> info 출력하기 

//=> 맴버필드(private) : idNo(String), name(String), age(int), gender(char)
//=> 생성자 2개
//    * default
//    * 주민등록번호,이름을 매개변수로 전달받아 초기화 
//    -> 나이 계산, 성별도 찾아서 set
//=> setter/getter
//     이름만 수정 가능, 
//    모든필드를 사용가능 (그러나 주민번호는 뒷자리는 * 로표시)
//=> infoPrint()
//=> toString 은 오버라이딩

//** info
//이름 : 000
//번호 : 090909-*******
//나이 : 20세
//성별 : "남" 또는 "여"

class Person {
	private String idNo;
	private String name;
	private int age;
	private char gender;

	public Person() {

	}

	public Person(String name, String idNo) {

		this.idNo = idNo;
		this.name = name;

		int year = Calendar.getInstance().get(Calendar.YEAR);
		if (idNo.charAt(7) == '3' || idNo.charAt(7) == '4') {
			this.age = year - Integer.parseInt(idNo.substring(0, 2)) - 2000 + 1;
		} else {
			this.age = year - Integer.parseInt(idNo.substring(0, 2)) - 1900 + 1;
		}

		if (idNo.charAt(7) % 2 == 0) {
			this.gender = '여';
		} else {
			this.gender = '남';
		}
	}

	public String getIdNo() {
		return idNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public char getGender() {
		return gender;
	}

	public void infoPrint() {
		System.out.println("** info");
		System.out.println("이름 : " + getName());
		System.out.println("번호 : " + getIdNo().substring(0, 7) + "*******");
		System.out.println("나이 : " + getAge());
		System.out.println("성별 : " + getGender());
		System.out.println("");
	}

	@Override
	public String toString() {
		return "** info\n" + "이름 : " + name + "\n" + "번호 : " + idNo.substring(0, 7) + "*******" + "\n" + "나이 : " + age
				+ "\n" + "성별 : " + gender;
	}

}// Person

//** PersonTest
//=> Person 5명 생성후 배열에 넣고,
// 나이순으로 출력하기
//=> 나이순 정렬은 정렬메서드 (static ageSort()) 만들어서 하세요~~  
//=> 출력은 infoPrint() 로 

public class Ex07_PersonTest {

	public static void ageSort(Person[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].getAge() < arr[j].getAge()) {
					Person temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				if (arr[i].getAge() == arr[j].getAge() && Integer.parseInt(arr[i].getIdNo().substring(2, 6)) > Integer
						.parseInt(arr[j].getIdNo().substring(2, 6))) {
					Person temp2 = arr[i];
					arr[i] = arr[j];
					arr[j] = temp2;
				}
			}
		}
	}

	public static void main(String[] args) {
		Person p1 = new Person("안진혁", "970908-1000000");
		Person p2 = new Person("홍길동", "970909-2000000");
		Person p3 = new Person("김길동", "880000-1000000");
		Person p4 = new Person("이길동", "160000-4000000");
		Person p5 = new Person("박길동", "110000-3000000");

		Person[] arr = { p1, p2, p3, p4, p5 };

		ageSort(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i].infoPrint();
		}
	}// main

}// class