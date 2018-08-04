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
import javax.servlet.http.HttpSession;

import bean.Book;
import common.indexPage;
import dao.BookDao;



/**
 * Servlet implementation class bookFactoryServlet
 */
@WebServlet("/bookFactoryServlet")
public class bookFactoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookFactoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDao dao=new BookDao();
		List<Book> bookList=new ArrayList<Book>();
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		indexPage page=(indexPage) session.getAttribute("page");
		if(page==null) {
			page=new indexPage();
		}
		try {
			if(action.equals("factory")) {
				page.setColumn_count(dao.getCount());

			}else {
				int id=Integer.parseInt(action);
				page.setColumn_count(dao.getCountById(id));
			}
			//System.out.print(page.getMaxCurrent_bottom_page());
			page.setCurrent_page(1);
			String current_page = request.getParameter("current_page");
			if(current_page!=null) {
				page.setCurrent_page(Integer.parseInt(current_page));
			}
			if(action.equals("factory")) {
				bookList=dao.getSomeBook(page);
			}else {
				int id=Integer.parseInt(action);
				bookList=dao.selectBookByTypeId(id,page);
			}
			
			session.setAttribute("bookList", bookList);
			session.setAttribute("page", page);
			session.setAttribute("a", action);
			request.getRequestDispatcher("user/bookFactory.jsp").forward(request, response);
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
