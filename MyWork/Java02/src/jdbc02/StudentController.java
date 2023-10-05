package jdbc02;

import java.util.List;

//** Controller
//=> 요청 : 요청분석 -> 담당 Service 로 보냄 -> Service 는 DAO 로 보냄
//=> 결과 : DAO -> Service -> Controller
//=> View : Controller -> View 담당 (Java:Console // Web:JSP, HTML.., React) 

public class StudentController {
	// ** 전역변수 정의
	StudentService service = new StudentService();

//	----------------------------------------------
	// 1. selectList

	// ** View 역할의 메서드
	public void printList(List<StudentVO> list) {
		System.out.println("** Student List **");

		if (list != null) {
			for (StudentVO s : list) {
				System.out.println(s);
			}

		} else {
			System.out.println("** 출력할 데이터 없음 **");
		}
	}
//------------------------------------------
	// ** selectOne

	// ** View 역할의 메서드
	public void printDetail(StudentVO vo) {
		System.out.println("** SelectOne **");

		if (vo != null) {
			System.out.println(vo.toString());
		} else {
			System.out.println("** 출력할 데이터 없음 **");
		}
	}
//	-----------------------------------------
	// groupList

	public void printGroup(List<GroupDTO> list) {
		System.out.println("** Group List **");

		if (list != null) {
			for (GroupDTO g : list) {
				System.out.println(g);
			}
		} else {
			System.out.println("** 출력할 데이터 없음 **");
		}
	}

//-------------------------------------------
	public static void main(String[] args) {

		// ** StudentController 인스턴스 생성
		StudentController controller = new StudentController();

		// ** selectList 출력
		controller.printList(controller.service.selectList());
		// => service 에서 selectList 를 받아 controller 의 printList 로 출력

		System.out.println("");
//-------------------------------------------
		// ** selectOne 출력

		StudentVO vo = new StudentVO();
		vo.setSno(10);

		controller.printDetail(controller.service.selectOne(vo));

		System.out.println("");
//		---------------------------------------
		// ** groupList 출력

		controller.printGroup(controller.service.groupList());

	}// main

}// class