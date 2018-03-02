package com.liang.smis.page;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

//分页的结果对象
@Getter
public class PageResult {
	private List<?> listData;

	// 总条数
	private Integer totalCount;
	// 当前页
	private Integer currentPage;
	// 总页数
	private Integer totalPage;
	// 上一页
	private Integer prePage;
	// 下一页
	private Integer nextPage;
	// 页面大小
	private Integer pageSize;
	// 首页
	private Integer beginPage = 1;
	
	private Integer beginIndex;
	
	private Integer endIndex;
	
	private List<Integer> pageItems = Arrays.asList(3,5,10);

	public PageResult(List<?> listData, Integer totalCount, Integer currentPage, Integer pageSize) {
		this.listData = listData;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		// 计算的数据
		this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize
				: this.totalCount / this.pageSize + 1;
		
		
		this.prePage = this.currentPage - 1 >= 1 ? this.currentPage - 1 : 1;
		this.nextPage = this.currentPage + 1 <= this.totalPage ? this.currentPage + 1 : this.totalPage;
		
		// 索引
		PageIndex pageIndex = PageIndex.getPageIndex(3, currentPage, this.totalPage);
		this.beginIndex = pageIndex.getBeginIndex();
		this.endIndex = pageIndex.getEndIndex();
		
		System.out.println("==========================================be");
		System.out.println(this.beginIndex);
		System.out.println("==========================================end");
		System.out.println(this.endIndex);
	}

}
