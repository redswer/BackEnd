package com.example.demo.service;

// ** controller 에서의 데이터 변경이 dao 와 vo 에서도 적용되는 것을 방지하기 위해 사이에 service 를 둠

//** insert,update,delete test 를 위해 StudentVO 를 JoDTO 로 변경

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.JoDTO;

import mapperInterface.JoMapper;

@Service
public class JoServiceImpl implements JoService {
	// ** 전역변수 정의
	@Autowired
	JoMapper mapper;
//	= JoDAO dao = new JoDAO();

	// ** selectList
	@Override
	public List<JoDTO> selectList() {
		return mapper.selectList();
	}

	// ** selectOne
	@Override
	public JoDTO selectOne(JoDTO vo) {
		return mapper.selectOne(vo);
	}

	// ** insert
	@Override
	public int insert(JoDTO dto) {
		return mapper.insert(dto);
	}

	// ** update
	@Override
	public int update(JoDTO dto) {
		return mapper.update(dto);
	}

	// ** delete
	@Override
	public int delete(JoDTO dto) {
		return mapper.delete(dto);
	}

}// class