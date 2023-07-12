package com.spring.ProjectWhite;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dao.ReplyDAO;
import com.spring.domain.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class ReplyTest {
	@Inject
	private ReplyDAO replydao;
	
	@Test
	public void replyInsert() throws Exception {
		ReplyVO replyvo = new ReplyVO();
		
		replyvo.setBno(1);
		replyvo.setReplytext("연습용 댓글");
		replyvo.setReplyer("ccc");
		
				
		replydao.insert(replyvo);
 
	}

	@Test
	public void replyList() throws Exception {
		replydao.List(1);
	}	
		
	
}