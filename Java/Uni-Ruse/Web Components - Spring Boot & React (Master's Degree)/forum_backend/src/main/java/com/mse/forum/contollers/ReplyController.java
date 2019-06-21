package com.mse.forum.contollers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mse.forum.dto.ReplyDTO;
import com.mse.forum.dto.ReplyWithTopicDTO;
import com.mse.forum.services.ReplyService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/replies")
@RolesAllowed(value = { "ADMIN", "USER", "MODERATOR" })
public class ReplyController {

	private ReplyService replyService;

	@RequestMapping(
		method = RequestMethod.POST, 
		consumes = "application/json"
	)
	public void createReply(@RequestBody ReplyDTO reply) {
		replyService.save(reply);
	}

	@RequestMapping(
		path = "/reply-with-topic", 
		method = RequestMethod.POST, 
		consumes = "application/json"
	)
	public void createReplyWithTopic(@RequestBody ReplyWithTopicDTO reply) {
		replyService.save(reply);
	}

	@RequestMapping(
		path = "/id/{id}/", 
		method = RequestMethod.GET
	)
	public List<ReplyDTO> getRepliesByTopic(@PathVariable Long id) {
		return replyService.getByTopicId(id);
	}

}