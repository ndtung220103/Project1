package com.tung2.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="user")
public class UserEntity extends BaseEntity {
	  
	
	@Column(name="sname")
	private String sname;
	
	@Column(name="username",columnDefinition="VARCHAR(100) NOT NULL ",unique=true)
	private String username;
	
	@Column(name="password",columnDefinition="VARCHAR(100) NOT NULL",unique=true)
	private String password;
	
	@Column(name="role",columnDefinition="VARCHAR(10)")
	private String role;
	
	@Column(name="avt")
	private String avt;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy="user")
	private List<CommentEntity> commentList=new ArrayList<>();
	
	@OneToMany(mappedBy="user_story")
	private List<StoryEntity> storyList=new ArrayList<>();
	
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public List<CommentEntity> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentEntity> commentList) {
		this.commentList = commentList;
	}

	public List<StoryEntity> getStoryList() {
		return storyList;
	}

	public void setStoryList(List<StoryEntity> storyList) {
		this.storyList = storyList;
	}

	
	
}
