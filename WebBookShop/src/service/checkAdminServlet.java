package service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import dao.adminDao;

/**
 * Servlet implementation class checkAdminServlet
 */
@WebServlet("/checkAdminServlet")
public class checkAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action != null && action.equals("login")) {
			try {
				login(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(action != null && action.equals("logout")) {
			logout(request,response);
		}
	}
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		String autoLogin=request.getParameter("autoLogin");
		String adminName =request.getParameter("username");
		String password = request.getParameter("pwd");
		String verification = request.getParameter("verif");
		HttpSession session = request.getSession();
		String rand = (String)session.getAttribute("rand");
		adminDao dao = new adminDao();
		Admin admin=new Admin();
		admin.setAdminUserName(adminName);
		admin.setAdminPasswd(password);
		Admin ad=dao.login(admin);
		if(ad!=null) {
			//有
			if(!verification.equals(rand)) {
				request.setAttribute("message", "验证码错误");
				request.getRequestDispatcher("admin/login.jsp").forward(request, response);
			}else {
				//管理界面
				session.setAttribute("adminUser", ad);
				if(autoLogin != null && autoLogin.equals("on")) {
					
					session.setMaxInactiveInterval(60*60*24*7);//秒
					
					Cookie cookie=new Cookie("JSESSIONID", session.getId());
					cookie.setMaxAge(60*60*24*7);
					response.addCookie(cookie);//更新
				}
				response.sendRedirect(request.getContextPath()+"/admin/main.jsp");
			}
		}else {
			//没有
			request.setAttribute("message", "用户名或密码错误，请核对");
			request.getRequestDispatcher("admin/login.jsp").forward(request, response);
		}
		

		
		
		
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.removeAttribute("adminUser");
		
		request.getRequestDispatcher("admin/login.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
