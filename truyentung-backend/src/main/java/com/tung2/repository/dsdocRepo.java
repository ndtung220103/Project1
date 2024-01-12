package com.tung2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tung2.entity.dsdocEntity;

@Repository
public interface dsdocRepo extends JpaRepository<dsdocEntity,Long> {

	List<dsdocEntity> findByIduser(Long iduser);
	dsdocEntity findByIduserAndIdstory(Long iduser,Long idstory);
}
