package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.BookType;
import dao.adminDao;
import dao.bookTypeDao;

/**
 * Servlet implementation class adminActionServlet
 */
@WebServlet("/adminActionServlet")
public class adminActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminActionServlet() {
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
			if ("changePass".equals(action)) {
				result = changePassword(request, response);
			}else if("add".equals(action)) {
				result = addAdmin(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher(result).forward(request, response);
	}
	//添加管理员
	private String  addAdmin(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String realname=request.getParameter("realname");
		Admin admin=new Admin();
		admin.setAdminUserName(username);
		admin.setAdminPasswd(password);
		admin.setAdminRealName(realname);
		boolean bool=new adminDao().addAdmin(admin);
		if(bool) {
			request.setAttribute("msg","添加管理员成功");
			return "admin/addAdmin.jsp";
		}else {
			request.setAttribute("msg", "添加管理员失败");
			return "admin/addAdmin.jsp";
		}
	}
    //修改密码
	private String  changePassword(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		String msg = new String("");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String re_newpassword = request.getParameter("re_newpassword");
		Admin admin = (Admin) request.getSession().getAttribute("adminUser");
		if (admin.getAdminPasswd().equals(oldpassword)) {
			if (!newpassword.equals(re_newpassword)) {
				msg = "<script>alert('密码不一致');</script>";
				request.setAttribute("errorMessage", msg);
				return "/admin/admin_changePassword.jsp";
			}else {
				
				Admin ad=new Admin();
				ad.setAdminId(admin.getAdminId());
				ad.setAdminPasswd(newpassword);
				boolean bool=new adminDao().updateAdminPassword(ad);
				if(bool==true) {
					 admin.setAdminPasswd(newpassword);
					 request.getSession().setAttribute("adminUser", admin);
					 msg = "<script>alert('密码修改成功，下次记得用新密码登录');</script>";
					 request.setAttribute("Message", msg);
					 return "/admin/main_right.jsp";
				}else {
					msg = "<script>alert('修改密码失败，重新修改');</script>";
					request.setAttribute("errorMessage", msg);
					return "/admin/admin_changePassword.jsp";
				}
				
			}
		} else {
			msg = "<script>alert('旧密码有错！');</script>";
			request.setAttribute("errorMessage", msg);
			return "/admin/admin_changePassword.jsp";
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
