package com.tung2.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tung2.entity.ChapterEntity;

@Repository
public interface ChapterRepo extends JpaRepository<ChapterEntity,Long> {

	@Query("SELECT e FROM ChapterEntity e WHERE e.idStory = ?1 AND e.stt = ?2 AND e.status !=0")
	public ChapterEntity findonebysttandid(Long id,Long stt);
	
	/*
	@Query("SELECT e FROM ChapterEntity e WHERE e.idStory = ?1 AND e.status !=0 ORDER BY e.stt DESC ")
	public ChapterEntity findtopstt(Long id);*/
	
	@Query("SELECT e FROM ChapterEntity e WHERE e.idStory = ?1 AND e.stt = ?2 AND e.status !=0")
	public Page<ChapterEntity> findonebysttandid(Long id,Long stt,Pageable pageable);
}
