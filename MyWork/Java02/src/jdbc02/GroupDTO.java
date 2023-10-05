package jdbc02;

// ** count(*), sum(age), avg(age), max(age), min(age)
// => 등과 같이 Table과 무관하게 자료전달용으로만 정의한 경우 DTO 라 함.

public class GroupDTO {
	private int jno;
	private int count;
	private int sum;
	private double avg;
	private int max;
	private int min;

	public int getJno() {
		return jno;
	}

	public void setJno(int jno) {
		this.jno = jno;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	@Override
	public String toString() {
		return "GroupDTO [jno=" + jno + ", count=" + count + ", sum=" + sum + ", avg=" + avg + ", max=" + max + ", min="
				+ min + "]";
	}

}// class