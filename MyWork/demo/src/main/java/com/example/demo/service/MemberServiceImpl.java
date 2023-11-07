package com.example.demo.service;

// ** controller 에서의 데이터 변경이 dao 와 vo 에서도 적용되는 것을 방지하기 위해 사이에 service 를 둠

//** insert,update,delete test 를 위해 StudentVO 를 MemberDTO 로 변경

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.MemberDTO;

import mapperInterface.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	// ** 전역변수 정의
	@Autowired
	MemberMapper mapper;
//	= MemberDAO dao = new MemberDAO();

	// ** selectJno
	@Override
	public List<MemberDTO> selectJno(int jno) {
		return mapper.selectJno(jno);
	}
	
	// ** selectList
	@Override
	public List<MemberDTO> selectList() {
		return mapper.selectList();
	}

	// ** selectOne
	@Override
	public MemberDTO selectOne(MemberDTO vo) {
		return mapper.selectOne(vo);
	}
	
	// ** insert
	@Override
	public int insert(MemberDTO dto) {
		return mapper.insert(dto);
	}

	// ** update
	@Override
	public int update(MemberDTO dto) {
		return mapper.update(dto);
	}

	// ** delete
	@Override
	public int delete(MemberDTO dto) {
		return mapper.delete(dto);
	}
	
	// ** password update
	@Override
	public int pupdate(MemberDTO dto) {
		return mapper.pupdate(dto);
	}

}// class