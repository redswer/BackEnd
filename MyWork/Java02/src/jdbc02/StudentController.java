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
	// 1. select

	// ** View 역할의 메서드
	public void printList(List<StudentDTO> list) {
		System.out.println("** Student List **");

		if (list != null) {
			for (StudentDTO s : list) {
				System.out.println(s);
			}

		} else {
			System.out.println("** 출력할 데이터 없음 **");
		}
	}
//------------------------------------------
	// ** selectOne

	// ** View 역할의 메서드
	public void printDetail(StudentDTO vo) {
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

//============================================================
	public static void main(String[] args) {

		// ** StudentController 인스턴스 생성
		StudentController controller = new StudentController();

		// ** selectList 출력
		controller.printList(controller.service.selectList());
		// => service 에서 selectList 를 받아 controller 의 printList 로 출력

		System.out.println("");
//-------------------------------------------
		// ** selectOne 출력

		StudentDTO vo = new StudentDTO();
		vo.setSno(10);

		controller.printDetail(controller.service.selectOne(vo));

		System.out.println("");
//		---------------------------------------
		// ** groupList 출력

		controller.printGroup(controller.service.groupList());

//		=======================================================================
		// ** insert

		StudentDTO dto = new StudentDTO();

		dto.setName("바나나");
		dto.setAge(30);
		dto.setJno(7);
		dto.setInfo("insert test");

		if (controller.service.insert(dto) > 0) {
			System.out.println("** insert 성공 **");
		} else {
			System.out.println("** insert 실패 **");
		}

//		------------------------
		// ** update

		dto.setSno(25);
		dto.setInfo("수정 테스트");
		dto.setPoint(123.456);
		dto.setBirthday("2000-09-09");

		if (controller.service.update(dto) > 0) {
			System.out.println("** update 성공 **");
		} else {
			System.out.println("** update 실패 **");
		}

//		------------------------
		// ** delete

		dto.setSno(25);

		if (controller.service.delete(dto) > 0) {
			System.out.println("** delete 성공 **");
		} else {
			System.out.println("** delete 실패 **");
		}
//		================================================
		// ** transaction test
		// => command 에서 start transaction; -> rollback; / commit; 으로 실행됨
		// => JDBC 에서는 Connection 객체가 관리 (default : autoCommit true)
		// => 적용 전/후 비교
		
		controller.service.transactionTest();
		// => 정확한 test 위해 위의 select, insert, update, delete 주석 처리 하고 실행
		

	}// main

}// class