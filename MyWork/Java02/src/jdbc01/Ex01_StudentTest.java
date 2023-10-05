package jdbc01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01_StudentTest {

	// ** 전역변수 정의
	private static Connection cn = DBConnection.getConnection();

	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	// => Connection, Statement, PreparedStatement, ResultSet : JDBC API 의 인터페이스
//--------------------------------------
	public static void selectList() {
		// 1) Connection
		// => 전역변수로 전달받음 (cn)

		// 2) SQL 구문 처리
		sql = "select * from student";

		// 3) 결과 출력
		// st = cn.createStatement();
		// => checked Exception 이기 때문에 try~catch~finally 사용하거나 throws 해야 함
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			// => select 결과 존재 여부 확인 & 출력 (ResultSet 에서 이를 위한 메서드인 next() 제공)
			// => next() : 다음 데이터가 존재하면 true 와 현재 데이터를 return
			if (rs.next()) {
				// => rs.next()를 하면 이미 ResultSet 에 첫 번째 데이터가 들어있기 때문에 do-while 로 출력
				do {
					System.out.print(rs.getInt(1) + ", ");
					System.out.print(rs.getString("name") + ", ");
					System.out.print(rs.getInt(3) + ", ");
					System.out.print(rs.getInt(4) + ", ");
					System.out.print(rs.getString(5) + ", ");
					System.out.print(rs.getFloat(6) + ", ");
					System.out.print(rs.getString(7) + ", ");
					System.out.print(rs.getString(8) + "\n");
				} while (rs.next());

			} else {
				System.out.println("** 데이터 없음 **");
			}

		} catch (SQLException e) {
			System.out.println("** selectList Exception => " + e.toString());
		}
	}

//---------------------------------------
	// ** 실습 : jo List 출력

	public static void joList() {
		sql = "select * from jo";

		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				do {
					System.out.print(rs.getInt(1) + ", ");
					System.out.print(rs.getString(2) + ", ");
					System.out.print(rs.getInt(3) + ", ");
					System.out.print(rs.getString(4) + ", ");
					System.out.print(rs.getString(5) + "\n");
				} while (rs.next());
			} else {
				System.out.println("** 데이터 없음 **");
			}
		} catch (SQLException e) {
			System.out.println("** joList Exception => " + e.toString());
		}
	}
// ---------------------------------------
	// ** 조별 studentList
	// => 출력 jno는 매개변수로 전달

	public static void studentList(int n) {
		sql = "select sno, name, jno, point+age bonus from student where jno = " + n;

		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				do {
					System.out.print(rs.getInt(1) + "번, ");
					System.out.print(rs.getString("name") + ", ");
					System.out.print(rs.getInt(3) + "조, ");
					System.out.print(rs.getFloat("bonus") + "\n");
					// => 인덱스 번호 또는 alias 로 호출해야 함 (point+age 로 호출 불가)
				} while (rs.next());
			} else {
				System.out.println("** 데이터 없음 **");
			}
		} catch (SQLException e) {
			System.out.println("** studentList Exception => " + e.toString());
		}
	}

//	------------------------------------------------------------
	// ** insert test

	public static void insert(String name, int age, int jno, String info) {
		// statement 적용
//		sql = "insert into student(name, age, jno, info) values('" + name + "','" + age + "','" + jno + "','" + info + "')";
		// => 위 처럼 statement 로 처리하면 매우 불편하고 오류 확룰 높음
		// => 이를 해결한 것이 preparedStatement
		// => preparedStatement : 바인딩 변수(?) 제공
		// => insert into student values(?,?,?,?,?,?)
		// => ? 해결은 query 문 실행 전에 함
		sql = "insert into student(name, age, jno, info) values(?,?,?,?)";

		try {
			pst = cn.prepareStatement(sql);
//			st = cn.createStatement();
//			rs = st.executeQuery(sql);
			// => 위 처럼 statement 문은 execute 할 때 sql 문을 넣었으나
			// => preparedStatement 문은 생성과 동시에 sql 문을 넣어줘야 함

			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setInt(3, jno);
			pst.setString(4, info);

			int count = pst.executeUpdate();
			// => executeUpdate() : 성공한 입력 갯수 return

			if (count > 0) {
				System.out.println("** 입력성공 **");
			} else {
				System.out.println("** 입력실패 **");
			}

		} catch (Exception e) {
			System.out.println("** Insert Exception => " + e.toString());
		}
	}

//	------------------------------------------------------------
	// ** 바인딩 변수(?) 가 없을 때 preparedStatement 사용

	public static void selectList2() {
		sql = "select sno, name, jno, age from student";

		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {
				do {
					System.out.print(rs.getInt(1) + ", ");
					System.out.print(rs.getString(2) + ", ");
					System.out.print(rs.getInt(3) + ", ");
					System.out.print(rs.getInt(4) + "\n");
				} while (rs.next());
			} else {
				System.out.println("** 데이터 없음 **");
			}

		} catch (Exception e) {
			System.out.println("** Insert Exception 2 => " + e.toString());
		}
	}

	public static void main(String[] args) {
		// ** MySQL 작업순서
		// 로그인 -> 데이터베이스(DB) 선택 -> SQL 구문 실행 및 결과 출력
		System.out.println("** DB 연결 확인 => " + cn);

		System.out.println("");
//-------------------------------------------
		// ** selectList
		System.out.println("** Student List **");
		System.out.println("---------------------------------------");
		selectList();

		System.out.println("");
//-------------------------------------------
		// ** joList
		System.out.println("** Jo List **");
		System.out.println("---------------------------------------");
		joList();

		System.out.println("");
// -------------------------------------------
		// ** studentList
		System.out.println("** Student List 2**");
		System.out.println("---------------------------------------");
		studentList(5);

		System.out.println("");
//		---------------------------------------
		// ** Insert

		System.out.println("** Insert Test **");
		System.out.println("----------------------------------------");
		insert("고길동", 50, 7, "insert test");

		System.out.println("");
//		---------------------------------------
		// ** selectList 2 - preparedStatement

		System.out.println("** Insert Test **");
		System.out.println("----------------------------------------");
		selectList2();
	}// main

}// class