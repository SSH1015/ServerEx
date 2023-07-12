package com.spring.ProjectWhite;


import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dao.BoardDAO;
import com.spring.domain.BoardVO;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class boardTest {
	
	@Inject
	private BoardDAO BoardDao;
	
	/*@Test
	public void boardWrite() throws Exception {
		//batis에 선언된 SQL 참조
		//INSERT INTO member(userid, userpw, username, useremail) 
		//values (#{userid}, #{userpw}, #{username}, #{useremail})
		BoardVO boardvo = new BoardVO();
		
		
		boardvo.setTitle("안녕하세요");
		boardvo.setContent("제목입니다");
		boardvo.setWriter("글쓴입니다");
				
		BoardDao.create(boardvo);*/


	@Test
	
	public void boardList() throws Exception {
		BoardDao.read(1);
		
		
		//Assert.assertTrue(user.size()>0);
		System.out.println("조회성공");
	}
	
	@Test
	public void boardUpdate() throws Exception {
		BoardVO boardvo = new BoardVO();
		
		boardvo.setBno(30);
		boardvo.setTitle("하이");
		boardvo.setContent("수정할거야?");
		boardvo.setWriter("ccc");		
		BoardDao.update(boardvo);
 
	}

	@Test
	public void memberDelete() throws Exception {
		BoardDao.delete(31);
		System.out.println("삭제성공");
	}
	
}