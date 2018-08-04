package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Orders;
import bean.Users;
import bean.orderDetail;
import bean.shoppingCartList;
import dao.orderDetailDao;
import dao.ordersDao;

/**
 * Servlet implementation class OrderActionServlet
 */
@WebServlet("/OrderActionServlet")
public class OrderActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String result=null;

		try {
			if(action.equals("listHasConf")) {
				result =  ordersList(request, response,"已支付");
			}else if(action.equals("listUnConf")) {
				result= ordersList(request, response,"未支付");
			}else if(action.equals("listComplete")) {
				result= ordersList(request, response,"已完成");
			}else if(action.equals("listAll")) {
				result= ordersList(request, response,null);
			}else if (action.equals("detailed")) {
				result = detailedOrder(request, response);
			}else if (action.equals("delete")) {
				result = deleteOrder(request, response);
			}else if ("endTheOrder".equals(action)) {
				result = endTheOrder(request, response);
			}else if("addOrder".equals(action)) {
				result = addOrder(request, response);
			}else if("getMoney".equals(action)) {
				result=getMoney(request, response);
			}else if("myOrders".equals(action)) {
				result=myOrders(request, response);
			}else if("Mydetailed".equals(action)) {
				result=Mydetailed(request, response);
			}else if("Userdelete".equals(action)) {
				result=Userdelete(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher(result).forward(request, response);
		
	}
	private String Userdelete(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		int orderid = (int) Integer.parseInt(request.getParameter("id"));
		ordersDao orderDao = new ordersDao();
		orderDao.deleteOrders(orderid);
		return "OrderActionServlet?action=myOrders";
	}
	private String Mydetailed(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		int orderid = (int) Integer.parseInt(request.getParameter("id"));
		orderDetailDao dao=new orderDetailDao();
		List<orderDetail> orderDetailList=dao.selectOrderDetailByOrder_id(orderid);
		request.setAttribute("orderDetailList", orderDetailList);
		request.setAttribute("order", orderDetailList.get(0).getOrder());
		request.setAttribute("totalMoney",orderDetail.caculMoney(orderDetailList));
		return "user/MyOrderDetail.jsp";
	}
	//我的订单
	private String myOrders(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("user");
		List<Orders> MyorderList=new ordersDao().selectOrderByUserId(user.getUserId());
		if(MyorderList.size()!=0) {
			session.setAttribute("MyorderList", MyorderList);
		}else {
			session.setAttribute("MyorderList", null);
		}
		
		return "user/MyAllOrders.jsp";
	}
	//付款
	private String getMoney(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		int orderid = (int) Integer.parseInt(request.getParameter("orderid"));
		ordersDao orderDao = new ordersDao();
		boolean bool=orderDao.getMoneyById(orderid);
		if(bool) {
			return "OrderActionServlet?action=myOrders";
		}else {
			request.setAttribute("msg", "付款失败");
			return "user/MyOrders.jsp";
		}
	}
	//生成订单
	private String addOrder(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		HttpSession session=request.getSession();
		shoppingCartList productCart = (shoppingCartList) session.getAttribute("productCart");
		Users user=(Users) session.getAttribute("user");
		
		ordersDao dao=new ordersDao();
		Orders order=new Orders();
		order.setUser(user);
		int orderId=dao.addOrders(order);
		orderDetailDao odDao=new orderDetailDao();
		boolean bool=odDao.addOrderDetailByshopCart(productCart, orderId);
		if(bool==true) {
			double totalMoney=productCart.getTotalCost();
			session.removeAttribute("productCart");
			
			List<orderDetail> orderDetailList=odDao.selectOrderDetailByOrder_id(orderId);
			Orders or= new Orders();
			or.setOrderId(orderId);
			or=dao.selectOrderByOrderId(or);
			session.setAttribute("orderDetailList", orderDetailList);
			session.setAttribute("order", or);
			session.setAttribute("totalMoney", totalMoney);
			return "user/MyOrders.jsp";
		}else {
			return "user/ShopCart.jsp";
		}
		
	}
	//发货
	private String endTheOrder(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		int orderid = (int) Integer.parseInt(request.getParameter("id"));
		ordersDao orderDao = new ordersDao();
		orderDao.endTheOrderById(orderid);
		request.setAttribute("orderId", orderid);
		return "admin/putProduce.jsp";
	}
	//删除
	private String deleteOrder(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		int orderid = (int) Integer.parseInt(request.getParameter("id"));
		ordersDao orderDao = new ordersDao();
		orderDao.deleteOrders(orderid);
		return "admin/deleteSuccess.html";
	}
	//详情
	private String detailedOrder(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		int orderid = (int) Integer.parseInt(request.getParameter("id"));
		orderDetailDao dao=new orderDetailDao();
		List<orderDetail> orderDetailList=dao.selectOrderDetailByOrder_id(orderid);
		request.setAttribute("orderDetailList", orderDetailList);
		request.setAttribute("order", orderDetailList.get(0).getOrder());
		request.setAttribute("totalMoney",orderDetail.caculMoney(orderDetailList));
		return "admin/admin_orderDetail.jsp";
	}
	//查询订单
	private String ordersList(HttpServletRequest request,HttpServletResponse response,String state) throws SQLException {
		// TODO Auto-generated method stub
		if(state!=null) {
			
			ordersDao orderDao = new ordersDao();
			List<Orders> orderList = orderDao.listProductOrderByState(state);
			request.setAttribute("orderList", orderList);
			return "admin/admin_OrderList.jsp";
		}else {
			ordersDao orderDao = new ordersDao();
			List<Orders> orderList = orderDao.selectAllOrder();
			request.setAttribute("orderList", orderList);
			return "admin/admin_OrderList.jsp";
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
