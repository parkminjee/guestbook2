package com.sds.icto.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.guestbook.vo.guestbookVo;

public class guestbookDao {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. connection 생성
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(dbURL, "webdb", "webdb");
		return conn;
	}

	public void insert(guestbookVo vo) throws ClassNotFoundException,
			SQLException {
		// 1. Connection 생성
		Connection conn = getConnection();
		// 2. Statement(SQL) 준비
		String sql = "insert into GUESTBOOK VALUES (guestbook_seq.nextval,?,?,?,sysdate)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 3.binding
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getMeg());

		// 4. query 실행
		pstmt.executeUpdate();
		// 5. 자원정리
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public List<guestbookVo> fetchList() throws ClassNotFoundException,
			SQLException {
		List<guestbookVo> list = new ArrayList<guestbookVo>();
		// 1. Connection 생성
		Connection conn = getConnection();
		// 2. statment 생성
		Statement stmt = conn.createStatement();
		// 3. SQL문 실행
		String sql = "select * from guestbook";
		ResultSet rs = stmt.executeQuery(sql);
		// 4. 결과 처리
		while (rs.next()) {
			int no = rs.getInt(1);
			String name = rs.getString(2);
			String pwd = rs.getString(3);
			String meg = rs.getString(4);
			String date = rs.getString(5);

			guestbookVo vo = new guestbookVo();
			vo.setNo(no);
			vo.setId(name);
			vo.setPwd(pwd);
			vo.setMeg(meg);
			vo.setDate(date);

			list.add(vo);
		}
		// 5. 자원정리
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
		return list;
	}

	public void delete(int no, String pwd) throws ClassNotFoundException, SQLException {
		// 1. Connection 생성
		Connection conn = getConnection();
		// 2. Statement(SQL) 준비
		String sql = "delete from guestbook where no = ? and password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 3.binding
		pstmt.setInt(1, no);
		pstmt.setString(2, pwd);

		// 4. query 실행
		pstmt.executeUpdate();
		// 5. 자원정리
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

}
