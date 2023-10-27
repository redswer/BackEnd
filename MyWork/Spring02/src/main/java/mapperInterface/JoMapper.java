package mapperInterface;

import java.util.List;

import domain.JoDTO;

public interface JoMapper {
	// ** selectList
	List<JoDTO> selectList();

	// ** selectOne
	JoDTO selectOne(JoDTO vo);

	// ** insert
	int insert(JoDTO dto);

	// ** update
	int update(JoDTO dto);

	// ** delete
	int delete(JoDTO dto);

}
