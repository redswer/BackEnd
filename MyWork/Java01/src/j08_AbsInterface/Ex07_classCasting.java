package j08_AbsInterface;

//*** 클래스의 형변환
//=> 자동 형변환 (형변환 생략가능)
// 조상 <- 자손 (Up_Casting)

//=> 명시적 형변환 (형변환 생략불가능)
// 자손 <- 조상 (Down_Casting)
// 실제적 클래스타입이 변환가능한 경우에만 적용됨 
// (변환불가능한 경우에는 컴파일 오류 없어도 런타임 오류(ClassCastException) 발생)

//Animal => Mammal 포유류  => PetAnimal
//Animal => Reptil 파충류 

class Animal2 {
	String name;

	public Animal2() {
		System.out.println("** Animal 생성자 **");
	}

	void breath() {
		System.out.println(name + " 는 숨을 쉽니다 ~~");
	}
} // Animal2

class Mammal extends Animal2 {
	String cry;

	public Mammal() {
		System.out.println("** Mammal 생성자 **");
	}

	void crying() {
		System.out.println(super.name + " 은(는) " + cry + " 웁니다 ~~");
	}
} // Mammal

class PetAnimal extends Mammal {
	PetAnimal() {
		System.out.println("~~ PetAnimal 생성 ~~");
	}

	void checking() {
		System.out.printf("** %s는 예방접종을 했습니다.\n", name);
	}
} // PetAnimal

class Reptile extends Animal2 {
} // Reptile

public class Ex07_classCasting {

	public static void main(String[] args) {
		// test 1) instance of test

		PetAnimal dog = new PetAnimal();

		if (dog instanceof PetAnimal) {
			System.out.println("** dog : PetAnimal **");
		}
		if (dog instanceof Mammal) {
			System.out.println("** dog : Mammal **");
		}
		if (dog instanceof Animal2) {
			System.out.println("** dog : Animal2 **");
		}

//		=======================
		// test 2) class Up_Casting Test

		Animal2 an1 = new PetAnimal(); // => 조상 <- 후손 : Up_Casting (자동)
		// PetAnimal pa = new Animal2(); // 후손 <- 조상 : Down_Casting (불가)

		an1 = new Reptile(); // 모든 후손은 교체 가능 (다형성 적용 가능)

		// ** 생성자 종류에 따른 Animal 인스턴스 비교
		Animal2 an2 = new Animal2();
		an1 = dog;
//		an2 = dog;
		// => 모두 Up_Casting 허용됨

//		==========================
		// test 3) Down_Casting
		// => 가능한 경우에만 명시적으로 허용

		System.out.println("** Down_Casting Test **");
		an1.breath(); // Animal2 에 정의된 멤버만 접근 가능
		PetAnimal cat = null;

		// cat = an1; // => PetAnimal(후손) <- Animal2(조상) 이기 때문에 불가
		cat = (PetAnimal) an1;
		cat.checking();// PetAnimal 에 정의된 멤버만 접근 가능

//		cat = (PetAnimal) an2;
		// => (위 80행의 an2 = dog 가 없으면) 컴파일 오류 없지만, 런타임 오류
		// => instance of 연산자로 확인 후 Down_Casting 적용

		if (an2 instanceof PetAnimal) {
			cat = (PetAnimal) an2;
			System.out.println("** an2 = PetAnimal **");
		} else {
			System.out.println("** an2 != PetAnimal **");
		}

		// ** instance 의 class type 확인
		// => Object 에 정의된 getClass() 메서드 이용
		System.out.println("dog 의 class type : " + dog.getClass().getName());
		System.out.println("cat 의 class type : " + cat.getClass().getName());
		System.out.println("an1 의 class type : " + an1.getClass().getName());
		System.out.println("an2 의 class type : " + an2.getClass().getName());

	} // main

} // class
