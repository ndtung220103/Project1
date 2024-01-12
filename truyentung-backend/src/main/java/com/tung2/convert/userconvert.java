package com.tung2.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tung2.dto.Dchapter;
import com.tung2.dto.Dstory;
import com.tung2.dto.userdto;
import com.tung2.entity.ChapterEntity;
import com.tung2.entity.StoryEntity;
import com.tung2.entity.UserEntity;

@Component
public class userconvert {
	
	
	public UserEntity toEntity(userdto dto) {
		UserEntity entity=new UserEntity();
		entity.setAvt(dto.getAvt());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setSname(dto.getSname());
		entity.setUsername(dto.getUsername());
		
		return entity;
	}
	
	public userdto todto(UserEntity entity) {
		userdto dto=new userdto();
		dto.setAvt(entity.getAvt());
		dto.setEmail(entity.getEmail());
		dto.setPassword(entity.getPassword());
		dto.setSname(entity.getSname());
		dto.setUsername(entity.getUsername());
		dto.setId(entity.getId());
		dto.setCreateDate(entity.getCreateDate());
		dto.setModifiedDate(entity.getModifiedDate());
		List<Dstory> list=new ArrayList<>();
		for(StoryEntity s: entity.getStoryList()) {
			if(s.getStatus()==0l) continue;
			Dstory tem=new Dstory();
			tem.setId(s.getId());
			tem.setAvt(s.getAvt());
			tem.setName(s.getName());
			//them chuong truyen
			List<Dchapter> listchapter=new ArrayList<>();
			for(ChapterEntity c: s.getChapterList()) {
				if(c.getStatus()==0l) continue;
				Dchapter ctem=new Dchapter();
				ctem.setStt(c.getStt());
				ctem.setName(c.getName());
				//them chuong truyen
				listchapter.add(ctem);
			}
			tem.setDschuong(listchapter);
			list.add(tem);
		}
		dto.setListstory(list);
		return dto;
		
	}
}
