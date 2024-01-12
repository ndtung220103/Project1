package com.tung2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tung2.entity.StoryEntity;

@Repository
public interface StoryRepo extends JpaRepository<StoryEntity,Long> {
	
	@Query("SELECT s FROM StoryEntity s WHERE s.status!=0 ORDER BY s.view DESC")
	Page<StoryEntity> showhome0v(org.springframework.data.domain.Pageable pageable);

	@Query("SELECT s FROM StoryEntity s WHERE s.status!=0 ORDER BY s.modifiedDate DESC")
	Page<StoryEntity> showhome0(org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT s FROM StoryEntity s WHERE s.name=?1 AND s.status!=0 ORDER BY s.view DESC")
	Page<StoryEntity> showhome1v(String name,org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT s FROM StoryEntity s WHERE s.category LIKE %?1% AND s.status!=0 ORDER BY s.view DESC")
	Page<StoryEntity> showhome2v(String category,org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT s FROM StoryEntity s WHERE s.source=?1 AND s.status!=0 ORDER BY s.view DESC")
	Page<StoryEntity> showhome3v(String source,org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT s FROM StoryEntity s WHERE s.name=?1 AND s.status!=0 ORDER BY s.modifiedDate DESC")
	Page<StoryEntity> showhome1(String name,org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT s FROM StoryEntity s WHERE s.category LIKE %?1% AND s.status!=0 ORDER BY s.modifiedDate DESC")
	Page<StoryEntity> showhome2(String category,org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT s FROM StoryEntity s WHERE s.source=?1 AND s.status!=0 ORDER BY s.modifiedDate DESC")
	Page<StoryEntity> showhome3(String source,org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT s FROM StoryEntity s WHERE s.name=?1 AND s.category LIKE %?2% AND s.status!=0 ORDER BY s.view DESC")
	Page<StoryEntity> showhome4v(String name,String category,org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT s FROM StoryEntity s WHERE s.category LIKE %?1% AND s.source=?2 AND s.status!=0 ORDER BY s.view DESC")
	Page<StoryEntity> showhome5v(String category,String source,org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT s FROM StoryEntity s WHERE s.source=?1 AND  s.name=?2 AND s.status!=0 ORDER BY s.view DESC")
	Page<StoryEntity> showhome6v(String source,String name,org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT s FROM StoryEntity s WHERE s.name=?1 AND s.category LIKE %?2% AND s.status!=0 ORDER BY s.modifiedDate DESC")
	Page<StoryEntity> showhome4(String name,String category,org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT s FROM StoryEntity s WHERE s.category LIKE %?1% AND s.source=?2 AND s.status!=0 ORDER BY s.modifiedDate DESC")
	Page<StoryEntity> showhome5(String category,String source,org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT s FROM StoryEntity s WHERE s.source=?1 AND  s.name=?2 AND s.status!=0 ORDER BY s.modifiedDate DESC")
	Page<StoryEntity> showhome6(String source,String name,org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT s FROM StoryEntity s WHERE s.name=?1 AND s.category LIKE %?2% AND s.source=?3 AND s.status!=0 ORDER BY s.modifiedDate DESC")
	Page<StoryEntity> showhome7(String name,String category,String source,org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT s FROM StoryEntity s WHERE s.name=?1 AND s.category LIKE %?2% AND s.source=?3 AND s.status!=0 ORDER BY s.view DESC")
	Page<StoryEntity> showhome7v(String name,String category,String source,org.springframework.data.domain.Pageable pageable);
	
}
