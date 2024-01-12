package com.tung2.output;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tung2.dto.Dstory;

public class outpage {

	private int page; // trang hiện tại
	private int totalPage; // số trang
	private List<Dstory> ds=new ArrayList<>();
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Dstory> getDs() {
		return ds;
	}
	public void setDs(List<Dstory> ds) {
		this.ds = ds;
	}

	
}
