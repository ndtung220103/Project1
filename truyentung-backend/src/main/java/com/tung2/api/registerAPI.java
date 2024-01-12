package com.tung2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tung2.dto.userdto;
import com.tung2.entity.NoticeEntity;
import com.tung2.service.registerService;

@RestController
public class registerAPI {
	
	@Autowired
	private registerService registerService;
	
	@PostMapping("/dang-ki")
	public NoticeEntity dangKi(@RequestBody userdto user) {
		NoticeEntity notice =new NoticeEntity();
		notice.setIdUser(1l);
		try {
			registerService.luutk(user);
			notice.setContent("Đăng kí thành công( bấm home về trang chủ)");
			return notice;
		}catch (Exception exception) {
			notice.setContent(exception.getMessage());
			return notice;
		}
	}
}
