package com.spring.mvcboard;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.member.dao.memberDAO;
import com.spring.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class sqlTest {
	@Inject
	private memberDAO memberdao;
	
	@Test
	public void memberWrite() throws Exception {
		//batis에 선언된 SQL 참조
		//INSERT INTO member(userid, userpw, username, useremail) 
		//values (#{userid}, #{userpw}, #{username}, #{useremail})
		MemberVO membervo = new MemberVO();
		
		membervo.setUserid("test1");
		membervo.setUserpw("1234");
		membervo.setUsername("테스트");
		membervo.setUseremail("test@naver.com");
		
		memberdao.insertMember(membervo); //삽입
 
	}
	
	@Test
	@Transactional
	public void memberList() throws Exception {
		List<MemberVO> user = memberdao.memberList();
		
		
		//Assert.assertTrue(user.size()>0);
		System.out.println("조회성공");
	}
	
	@Test
	public void memberView() throws Exception {
		memberdao.viewMember("test");
		System.out.println("조회성공");
	}
	//mariaDB와 MySQL 명령어 동일, Oracle 명령어 약간 다르다.
	//필드 속성 varchar(mariaDb, MySQL) int, varchar2(Oracle), number
	@Test
	public void memberUpdate() throws Exception {
		//batis에 선언된 SQL 참조
		//INSERT INTO member(userid, userpw, username, useremail) 
		//values (#{userid}, #{userpw}, #{username}, #{useremail})
		MemberVO membervo = new MemberVO();
		
		membervo.setUserid("test1");
		membervo.setUserpw("2345");
		membervo.setUsername("수정");
		membervo.setUseremail("test@naver.com");
		
		memberdao.updateMember(membervo);//수정
 
	}

	@Test
	public void memberDelete() throws Exception {
		memberdao.deleteMember("test1");
		System.out.println("삭제성공");
	}
	
	@Test
	public void checkPw() throws Exception {
		memberdao.checkPw("ccc", "1234");		
		
		System.out.println("아이디 확인성공");
	}
	
	@Test
	public void loginCheck() throws Exception {
		//batis에 선언된 SQL 참조
		//INSERT INTO member(userid, userpw, username, useremail) 
		//values (#{userid}, #{userpw}, #{username}, #{useremail})
		MemberVO membervo = new MemberVO();
		
		membervo.setUserid("ccc");
		membervo.setUserpw("1234");
		memberdao.loginCheck(membervo); 
	}	
	

}
