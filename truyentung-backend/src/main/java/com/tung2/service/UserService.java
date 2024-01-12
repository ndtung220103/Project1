package com.tung2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tung2.entity.UserEntity;
import com.tung2.repository.UserRepo;


@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo UserRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserEntity> userEntities=UserRepo.findByUsername(username);
		String password=null;
		List<GrantedAuthority> authorities=null;
		if(userEntities.isEmpty()) {
			throw new UsernameNotFoundException("khong tim thay username= "+username);
		}
		username=userEntities.get(0).getUsername();
		password=userEntities.get(0).getPassword();
		authorities=new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(userEntities.get(0).getRole()));
		return new User(username,password,authorities);
	}
}

