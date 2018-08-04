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

import bean.Users;
import dao.usersDao;

/**
 * Servlet implementation class checkUserLogin
 */
@WebServlet("/checkUserLogin")
public class checkUserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkUserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=request.getContextPath();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String autoLogin=request.getParameter("autoLogin");
		usersDao dao=new usersDao();
		Users u=new Users();
		u.setUserEmail(email);
		u.setUserPasswd(password);
		try {
			Users user=dao.login(u);
			if(user!=null) {
				//成功
				
			    HttpSession session=request.getSession();
			    if(session.getAttribute("rand").equals(request.getParameter("verf"))) {
			    	session.setAttribute("user", user);
			    	if(autoLogin != null && autoLogin.equals("on")) {
						
						session.setMaxInactiveInterval(60*60*24*7);//秒
						
						Cookie cookie=new Cookie("JSESSIONID", session.getId());
						cookie.setMaxAge(60*60*24*7);
						response.addCookie(cookie);//更新
					}
				    response.sendRedirect("user/login.jsp");
			    }else {
			    	request.setAttribute("msg", "验证码不正确，请重新输入");
			    	request.getRequestDispatcher("user/login.jsp").forward(request, response);
			    }
			    
			}else {
				//失败
				request.setAttribute("msg", "邮箱或密码不正确");
				request.getRequestDispatcher("user/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
