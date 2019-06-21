package com.mse.forum.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.mse.forum.dto.ReplyWithTopicDTO;
import com.mse.forum.dto.TopicDTO;
import com.mse.forum.persistance.entities.TopicEntity;

@Mapper(componentModel = "spring")
public interface TopicMapper {
	
	TopicEntity toEntity(TopicDTO dto);
	TopicDTO toDto(TopicEntity entity);
	TopicEntity toEntityFromReply(ReplyWithTopicDTO dto);
	List<TopicEntity> toEntityList(List<TopicDTO> dtoList);
	List<TopicDTO> toDtoList(List<TopicEntity> entityList);
	
}