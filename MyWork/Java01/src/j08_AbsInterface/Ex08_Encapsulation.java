package j08_AbsInterface;

//** 캡슐화(Encapsulation)
//1. 은닉 (보호) : 접근 제어자를 이용
//=> 외부로부터 데이터를 보호하고,
// 내부적으로만 사용되는 부분은 감추어 준다 
//=> 접근 제어자 : private < default < protected < public
//				 class	  package  package+상속	프로젝트 전체

//2. 단위 기능 모듈화
//=> 세분화 되어있는 모듈을 하나의 기능으로 처리할 수 있도록 묶어준다.
//=> 종합 감기약 처럼 
//=> 세분화 되어있는 모듈을 사용하면서 호출 순서에 따른 오류 등
// 발생가능한 논리적 오류를 예방하고, 생산성 및 유지보수 에 유리

//** 실습
//=> 감기 증상 : 두통, 콧물, 몸살
class HeadacheCap {
	void take() {
		System.out.println(" 두통 해결 ~~");
	}
} // HeadacheCap

class SinivelCap {
	void take() {
		System.out.println(" 콧물 해결 ~~");
	}
} // SinivelCap

class BodyPainCap {
	void take() {
		System.out.println(" 몸살 해결 ~~");
	}
} // BodyPainCap

//============================================
//** 환자발생1. BadCase Encapsulation
//=> 증상별 복용순서에 따라 복용
//=> 세분화 되어있는 모듈을 직접 사용하는 경우

class ColdPatient {
	void takeHead(HeadacheCap hcap) {
		hcap.take();
	}

	void takeSinivel(SinivelCap scap) {
		scap.take();
	}

	void takeBody(BodyPainCap bcap) {
		bcap.take();
	}
}

//========================================
//환자발생 2. GoodCase Encapsulation

class TotalCap {

	HeadacheCap hcap = new HeadacheCap();
	SinivelCap scap = new SinivelCap();
	BodyPainCap bcap = new BodyPainCap();
	// => 인스턴스를 멤버면수로 정의

	void take() {

		hcap.take();
		scap.take();
		bcap.take();
		// => 복용 순서대로 작성해놓음
	}
}

class Patient2 {
	void takeTotal(TotalCap tcap) {
		tcap.take();
	}
}

public class Ex08_Encapsulation {

	public static void main(String[] args) {
//		============================================
		// 환자발생 1. BadCase Encapsulation
		// => 인스턴스 생성, 메서드 호출
		// => 단점 : 메서드 호출 순서의 오류발생 가능성

		ColdPatient cp = new ColdPatient();
		cp.takeBody(new BodyPainCap());
		cp.takeHead(new HeadacheCap());
		cp.takeSinivel(new SinivelCap());

		System.out.println("");
//		============================================
		// 활자발생 2. GoodCase Encapsulation

		Patient2 np = new Patient2();
		np.takeTotal(new TotalCap());

	}// main

}// class