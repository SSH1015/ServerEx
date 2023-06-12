package com.spring.mvcboard;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.member.dao.replyDAO;
import com.spring.member.vo.replyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class replyTest {
	@Inject
	private replyDAO replydao;
	
	@Test
	public void replyInsert() throws Exception {
		replyVO replyvo = new replyVO();
		
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
