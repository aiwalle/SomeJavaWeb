package com.liang.wms.domain;


import com.liang.wms.domain.BaseDomain;

public class Department extends BaseDomain {
	private String name;
	private String sn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String toString() {
		return "Department{" +
				"id=" + id +
				", name='" + name + '\'' +
				", sn='" + sn + '\'' +
				'}';
	}
}
