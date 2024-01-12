package com.tung2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class CommentEntity extends BaseEntity {

	@Column(name="content",columnDefinition="TEXT")
	private String content;
	
	@Column(name="storyid")
	private Long storyid;
	
	@ManyToOne
	@JoinColumn(name="user")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name="story")
	private StoryEntity story_comment;
	

	public Long getStoryid() {
		return storyid;
	}

	public void setStoryid(Long storyid) {
		this.storyid = storyid;
	}

	public StoryEntity getStory_comment() {
		return story_comment;
	}

	public void setStory_comment(StoryEntity story_comment) {
		this.story_comment = story_comment;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public StoryEntity getStory() {
		return story_comment;
	}

	public void setStory(StoryEntity story) {
		this.story_comment = story;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
