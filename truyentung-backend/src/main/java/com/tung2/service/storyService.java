package com.tung2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tung2.convert.storyconvert;
import com.tung2.dto.Dchapter;
import com.tung2.dto.Dstory;
import com.tung2.dto.storydto;
import com.tung2.entity.ChapterEntity;
import com.tung2.entity.StoryEntity;
import com.tung2.entity.UserEntity;
import com.tung2.entity.dsdocEntity;
import com.tung2.output.outpage;
import com.tung2.repository.StoryRepo;
import com.tung2.repository.UserRepo;
import com.tung2.repository.dsdocRepo;

@Service
public class storyService {

	@Autowired
	private storyconvert storyconvert;
	@Autowired
	private dsdocRepo dsdocRepo;
	@Autowired
	private StoryRepo storyRepo;
	@Autowired
	private UserRepo userRepo;

	public StoryEntity luutruyen(storydto storydto, Long id) {
		StoryEntity storyEntity = storyconvert.toEntity(storydto);
		UserEntity userEntity = userRepo.findOne(id);
		if(storydto.getAuthor().equals(userEntity.getSname())) {
			storyEntity.setSource("st");
		}else {
			storyEntity.setSource("dịch");
		}
		storyEntity.setView((long) 0);
		storyEntity.setUser_story(userEntity);
		storyEntity.setStatus(1l);
		return storyRepo.save(storyEntity);
	}

	public storydto xemtruyen(Long id) {
		StoryEntity storyEntity = storyRepo.findOne(id);
		storydto storydto = storyconvert.toDto(storyEntity);
		storydto.setNameuser(storyEntity.getUser_story().getSname());
		List<Dchapter> list = new ArrayList<>();
		for (ChapterEntity chapterEntity : storyEntity.getChapterList()) {
			if (chapterEntity.getStatus() == 0l)
				continue;
			Dchapter dchapter = new Dchapter();
			dchapter.setStt(chapterEntity.getStt());
			dchapter.setName(chapterEntity.getName());
			dchapter.setModifiedDate(chapterEntity.getModifiedDate());
			list.add(dchapter);
		}
		storydto.setDschuong(list);
		return storydto;
	}

	public outpage tim_kiem_ds(Integer page, String name, String category, String source, Long view,int limit) {
		Pageable pageable;
		if(limit<=0) {
		pageable =new PageRequest(page-1, 4);
		}
		else {
		pageable =new PageRequest(page-1,limit);
		}
		Page<StoryEntity> tem;
		
		if(view==null) {
			if(name==null&&category==null&&source==null) {
				tem=storyRepo.showhome0(pageable);
			}else if(name!=null&&category==null&&source==null) {
				tem=storyRepo.showhome1(name, pageable);
			}else if(name==null&&category!=null&&source==null) {
				tem=storyRepo.showhome2(category, pageable);
			}else if(name==null&&category==null&&source!=null) {
				tem=storyRepo.showhome3(source, pageable);
			}else if(name!=null&&category!=null&&source==null) {
				tem=storyRepo.showhome4(name, category, pageable);
			}else if(name==null&&category!=null&&source!=null) {
				tem=storyRepo.showhome5(category, source, pageable);
			}else if(name!=null&&category==null&&source!=null) {
				tem=storyRepo.showhome6(source, name, pageable);
			}else {
				tem=storyRepo.showhome7(name, category, source, pageable);
			}
			
		}else {
			if(name==null&&category==null&&source==null) {
				tem=storyRepo.showhome0v(pageable);
			}else if(name!=null&&category==null&&source==null) {
				tem=storyRepo.showhome1v(name, pageable);
			}else if(name==null&&category!=null&&source==null) {
				tem=storyRepo.showhome2v(category, pageable);
			}else if(name==null&&category==null&&source!=null) {
				tem=storyRepo.showhome3v(source, pageable);
			}else if(name!=null&&category!=null&&source==null) {
				tem=storyRepo.showhome4v(name, category, pageable);
			}else if(name==null&&category!=null&&source!=null) {
				tem=storyRepo.showhome5v(category, source, pageable);
			}else if(name!=null&&category==null&&source!=null) {
				tem=storyRepo.showhome6v(source, name, pageable);
			}else {
				tem=storyRepo.showhome7v(name, category, source, pageable);
		    }
		}	
	
		List<Dstory> dso=new ArrayList<>();
		for(StoryEntity s: tem) {
			Dstory story=new Dstory();
			story.setId(s.getId());
			story.setName(s.getName());
			story.setView(s.getView());
			story.setAvt(s.getAvt());
			story.setModifiedDate(s.getModifiedDate());
			dso.add(story);
		}
		outpage sOutpage=new outpage();
		sOutpage.setPage(page);
		int numberitem= tem.getTotalPages();
		sOutpage.setTotalPage(numberitem);
		sOutpage.setDs(dso);
		return sOutpage;
	}
	
	public String xoatruyen(Long id_user,Long id) throws Exception {
		StoryEntity storyEntity=storyRepo.findOne(id);
		if(storyEntity==null||storyEntity.getStatus()==0l) {
			throw new Exception("Không tồn tại truyện này");
		}else {
			if(storyEntity.getUser_story().getId()!=id_user) {
			throw new Exception("Truyện đang xóa không phải của bạn");
			}else {
			storyEntity.setStatus(0l);
			storyRepo.save(storyEntity);
			return "Thành công";
		}
		}
	}
	
	public void updateDate(Long id_user,Long id_story) {
		dsdocEntity dsdocEntity=dsdocRepo.findByIduserAndIdstory(id_user, id_story);
		if(dsdocEntity==null) return;
		else {
			long millis=System.currentTimeMillis();   
			java.util.Date date=new java.util.Date(millis); 
			dsdocEntity.setVisitedDate(date);
			dsdocRepo.save(dsdocEntity);
			return ;
		}
		
	}
}
