package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Users;
import dao.usersDao;

/**
 * Servlet implementation class addUserToDBServlet
 */
@WebServlet("/addUserToDBServlet")
public class addUserToDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUserToDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=request.getContextPath();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String telephone=request.getParameter("telephone");
		String address=request.getParameter("address");
		Users user=new Users();
		user.setUserName(username);
		user.setUserPasswd(password);
		user.setUserEmail(email);
		user.setUserTelephone(telephone);
		user.setUserAddress(address);
		
		usersDao dao=new usersDao();
		try {
			boolean bool=dao.addUser(user);
			if(bool==true) {
				request.getRequestDispatcher("user/login.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "注册失败");
				request.getRequestDispatcher("user/register.jsp").forward(request, response);
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
