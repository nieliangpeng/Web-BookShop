package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Book;
import bean.CartBookBean;
import bean.shoppingCartList;
import dao.BookDao;


/**
 * Servlet implementation class shopCartActionServlet
 */
@WebServlet("/shopCartActionServlet")
public class shopCartActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shopCartActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String result = null;
		
			try {
				if ("view".equals(action)) {
					result = ViewProductCart(request, response);
				} else if ("addProduct".equals(action)) {
					result = putProductInCart(request, response);
				}else if("updateCount".equals(action)) {
					result = updateCount(request, response);
				}else if("delete".equals(action)) {
					result = delete(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		request.getRequestDispatcher(result).forward(request, response);
	}
	//删除
	public String delete(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		shoppingCartList list=null ;
		HttpSession session = request.getSession();
		list =(shoppingCartList) session.getAttribute("productCart");
		list.delete(id);
		return "/shopCartActionServlet?action=view";
	}
	//修改数量
	public String updateCount(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		String BookCount=request.getParameter("count");
		int count=Integer.parseInt(BookCount);//几本
		
		BookDao bookDao = new BookDao();
		Book book = bookDao.selectBookByBookId(id);//书
		CartBookBean bean = new CartBookBean();
		shoppingCartList list=null ;
		HttpSession session = request.getSession();
		list =(shoppingCartList) session.getAttribute("productCart");
		bean.setProduct(book);
		bean.setCount(count);
		list.update(bean);
		session.setAttribute("productCart", list);
		return "/shopCartActionServlet?action=view";
	}
	//加入购物车
	public String putProductInCart(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		String BookCount=request.getParameter("BookCount");
		int count=Integer.parseInt(BookCount);//几本
		
		BookDao bookDao = new BookDao();
		Book book = bookDao.selectBookByBookId(id);//书
		CartBookBean bean = new CartBookBean();
		shoppingCartList list=null ;
		HttpSession session = request.getSession();
		list =(shoppingCartList) session.getAttribute("productCart");
		if(list==null) {
			//第一次,不存在重复
			list=new shoppingCartList();
			bean.setProduct(book);
			bean.setCount(count);
			list.add(bean);
			session.setAttribute("productCart", list);
			
		}else {
			//已经有session对象
			bean.setProduct(book);
			bean.setCount(count);
			if(list.equals(bean)) {
				session.setAttribute("productCart", list);
			}else {
				//没有
				list.add(bean);
				session.setAttribute("productCart", list);
			}
		}
		return "/shopCartActionServlet?action=view";
	}
	//查看购物车
	private String ViewProductCart(HttpServletRequest request,HttpServletResponse response) {
		
		shoppingCartList productCart = (shoppingCartList) (request.getSession()).getAttribute("productCart");
		if (productCart != null) {
			request.setAttribute("totalcost", productCart.getTotalCost());
		}	
		return "/user/ShopCart.jsp";
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
