package com.tung2.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tung2.convert.chapterconvert;
import com.tung2.dto.chapterdto;
import com.tung2.entity.ChapterEntity;
import com.tung2.entity.StoryEntity;
import com.tung2.repository.ChapterRepo;
import com.tung2.repository.StoryRepo;
import com.tung2.repository.UserRepo;

@Service
public class chapterService {

	@Autowired
	private ChapterRepo chapterRepo;
	
	@Autowired
	private StoryRepo storyRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private chapterconvert chapterconvert;
	
	public ChapterEntity luu_sua(chapterdto chapterdto,Long id_user) throws Exception{
		StoryEntity storyEntity=storyRepo.findOne(chapterdto.getStoryid());
		if(storyEntity==null) {
			throw new Exception("Không có id truyện");
		}else {
			if(storyEntity.getUser_story().getId()!=id_user) {
				throw new Exception("Truyện với id này không phải của bạn");
			}else {
				if(storyEntity.getStatus()==0l) { 
				throw new Exception("Truyện với id này đã bị xóa");
				}
				else {
				ChapterEntity chapterEntity=chapterconvert.toEntity(chapterdto);
				chapterEntity.setStory_chapter(storyEntity);
				chapterEntity.setStatus(1l);
				long millis=System.currentTimeMillis();   
				java.util.Date date=new java.util.Date(millis); 
				chapterEntity.setModifiedDate(date);
				
				//cap nhat truyen
				storyEntity.setModifiedDate(date);
				storyRepo.save(storyEntity);
				return chapterRepo.save(chapterEntity);
				}
			}
		}
		
	}
	
	public chapterdto xemchuong(Long id,Long stt,Long nob) throws Exception {
		//Long maxstt=chapterRepo.findtopstt(id).getStt();
		Long maxstt=200l;
		ChapterEntity chapterEntity=chapterRepo.findonebysttandid(id, stt);
		if(nob==null) {
		// nếu ko có stt thì tìm đến thằng tiếp theo
		while(chapterEntity==null&&stt<=maxstt) {
			stt++;
			chapterEntity=chapterRepo.findonebysttandid(id, stt);
		}
		}else {
			while(chapterEntity==null&&stt>0) {
				stt--;
				chapterEntity=chapterRepo.findonebysttandid(id, stt);
			}
		}
		if(0<stt&&stt<=maxstt) {
		chapterdto dto=chapterconvert.toDto(chapterEntity);
		// them luot xem
		StoryEntity storyEntity=storyRepo.findOne(id);
		Long view=storyEntity.getView();
		view+=(long)1;
		storyEntity.setView(view);
		storyRepo.save(storyEntity);
		return dto;
		}else {
			throw new Exception("chưa có cập nhật chương này. Bạn nó thể quay lại sau.");
		}
	}
	
	public String xoachuong(Long id_user,Long strotyid,Long stt) throws Exception {
		ChapterEntity chapterEntity=chapterRepo.findonebysttandid(strotyid, stt);
	   if(chapterEntity==null) {
		   throw new Exception("Không tồn tại chương này");
	   }else
		   if(chapterEntity.getStory_chapter().getUser_story().getId()!=id_user) {
			throw new Exception("Truyện này không phải của bạn");
		   }else {
			chapterEntity.setStatus(0l);
			chapterRepo.save(chapterEntity);
			return "Thành công";
		}
	}
}
