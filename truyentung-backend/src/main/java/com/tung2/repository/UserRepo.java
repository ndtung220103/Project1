package com.tung2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tung2.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long> {

	public UserEntity findOneByUsername(String username);
	public List<UserEntity> findByUsername(String username);
}
