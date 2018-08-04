package bean;

import java.util.ArrayList;



public class shoppingCartList extends ArrayList<CartBookBean>  {
	public boolean add(CartBookBean cartBookBean) {
		super.add(cartBookBean);
		return true;
	}

	public CartBookBean remove(int index) {
		super.remove(index);
		return super.get(index);
	}

	public CartBookBean get(int index) {
		return super.get(index);
	}

	public int size() {
		return super.size();
	}
	//看购物车中是否已经有该商品的存在
	public boolean equals(CartBookBean bean) {
		for (int i = 0; i < this.size(); i++) {
			//存在，直接加数量
			if (this.get(i).getProduct().getBookId() == bean.getProduct().getBookId()) {
				this.get(i).setCount(this.get(i).getCount() +bean.getCount() );
				// System.out.println(i);
				return true;
			}
		}
		return false;
	}
	public void update(CartBookBean bean) {
		for (int i = 0; i < this.size(); i++) {
			//存在，直接加数量
			if (this.get(i).getProduct().getBookId() == bean.getProduct().getBookId()) {
				this.get(i).setCount(bean.getCount() );
				// System.out.println(i);
				
			}
		}
		
	}
	//书的id
	public void delete(int id) {
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).getProduct().getBookId() == id) {
				super.remove(i);
			}
		}
	}
	//购物车中的所有的总额
	public double getTotalCost() {
		double totalCost = 0;
		for (int i = 0; i < this.size(); i++) {
			totalCost = totalCost + this.get(i).getTotalCost();
		}
		return totalCost;
	}
}
