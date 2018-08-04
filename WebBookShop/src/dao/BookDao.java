package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import bean.Book;
import bean.BookType;
import common.Page;
import common.indexPage;



public class BookDao {
			//分页操作sql
			public List<Book> getSomeBook(indexPage page) throws SQLException{
				List<Book> bookList=new ArrayList<Book>();
				Connection conn=DBConnection.getConnection();
				PreparedStatement pst=null;
				ResultSet rs=null;
				String sql="select * from book limit ?,?";
				int begin=1;
				int end=1;
				if(page.getPage_count()==1) {
					begin=1;
					end=page.getColumn_count();
				}else if(page.isLast_page()) {
					begin=(page.getCurrent_page()-1)*page.getColumn_page()+1;
					end=page.getColumn_count();
				}else {
					begin=(page.getCurrent_page()-1)*page.getColumn_page()+1;
					end=begin+page.getColumn_page()-1;
				}
				pst=conn.prepareStatement(sql);
				pst.setInt(1, begin-1);
				pst.setInt(2, end-begin+1);//长度
				rs=pst.executeQuery();
				while(rs.next()) {
					Book b=new Book();
					b.setBookId(rs.getInt("book_id"));
					b.setBookName(rs.getString("book_name"));
					b.setBookAuthor(rs.getString("book_author"));
					b.setBookPublisher(rs.getString("book_publisher"));
					b.setBookPrice(rs.getDouble("book_price"));
					String desc = rs.getString("book_description");
					if (desc == null)
						b.setBookDescription("");
					if (desc.length() > 40) {
						b.setBookDescription(desc.substring(0, 40) + "....");
					} else {
						b.setBookDescription(desc);
					}
					//b.setBookDescription(rs.getString("book_description"));
					b.setBookImgurl(rs.getString("book_imgurl"));
					BookType BT=new BookType();
					BT=(new bookTypeDao()).selectBookType(rs.getInt("type_id"));
					b.setBookType(BT);
					bookList.add(b);
				}
				DBConnection.close(rs);
				DBConnection.close(pst);
				DBConnection.close(conn);
				return bookList;
			}
			
			public int getCount() throws SQLException {
				int count = 0;
				Connection conn = DBConnection.getConnection();
				PreparedStatement pst = null;
				ResultSet rs = null;
				String sql = "select count(*) c from book";
				try {
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					if(rs.next()) {
						count = rs.getInt("c");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBConnection.close(rs);
					DBConnection.close(pst);
					DBConnection.close(conn);
				}
				return count;
			}
			public int getCountById(int id) throws SQLException {
				int count = 0;
				Connection conn = DBConnection.getConnection();
				PreparedStatement pst = null;
				ResultSet rs = null;
				String sql = "select count(*) c from book where type_id=?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, id);
					rs = pst.executeQuery();
					if(rs.next()) {
						count = rs.getInt("c");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DBConnection.close(rs);
					DBConnection.close(pst);
					DBConnection.close(conn);
				}
				return count;
			}
			//增加书
			public boolean addBook(Book book) throws SQLException {
				boolean flag = false;
				Connection conn = DBConnection.getConnection();
				PreparedStatement pst = null;
				ResultSet rs = null;
				String sql = "insert into book(book_name,book_author,book_publisher,book_price,book_description,type_id) values(?,?,?,?,?,?)";
				try {
						pst = conn.prepareStatement(sql);
						pst.setString(1,book.getBookName());
						pst.setString(2,book.getBookAuthor());
						pst.setString(3,book.getBookPublisher());
						pst.setDouble(4,book.getBookPrice());
						pst.setString(5,book.getBookDescription());
						
						pst.setInt(6,book.getBookType().getTypeId());
						pst.execute();
						flag=true;
					}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}finally {
					DBConnection.close(rs);
					DBConnection.close(pst);
					DBConnection.close(conn);
				}
				return flag;
			}
			//删除书
			public boolean deleteBook(int id) throws SQLException {
				boolean bool=false;
				PreparedStatement pre = null;
				Connection conn = DBConnection.getConnection();
				String sql="delete from book where book_id=?";
				try {
					pre=conn.prepareStatement(sql);
					pre.setInt(1,id);
					pre.execute();
					bool=true;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}finally {
					
					DBConnection.close(pre);
					DBConnection.close(conn);
				}
				return bool;
				
			}
			//更新书的信息
			public boolean updateBook(Book book) throws SQLException {
				boolean bool=false;
				PreparedStatement pre = null;
				Connection conn = DBConnection.getConnection();
				String sql="update book set book_name=?, book_author=?,book_publisher=?,book_price=?,book_description=?,type_id=? where book_id=?";
				try {
					pre=conn.prepareStatement(sql);
					pre.setString(1,book.getBookName());
					pre.setString(2,book.getBookAuthor());
					pre.setString(3,book.getBookPublisher());
					pre.setDouble(4,book.getBookPrice());
					pre.setString(5,book.getBookDescription());
					
					pre.setInt(6,book.getBookType().getTypeId());
					pre.setInt(7, book.getBookId());
					pre.execute();
					bool=true;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}finally {
					
					DBConnection.close(pre);
					DBConnection.close(conn);
				}
				return bool;
				
			}
			//根据书的ID查询
			public Book selectBookByBookId(int bookid) throws SQLException {
				Book b=null;
				PreparedStatement pre = null;
				Connection conn = DBConnection.getConnection();
				String sql="select * from book where book_id=?";
				ResultSet rs=null;
				try {
					pre=conn.prepareStatement(sql);
					pre.setInt(1,bookid);
					rs=pre.executeQuery();
					while(rs.next()) {
						b=new Book();
						b.setBookId(rs.getInt("book_id"));
						b.setBookName(rs.getString("book_name"));
						b.setBookAuthor(rs.getString("book_author"));
						b.setBookPublisher(rs.getString("book_publisher"));
						b.setBookPrice(rs.getDouble("book_price"));
						b.setBookDescription(rs.getString("book_description"));
						b.setBookImgurl(rs.getString("book_imgurl"));
						BookType BT=new BookType();
						
						BT=new bookTypeDao().selectBookType(rs.getInt("type_id"));
						b.setBookType(BT);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}finally {
					DBConnection.close(rs);
					DBConnection.close(pre);
					DBConnection.close(conn);
				}
				return b;
				
			}
			
			//通过类别查询
			public List<Book> selectBookByTypeId(int id,indexPage page) throws SQLException {
				List<Book> bookList=new ArrayList<Book>();
				Connection conn=DBConnection.getConnection();
				PreparedStatement pst=null;
				ResultSet rs=null;
				String sql="select * from book where type_id=? limit ?,? ";
				int begin=1;
				int end=1;
				if(page.getPage_count()==1) {
					begin=1;
					end=page.getColumn_count();
				}else if(page.isLast_page()) {
					begin=(page.getCurrent_page()-1)*page.getColumn_page()+1;
					end=page.getColumn_count();
				}else {
					begin=(page.getCurrent_page()-1)*page.getColumn_page()+1;
					end=begin+page.getColumn_page()-1;
				}
				pst=conn.prepareStatement(sql);
				pst.setInt(1, id);
				pst.setInt(2, begin-1);
				pst.setInt(3, end-begin+1);//长度
				
				rs=pst.executeQuery();
				while(rs.next()) {
					Book b=new Book();
					b.setBookId(rs.getInt("book_id"));
					b.setBookName(rs.getString("book_name"));
					b.setBookAuthor(rs.getString("book_author"));
					b.setBookPublisher(rs.getString("book_publisher"));
					b.setBookPrice(rs.getDouble("book_price"));
					String desc = rs.getString("book_description");
					if (desc == null)
						b.setBookDescription("");
					if (desc.length() > 40) {
						b.setBookDescription(desc.substring(0, 40) + "....");
					} else {
						b.setBookDescription(desc);
					}
					//b.setBookDescription(rs.getString("book_description"));
					b.setBookImgurl(rs.getString("book_imgurl"));
					BookType BT=new BookType();
					BT=(new bookTypeDao()).selectBookType(rs.getInt("type_id"));
					b.setBookType(BT);
					bookList.add(b);
				}
				DBConnection.close(rs);
				DBConnection.close(pst);
				DBConnection.close(conn);
				return bookList;
				
			}
			//查询所有的书
			public List<Book> selectAllBook() throws SQLException {
				List<Book> bookList=new ArrayList<Book>();
				PreparedStatement pre = null;
				Connection conn = DBConnection.getConnection();
				String sql="select * from book";
				ResultSet rs=null;
				try {
					pre=conn.prepareStatement(sql);
					rs=pre.executeQuery();
					while(rs.next()) {
						Book b=new Book();
						b.setBookId(rs.getInt("book_id"));
						b.setBookName(rs.getString("book_name"));
						b.setBookAuthor(rs.getString("book_author"));
						b.setBookPublisher(rs.getString("book_publisher"));
						b.setBookPrice(rs.getDouble("book_price"));
						String desc = rs.getString("book_description");
						if (desc == null)
							b.setBookDescription("");
						if (desc.length() > 10) {
							b.setBookDescription(desc.substring(0, 10) + "....");
						} else {
							b.setBookDescription(desc);
						}
						//b.setBookDescription(rs.getString("book_description"));
						b.setBookImgurl(rs.getString("book_imgurl"));
						BookType BT=new BookType();
						BT=(new bookTypeDao()).selectBookType(rs.getInt("type_id"));
						b.setBookType(BT);
						bookList.add(b);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}finally {
					DBConnection.close(rs);
					DBConnection.close(pre);
					DBConnection.close(conn);
				}
				return bookList;
				
			}
			//通过书名查询
			public List<Book> selectBookByBookName(Book book) throws SQLException {
				List<Book> bookList=new ArrayList<Book>();
				PreparedStatement pre = null;
				Connection conn = DBConnection.getConnection();
				String sql="select * from book where book_name=?";
				ResultSet rs=null;
				try {
					pre=conn.prepareStatement(sql);
					pre.setString(1,book.getBookName());
					rs=pre.executeQuery();
					while(rs.next()) {
						Book b=new Book();
						b.setBookId(rs.getInt("book_id"));
						b.setBookName(rs.getString("book_name"));
						b.setBookAuthor(rs.getString("book_author"));
						b.setBookPublisher(rs.getString("book_publisher"));
						b.setBookPrice(rs.getDouble("book_price"));
						b.setBookDescription(rs.getString("book_description"));
						b.setBookImgurl(rs.getString("book_imgurl"));
						BookType BT=new BookType();
						BT.setTypeId(rs.getInt("type_id"));
						b.setBookType(BT);
						bookList.add(b);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}finally {
					DBConnection.close(rs);
					DBConnection.close(pre);
					DBConnection.close(conn);
				}
				return bookList;
				
			}
			//更新图片
			public boolean updateImage(int id, String imgurl) throws SQLException {
				Connection conn = DBConnection.getConnection();
				String sql = "update book SET book_imgurl=? WHERE book_id=?";
				PreparedStatement prep = null;
				try {
					prep = conn.prepareStatement(sql);
					prep.setString(1, imgurl);
					prep.setInt(2, id);
					prep.executeUpdate();
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DBConnection.close(prep);
					DBConnection.close(conn);
				}
				return false;
			}	
			public static void main(String[] args) throws SQLException {
				BookDao dao=new BookDao();
				for(int i=1;i<=100;i++) {
					Book book=new Book();
					book.setBookName("书名"+i);
					book.setBookAuthor("作者"+i);
					book.setBookPublisher("出版社"+i);
					book.setBookPrice(i);
					book.setBookDescription("描述"+i);
					book.setBookImgurl("");
					BookType type=new BookType();
					type.setTypeId(1);
					book.setBookType(type);
					dao.addBook(book);
				}
			}
			
}
