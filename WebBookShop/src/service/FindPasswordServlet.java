package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Users;
import dao.usersDao;

/**
 * Servlet implementation class FindPasswordServlet
 */
@WebServlet("/FindPasswordServlet")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String path=request.getParameter("path");
		usersDao dao=new usersDao();
		try {
			Users user=dao.selectUserByEmail(email);
			if(user!=null) {
				//注册用户中存在某个用户有该邮箱
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.163.com");
				// 发送邮件协议名称  
				props.put("mail.transport.protocol", "smtp");
				// 是否认证  
				props.put("mail.smtp.auth", true);
				//创建java程序端与邮件服务器的会话实例
				Session mailSession = Session.getInstance(props,new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						//授权码
						return new PasswordAuthentication("javamail5678@163.com","javamail5678sqm");
					}
				});
				Message msg = new MimeMessage(mailSession);
				//设置邮件的发件人
				msg.setFrom(new InternetAddress("javamail5678@163.com"));
				//设置邮件的收件人
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
				//设置邮件的标题
				msg.setSubject("找回密码");
				//设置邮件的发送日期
				msg.setSentDate(new Date());
				//设置正文
				MimeBodyPart mbp = new MimeBodyPart();
				String password=user.getUserPasswd();
				path=path+"/login.jsp";
				System.out.print(path);
				mbp.setContent("亲爱的【"+user.getUserName()+"】,你的网上书店的登录密码是"+password+"&nbsp;&nbsp;<a target=\"_blank\" href=\"http://localhost:8080/WebBookShop/user/login.jsp\">登录</a>","text/html;charset=UTF-8");
				MimeMultipart mm = new MimeMultipart();
				mm.addBodyPart(mbp);
				msg.setContent(mm);
				Transport.send(msg);
				response.sendRedirect("user/login.jsp");
					
			}else {
				//邮箱错误
				request.setAttribute("error", "<script>alert(\"邮箱错误,请仔细核对\");</script>");	
				request.getRequestDispatcher("user/FindPassword.jsp").forward(request, response);;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
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
