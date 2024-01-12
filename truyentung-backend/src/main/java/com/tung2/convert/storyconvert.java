package com.tung2.convert;

import org.springframework.stereotype.Component;

import com.tung2.dto.storydto;
import com.tung2.entity.StoryEntity;

@Component
public class storyconvert {
	
	public StoryEntity toEntity(storydto dto) {
		StoryEntity entity=new StoryEntity();
		entity.setAuthor(dto.getAuthor());
		entity.setAvt(dto.getAvt());
		entity.setCategory(dto.getCategory());
		entity.setName(dto.getName());
		entity.setShortD(dto.getShortD());
		//entity.setSource(dto.getSource());
		
		return entity;
	}
	
	public storydto toDto(StoryEntity dto) {
		storydto entity=new storydto();
		entity.setAuthor(dto.getAuthor());
		entity.setAvt(dto.getAvt());
		entity.setCategory(dto.getCategory());
		entity.setName(dto.getName());
		entity.setShortD(dto.getShortD());
		entity.setSource(dto.getSource());
		entity.setId(dto.getId());
		entity.setCreateDate(dto.getCreateDate());
		entity.setModifiedDate(dto.getModifiedDate());
		entity.setView(dto.getView());
		entity.setId_user(dto.getUser_story().getId());
		return entity;
	}
}
