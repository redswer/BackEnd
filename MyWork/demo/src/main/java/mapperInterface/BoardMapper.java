package mapperInterface;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.BoardDTO;

import criTest.SearchCriteria;

public interface BoardMapper {
	// ** Board_Search_Cri_Paging
	List<BoardDTO> searchCri(SearchCriteria cri);
	int searchTotalCount(SearchCriteria cri);
	
	// ** Board_Cri_Paging
	List<BoardDTO> bcriList(SearchCriteria cri);
	int criTotalCount();
	
	// ** rinsert
	int rinsert(BoardDTO dto);
	int stepUpdate(BoardDTO dto);

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
	
	// ** Rest_API Axios Test
	@Select("select * from board where id=#{id} order by root desc, step asc")
	List<BoardDTO> idBList(String id);
}
