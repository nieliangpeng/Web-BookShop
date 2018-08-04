package service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.BookType;
import dao.bookTypeDao;

/**
 * Servlet implementation class BookClassActionServlet
 */
@WebServlet("/BookClassActionServlet")
public class BookClassActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookClassActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String result = null;
		String action = request.getParameter("action");
		try {
			if ("select".equals(action)) {
				result = selectProductClass(request, response);
			}else if("delete".equals(action)){
				result = deleteProductClass(request, response);
			}else if("gotoModify".equals(action)){
				result = gotoModifyProductClass(request, response);
			}else if("modify".equals(action)){
				System.out.print("modify");
				result = modifyProductClass(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher(result).forward(request, response);
	}
	private String modifyProductClass(HttpServletRequest request,HttpServletResponse response) throws SQLException, UnsupportedEncodingException{		
		if(request.getParameter("update")!=null) {
			String productclassid = request.getParameter("id");
			System.out.print(productclassid);
			int id = Integer.parseInt(productclassid);
			String productclassname = request.getParameter("type");
			System.out.print(productclassname);
			BookType productClass = new BookType();
			productClass.setTypeId(id);
			productClass.setTypeName(productclassname);
			boolean bool=new bookTypeDao().updateBookType(productClass);
			if(bool) {
				request.setAttribute("msg", "更新成功");
				System.out.print("ok");
				return "admin/updateClass.jsp";
			}else {
				request.setAttribute("msg", "更新失败");
				return "admin/updateClass.jsp";
			}
		}else {
			String productclassname = request.getParameter("type");
			BookType bt=new BookType();
			bt.setTypeName(productclassname);;
			boolean bool=new bookTypeDao().addBookType(bt);
			if(bool) {
				request.setAttribute("msg", "插入成功");
				System.out.print("ok");
				return "admin/updateClass.jsp";
			}else {
				request.setAttribute("msg", "插入失败");
				return "admin/updateClass.jsp";
			}
		}
		
		
	}
	//修改
	private String gotoModifyProductClass(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		int id = (int)Integer.parseInt(request.getParameter("id"));
		BookType bt = new bookTypeDao().selectBookType(id);
		request.setAttribute("msg","修改");
		request.setAttribute("bookType", bt);
		return "/admin/admin_classModif.jsp";
	}
	//删除
	private String deleteProductClass(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		String productclassid = request.getParameter("id");
		int id = Integer.parseInt(productclassid);
		BookType bookType = new BookType();
		bookType.setTypeId(id);
		
		bookTypeDao bookTypeDao = new bookTypeDao();
		boolean result = bookTypeDao.deleteBookType(bookType);
		
		if (result) {
			return "BookClassActionServlet?action=select";
		} else {
			return "admin/deleteFailed.jsp";
		}
	}
	//查询
	private String selectProductClass(HttpServletRequest request,HttpServletResponse response) throws SQLException {

		bookTypeDao productClassDao = new bookTypeDao();
		List<BookType> productlist = productClassDao.selectAllBookType();
		request.setAttribute("productclasslist", productlist);
		return "admin/admin_ClassList.jsp";
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
