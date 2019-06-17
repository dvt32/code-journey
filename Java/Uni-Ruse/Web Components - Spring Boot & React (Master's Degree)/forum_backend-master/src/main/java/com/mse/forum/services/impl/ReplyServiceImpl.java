package com.mse.forum.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mse.forum.dto.ReplyDTO;
import com.mse.forum.dto.ReplyWithTopicDTO;
import com.mse.forum.mappers.ReplyMapper;
import com.mse.forum.mappers.TopicMapper;
import com.mse.forum.persistance.RepliesRepository;
import com.mse.forum.persistance.TopicRepository;
import com.mse.forum.persistance.UserRepository;
import com.mse.forum.persistance.entities.ReplyEntity;
import com.mse.forum.persistance.entities.TopicEntity;
import com.mse.forum.persistance.entities.UserEntity;
import com.mse.forum.services.ReplyService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImpl 
	implements ReplyService 
{
	private RepliesRepository replyRepository;

	private TopicRepository topicRepository;

	private ReplyMapper replyMapper;

	private TopicMapper topicMapper;

	private UserRepository userRepository;

	@Override
	public boolean save(ReplyDTO dto) {
		Optional<TopicEntity> topic = topicRepository.findById(dto.getTopicId());
		if (!topic.isPresent()) {
			throw new IllegalArgumentException("Tried to add a reply for non-existent topic.");
		}

		UserDetails userDetails = 
			(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//System.out.println(userDetails.getUsername());
		Optional<UserEntity> user = userRepository.findByUsername(userDetails.getUsername());
		
		ReplyEntity entity = replyMapper.toEntity(dto);
		entity.setTopic(topic.get());
		entity.setUser(user.get());

		replyRepository.save(entity);
		
		// Update reply count for topic
		TopicEntity topicEntity = topic.get();
		topicEntity.setReplyCount( Long.valueOf(topic.get().getReplies().size()) );
		topicRepository.save(topicEntity);
		
		return true;
	}

	@Override
	public List<ReplyDTO> getByTopicId(Long id) {
		Optional<TopicEntity> topic = topicRepository.findById(id);
		if (!topic.isPresent()) {
			throw new IllegalArgumentException("Tried to add a reply for non-existent topic.");
		}
		
		// List<ReplyEntity> replies = topic.get().getReplies();
		// topic.get().getReplies().stream().forEach(r -> System.out.println(r.getUser().getId()));
		
		return 
			topic.get()
				.getReplies()
				.stream()
				.map(replyMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public void save(ReplyWithTopicDTO reply) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//System.out.println(userDetails.getUsername());
		Optional<UserEntity> user = userRepository.findByUsername(userDetails.getUsername());
		if (!user.isPresent()) {
			throw new IllegalArgumentException("No user found with the given ID.");
		}

		TopicEntity topicEntity = topicMapper.toEntityFromReply(reply);
		ReplyEntity replyEntity = replyMapper.toReplyWithTopicEntity(reply);
		topicEntity.setReplies(Collections.singletonList(replyEntity));
		
		// topicEntity.setReplyCount( Long.valueOf(Collections.singletonList(replyEntity).size()) );

		TopicEntity save = topicRepository.save(topicEntity);

		replyEntity.setTopic(save);
		replyEntity.setUser(user.get());

		ReplyEntity save2 = replyRepository.save(replyEntity);
	}

}