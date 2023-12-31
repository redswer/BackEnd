package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.MemberDTO;


public interface MemberService {
	
	// Rest Controller
	MemberDTO selectOneJno(String id, Integer jno);

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
	
	// ** password update
	int pupdate(MemberDTO dto);

}