package bean;
public class CartBookBean {
	private int count;//商品数量
	private Book product;//哪本书
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Book getProduct() {
		return product;
	}
	public void setProduct(Book product) {
		this.product = product;
	}
	//该商品的金额
	public Double getTotalCost() {
		return  product.getBookPrice()*count;
	}
	
}
