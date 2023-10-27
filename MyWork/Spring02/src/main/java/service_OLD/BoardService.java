package service_OLD;

import java.util.List;

import domain.BoardDTO;

public interface BoardService {
	// ** rinsert
	int rinsert(BoardDTO dto);

	// ** selectList
	List<BoardDTO> selectList();

	// ** selectOne
	BoardDTO selectOne(BoardDTO vo);

	// ** insert
	int insert(BoardDTO dto);

	// ** update
	int update(BoardDTO dto);

	// ** delete
	int delete(BoardDTO dto);

}