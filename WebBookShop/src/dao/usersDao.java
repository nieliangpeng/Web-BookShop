package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Users;

public class usersDao {
		//增加会员用户
		public boolean addUser(Users user) throws SQLException {
			boolean flag = false;
			Connection conn = DBConnection.getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			List<Users> list=selectAllUser();
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getUserEmail().equals(user.getUserEmail())) {
					return false;
				}
			}
			String sql = "insert into users(user_username,user_passwd,user_email,user_telephone,user_address,posttime) values(?,?,?,?,?,CURRENT_TIMESTAMP())";
			try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,user.getUserName());
					pst.setString(2,user.getUserPasswd());
					pst.setString(3,user.getUserEmail());
					pst.setString(4,user.getUserTelephone());
					pst.setString(5,user.getUserAddress());
					
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
		//删除会员用户
		public boolean deleteUser(Users user) throws SQLException {
			boolean bool=false;
			PreparedStatement pre = null;
			Connection conn = DBConnection.getConnection();
			String sql="delete from users where user_id=?";
			try {
				pre=conn.prepareStatement(sql);
				pre.setInt(1,user.getUserId());
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
		//初始化用户密码000000
		public boolean initUserPassword(Users user) throws SQLException {
			boolean bool=false;
			PreparedStatement pre = null;
			Connection conn = DBConnection.getConnection();
			String sql="update users set user_passwd=? where user_id=?";
			try {
				pre=conn.prepareStatement(sql);
				
				pre.setString(1,"000000");
				
				pre.setInt(2,user.getUserId());
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
		//更新会员用户信息  
		public boolean updateUser(Users user) throws SQLException {
			boolean bool=false;
			PreparedStatement pre = null;
			Connection conn = DBConnection.getConnection();
			String sql="update users set user_username=?, user_passwd=?,user_email=?,user_telephone=?,user_address=?,posttime=? where user_id=?";
			try {
				pre=conn.prepareStatement(sql);
				pre.setString(1,user.getUserName());
				pre.setString(2,user.getUserPasswd());
				pre.setString(3,user.getUserEmail());
				pre.setString(4,user.getUserTelephone());
				pre.setString(5,user.getUserAddress());
				pre.setDate(6,(Date) user.getPostTime() );
				pre.setInt(7,user.getUserId());
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
		//根据email查询
		public Users selectUserByEmail(String email) throws SQLException {
			Users u=null;
			PreparedStatement pre = null;
			Connection conn = DBConnection.getConnection();
			String sql="select * from users where user_email=?";
			ResultSet rs=null;
			try {
				pre=conn.prepareStatement(sql);
				pre.setString(1, email);
				rs=pre.executeQuery();
				while(rs.next()) {
					u=new Users();
					u.setUserId(rs.getInt("user_id"));
					u.setUserName(rs.getString("user_username"));
					u.setUserPasswd(rs.getString("user_passwd"));
					u.setUserEmail(rs.getString("user_email"));
					u.setUserTelephone(rs.getString("user_telephone"));
					u.setUserAddress(rs.getString("user_address"));
					u.setPostTime(rs.getDate("posttime"));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}finally {
				DBConnection.close(rs);
				DBConnection.close(pre);
				DBConnection.close(conn);
			}
			return u;
			
		}
		//查询
		public Users selectUser(Users user) throws SQLException {
			Users u=null;
			PreparedStatement pre = null;
			Connection conn = DBConnection.getConnection();
			String sql="select * from users where user_id=?";
			ResultSet rs=null;
			try {
				pre=conn.prepareStatement(sql);
				pre.setInt(1, user.getUserId());
				rs=pre.executeQuery();
				while(rs.next()) {
					u=new Users();
					u.setUserId(rs.getInt("user_id"));
					u.setUserName(rs.getString("user_username"));
					u.setUserPasswd(rs.getString("user_passwd"));
					u.setUserEmail(rs.getString("user_email"));
					u.setUserTelephone(rs.getString("user_telephone"));
					u.setUserAddress(rs.getString("user_address"));
					u.setPostTime(rs.getDate("posttime"));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}finally {
				DBConnection.close(rs);
				DBConnection.close(pre);
				DBConnection.close(conn);
			}
			return u;
			
		}
		//查询所有的会员
		public List<Users> selectAllUser() throws SQLException {
			List<Users> list=new ArrayList<Users>();
			PreparedStatement pre = null;
			Connection conn = DBConnection.getConnection();
			String sql="select * from users";
			ResultSet rs=null;
			try {
				pre=conn.prepareStatement(sql);
				
				rs=pre.executeQuery();
				while(rs.next()) {
					Users u=new Users();
					u.setUserId(rs.getInt("user_id"));
					u.setUserName(rs.getString("user_username"));
					u.setUserPasswd(rs.getString("user_passwd"));
					u.setUserEmail(rs.getString("user_email"));
					u.setUserTelephone(rs.getString("user_telephone"));
					u.setUserAddress(rs.getString("user_address"));
					u.setPostTime(rs.getDate("posttime"));
					list.add(u);
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
		//检查用户邮箱密码
		public Users login(Users user) throws SQLException {
			Users u=null;
			PreparedStatement pre = null;
			Connection conn = DBConnection.getConnection();
			String sql="select * from users where user_email=? and user_passwd=?";
			ResultSet rs=null;
			try {
				pre=conn.prepareStatement(sql);
				pre.setString(1, user.getUserEmail());
				pre.setString(2, user.getUserPasswd());
				rs=pre.executeQuery();
				while(rs.next()) {
					u=new Users();
					u.setUserId(rs.getInt("user_id"));
					u.setUserName(rs.getString("user_username"));
					u.setUserPasswd(rs.getString("user_passwd"));
					u.setUserEmail(rs.getString("user_email"));
					u.setUserTelephone(rs.getString("user_telephone"));
					u.setUserAddress(rs.getString("user_address"));
					u.setPostTime(rs.getDate("posttime"));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}finally {
				DBConnection.close(rs);
				DBConnection.close(pre);
				DBConnection.close(conn);
			}
			return u;
			
		}
}
