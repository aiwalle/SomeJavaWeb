package com.liang.shoppingcart.domin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {
	private List<CartItem> items = new ArrayList<>();
	
	// 将商品加入购物车
	public void save(CartItem item) {
		for (CartItem cartItem : items) {
			if (cartItem.getId().equals(item.getId())) {
				cartItem.setNum(cartItem.getNum() + item.getNum());
				return;
			}
		}
		items.add(item);
	}
	
	public void delete(String id) {
		// 这里不能使用foreach来遍历
		Iterator<CartItem> iterator = items.iterator();
		while (iterator.hasNext()) {
			CartItem item = iterator.next();
			if (item.getId().equals(id)) {
				iterator.remove();
			}
		}
	}
	
	public List<CartItem> getItems() {
		return items;
	}
	
	// 总价格
	public BigDecimal getTotalPrice() {
		BigDecimal totalPrice = BigDecimal.ZERO;
		for (CartItem cartItem : items) {
			totalPrice = totalPrice.add(cartItem.getPrice().multiply(new BigDecimal(cartItem.getNum())));
		}
		return totalPrice;
	}
	
	
}
