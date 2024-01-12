package com.tung2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tung2.dto.commentdto;
import com.tung2.entity.CommentEntity;
import com.tung2.entity.StoryEntity;
import com.tung2.entity.UserEntity;
import com.tung2.repository.CommentRepo;
import com.tung2.repository.StoryRepo;
import com.tung2.repository.UserRepo;

@Service
public class commentService {
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private StoryRepo storyRepo;
	
	public String themcomment(Long id_user,commentdto commentdto) throws Exception {
		UserEntity userEntity=userRepo.findOne(id_user);
		if(userEntity==null) {
			throw new Exception("Chưa đăng nhập");
		}else {
			StoryEntity storyEntity=storyRepo.findOne(commentdto.getStoryid());
			CommentEntity commentEntity=new CommentEntity();
			commentEntity.setContent(commentdto.getContent());
			commentEntity.setUser(userEntity);
			commentEntity.setStory(storyEntity);
			commentEntity.setStoryid(storyEntity.getId());
			commentRepo.save(commentEntity);
			return "OK";
		}
	}
	
	public List<commentdto> listcomment(Long storyid) {
		List<commentdto> listcomment=new ArrayList<>();
		for(CommentEntity commentEntity: commentRepo.findByStoryid(storyid)) {
			commentdto commentdto=new commentdto();
			commentdto.setNameuser(commentEntity.getUser().getSname());
			commentdto.setContent(commentEntity.getContent());
			commentdto.setCreateDate(commentEntity.getCreateDate());
			commentdto.setId(commentEntity.getId());
			
			listcomment.add(commentdto);
		}
		
		return listcomment;
	}
	
	public String deletecomment(Long id_user,Long id_comment) {
		CommentEntity commentEntity=commentRepo.findOne(id_comment);
		if(id_user==commentEntity.getUser().getId()) {
			commentRepo.delete(commentEntity);
			return "Xóa thành công";
		}else {
			return "Không có quyền xóa bình luận này";
		}
	}
}
