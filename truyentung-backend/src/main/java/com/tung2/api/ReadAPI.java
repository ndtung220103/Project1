package com.tung2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tung2.dto.chapterdto;
import com.tung2.dto.storydto;
import com.tung2.service.chapterService;
import com.tung2.service.storyService;

@RestController
public class ReadAPI {
	
	@Autowired
	private storyService storyService;
	
	@Autowired
	private chapterService chapterService;
	
	@GetMapping("/story")
	public storydto viewstory(@RequestParam(value="id_story") Long id) {
		if(id!=null) {
			return storyService.xemtruyen(id);
		}else {
			return null;
		}
	}
	
	@GetMapping("/xem-chuong")
	public chapterdto viewchapter(@RequestParam(value="id_story") Long id,@RequestParam(value="stt")Long stt,@RequestParam(value="nob" ,required=false)Long nob) {
		try {
		return chapterService.xemchuong(id, stt,nob);
		}catch (Exception e) {
			chapterdto chapterdto=new chapterdto();
			chapterdto.setContent(e.getMessage());
			chapterdto.setStt(0l);
			chapterdto.setName("Chưa có chương");
			return chapterdto;
		}
	}

}
