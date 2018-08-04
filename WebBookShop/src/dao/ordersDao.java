package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bean.Orders;
import bean.Users;

public class ordersDao {
	// 增加未支付订单表
	public int  addOrders(Orders order) throws SQLException {
		int id=0;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pst = null;
		String sql = "insert into orders(user_id,order_time,order_state) values(?,CURRENT_TIMESTAMP(),'未支付')";
		String sql_1="SELECT LAST_INSERT_ID() d FROM orders";
		ResultSet rs=null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, order.getUser().getUserId());
			pst.execute();
			pst=conn.prepareStatement(sql_1);
			rs=pst.executeQuery();
			while(rs.next()) {
				id=rs.getInt("d");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			DBConnection.close(rs);
			DBConnection.close(pst);
			DBConnection.close(conn);
		}
		return id;
	}

	// 删除订单表
	public boolean deleteOrders(int order_id) throws SQLException {
		orderDetailDao odDao = new orderDetailDao();
		odDao.deleteOrderDetailByOrderId(order_id);
		boolean bool = false;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "delete from orders where order_id=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, order_id);
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
	//付款
	public boolean getMoneyById(int orderid) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE orders SET order_state='已支付' WHERE order_id=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, orderid);
			if (stmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return false;
	}
	//发货
	public boolean endTheOrderById(int orderid) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE orders SET order_state='已完成' WHERE order_id=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, orderid);
			if (stmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return false;
	}
	// 更新订单表信息
	public boolean updateOrder(Orders order) throws SQLException {
		boolean bool = false;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "update orders set user_id=?,order_time=?,order_state=? where order_id=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, order.getUser().getUserId());
			pre.setDate(2, (Date) order.getOrderTime());
			pre.setString(3, order.getOrderState());
			pre.setInt(4, order.getOrderId());
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

	// 根据订单表id查询订单表
	public Orders selectOrderByOrderId(Orders order) throws SQLException {
		Orders od = null;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "select * from orders where order_id=?";
		ResultSet rs = null;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, order.getOrderId());
			rs = pre.executeQuery();
			usersDao dao=new usersDao();
			while (rs.next()) {
				od=new Orders();
				od.setOrderId(rs.getInt("order_id"));
				Users user=new Users();
				user.setUserId(rs.getInt("user_id"));
				user=dao.selectUser(user);
				od.setUser(user);
				od.setOrderTime(rs.getDate("order_time"));
				od.setOrderState(rs.getString("order_state"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			DBConnection.close(rs);
			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return od;

	}

	// 根据用户id查询订单表
	public List<Orders> selectOrderByUserId(int userId) throws SQLException {
		List<Orders> orderList = new ArrayList<Orders>();
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "select * from orders where user_id=?";
		ResultSet rs = null;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, userId);
			rs = pre.executeQuery();
			while (rs.next()) {
				Orders od = new Orders();
				od.setOrderId(rs.getInt("order_id"));
				Users user=new Users();
				user.setUserId(rs.getInt("user_id"));
				user=new usersDao().selectUser(user);
				od.setUser(user);
				
				od.setOrderTime(rs.getDate("order_time"));
				od.setOrderState(rs.getString("order_state"));
				orderList.add(od);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			DBConnection.close(rs);
			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return orderList;

	}

	// 查询所有订单表
	public List<Orders> selectAllOrder() throws SQLException {
		List<Orders> orderList = new ArrayList<Orders>();
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "select * from orders";
		ResultSet rs = null;
		try {
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				Orders od = new Orders();
				od.setOrderId(rs.getInt("order_id"));
				Users user=new Users();
				user.setUserId(rs.getInt("user_id"));
				usersDao userDao = new usersDao();
				Users u = userDao.selectUser(user);
				od.setUser(u);
				od.setOrderTime(rs.getDate("order_time"));
				od.setOrderState(rs.getString("order_state"));
				orderList.add(od);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			DBConnection.close(rs);
			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return orderList;

	}
	//根据订单状态查询订单
	public List<Orders> listProductOrderByState(String state) throws SQLException {
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Orders> orderList = new ArrayList<Orders>();
		Orders tmpOrder = null;
		try {

			String sql = "select * from orders where order_state= ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, state);
			rs = stmt.executeQuery();
			usersDao userDao = new usersDao();
			while (rs.next()) {
				tmpOrder = new Orders();
				tmpOrder.setOrderId(rs.getInt("order_id"));
				Users user=new Users();
				user.setUserId(rs.getInt("user_id"));
				Users u = userDao.selectUser(user);
				tmpOrder.setUser(u);
				tmpOrder.setOrderTime(rs.getDate("order_time"));
				tmpOrder.setOrderState(rs.getString("order_state"));
				orderList.add(tmpOrder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return orderList;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws SQLException {
		ordersDao dao=new ordersDao();
		Orders order=new Orders();
		Users user=new Users();
		user.setUserId(1);
		
		order.setUser(user);
		
		int s=dao.addOrders(order);
		System.out.print(s);
	}
}
