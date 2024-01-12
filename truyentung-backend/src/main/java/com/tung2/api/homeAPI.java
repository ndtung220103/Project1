package com.tung2.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tung2.dto.commentdto;
import com.tung2.output.outpage;
import com.tung2.service.commentService;
import com.tung2.service.storyService;

@RestController
public class homeAPI {

	@Autowired
	private commentService commentService;

	@Autowired
	private storyService storyService;

	@GetMapping("/danh-sach-truyen")
	public outpage dstruyen(@RequestParam(value = "page") Integer page,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "source", required = false) String source,
			@RequestParam(value = "view", required = false) Long view) {
		return storyService.tim_kiem_ds(page, name, category, source, view, 0);
	}

	@GetMapping("/ds-home")
	public outpage dstruyen2(@RequestParam(value = "page") Integer page,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "source", required = false) String source,
			@RequestParam(value = "view", required = false) Long view) {
		return storyService.tim_kiem_ds(page, name, category, source, view, 8);
	}

	@GetMapping("/listcomment")
	public List<commentdto> listcommet(@RequestParam Long storyid) {
		return commentService.listcomment(storyid);
	}
}
