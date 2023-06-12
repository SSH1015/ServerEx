package com.spring.mvcboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.member.dao.boardDAO;
import com.spring.member.vo.MemberVO;
import com.spring.member.vo.boardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class boardTest {
	@Inject
	private boardDAO boarddao;
	
	@Test
	public void boardWrite() throws Exception {
		//batis에 선언된 SQL 참조
		//INSERT INTO member(userid, userpw, username, useremail) 
		//values (#{userid}, #{userpw}, #{username}, #{useremail})
		boardVO boardvo = new boardVO();
		
		boardvo.setTitle("게시글제목");
		boardvo.setContent("게시글내용");
		boardvo.setWriter("ccc");
				
		boarddao.insert(boardvo);
 
	}
	
	@Test
	
	public void boardList() throws Exception {
		boarddao.selectList();
		
		
		//Assert.assertTrue(user.size()>0);
		System.out.println("조회성공");
	}
	
	@Test
	public void memberView() throws Exception {
		boarddao.view(1);
		System.out.println("조회성공");
	}
	//mariaDB와 MySQL 명령어 동일, Oracle 명령어 약간 다르다.
	//필드 속성 varchar(mariaDb, MySQL) int, varchar2(Oracle), number
	@Test
	public void boardUpdate() throws Exception {
		boardVO boardvo = new boardVO();
		
		boardvo.setBno(1);
		boardvo.setTitle("수정");
		boardvo.setContent("수정내용");
		boardvo.setWriter("ccc");		
		boarddao.update(boardvo);
 
	}

	@Test
	public void memberDelete() throws Exception {
		boarddao.delete(2);
		System.out.println("삭제성공");
	}
	
	@Test
	public void increaseViewCnt() throws Exception {
		boarddao.increaseViewcnt(1);
	}
	
	@Test
	public void listAll() throws Exception {
		boarddao.listAll("all", "연습");
	}


}
