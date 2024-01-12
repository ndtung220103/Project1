package com.tung2.dto;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dstory {
	
	private Long id;
	private String name;
	private String avt;
	private List<Dchapter> dschuong=new ArrayList<>();
	private Long view;
	private Date modifiedDate;
	private Date Visituserdate;
	
	
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date date) {
		this.modifiedDate = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvt() {
		return avt;
	}
	public void setAvt(String avt) {
		this.avt = avt;
	}
	public List<Dchapter> getDschuong() {
		return dschuong;
	}
	public void setDschuong(List<Dchapter> dschuong) {
		this.dschuong = dschuong;
	}
	public Long getView() {
		return view;
	}
	public void setView(Long view) {
		this.view = view;
	}
	public Date getVisituserdate() {
		return Visituserdate;
	}
	public void setVisituserdate(Date visituserdate) {
		this.Visituserdate = visituserdate;
	}
	
	
}
