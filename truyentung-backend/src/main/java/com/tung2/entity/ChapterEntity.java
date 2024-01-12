package com.tung2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.tung2.IDclass.ChapterID;

@Entity
@IdClass(ChapterID.class)
@Table(name="chapter")
public class ChapterEntity  {
	
	@Id
	@Column(name="STT")
	private Long stt;
	
	@Id
	@Column(name="idstory")
	private Long idStory;
	
	
	@ManyToOne
	@JoinColumn(name="story")
	private StoryEntity story_chapter;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="content",columnDefinition = "TEXT ")
	private String content;
	
	@Column(name="status")
	private Long status;
	
	@CreatedBy
	@Column(name = "createby", columnDefinition = "VARCHAR(50) ")
	private String createBy;
	
	@CreatedDate
	@Column(name = "createdate")
	private Date createDate;
	
	@LastModifiedDate
	@Column(name = "modifieddate")
	private Date modifiedDate;

	

	public Long getIdStory() {
		return idStory;
	}

	public void setIdStory(Long idStory) {
		this.idStory = idStory;
	}

	public StoryEntity getStory_chapter() {
		return story_chapter;
	}

	public void setStory_chapter(StoryEntity story_chapter) {
		this.story_chapter = story_chapter;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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

	public Long getStt() {
		return stt;
	}

	public void setStt(Long stt) {
		this.stt = stt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	
}
