package service;

// ** controller 에서의 데이터 변경이 dao 와 vo 에서도 적용되는 것을 방지하기 위해 사이에 service 를 둠

//** insert,update,delete test 를 위해 StudentVO 를 MemberDTO 로 변경

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.MemberDTO;
import model.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	// ** 전역변수 정의
	@Autowired
	MemberDAO dao;
//	= MemberDAO dao = new MemberDAO();

	// ** selectJno
	@Override
	public List<MemberDTO> selectJno(int jno) {
		return dao.selectJno(jno);
	}
	
	// ** selectList
	@Override
	public List<MemberDTO> selectList() {
		return dao.selectList();
	}

	// ** selectOne
	@Override
	public MemberDTO selectOne(MemberDTO vo) {
		return dao.selectOne(vo);
	}
	
	// ** insert
	@Override
	public int insert(MemberDTO dto) {
		return dao.insert(dto);
	}

	// ** update
	@Override
	public int update(MemberDTO dto) {
		return dao.update(dto);
	}

	// ** delete
	@Override
	public int delete(MemberDTO dto) {
		return dao.delete(dto);
	}

}// class