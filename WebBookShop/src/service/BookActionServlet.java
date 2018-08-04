package service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Book;
import bean.BookType;
import common.Page;
import dao.BookDao;
import dao.bookTypeDao;


/**
 * Servlet implementation class BookActionServlet
 */
@WebServlet("/BookActionServlet")
public class BookActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookActionServlet() {
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
				if ("selectlist".equals(action)) {
					result = adminSelectProduct(request, response);
				}else if ("detailed".equals(action)) {
					result = detailedProduct(request, response);
				}else if ("delete".equals(action)) {
					result = deleteProduct(request, response);
				}else if ("uploadImage".equals(action)) {
					result = uploadImage(request, response);
				}else if ("uploadsubmit".equals(action)) {
					result = uploadSubmit(request, response);
				} else if ("updateSelect".equals(action)) {
					result = updateSelect(request, response);
				} else if ("update".equals(action)) {
					result = updateBook(request, response);
				}else if ("add".equals(action)) {
					result = addProduct(request, response);
				}else if("index_detailed".equals(action)) {
					result = indexDetailed(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		request.getRequestDispatcher(result).forward(request, response);
	}
	//
	private String  indexDetailed(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		String book_id = request.getParameter("id");
		int id = Integer.parseInt(book_id);
		Book book = (new BookDao()).selectBookByBookId(id);
		request.setAttribute("book", book);
		return "/user/detailShow.jsp";
		
	}
	
	//添加书本
	private String addProduct(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		String book_name = request.getParameter("product");
		String book_price = request.getParameter("price");
		String classid = request.getParameter("classid");
		String description = request.getParameter("description");
		String bookAuth = request.getParameter("author");
		String bookPublisher = request.getParameter("publisher");
		Book book = new Book();
		book.setBookName(book_name);
		book.setBookPrice(Double.parseDouble(book_price));
		// book.setBook_imgurl(imgurl);
		book.setBookAuthor(bookAuth);
		book.setBookPublisher(bookPublisher);
		book.setBookDescription(description);
		BookType bookType = new BookType();
		bookType.setTypeId(Integer.parseInt(classid));
		book.setBookType(bookType);
		boolean result = new BookDao().addBook(book);
		if (result) {
			request.setAttribute("book", book);
			return "/admin/addBook.jsp";
		} else {
			return "/admin/admin_addBook.jsp";
		}
	}
	//更新该书的信息
	private String updateBook(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		Book book = new Book();
		String book_id = request.getParameter("id");
		String book_name = request.getParameter("product");
		String book_price = request.getParameter("price");
		String classid = request.getParameter("classid");
		String description = request.getParameter("description");
		String bookAuth = request.getParameter("author");
		String bookPublisher = request.getParameter("publisher");
		book.setBookId(Integer.parseInt(book_id));
		book.setBookName(book_name);
		book.setBookPrice(Double.parseDouble(book_price));
		book.setBookAuthor(bookAuth);
		book.setBookPublisher(bookPublisher);
		book.setBookDescription(description);
		BookType bookType = new BookType();
		bookType.setTypeId(Integer.parseInt(classid));
		book.setBookType(bookType);
		boolean result = new BookDao().updateBook(book);
		if (result) {
			request.setAttribute("msg","更新成功");
			request.setAttribute("bookid", book_id);
			return "admin/update.jsp";
		} else {
			request.setAttribute("msg","更新失败");
			request.setAttribute("bookid", book_id);
			return "admin/update.jsp";
		}
	}
	private String updateSelect(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		String prodid = request.getParameter("id");
		int productid = Integer.parseInt(prodid);
		Book book = new BookDao().selectBookByBookId(productid);
		List<BookType> bookTypeList = new bookTypeDao().selectAllBookType();
		request.setAttribute("book", book);
		request.setAttribute("typeList", bookTypeList);
		return "/admin/admin_updateBook.jsp";
	}
	//上传到项目根目录
	private String uploadSubmit(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		String idString = request.getParameter("id");
		String realPath = this.getServletConfig().getServletContext().getRealPath("/")+"/images/book/";
		File uploadFile = new File(realPath);  
		if (!uploadFile.exists()) {  
			uploadFile.mkdirs();  
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
	
		List<FileItem> fileItems = null;
		
		try {
			fileItems = upload.parseRequest(request);
			
			for(FileItem item : fileItems) {
				if(!item.isFormField()){
					item.write(new File(realPath,idString + ".JPG"));
					BookDao bookDao = new BookDao();
					bookDao.updateImage(Integer.parseInt(idString), "/images/book/"+ idString + ".JPG");
					
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("id", idString);
		return "admin/imageUpload.jsp";
	}
	//上传图片
	private String uploadImage(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		String idString = request.getParameter("id");
		request.setAttribute("id", idString);
		return "/admin/admin_uploadImage.jsp";
	}
	//删除
	private String deleteProduct(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		String Productid = request.getParameter("id");
		int id = Integer.parseInt(Productid);
		BookDao bookDao = new BookDao();
		Book book = bookDao.selectBookByBookId(id);
		File file = new File(this.getServletContext().getRealPath("/")+ book.getBookImgurl());
		file.delete();
		boolean deleresult = bookDao.deleteBook(id);
		if (deleresult) {
			return "admin/deleteSuccess.html";
		} else {
			return "admin/deleteFailed.jsp";
		}

	}
	//详细
	private String detailedProduct(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		String book_id = request.getParameter("id");
		int productid = Integer.parseInt(book_id);
		Book book = (new BookDao()).selectBookByBookId(productid);
		request.setAttribute("book", book);
		return "/admin/admin_detailedBook.jsp";
	}
	//商品列表
	private String adminSelectProduct(HttpServletRequest request,HttpServletResponse response) throws SQLException {
		List<Book> productList = (new BookDao()).selectAllBook();
		int pageNum;//显示当前页
		String pageNumStr = request.getParameter("pageNum");
		if (pageNumStr == null) {
			pageNumStr = "1";
		}
		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (NumberFormatException e) {
			pageNum = 1;
		}
		
		Page pageCount = new Page();// 创建分页对象
		pageCount.setPageSize(15);
		pageCount.setRecordCount(productList.size());
		pageCount.setCount(pageCount.getRecordCount(), pageCount.getPageSize());
		pageCount.setShowPage(pageNum);
		
		request.setAttribute("pageCount", pageCount);
		int showPage = pageCount.getShowPage();
		int pageSize = pageCount.getPageSize();

		int begin, end;
		if (pageCount.getCount()== 1) {
			begin = 1;
			end=pageCount.getRecordCount();
		} else if (pageCount.getIsLast()) {
			begin = (pageCount.getCount() - 1) * pageSize+1;
			end=pageCount.getRecordCount();
		} else {
			begin = (showPage - 1) * pageSize+1;
			end=begin+pageSize-1;
		}
		
		List<Book> subList = new ArrayList<Book>();
		subList = productList.subList(begin-1, end);
		request.setAttribute("productList",subList);
		return "/admin/admin_BookList.jsp";

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
