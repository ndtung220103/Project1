package com.tung2.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tung2.convert.chapterconvert;
import com.tung2.convert.storyconvert;
import com.tung2.convert.userconvert;
import com.tung2.dto.Dstory;
import com.tung2.dto.chapterdto;
import com.tung2.dto.commentdto;
import com.tung2.dto.storydto;
import com.tung2.dto.userdto;
import com.tung2.entity.NoticeEntity;
import com.tung2.entity.StoryEntity;
import com.tung2.entity.UserEntity;
import com.tung2.entity.dsdocEntity;
import com.tung2.repository.StoryRepo;
import com.tung2.repository.UserRepo;
import com.tung2.repository.dsdocRepo;
import com.tung2.service.chapterService;
import com.tung2.service.commentService;
import com.tung2.service.storyService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/user") // cần login
public class userAPI {

	@Autowired
	private UserRepo UserRepo;
	@Autowired
	private StoryRepo storyRepo;
	@Autowired
	private userconvert userconvert;
	@Autowired
	private storyconvert storyconvert;
	@Autowired
	private chapterconvert chapterconvert;
	@Autowired
	private storyService storyService;
	@Autowired
	private chapterService chapterService;
	@Autowired
	private commentService commentService;
	@Autowired
	private dsdocRepo dsdocRepo;
	
	private final String JWT_SECRET = "lodaaaaaa";

	@GetMapping("/tt")
	public userdto tttk(HttpServletRequest request) {
		userdto userdto = new userdto();
		String bearerToken = request.getHeader("Authorization");
		// Kiểm tra xem header Authorization có chứa thông tin jwt không
		try {
			if (StringUtils.hasText(bearerToken)) {
				Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(bearerToken).getBody();

				Long id_user = Long.parseLong(claims.getSubject());
				UserEntity userEntity = UserRepo.findOne(id_user);
				userdto = userconvert.todto(userEntity);
				
				//lấy danh sach truyen theo doi
				List<Dstory> listfollow=new ArrayList<>();
				for(dsdocEntity e:dsdocRepo.findByIduser(id_user)) {
					Dstory sDstory=new Dstory();
					sDstory.setId(e.getIdstory());
					sDstory.setVisituserdate(e.getVisitedDate());
					StoryEntity storyEntity=storyRepo.findOne(e.getIdstory());
					sDstory.setModifiedDate(storyEntity.getModifiedDate());
					sDstory.setName(storyEntity.getName());
					listfollow.add(sDstory);
				}
				userdto.setListfollow(listfollow);
				userdto.setUsername("0");
				userdto.setPassword("0");
			}else {
				userdto.setSname("Hết phiên. Bạn cần đăng nhập lại!");
			}
		} catch (Exception e) {
			userdto.setSname("Bạn cần đăng nhập!");
		}
		return userdto;
	}

	@PostMapping("/them-truyen")
	public storydto themtruyen(HttpServletRequest request, @RequestBody storydto storydto) {
		// them thong bao
		storydto dto2 = new storydto();
		try {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken)) {
			Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(bearerToken).getBody();
			Long id_user = Long.parseLong(claims.getSubject());
			dto2= storyconvert.toDto(storyService.luutruyen(storydto,id_user));
		}else {
			dto2.setName("Chưa đăng nhập");
		}
		}catch (Exception e){
			dto2.setName("Cần đăng nhập lại");
		}
		return dto2;
	}

	@PostMapping("/them-chuong")
	public chapterdto them_suachuong(HttpServletRequest request, @RequestBody chapterdto chapterdto) {
		// them thong bao
		chapterdto chapterdto2 = new chapterdto();
		Long id_user;
		try {
			String bearerToken = request.getHeader("Authorization");
			if (StringUtils.hasText(bearerToken)) {
				Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(bearerToken).getBody();
				id_user = Long.parseLong(claims.getSubject());
				//lưu chương
				try {
					chapterdto2= chapterconvert.toDto(chapterService.luu_sua(chapterdto,id_user));
				} catch (Exception e) {
					chapterdto2.setContent(e.getMessage());
				}
			}else {
				chapterdto2.setContent("Chưa đăng nhập");
			}
		}catch (Exception e){
				chapterdto2.setContent("Cần đăng nhập lại");
			}
		return chapterdto2;
	}

	@GetMapping("/xoa-truyen")
	public NoticeEntity xoa_truyen(HttpServletRequest request, @RequestParam(value = "id") Long id) {
		NoticeEntity noticeEntity=new NoticeEntity();
		try {
			String bearerToken = request.getHeader("Authorization");
			if (StringUtils.hasText(bearerToken)) {
				Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(bearerToken).getBody();
				Long id_user = Long.parseLong(claims.getSubject());
				try {
					 storyService.xoatruyen(id_user, id);
					 noticeEntity.setContent("Đã xóa thành công");
				} catch (Exception e) {
					noticeEntity.setContent(e.getMessage());
				}
			}else {
				noticeEntity.setContent("Chưa đăng nhập");
			}
			}catch (Exception e){
				noticeEntity.setContent("Cần đăng nhập lại");
			}
		return noticeEntity;
	}

	@GetMapping("/xoa-chuong")
	public NoticeEntity xoa_chuong(HttpServletRequest request, @RequestParam(value = "storyid") Long storyid,
			@RequestParam(value = "stt") Long stt) {
		NoticeEntity noticeEntity=new NoticeEntity();
		try {
			String bearerToken = request.getHeader("Authorization");
			if (StringUtils.hasText(bearerToken)) {
				Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(bearerToken).getBody();
				Long id_user = Long.parseLong(claims.getSubject());
				try {
					chapterService.xoachuong(id_user, storyid, stt);
					 noticeEntity.setContent("Đã xóa thành công");
				} catch (Exception e) {
					noticeEntity.setContent(e.getMessage());
				}
			}else {
				noticeEntity.setContent("Chưa đăng nhập");
			}
			}catch (Exception e){
				noticeEntity.setContent("Cần đăng nhập lại");
			}
		return noticeEntity;
	}

	// them comment
	@PostMapping("/comment")
	public NoticeEntity com(HttpServletRequest request,@RequestBody commentdto comment) {
		NoticeEntity noticeEntity=new NoticeEntity();
		try {
			String bearerToken = request.getHeader("Authorization");
			if (StringUtils.hasText(bearerToken)) {
				Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(bearerToken).getBody();
				Long id_user = Long.parseLong(claims.getSubject());
				try {
					 commentService.themcomment(id_user, comment);
					 noticeEntity.setContent("Đã comment thành công");
				} catch (Exception e) {
					noticeEntity.setContent(e.getMessage());
				}
			}else {
				noticeEntity.setContent("Chưa đăng nhập");
			}
			}catch (Exception e){
				noticeEntity.setContent("Cần đăng nhập lại");
			}
		return noticeEntity;
	}
	
	
	@GetMapping("/them-ds-doc")
	public Dstory dsdocc(HttpServletRequest request,@RequestParam Long id_story){
		Dstory dstory=new Dstory();
		try {
			String bearerToken = request.getHeader("Authorization");
			if (StringUtils.hasText(bearerToken)) {
				Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(bearerToken).getBody();
				Long id_user = Long.parseLong(claims.getSubject());
				try {
					// kiem tra user co phai tac gia
					StoryEntity storyEntity=storyRepo.findOne(id_story);
					if(storyEntity.getUser_story().getId()==id_user) {
						dstory.setName("Bạn là người đăng truyện này!!!");
					}else {
						if(dsdocRepo.findByIduserAndIdstory(id_user, id_story)!=null) {
							dstory.setName("Truyện này đã có trong danh sách của bạn!!!");
						}else {
						dsdocEntity dsdoc=new dsdocEntity();
						dsdoc.setIdstory(id_story);
						dsdoc.setIduser(id_user);
						dsdocRepo.save(dsdoc);
						dstory.setName("Thành công");
						}
					}
				} catch (Exception e) {
					dstory.setName(e.getMessage());
				}
			}else {
				dstory.setName("Chưa đăng nhập");
			}
			}catch (Exception e){
				dstory.setName(e.getMessage());
			}
		return dstory;
	      }
	
	//update ngay truy cập truyện của user
	@GetMapping("/updateDate")
	public Dstory sysupdate(HttpServletRequest request,@RequestParam Long id_story){
		Dstory dstory=new Dstory();
		dstory.setName("OK");
		try {
			String bearerToken = request.getHeader("Authorization");
			if (StringUtils.hasText(bearerToken)) {
				Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(bearerToken).getBody();
				Long id_user = Long.parseLong(claims.getSubject());
					// kiem tra user co phai tac gia
				storyService.updateDate(id_user, id_story);
			}
			}catch (Exception e){
				dstory.setName("NOT OK");
				return dstory;
			}
			return dstory;
	   } 
	
	@DeleteMapping("/xoa-khoi-ds-doc")
	public NoticeEntity xoads(HttpServletRequest request, @RequestParam Long id_story) {
		NoticeEntity noticeEntity=new NoticeEntity();
		try {
			String bearerToken = request.getHeader("Authorization");
			if (StringUtils.hasText(bearerToken)) {
				Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(bearerToken).getBody();
				Long id_user = Long.parseLong(claims.getSubject());
				try {
					dsdocEntity e=dsdocRepo.findByIduserAndIdstory(id_user, id_story);
					if(e!=null) {
						dsdocRepo.delete(e);
						noticeEntity.setContent("Xóa thành công!");
					}else {
						noticeEntity.setContent("Không thành công!");
					}
				} catch (Exception e) {
					noticeEntity.setContent(e.getMessage());
				}
			}else {
				noticeEntity.setContent("Chưa đăng nhập");
			}
			}catch (Exception e){
				noticeEntity.setContent("Cần đăng nhập lại");
			}
		return noticeEntity;
	}
	
	@DeleteMapping("/delete-comment")
	public NoticeEntity xoabl(HttpServletRequest request, @RequestParam Long id_comment) {
		NoticeEntity noticeEntity=new NoticeEntity();
		try {
			String bearerToken = request.getHeader("Authorization");
			if (StringUtils.hasText(bearerToken)) {
				Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(bearerToken).getBody();
				Long id_user = Long.parseLong(claims.getSubject());
				try {
					noticeEntity.setContent(commentService.deletecomment(id_user, id_comment));
				} catch (Exception e) {
					noticeEntity.setContent(e.getMessage());
				}
			}else {
				noticeEntity.setContent("Chưa đăng nhập");
			}
			}catch (Exception e){
				noticeEntity.setContent("Cần đăng nhập");
			}
		return noticeEntity;
	}

}
