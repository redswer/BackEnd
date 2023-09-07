package j07_classExtends;

public class Ex03_AnimalTest {

	public class Animal {

		String breath = "육지";
		int legs = 4;

		public void breath(String breath) {
			this.breath = breath;
		}

		public void legs(int legs) {
			this.legs = legs;
		}

		public String toString(String breath, int legs) {
			return "호흡 = " + breath + ", 다리 = " + legs + "개";
		}

	}

	public class Mammal extends Animal {

		String cry;
		String run = "빠름";

		public void cry(String cry) {
			this.cry = cry;
		}

		public void run(String run) {
			this.run = run;
		}

		public String toString(String cry, String run) {
			return "울음 = " + cry + ", 뛰기 = " + run;
		}
	}

	public class Wild extends Mammal {
		String place = "동물원";
		String species;

		public String toString() {
			return "사는 곳 = " + place + "에 산다";
		}

		public void lion() {
			this.species = "사자";
			super.cry = "어흥";

			System.out.println(species + " : " + "[ " + super.toString(breath, legs) + ", " + super.toString(cry, run)
					+ ", " + toString() + " ]");
		}

		public void tiger() {
			this.species = "호랑이";
			super.cry = "어흥";

			System.out.println(species + " : " + "[ " + super.toString(breath, legs) + ", " + super.toString(cry, run)
					+ ", " + toString() + " ]");
		}

	}

	public class Pet extends Mammal {

		String toDo = "예방접종";
		String species;

		public String toString() {
			return "할 일 = " + toDo + "하기";
		}

		public void dog() {
			this.species = "개";
			super.cry = "멍멍";

			System.out.println(species + " : " + "[ " + super.toString(breath, legs) + ", " + super.toString(cry, run)
					+ ", " + toString() + " ]");
		}

		public void cat() {
			this.species = "고양이";
			super.cry = "야옹";

			System.out.println(species + " : " + "[ " + super.toString(breath, legs) + ", " + super.toString(cry, run)
					+ ", " + toString() + " ]");
		}
	}

	public static void main(String[] args) {
		Ex03_AnimalTest a = new Ex03_AnimalTest();

		Wild animal = a.new Wild();
		animal.lion();
		animal.tiger();

		Pet animal2 = a.new Pet();
		animal2.dog();
		animal2.cat();
	}

}
