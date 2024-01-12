package com.tung2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tung2.entity.NoticeEntity;

public interface NoticeRepo extends JpaRepository<NoticeEntity,Long> {

}
