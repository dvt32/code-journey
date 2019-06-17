package com.mse.forum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mse.forum.dto.TopicDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ForumApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testTopics() throws Exception {
		String body = "{\"title\": \"topic\", \"userId\": \"ivo\", \"viewsCount\": \"1\"}";
		mockMvc.perform(post("/topics").contentType("application/json").content(body)).andExpect(status().isOk());

		ResultActions andExpect = mockMvc.perform(get("/topics").accept("application/json;charset=UTF-8"))
				.andExpect(status().isOk());

		MvcResult result = andExpect.andReturn();
		String contentAsString = result.getResponse().getContentAsString();

		TopicDTO[] readValue = objectMapper.readValue(contentAsString, TopicDTO[].class);

		assertEquals(1, readValue.length);
		verifyTopic(TopicDTO.builder().userId("ivo").title("topic").viewsCount(1).build(), readValue[0]);
	}

	private void verifyTopic(TopicDTO expected, TopicDTO actual) {
		assertEquals(expected.getTitle(), actual.getTitle());
		assertEquals(expected.getUserId(), actual.getUserId());
		assertEquals(expected.getViewsCount(), actual.getViewsCount());
		assertNotNull(actual.getModifiedOn());
		assertNotNull(actual.getCreatedOn());
	}

	/*
	 * @Autowired private RepliesRepository rep;
	 * 
	 * @Autowired private TopicRepository top;
	 * 
	 * @Test public void testRelations() throws Exception { TopicEntity topic = new
	 * TopicEntity(); topic.setTitle("asd"); ReplyEntity reply = new ReplyEntity();
	 * 
	 * List<ReplyEntity> replies = Collections.singletonList(reply);
	 * 
	 * reply.setTopicId(topic); topic.setReplies(replies);
	 * 
	 * top.saveAndFlush(t);
	 * 
	 * List<TopicEntity> result = top.findAll(); List<ReplyEntity> r = result.get(0)
	 * .getReplies(); assertEquals(1, r.size());
	 * 
	 * System.out.println(); }
	 */

}