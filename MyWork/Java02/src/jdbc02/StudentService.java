package jdbc02;

// ** controller 에서의 데이터 변경이 dao 와 vo 에서도 적용되는 것을 방지하기 위해 사이에 service 를 둠

import java.util.List;

public class StudentService {
	// ** 전역변수 정의
	StudentDAO dao = new StudentDAO();

	// ** selectList
	public List<StudentVO> selectList() {
		return dao.selectList();
	}

	// ** selectOne
	public StudentVO selectOne(StudentVO vo) {
		return dao.selectOne(vo);
	}

	public List<GroupDTO> groupList() {
		return dao.groupList();
	}

}// class