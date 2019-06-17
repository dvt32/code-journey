package com.mse.forum.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This object will be used to create a reply with the connected topic.
 * 
 * @author ivo.rusev
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyWithTopicDTO {

	private String title;
	private Long topicId;
	private String replyContent;
	private Date createdOn;
	private Date modifiedOn;
	private Long userId;

}