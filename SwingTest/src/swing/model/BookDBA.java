package swing.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDBA {
	String url, user, pwd;

	// 디비셋팅
	public BookDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "scott";
			pwd = "TIGER";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	//입력하기
	public void BookInsert(BookBean b) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "insert into book values(book_seq.nextval,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getWriter());
			ps.setString(3, b.getIndate());
			ps.setString(4, b.getOutdate());
			ps.setString(5, b.getGubun());
			ps.setInt(6, b.getPrice());
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//전체보기목록
	public ArrayList<BookBean> BookView() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<BookBean> arr = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from book";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			arr = new ArrayList<>();
			while (rs.next()) {
				BookBean b = new BookBean();
				b.setNum(rs.getInt("num"));
				b.setTitle(rs.getString("title"));
				b.setWriter(rs.getString("writer"));
				b.setIndate(rs.getString("indate"));
				b.setOutdate(rs.getString("outdate"));
				b.setGubun(rs.getString("gubun"));
				b.setPrice(rs.getInt("price"));
				arr.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}
	//수정
	public void BookUpdate(BookBean b, int num) {
		Connection con =null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "update book set title = ?,writer = ?,indate = ?,outdate = ?,gubun = ?,price = ? where num = "+num;
			ps = con.prepareStatement(sql);
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getWriter());
			ps.setString(3, b.getIndate());
			ps.setString(4, b.getOutdate());
			ps.setString(5, b.getGubun());
			ps.setInt(6, b.getPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//삭제
	public void BookDelete(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "delete from book where num ="+num;
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
