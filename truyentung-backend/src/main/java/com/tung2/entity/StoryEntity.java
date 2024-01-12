package com.tung2.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="story")
public class StoryEntity extends BaseEntity {
	
	@Column(name="name")
	private String name;
	
	@Column(name="category", columnDefinition="VARCHAR(50)")
	private String category;
	
	@Column(name="source", columnDefinition="NVARCHAR(20)")
	private String source;
	
	@Column(name="author")
	private String author;
	
	@Column(name="avt")
	private String avt;
	
	@Column(name="shortD", columnDefinition="TEXT")
	private String shortD;
	
	@Column(name="status")
	private Long status;
	
	@Column(name="view")
	private Long view;
	
	@ManyToOne
	@JoinColumn(name="user")
	private UserEntity user_story;
	
	@OneToMany(mappedBy="story_chapter")
	private List<ChapterEntity> chapterList=new ArrayList<>();
	
	@OneToMany(mappedBy="story_comment")
	private List<CommentEntity> commentList=new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAvt() {
		return avt;
	}

	public void setAvt(String avt) {
		this.avt = avt;
	}

	public String getShortD() {
		return shortD;
	}

	public void setShortD(String shortD) {
		this.shortD = shortD;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getView() {
		return view;
	}

	public void setView(Long view) {
		this.view = view;
	}

	public UserEntity getUser_story() {
		return user_story;
	}

	public void setUser_story(UserEntity user_story) {
		this.user_story = user_story;
	}

	public List<ChapterEntity> getChapterList() {
		return chapterList;
	}

	public void setChapterList(List<ChapterEntity> chapterList) {
		this.chapterList = chapterList;
	}

	public List<CommentEntity> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentEntity> commentList) {
		this.commentList = commentList;
	}
	
	
}
