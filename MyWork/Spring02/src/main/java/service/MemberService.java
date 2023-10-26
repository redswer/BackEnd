package service;

import java.util.List;

import domain.MemberDTO;

public interface MemberService {

	// ** selectJno
	List<MemberDTO> selectJno(int jno);
	
	// ** selectList
	List<MemberDTO> selectList();

	// ** selectOne
	MemberDTO selectOne(MemberDTO vo);
	
	// ** insert
	int insert(MemberDTO dto);

	// ** update
	int update(MemberDTO dto);

	// ** delete
	int delete(MemberDTO dto);

}