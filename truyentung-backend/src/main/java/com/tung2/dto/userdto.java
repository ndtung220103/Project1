package com.tung2.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class userdto {
	private Long id;
	private Date createDate;
	private Date modifiedDate;
	private String sname;
	private String username;
	private String password;
	private String avt;
	private String email;
	private List<Dstory> liststory=new ArrayList<>();
	private List<Dstory> listfollow=new ArrayList<>();// danh sach truyen cua user
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvt() {
		return avt;
	}
	public void setAvt(String avt) {
		this.avt = avt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Dstory> getListstory() {
		return liststory;
	}
	public void setListstory(List<Dstory> liststory) {
		this.liststory = liststory;
	}
	public List<Dstory> getListfollow() {
		return listfollow;
	}
	public void setListfollow(List<Dstory> listfollow) {
		this.listfollow = listfollow;
	}
	
	
}
