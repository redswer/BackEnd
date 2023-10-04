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

		}
	}
// ---------------------------------------
	// ** 실습2 : 조 번호를 입력받아 jo List 출력

	public static void joList(int n) {
		sql = "select * from jo where jno = " + n;

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

		}
	}

	public static void main(String[] args) {
		// ** MySQL 작업순서
		// 로그인 -> 데이터베이스(DB) 선택 -> SQL 구문 실행 및 결과 출력

		// ** student list
		// 1. DB 연결
		System.out.println("** DB 연결 확인 => " + cn);

		System.out.println("");
//-------------------------------------------
		// 2. SQL 구문 실행 & 결과 출력 (호출)
		System.out.println("** Student List **");
		System.out.println("---------------------------------------");
		selectList();

		System.out.println("");
//-------------------------------------------
		// ** 실습 : joList 출력
		System.out.println("** Jo List **");
		System.out.println("---------------------------------------");
		joList();

		System.out.println("");
// -------------------------------------------
		// ** 실습 : joList 출력
		System.out.println("** Jo List 2**");
		System.out.println("---------------------------------------");
		joList(5);

	}// main

}// class