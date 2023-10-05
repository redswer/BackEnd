package jdbc02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc01.DBConnection;

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
	public List<StudentVO> selectList() {
		sql = "select * from student";

		List<StudentVO> list = new ArrayList<StudentVO>();
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
					StudentVO vo = new StudentVO();

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

	public StudentVO selectOne(StudentVO vo) {
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
//		-----------------------------------------
	// ** student 의 GroupDTO

	public List<GroupDTO> groupList() {
		sql = "select jno, count(*), sum(age), avg(age), max(age), min(age) from student group by jno order by jno";
		List<GroupDTO> list = new ArrayList<GroupDTO>();

		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {
				do {
					GroupDTO dto = new GroupDTO();

					dto.setJno(rs.getInt(1));
					dto.setCount(rs.getInt(2));
					dto.setSum(rs.getInt(3));
					dto.setAvg(rs.getDouble(4));
					dto.setMax(rs.getInt(5));
					dto.setMin(rs.getInt(6));

					list.add(dto);
				} while (rs.next());
			} else {
				list = null;
			}

		} catch (Exception e) {
			System.out.println("** groupDTO Exception => " + e.toString());
			list = null;
		}
		return list;
	}

	// ** insert

	// ** update

	// ** delete

}// class