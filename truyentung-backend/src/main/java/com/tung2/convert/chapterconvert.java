package com.tung2.convert;

import org.springframework.stereotype.Component;

import com.tung2.dto.chapterdto;
import com.tung2.entity.ChapterEntity;

@Component
public class chapterconvert {

	public ChapterEntity toEntity(chapterdto in) {
		ChapterEntity out=new ChapterEntity();
		out.setContent(in.getContent());
		out.setName(in.getName());
		out.setStt(in.getStt());
		out.setIdStory(in.getStoryid());
		return out;
	}
	
	public chapterdto toDto(ChapterEntity in) {
		chapterdto out=new chapterdto();
		out.setContent(in.getContent());
		out.setName(in.getName());
		out.setStt(in.getStt());
		out.setStoryid(in.getIdStory());
		out.setModifiedDate(in.getModifiedDate());
		return out;
	}
}
