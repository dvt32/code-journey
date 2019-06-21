package com.mse.forum.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mse.forum.persistance.entities.ReplyEntity;

public interface RepliesRepository 
	extends JpaRepository<ReplyEntity, Long> 
{

}