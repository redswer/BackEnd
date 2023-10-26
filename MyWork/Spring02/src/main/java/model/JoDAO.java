package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import domain.JoDTO;

@Repository
public class JoDAO {

	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	public List<JoDTO> selectList() {
		sql = "select * from jo";

		List<JoDTO> list = new ArrayList<JoDTO>();

		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				do {
					JoDTO dto = new JoDTO();

					dto.setJno(rs.getInt(1));
					dto.setJname(rs.getString(2));
					dto.setId(rs.getString(3));
					dto.setProject(rs.getString(4));
					dto.setSlogan(rs.getString(5));

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

	public JoDTO selectOne(JoDTO dto) {
		sql = "select * from jo where jno = ?";

		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, dto.getJno());
			rs = pst.executeQuery();

			if (rs.next()) {
				do {
					dto.setJno(rs.getInt(1));
					dto.setJname(rs.getString(2));
					dto.setId(rs.getString(3));
					dto.setProject(rs.getString(4));
					dto.setSlogan(rs.getString(5));

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
	public int insert(JoDTO dto) {
		sql = "insert into jo(jno, jname, id, project, slogan) values(?, ?, ?, ?, ?)";

		try {
			pst = cn.prepareStatement(sql);

			pst.setInt(1, dto.getJno());
			pst.setString(2, dto.getJname());
			pst.setString(3, dto.getId());
			pst.setString(4, dto.getProject());
			pst.setString(5, dto.getSlogan());

			return pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("** insert Exception => " + e.toString());
			return 0;
		}
	}

	public int update(JoDTO dto) {
		sql = "update jo set jname = ?, id = ?, project = ?, slogan = ? where jno = ?";

		try {
			pst = cn.prepareStatement(sql);

			pst.setString(1, dto.getJname());
			pst.setString(2, dto.getId());
			pst.setString(3, dto.getProject());
			pst.setString(4, dto.getSlogan());
			pst.setInt(5, dto.getJno());

			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** update Exception => " + e.toString());
			return 0;
		}
	}

	public int delete(JoDTO dto) {
		sql = "delete from jo where jno = ?";

		try {
			pst = cn.prepareStatement(sql);

			pst.setInt(1, dto.getJno());

			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** delete Exception => " + e.toString());
			return 0;
		}
	}

}// class