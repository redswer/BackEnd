package service;

// ** controller 에서의 데이터 변경이 dao 와 vo 에서도 적용되는 것을 방지하기 위해 사이에 service 를 둠

//** insert,update,delete test 를 위해 StudentVO 를 BoardDTO 로 변경

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.BoardDTO;
import model.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	// ** 전역변수 정의
	@Autowired
	BoardDAO dao;
//	= BoardDAO dao = new BoardDAO();
	
	// ** rinsert
	@Override
	public int rinsert(BoardDTO dto) {
		return dao.rinsert(dto);
	}

	// ** selectList
	@Override
	public List<BoardDTO> selectList() {
		return dao.selectList();
	}

	// ** selectOne
	@Override
	public BoardDTO selectOne(BoardDTO vo) {
		return dao.selectOne(vo);
	}

	// ** insert
	@Override
	public int insert(BoardDTO dto) {
		return dao.insert(dto);
	}

	// ** update
	@Override
	public int update(BoardDTO dto) {
		return dao.update(dto);
	}

	// ** delete
	@Override
	public int delete(BoardDTO dto) {
		return dao.delete(dto);
	}

}// class