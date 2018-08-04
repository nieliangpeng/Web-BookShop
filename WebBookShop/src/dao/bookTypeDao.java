package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.BookType;

public class bookTypeDao {
	// 增加图书类别
	public boolean addBookType(BookType bt) throws SQLException {
		boolean flag = false;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pst = null;
		// ResultSet rs = null;
		String sql = "insert into book_type(type_name) values(?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, bt.getTypeName());
			pst.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			// DBConnection.close(rs);
			DBConnection.close(pst);
			DBConnection.close(conn);
		}
		return flag;
	}

	// 删除图书类别
	public boolean deleteBookType(BookType bt) throws SQLException {
		boolean bool = false;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "delete from book_type where type_id=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, bt.getTypeId());
			pre.execute();
			bool = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return bool;

	}

	// 更新图书类别信息
	public boolean updateBookType(BookType bt) throws SQLException {
		boolean bool = false;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "update book_type set type_name=? where type_id=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, bt.getTypeName());
			pre.setInt(2, bt.getTypeId());
			pre.execute();
			bool = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return bool;

	}

	// 查询
	public BookType selectBookType(int id) throws SQLException {
		BookType type = null;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "select * from book_type where type_id=?";
		ResultSet rs = null;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while (rs.next()) {
				type = new BookType();
				type.setTypeId(rs.getInt("type_id"));
				type.setTypeName(rs.getString("type_name"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			DBConnection.close(rs);
			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return type;

	}

	// 查询所有的图书类型
	public List<BookType> selectAllBookType() throws SQLException {
		List<BookType> list=new ArrayList<BookType>();
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "select * from book_type";
		ResultSet rs = null;
		try {
			pre = conn.prepareStatement(sql);
			
			rs = pre.executeQuery();
			while (rs.next()) {
				BookType type = new BookType();
				type.setTypeId(rs.getInt("type_id"));
				type.setTypeName(rs.getString("type_name"));
				list.add(type);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			DBConnection.close(rs);
			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return list;

	}
}
