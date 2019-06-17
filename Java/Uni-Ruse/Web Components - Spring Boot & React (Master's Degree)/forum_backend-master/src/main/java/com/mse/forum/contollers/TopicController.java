package com.mse.forum.contollers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.mse.forum.dto.TopicDTO;
import com.mse.forum.services.TopicService;
import com.mse.forum.utils.WebExceptionUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@ControllerAdvice
@RolesAllowed(value = { "ADMIN", "USER", "MODERATOR" })
@RequestMapping(path = "/topics")
public class TopicController {

	private TopicService topicService;

	@RequestMapping(method = RequestMethod.GET)
	public List<TopicDTO> getAll() {
		return topicService.getAll();
	}

	@RequestMapping(path = "/title/{title}/", method = RequestMethod.GET)
	public TopicDTO getTopicByTitle(@PathVariable String title) {
		return topicService.findByTitle(title);
	}

	@RequestMapping(path = "/id/{id}/", method = RequestMethod.GET)
	public TopicDTO getTopicById(@PathVariable Long id) {
		return topicService.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void createTopic(@RequestBody TopicDTO topic) {
		topicService.saveTopic(topic);
		return;
	}

	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		return WebExceptionUtil.build(HttpStatus.INTERNAL_SERVER_ERROR, "error", "unknonwn error occured");
	}
	
	@GetMapping("/top-3-most-replied-to")
	public List<TopicDTO> getTopThreeMostRepliedToTopics(
		@RequestParam(name="startDate", required=false) String startDateString, 
		@RequestParam(name="endDate", required=false) String endDateString) 
	{
		return topicService.getTopThreeMostRepliedToTopics(startDateString, endDateString);
	}
	
	@GetMapping("/top-3-most-viewed")
	public List<TopicDTO> getTopThreeMostViewedTopics(
		@RequestParam(name="startDate", required=false) String startDateString, 
		@RequestParam(name="endDate", required=false) String endDateString) 
	{
		return topicService.getTopThreeMostViewedTopics(startDateString, endDateString);
	}

}