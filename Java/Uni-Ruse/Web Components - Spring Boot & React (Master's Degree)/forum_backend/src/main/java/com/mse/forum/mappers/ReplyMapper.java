package com.mse.forum.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mse.forum.dto.ReplyDTO;
import com.mse.forum.dto.ReplyWithTopicDTO;
import com.mse.forum.persistance.entities.ReplyEntity;

@Mapper(componentModel = "spring")
public interface ReplyMapper {
	ReplyEntity toEntity(ReplyDTO dto);

	@Mapping(source = "topic.id", target = "topicId")
	@Mapping(source = "user.id", target = "userId")
	ReplyDTO toDto(ReplyEntity entity);

	@Mapping(target = "topic", ignore = true)
	ReplyEntity toReplyWithTopicEntity(ReplyWithTopicDTO dto);
}