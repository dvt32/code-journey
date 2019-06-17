package com.mse.forum.persistance;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mse.forum.persistance.entities.TopicEntity;

public interface TopicRepository 
	extends JpaRepository<TopicEntity, Long> 
{
	TopicEntity findByTitle(String title);
	
	List<TopicEntity> findTop3ByOrderByReplyCountDesc();
	List<TopicEntity> findTop3ByOrderByViewsCountDesc();
	
	List<TopicEntity> findTop3ByCreatedOnBetweenOrderByReplyCountDesc(Date createdOnStartDate, Date createdOnEndDate);
	List<TopicEntity> findTop3ByCreatedOnBetweenOrderByViewsCountDesc(Date createdOnStartDate, Date createdOnEndDate);
	
	// List<TopicEntity> findTop3ByCreatedOnGreaterThanEqualAndCreatedOnLessThanEqualOrderByReplyCountDesc(Date createdOnStartDate, Date createdOnEndDate);
}