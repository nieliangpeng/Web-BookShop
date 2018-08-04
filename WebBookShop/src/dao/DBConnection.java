package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	// 获得连接
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshopdatabase?useUnicode=true&characterEncoding=utf-8", "root", "");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	// 关闭连接
	public static void close(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}

	// 关闭结果集
	public static void close(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
			rs = null;
		}
	}

	public static void close(PreparedStatement pst) throws SQLException {
		if (pst != null) {
			pst.close();
			pst = null;
		}
	}
}
