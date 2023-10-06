package jdbc02;

// ** controller 에서의 데이터 변경이 dao 와 vo 에서도 적용되는 것을 방지하기 위해 사이에 service 를 둠

//** insert,update,delete test 를 위해 StudentVO 를 StudentDTO 로 변경

import java.util.List;

public class StudentService {
	// ** 전역변수 정의
	StudentDAO dao = new StudentDAO();

	// ** selectList
	public List<StudentDTO> selectList() {
		return dao.selectList();
	}

	// ** selectOne
	public StudentDTO selectOne(StudentDTO vo) {
		return dao.selectOne(vo);
	}

	// ** groupList
	public List<GroupDTO> groupList() {
		return dao.groupList();
	}

	// ** insert
	public int insert(StudentDTO dto) {
		return dao.insert(dto);
	}

	// ** update
	public int update(StudentDTO dto) {
		return dao.update(dto);
	}

	// ** delete
	public int delete(StudentDTO dto) {
		return dao.delete(dto);
	}
//	=================================================
	// ** transaction
	public void transactionTest() {
		dao.transactionTest();
	}

}// class