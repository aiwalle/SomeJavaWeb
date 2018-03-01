package com.liang.smis.query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.liang.smis.domin.Product;

import lombok.Data;


// 封装了商品对象的查询参数
@Data
public class ProductDirQueryObject extends QueryObject {
	private String name;
	
	private Long parentid = -1L;
	
	public void customizedQuery() {
		// 商品名称
		if (StringUtils.isNotBlank(name)) {
			super.addQuery("dirname LIKE ?", "%" + name + "%");
		}
		if (parentid != -1L) {
			super.addQuery("parentid = ?", parentid);
		}
	}
	
}
