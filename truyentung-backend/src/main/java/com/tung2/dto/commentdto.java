package com.tung2.dto;

import java.util.Date;

public class commentdto {
	private Long storyid;
	private String content;
	private Date createDate;
	private String nameuser;
	private Long id;
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getNameuser() {
		return nameuser;
	}
	public void setNameuser(String nameuser) {
		this.nameuser = nameuser;
	}
	public Long getStoryid() {
		return storyid;
	}
	public void setStoryid(Long storyid) {
		this.storyid = storyid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
