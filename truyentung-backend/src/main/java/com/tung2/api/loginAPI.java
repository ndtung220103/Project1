package com.tung2.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tung2.dto.userlogin;
import com.tung2.entity.NoticeEntity;
import com.tung2.entity.UserEntity;
import com.tung2.repository.UserRepo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class loginAPI {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserRepo UserRepo;
	private final String JWT_SECRET = "lodaaaaaa";
	private final long JWT_EXPIRATION = 60480000L;

	@PostMapping("/login")
	public NoticeEntity Checklogin(@RequestBody userlogin userlogin) {

		NoticeEntity notice = new NoticeEntity();
		// notice.setContent("Bạn đã đăng nhập thành công");
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userlogin.getUsername(), userlogin.getPassword()));

			// Nếu không xảy ra exception tức là thông tin hợp lệ
			// Set thông tin authentication vào Security Context
			SecurityContextHolder.getContext().setAuthentication(authentication);

			// Tạo ra jwt từ thông tin user
			Date now = new Date();
			Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
			// Tạo chuỗi json web token từ id của user.
			UserEntity userEntity = UserRepo.findOneByUsername(userlogin.getUsername());
			// Trả về jwt cho người dùng.
			String jwt = Jwts.builder().setSubject(Long.toString(userEntity.getId())).setIssuedAt(now)
					.setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
			notice.setContent(jwt);
			return notice;
		} catch (Exception e) {
			notice.setContent("Đăng nhập không thành công");
			return notice;
		}
	}
	/*
	@PostMapping("/logout")
	public NoticeEntity logout(HttpServletRequest request) {
		NoticeEntity notice = new NoticeEntity();
		notice.setContent("Bạn đã đăng xuất thành công");

		return notice;
	}*/

}
