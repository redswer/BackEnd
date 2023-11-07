package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.BoardDTO;
import criTest.SearchCriteria;

public interface BoardService {
	// ** Board_Cri_Paging
//	int criTotalCount();
	int criTotalCount(SearchCriteria cri);
	List<BoardDTO> bcriList(SearchCriteria cri);
	
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