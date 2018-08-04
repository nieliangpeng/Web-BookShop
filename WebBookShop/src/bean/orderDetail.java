package bean;

import java.util.List;

public class orderDetail {
	private int orderDetailId;
	private Orders order;
	private Book book;
	private int count;

	public orderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public static int caculMoney(List<orderDetail> list) {
		int money=0;
		for(orderDetail ad : list) {
			money+=(ad.getBook().getBookPrice()*ad.getCount());
		}
		return money;
	}
}
