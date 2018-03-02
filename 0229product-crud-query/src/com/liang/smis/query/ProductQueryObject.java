package com.liang.smis.query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.liang.smis.domin.Product;

import lombok.Data;


// 封装了商品对象的查询参数
@Data
public class ProductQueryObject extends QueryObject {
	private String name;
	private BigDecimal minSalePrice;
	private BigDecimal maxSalePrice;
	private Long dir_id = -1L;
	private String keyword;
	
//	private Integer currentPage;
//	private Integer pageSize;
	
	public void customizedQuery() {
		// 商品名称
		if (StringUtils.isNotBlank(name)) {
			super.addQuery("productName LIKE ?", "%" + name + "%");
		}
		// 最低价格
		if (minSalePrice != null) {
			super.addQuery("salePrice >= ?", minSalePrice);
		}
		// 最高价格
		if (maxSalePrice != null) {
			super.addQuery("salePrice <= ?", maxSalePrice);
		}
		
		if (dir_id != -1L) {
			super.addQuery("dir_id = ?", dir_id);
		}
		
		if (StringUtils.isNotBlank(keyword)) {
			super.addQuery("(productName LIKE ? OR brand LIKE ?)", "%" + keyword + "%", "%" + keyword + "%");
		}
		
	}
	
}
