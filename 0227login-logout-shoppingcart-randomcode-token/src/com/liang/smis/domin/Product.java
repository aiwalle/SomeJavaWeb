package com.liang.smis.domin;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 商品对象
 * @author liang
 *
 */
@Data
public class Product {
	private Long id;
	private String productName;
	private String brand;
	private String supplier;
	private BigDecimal salePrice;
	private BigDecimal costPrice;
	private Double cutoff;
	private Long dir_id;
}
