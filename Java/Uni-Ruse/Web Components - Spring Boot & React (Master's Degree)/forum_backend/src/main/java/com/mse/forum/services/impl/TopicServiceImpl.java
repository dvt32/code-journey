package com.mse.forum.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mse.forum.dto.TopicDTO;
import com.mse.forum.mappers.TopicMapper;
import com.mse.forum.persistance.TopicRepository;
import com.mse.forum.persistance.entities.TopicEntity;
import com.mse.forum.services.TopicService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TopicServiceImpl 
	implements TopicService 
{
	private TopicMapper mapper;

	private TopicRepository topicRepository;

	@Override
	public boolean saveTopic(TopicDTO dto) {
		TopicEntity entity = mapper.toEntity(dto);
		topicRepository.save(entity);
		return true;
	}

	@Override
	public List<TopicDTO> getAll() {
		return 
			topicRepository.findAll()
				.stream()
				.map( entity -> mapper.toDto(entity) )
				.collect( Collectors.toList() );
	}

	@Override
	public TopicDTO findByTitle(String title) {
		return mapper.toDto(topicRepository.findByTitle(title));
	}

	@Override
	public TopicDTO findById(Long id) {
		// Increase topic views
		TopicEntity topic = topicRepository.findById(id).get();
		topic.setViewsCount( topic.getViewsCount() + 1);
		topicRepository.save(topic);
		
		return mapper.toDto(topicRepository.findById(id).get());
	}

	@Override
	public List<TopicDTO> getTopThreeMostRepliedToTopics(String startDateString, String endDateString) {
		List<TopicEntity> listOfTopicEntities = null;
		
		if (startDateString != null && endDateString != null) {
			Date[] formattedDates = formatStartAndEndDates(startDateString, endDateString);
			Date startDate = formattedDates[0];
			Date endDate = formattedDates[1];
	        listOfTopicEntities = topicRepository.findTop3ByCreatedOnBetweenOrderByReplyCountDesc(startDate, endDate);
		}
		else {
			listOfTopicEntities = topicRepository.findTop3ByOrderByReplyCountDesc();
		}
		
		List<TopicDTO> listOfTopicDtos = mapper.toDtoList(listOfTopicEntities);
		return listOfTopicDtos;
	}

	@Override
	public List<TopicDTO> getTopThreeMostViewedTopics(String startDateString, String endDateString) {
		List<TopicEntity> listOfTopicEntities = null;
		
		if (startDateString != null && endDateString != null) {
			Date[] formattedDates = formatStartAndEndDates(startDateString, endDateString);
			Date startDate = formattedDates[0];
			Date endDate = formattedDates[1];
	        listOfTopicEntities = topicRepository.findTop3ByCreatedOnBetweenOrderByViewsCountDesc(startDate, endDate);
		}
		else {
			listOfTopicEntities = topicRepository.findTop3ByOrderByViewsCountDesc();
		}
		
		List<TopicDTO> listOfTopicDtos = mapper.toDtoList(listOfTopicEntities);
		return listOfTopicDtos;
	}

	@Override
	public Date[] formatStartAndEndDates(String startDateString, String endDateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = dateFormat.parse(startDateString);
			endDate = dateFormat.parse(endDateString);
			
			// Update time to filter data correctly using Spring Data JPA ("between" is exclusive)
			startDate.setTime( startDate.getTime() - 1000 );
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(endDate);
		    calendar.add(Calendar.DAY_OF_WEEK, 1);
		    endDate = calendar.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return new Date[] { startDate, endDate };
	}

}