package mvcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//** DAO(Data Access Object)
//=> SQL 구문 처리
//=> CRUD 구현 
// Create(Insert), Read(selectList, selectOne), Update, Delete

//=> 첫번째 예제 Ex01_StudentTest 와 DAO 와 다른점
//  - 요청 처리 결과를 제공
// 	- 즉, 메서드의 역할별로 처리 결과를 리턴해야 함
// 	- 그러므로 select 결과를 전달하기 위해 담는 작업이 필요함  

public class StudentDAO {

	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	// ** selectList
	public List<StudentDTO> selectList() {
		sql = "select * from student";

		List<StudentDTO> list = new ArrayList<StudentDTO>();
		// => DB 에서 이미 중복확인이 되어 있으므로 Collection 중 중복 허용하고 순서를 유지하는 ArrayList 사용

		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				// => selectList 결과 존재함
				do {
					// => 따라서 결과를 List 에 담아야 하지만
					// list = rs; -> 서로 다른 형식의 객체이기 때문에 불가
					// => 따라서 1 줄(row) 단위로 옮겨야 함
					// => 이 때 1 row 는 각각 studentVO 타입
					StudentDTO vo = new StudentDTO();

					vo.setSno(rs.getInt(1));
					vo.setName(rs.getString(2));
					vo.setAge(rs.getInt(3));
					vo.setJno(rs.getInt(4));
					vo.setInfo(rs.getString(5));
					vo.setPoint(rs.getDouble(6));
					vo.setBirthday(rs.getString(7));

					list.add(vo);

				} while (rs.next());

			} else {
				list = null;
				// => 데이터가 없어도 list 는 주소를 가지고 있으므로 null이 아님
				// => 따라서 null 값을 줘야 함
			}

		} catch (Exception e) {
			System.out.println("** selectList Exception => " + e.toString());

			list = null;
			// => 위와 동일
		}

		return list;
	}// selectList()
//--------------------------------------------------
	// ** selectOne

	public StudentDTO selectOne(StudentDTO vo) {
		// => 매개변수로 int sno 대신 StudentVO 타입을 사용하면 밑에서 StudentVO 를 생성하지 않아도 됨
		// => 따라서 매개변수로는 일반적으로 출력할 데이터의 타입을 사용
		sql = "select * from student where sno = ?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, vo.getSno());
			rs = pst.executeQuery();

			if (rs.next()) {
				do {
					// StudentVO vo = new StudentVO();
					// => 위에서 매개변수로 StudentVO 를 사용했기 때문에 선언할 필요 없음

					vo.setName(rs.getString(2));
					vo.setAge(rs.getInt(3));
					vo.setJno(rs.getInt(4));
					vo.setInfo(rs.getString(5));
					vo.setPoint(rs.getDouble(6));
					vo.setBirthday(rs.getString(7));

					return vo;

				} while (rs.next());
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println("** selectOne Exception => " + e.toString());
			return null;
		}
	}// selectOne

//=================================================================================
	// ** insert
	// => name, age, jno, info 입력

	public int insert(StudentDTO dto) {
		sql = "insert into student(name, age, jno, info) values(?, ?, ?, ?)";

		try {
			pst = cn.prepareStatement(sql);

			pst.setString(1, dto.getName());
			pst.setInt(2, dto.getAge());
			pst.setInt(3, dto.getJno());
			pst.setString(4, dto.getInfo());

			return pst.executeUpdate();
			// => Ex01_StudentTest 클래스의 insert test 와 비교

		} catch (Exception e) {
			System.out.println("** insert Exception => " + e.toString());
			return 0;
		}
	}

//-----------------------
	// ** update
	// => info, birthday, point 수정

	public int update(StudentDTO dto) {
		sql = "update student set info = ?, point = ?, birthday = ? where sno = ?";

		try {
			pst = cn.prepareStatement(sql);

			pst.setString(1, dto.getInfo());
			pst.setDouble(2, dto.getPoint());
			pst.setString(3, dto.getBirthday());
			pst.setInt(4, dto.getSno());

			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** update Exception => " + e.toString());
			return 0;
		}
	}
//------------------------
	// ** delete
	// => sno 로 삭제

	public int delete(StudentDTO dto) {
		sql = "delete from student where sno = ?";

		try {
			pst = cn.prepareStatement(sql);

			pst.setInt(1, dto.getSno());

			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** delete Exception => " + e.toString());
			return 0;
		}
	}
//	============================================================
	// ** transaction
	// => Connection 객체가 관리
	// => 기본값은 AutoCommit true 임.
	// => setAutoCommit(false) -> commit 또는 rollback
	// => Test 사항
	// - 동일자료를 2번 입력 -> 2번째 입력에서 p.key 중복 오류발생

	// 1) Transaction 적용전
	// => 동일자료를 2번 입력
	// - 1번째는 입력완료 되고, 2번째 입력에서 p.key 중복 오류발생
	// - Rollback 불가능
	// - MySql Command 로 1번째 입력 확인 가능

	// 2) Transaction 적용후
	// => 동일자료를 2번 입력
	// - 1번째는 입력완료 되고, 2번째 입력에서 p.key 중복 오류발생
	// - Rollback 가능 -> 둘다 취소됨

	public void transactionTest() {
//		sql = "insert into student(sno, name, age, jno, info) values(25, '박길동', 20, 7, 'transaction test')";
		// => 적용 전
		
		sql = "insert into student(sno, name, age, jno, info) values(26, '박길동', 20, 7, 'transaction test')";
		// => 적용 후 (sno 값만 변경)

		// 1) 적용 전
//		try {
//			pst = cn.prepareStatement(sql);
//
//			pst.executeUpdate();
//			pst.executeUpdate();
//			// => 동일한 데이터 2번 입력
//			// => 첫 번째는 입력되고 두 번째는 p.key 중복 오류 발생
//
//		} catch (Exception e) {
//			System.out.println("** transaction 1 Exception =>  **" + e.toString());
//		}
//		------------------
		// 2) 적용 후

		try {
			cn.setAutoCommit(false);
			// => command 에서의 start transaction 과 동일

			pst = cn.prepareStatement(sql);
			pst.executeUpdate();
			pst.executeUpdate();

			cn.commit();
		} catch (Exception e) {
			System.out.println("transaction 1 Exception =>  **" + e.toString());
			try {
				cn.rollback();
				System.out.println("transaction -> rollback 성공");
			} catch (Exception e1) {
				System.out.println("transaction 2 Exception => " + e1.toString());
			}
		}

	}

}// class