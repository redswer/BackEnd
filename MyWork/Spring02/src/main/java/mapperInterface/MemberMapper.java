package mapperInterface;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import domain.MemberDTO;

public interface MemberMapper {
	// ** JUnit Test
	@Select("select * from member where id = #{id}")
	MemberDTO selectOneID(String id);
	// => mapper 매서드의 매개변수는 type 무관, 그러나 갯수는 반드시 1개
	
	@Select("select * from member where id=#{ii} and jno=#{jno}")
	MemberDTO selectOneJno(@Param("ii") String id, @Param("jno") Integer jno);
	// @ param : 
	// => mybatis 에서는 매개변수 type 은 무관하지만 갯수는 1개만 허용
	// => mapper 에서 #{} 적용, 복수 갯수 허용 (단, 기본자료형은 사용 불가)
	
	@Select("select count(*) from member where id != 'admin'")
	int totalCount();
	
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
	
	int pupdate(MemberDTO dto);
}
