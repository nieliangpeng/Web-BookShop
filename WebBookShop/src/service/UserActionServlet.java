package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.Users;
import dao.usersDao;

/**
 * Servlet implementation class UserActionServlet
 */
@WebServlet("/UserActionServlet")
public class UserActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserActionServlet() {
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
				if ("list".equals(action)) {
					result = doList(request, response);
				}else if("delete".equals(action)) {
					result = deleteUser(request, response);
				}else if("initPwd".equals(action)) {
					result = initPwd(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		request.getRequestDispatcher(result).forward(request, response);
	}
	//初始化密码
	private String initPwd(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		String UserId=request.getParameter("id");
		int id=Integer.parseInt(UserId);
		Users user=new Users();
		user.setUserId(id);
		boolean bool=new usersDao().initUserPassword(user);
		if(bool) {
			List<Users> userlist = new usersDao().selectAllUser();
			request.setAttribute("userList", userlist);
			request.setAttribute("msg","初始化密码成功");
			return "admin/admin_userlist.jsp";
		}else {
			List<Users> userlist = new usersDao().selectAllUser();
			request.setAttribute("userList", userlist);
			request.setAttribute("msg","初始化密码失败");
			return "admin/admin_userlist.jsp";
		}
		
	}
	//查看用户
	private String doList(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		List<Users> userlist = new usersDao().selectAllUser();
		request.setAttribute("userList", userlist);
		return "/admin/admin_userlist.jsp";
	}
	//删除
	private String deleteUser(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		String UserId=request.getParameter("id");
		int id=Integer.parseInt(UserId);
		Users user=new Users();
		user.setUserId(id);
		boolean bool=new usersDao().deleteUser(user);
		if(bool) {
			List<Users> userlist = new usersDao().selectAllUser();
			request.setAttribute("userList", userlist);
			request.setAttribute("msg","删除成功");
			return "admin/admin_userlist.jsp";
		}else {
			List<Users> userlist = new usersDao().selectAllUser();
			request.setAttribute("userList", userlist);
			request.setAttribute("msg","删除失败");
			return "admin/admin_userlist.jsp";
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
