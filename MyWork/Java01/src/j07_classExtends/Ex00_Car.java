package j07_classExtends;

public class Ex00_Car {
	public int speed;
	public int mileage;
	public String color = "Yellow";

	public Ex00_Car() {
	}

	public Ex00_Car(int speed, int mileage, String color) {
		this.speed = speed;
		this.mileage = mileage;
		this.color = color;
	}

	public void speedUp() {
		speed += 10;
	}

	public void speedDown() {
		speed -= 10;
	}

	public String toString() {
		return "[ speed = " + speed + ", mileage = " + mileage + ", color = " + color + " ]";
	}
}
// class