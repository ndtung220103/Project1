package com.tung2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="notice")
public class NoticeEntity extends BaseEntity {

	@Column(name="content",columnDefinition="TEXT")
	private String content;
	
	@Column(name="user")
	private Long idUser;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	
}
