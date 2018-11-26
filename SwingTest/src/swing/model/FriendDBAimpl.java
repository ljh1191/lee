package swing.model;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;

public class FriendDBAimpl implements FriendDBA {
	// 디비셋팅
	String url, user, pwd;

	public FriendDBAimpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "scott";
			pwd = "TIGER";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// 친구추가
	@Override // 어노테이션 - 컴파일러에게 부모에게 있는 함수인지 새로정의 하는 함수인지 알려주기 위해 필요함.
	public void friendInsert(Friend f) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "insert into friend values(friend_seq.nextval,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, f.getName());
			ps.setString(2, f.getBirth());
			ps.setString(3, f.getPhone());
			ps.setString(4, f.getAddr());
			ps.executeQuery();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 친구전체보기
	@Override
	public ArrayList<Friend> friendView() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Friend> arr = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from friend";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Friend f = new Friend();
				f.setNum(rs.getInt("num"));
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				arr.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arr;
	}

	// 친구검색
	@Override
	public ArrayList<Friend> friendSearch(String key, String str) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Friend> arr = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from friend where " + key + " like '%" + str + "%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Friend f = new Friend();
				f.setNum(rs.getInt("num"));
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
				arr.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}
	//상세보기
	public Friend friendSelect(int num ) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Friend f = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from friend where num = "+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				f = new Friend();
				f.setName(rs.getString("name"));
				f.setBirth(rs.getString("birth"));
				f.setPhone(rs.getString("phone"));
				f.setAddr(rs.getString("addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
	//수정
	public void friendUpdate(Friend f, int i) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "update friend set name = ?,birth = ?,phone = ?,addr = ? where num = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, f.getName());
			ps.setString(2, f.getBirth());
			ps.setString(3, f.getPhone());
			ps.setString(4, f.getAddr());
			ps.setInt(5, i);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//삭제
	public void friendDelete(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "delete from friend where num ="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			try { 
				if (st != null) 
				st.close(); 
				if (con != null) 
				con.close(); 
				if (rs != null) 
					rs.close(); 
				} catch (SQLException e) { 
				e.printStackTrace(); 
				} 
				}
	}
}
