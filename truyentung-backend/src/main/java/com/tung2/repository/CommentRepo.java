package com.tung2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tung2.entity.CommentEntity;

@Repository
public interface CommentRepo extends JpaRepository<CommentEntity,Long> {
	@Query("SELECT st FROM CommentEntity st WHERE st.storyid=?1 ORDER BY st.id DESC")
	public List<CommentEntity> findByStoryid(Long storyid);
	

}
