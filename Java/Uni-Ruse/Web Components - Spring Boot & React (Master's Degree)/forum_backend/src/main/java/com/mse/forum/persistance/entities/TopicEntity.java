package com.mse.forum.persistance.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "topics")
public class TopicEntity {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String title;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "modified_on")
	private Date modifiedOn;

	@Column(name = "views_count")
	private Long viewsCount = 0L;
	
	@Column(name = "reply_count")
	private Long replyCount = 0L;

	@OneToMany(mappedBy = "topic", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<ReplyEntity> replies;
	
	@PrePersist
	public void setDates() {
		this.modifiedOn = new Date();
		this.createdOn = new Date();
	}

	@PreUpdate
	public void updateDates() {
		this.modifiedOn = new Date();
	}

}