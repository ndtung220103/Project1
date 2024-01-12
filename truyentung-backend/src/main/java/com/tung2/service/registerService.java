package com.tung2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tung2.convert.userconvert;
import com.tung2.dto.userdto;
import com.tung2.entity.UserEntity;
import com.tung2.repository.UserRepo;

@Service
public class registerService {
	
	@Autowired
	private userconvert userconvert;
	@Autowired
	private UserRepo userRepo;

	public UserEntity luutk(userdto userdto) throws Exception {
		if(userRepo.findOneByUsername(userdto.getUsername())==null) {
		UserEntity userEntity=userconvert.toEntity(userdto);
		userEntity.setRole("USER");
		return userRepo.save(userEntity);
		}else {
			throw new Exception("Tài khoản này đã thiết lập");
		}
	}
}
