package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import domain.BoardDTO;

@Repository
public class BoardDAO {

	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	public List<BoardDTO> selectList() {
		sql = "select * from board order by root desc, step asc";

		List<BoardDTO> list = new ArrayList<BoardDTO>();

		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				do {
					BoardDTO dto = new BoardDTO();

					dto.setSeq(rs.getInt(1));
					dto.setId(rs.getString(2));
					dto.setTitle(rs.getString(3));
//					dto.setContent(rs.getString(4));
					dto.setRegdate(rs.getString(5));
					dto.setCnt(rs.getInt(6));
					dto.setRoot(rs.getInt(7));
					dto.setStep(rs.getInt(8));
					dto.setIndent(rs.getInt(9));

					list.add(dto);

				} while (rs.next());

			} else {
				list = null;
			}

		} catch (Exception e) {
			System.out.println("** selectList Exception => " + e.toString());
			list = null;
		}
		return list;
	}

	public BoardDTO selectOne(BoardDTO dto) {
		sql = "select * from board where seq = ?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dto.getSeq());
			rs = pst.executeQuery();

			if (rs.next()) {
				do {
					dto.setSeq(rs.getInt(1));
					dto.setId(rs.getString(2));
					dto.setTitle(rs.getString(3));
					dto.setContent(rs.getString(4));
					dto.setRegdate(rs.getString(5));
					dto.setCnt(rs.getInt(6));
					dto.setRoot(rs.getInt(7));
					dto.setStep(rs.getInt(8));
					dto.setIndent(rs.getInt(9));

					return dto;

				} while (rs.next());
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println("** selectOne Exception => " + e.toString());
			return null;
		}
	}

	// ** Insert
	// => 입력 컬럼 : id, title, content
	// => default : regdate, cnt
	// => auto_inc : seq (auto 보다는 직접 계산해서 입력하는 것이 바람직)
	public int insert(BoardDTO dto) {
//		sql = "insert into board(seq, id, title, content) values("
//				+ "(select * from (select ifnull(max(seq),0)+1 from board) as temp)" + ", ?, ?, ?)";
		// => select ifnull(max(seq),0)+1 from board
		// => 바로 사용 불가능하므로 select * from 과 () 붙여줘야 함
		// => select * from (select ifnull(max(seq),0)+1 from board)
		// => 바로 사용 불가능 () 와 as temp 붙여줘야 함
		// => (select * from (select ifnull(max(seq),0)+1 from board) as temp)

		// ** 댓글 입력으로 인해 수정
		sql = "insert into board(seq, id, title, content, root) values("
				+ "(select * from (select ifNull(max(seq), 0)+1 from board) as temp), ?, ?, ?,"
				+ "(select * from (select ifNull(max(seq), 0)+1 from board) as temp))";
		
		try {
			pst = cn.prepareStatement(sql);

			pst.setString(1, dto.getId());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getContent());

			return pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("** insert Exception => " + e.toString());
			return 0;
		}
	}

	// ** 답글등록
	// => 댓글등록, seq는 IFNULL 이용
	// => stepUpdate 가 필요함
	// 댓글 입력 성공 후 실행
	// -> 현재 입력된 답글의 step 값은 수정되지 않도록 sql 구문의 조건 주의
	// => JDBC subQuery 구문 적용시 주의사항
	// -> MySql: select 구문으로 한번더 씌워 주어야함 (insert 의 경우에도 동일)
	public int rinsert(BoardDTO dto) {
		sql = "insert into board(seq, id, title, content, root, step, indent)"
				+ "values((select * from (select ifNull(max(seq),0)+1 from board) as temp),"
				+ " ?, ?, ?, ?, ?, ?)";
		
		try {
			pst=cn.prepareStatement(sql);
			
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getContent());
			pst.setInt(4, dto.getRoot());
			pst.setInt(5, dto.getStep());
			pst.setInt(6, dto.getIndent());
			
			pst.executeUpdate();
			
			System.out.println("stepUdate Count => " + stepUpdate(dto));
			return 1;
			
		} catch (Exception e) {
			System.out.println("** reply_insert Exception => " + e.toString());
			return 0;
		}
	}
	
	public int stepUpdate(BoardDTO dto) {
		sql="update board set step = step+1 where root = ? and step >= ? "
				+ "and seq <> (select * from (select ifNull(max(seq),0) from board) as temp)";
		
		try {
			pst=cn.prepareStatement(sql);
			
			pst.setInt(1, dto.getRoot());
			pst.setInt(2, dto.getStep());
			
			return pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("** stepUpdate Exception => " + e.toString());
			return 0;
		}		
	}

	// ** title 과 content 만 수정
	public int update(BoardDTO dto) {
		sql = "update board set title = ?, content = ?, cnt = ? where seq = ?";

		try {
			pst = cn.prepareStatement(sql);

			pst.setString(1, dto.getTitle());
			pst.setString(2, dto.getContent());
			pst.setInt(3, dto.getCnt());
			pst.setInt(4, dto.getSeq());

			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** update Exception => " + e.toString());
			return 0;
		}
	}

	public int delete(BoardDTO dto) {
		sql = "delete from board where seq = ?";

		try {
			pst = cn.prepareStatement(sql);

			pst.setInt(1, dto.getSeq());

			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** delete Exception => " + e.toString());
			return 0;
		}
	}

}// class