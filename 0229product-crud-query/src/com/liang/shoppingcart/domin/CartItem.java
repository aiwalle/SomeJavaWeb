package com.liang.shoppingcart.domin;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartItem {
	private String id;
	private String name;
	private BigDecimal price;
	private Integer num;
	
//	public CartItem(String id, String name, BigDecimal price, Integer num) {
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.num = num;
//	}
	
	
}
