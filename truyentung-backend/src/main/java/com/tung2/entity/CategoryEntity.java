package com.tung2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryEntity  {
	@Id
	@Column(name="code",columnDefinition = "VARCHAR(2) ")
	private String code;
	
	@Column(name="name", columnDefinition = "VARCHAR(30) ")
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
