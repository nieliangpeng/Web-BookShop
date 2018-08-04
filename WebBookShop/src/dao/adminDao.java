package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Admin;

public class adminDao {
	//增加管理员
	public boolean addAdmin(Admin admin) throws SQLException {
		boolean flag = false;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "insert into admin(admin_username,admin_passwd,admin_realname) values(?,?,?)";
		try {
			
				pst = conn.prepareStatement(sql);
				pst.setString(1,admin.getAdminUserName() );
				pst.setString(2,admin.getAdminPasswd() );
				pst.setString(3, admin.getAdminRealName());
				pst.execute();
				flag=true;
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			DBConnection.close(rs);
			DBConnection.close(pst);
			DBConnection.close(conn);
		}
		return flag;
	}
	//删除管理员
	public boolean deleteAdmin(Admin admin) throws SQLException {
		boolean bool=false;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql="delete from admin where admin_id=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1,admin.getAdminId());
			pre.execute();
			bool=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			
			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return bool;
		
	}
	//更新管理员信息  UPDATE Person SET FirstName = 'Fred' WHERE LastName = 'Wilson' 
	public boolean updateAdmin(Admin admin) throws SQLException {
		boolean bool=false;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql="update admin set admin_username=?,admin_passwd=?,admin_realname=? where admin_id=?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1, admin.getAdminUserName());
			pre.setString(2, admin.getAdminPasswd());
			pre.setString(3, admin.getAdminRealName());
			pre.setInt(4, admin.getAdminId());
			pre.execute();
			bool=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			
			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return bool;
		
	}
	//密码
	public boolean updateAdminPassword(Admin admin) throws SQLException {
		boolean bool=false;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql="update admin set admin_passwd=? where admin_id=?";
		try {
			pre=conn.prepareStatement(sql);
			
			pre.setString(1, admin.getAdminPasswd());
			pre.setInt(2, admin.getAdminId());
			pre.execute();
			bool=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			
			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return bool;
		
	}
	public Admin selectAdminByRealanme(String name) throws SQLException {
		Admin ad=null;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql="select * from admin where admin_realname=? ";
		ResultSet rs=null;
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1,name);
			rs=pre.executeQuery();
			while(rs.next()) {
				ad=new Admin();
				ad.setAdminId(rs.getInt("admin_id"));
				ad.setAdminPasswd(rs.getString("admin_passwd"));
				ad.setAdminUserName(rs.getString("admin_username"));
				ad.setAdminRealName(rs.getString("admin_realname"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			DBConnection.close(rs);
			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return ad;
		
	}
	//查询
	public Admin selectAdmin(Admin admin) throws SQLException {
		Admin ad=null;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql="select * from admin where admin_id=? ";
		ResultSet rs=null;
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1, admin.getAdminId());
			rs=pre.executeQuery();
			while(rs.next()) {
				ad=new Admin();
				ad.setAdminId(rs.getInt("admin_id"));
				ad.setAdminPasswd(rs.getString("admin_passwd"));
				ad.setAdminUserName(rs.getString("admin_username"));
				ad.setAdminRealName(rs.getString("admin_realname"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			DBConnection.close(rs);
			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return ad;
		
	}
	//查询所有的管理员
	public List<Admin> selectAllAdmin() throws SQLException {
		List<Admin> list=new ArrayList<Admin>();
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql="select * from admin";
		ResultSet rs=null;
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()) {
				Admin ad=new Admin();
				
				ad.setAdminId(rs.getInt("admin_id"));
				ad.setAdminPasswd(rs.getString("admin_passwd"));
				ad.setAdminUserName(rs.getString("admin_username"));
				ad.setAdminRealName(rs.getString("admin_realname"));
				list.add(ad);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			DBConnection.close(rs);
			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return list;
		
	}
	//登录
	public Admin login(Admin admin) throws SQLException {
		Admin ad=null;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql="select * from admin where admin_username=? and admin_passwd=? ";
		ResultSet rs=null;
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1, admin.getAdminUserName());
			pre.setString(2, admin.getAdminPasswd());
			rs=pre.executeQuery();
			while(rs.next()) {
				ad=new Admin();
				ad.setAdminId(rs.getInt("admin_id"));
				ad.setAdminPasswd(rs.getString("admin_passwd"));
				ad.setAdminUserName(rs.getString("admin_username"));
				ad.setAdminRealName(rs.getString("admin_realname"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			DBConnection.close(rs);
			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return ad;
		
	}
	
	
}
