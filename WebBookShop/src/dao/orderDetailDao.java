package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Book;
import bean.CartBookBean;
import bean.Orders;
import bean.orderDetail;
import bean.shoppingCartList;

public class orderDetailDao {
	//根据购物车增加订单详细表
	public boolean addOrderDetailByshopCart(shoppingCartList productCart ,int orderId) throws SQLException {
		boolean flag = false;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pst = null;
		String sql = "insert into order_detail(order_id,book_id,count) values(?,?,?)";
		try {
			for(CartBookBean bean : productCart) {
				pst = conn.prepareStatement(sql);
				pst.setInt(1,orderId);
				pst.setInt(2,bean.getProduct().getBookId());
				pst.setInt(3,bean.getCount());
				pst.execute();
			}
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(pst);
			DBConnection.close(conn);
		}
		return flag;
		
		
			
		
	}
	// 增加订单明细表
	public boolean addOrderDetail(orderDetail od) throws SQLException {
		boolean flag = false;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pst = null;
		String sql = "insert into order_detail(order_id,book_id,count) values(?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,od.getOrder().getOrderId());
			pst.setInt(2,od.getBook().getBookId());
			pst.setInt(3,od.getCount());
			pst.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			DBConnection.close(pst);
			DBConnection.close(conn);
		}
		return flag;
	}

	// 删除订单明细表
	public boolean deleteOrderDetail(orderDetail od) throws SQLException {
		boolean bool = false;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "delete from order_detail where order_detail_id=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1,od.getOrderDetailId());
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
	public boolean deleteOrderDetailByOrderId(int id) throws SQLException {
		boolean bool = false;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "delete from order_detail where order_id=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1,id);
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

	// 更新订单明细表信息
	public boolean updateOrderDetail(orderDetail od) throws SQLException {
		boolean bool = false;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "update order_detail set order_id=?,book_id=?,count=? where order_detail_id=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1,od.getOrder().getOrderId());
			pre.setInt(2,od.getBook().getBookId());
			pre.setInt(3,od.getCount());
			pre.setInt(4,od.getOrderDetailId());
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

	// 查询订单明细表信息
	public orderDetail selectOrderDetailByOrder_detail_id(orderDetail od) throws SQLException {
		orderDetail odl = null;
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "select * from order_detail where order_detail_id=?";
		ResultSet rs = null;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, od.getOrderDetailId());
			rs = pre.executeQuery();
			while (rs.next()) {
				odl=new orderDetail();
				odl.setOrderDetailId(rs.getInt("order_detail_id"));
				Orders order=new Orders();
				order.setOrderId(rs.getInt("order_id"));
				odl.setOrder(order);
				Book book=new Book();
				book.setBookId(rs.getInt("book_id"));
				odl.setBook(book);
				odl.setCount(rs.getInt("count"));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			DBConnection.close(rs);
			DBConnection.close(pre);
			DBConnection.close(conn);
		}
		return odl;

	}
	//根据书的id查询所有的订单
	public List<orderDetail> selectOrderDetailByBook_id(orderDetail od) throws SQLException {
		
		List<orderDetail> list=new ArrayList<orderDetail>();
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "select * from order_detail where book_id=?";
		ResultSet rs = null;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1,od.getBook().getBookId());
			rs = pre.executeQuery();
			while (rs.next()) {
				orderDetail odl = new orderDetail();
				odl.setOrderDetailId(rs.getInt("order_detail_id"));
				Orders order=new Orders();
				order.setOrderId(rs.getInt("order_id"));
				odl.setOrder(order);
				Book book=new Book();
				book.setBookId(rs.getInt("book_id"));
				odl.setBook(book);
				
				odl.setCount(rs.getInt("count"));
				list.add(odl);
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
	//查询所有订单明细表
public List<orderDetail> selectAllOrderDetail() throws SQLException {
		
		List<orderDetail> list=new ArrayList<orderDetail>();
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "select * from order_detail";
		ResultSet rs = null;
		try {
			pre = conn.prepareStatement(sql);
			
			rs = pre.executeQuery();
			while (rs.next()) {
				orderDetail odl = new orderDetail();
				odl.setOrderDetailId(rs.getInt("order_detail_id"));
				Orders order=new Orders();
				order.setOrderId(rs.getInt("order_id"));
				odl.setOrder(order);
				Book book=new Book();
				book.setBookId(rs.getInt("book_id"));
				odl.setBook(book);
				odl.setCount(rs.getInt("count"));
				list.add(odl);
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
	//根据订单id查询订单详情表
	public List<orderDetail> selectOrderDetailByOrder_id(int id) throws SQLException {
		
		List<orderDetail> list=new ArrayList<orderDetail>();
		PreparedStatement pre = null;
		Connection conn = DBConnection.getConnection();
		String sql = "select * from order_detail where order_id=?";
		ResultSet rs = null;
		BookDao bookDao=new BookDao();
		ordersDao orderDao=new ordersDao();
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1,id);
			rs = pre.executeQuery();
			while (rs.next()) {
				orderDetail odl = new orderDetail();
				odl.setOrderDetailId(rs.getInt("order_detail_id"));
				Orders order=new Orders();
				order.setOrderId(rs.getInt("order_id"));
				order=orderDao.selectOrderByOrderId(order);
				odl.setOrder(order);
				Book book=new Book();
				//book.setBookId(rs.getInt("book_id"));
				book=bookDao.selectBookByBookId(rs.getInt("book_id"));
				odl.setBook(book);
				
				odl.setCount(rs.getInt("count"));
				list.add(odl);
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
