package com.mse.forum.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicDTO {

	private Long id;
	private String title;
	private String userId;
	private Date createdOn;
	private Date modifiedOn;
	private long viewsCount;
	private long replyCount;

}