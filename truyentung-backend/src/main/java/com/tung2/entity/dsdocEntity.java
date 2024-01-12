package com.tung2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="dsdoc")
@EntityListeners(AuditingEntityListener.class)
public class dsdocEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "idstory")
	private Long idstory;
	

	@Column(name = "iduser")
	private Long iduser;
	
	@CreatedDate
	@Column(name="ngaytruycap")
	private Date visitedDate;


	
	
	public Date getVisitedDate() {
		return visitedDate;
	}


	public void setVisitedDate(Date visitedDate) {
		this.visitedDate = visitedDate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getIdstory() {
		return idstory;
	}


	public void setIdstory(Long idstory) {
		this.idstory = idstory;
	}


	public Long getIduser() {
		return iduser;
	}


	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}
	
	
	
}
