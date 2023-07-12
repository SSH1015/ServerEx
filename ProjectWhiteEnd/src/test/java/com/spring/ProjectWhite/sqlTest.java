package com.spring.ProjectWhite;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.MemberDAO;
import com.spring.domain.MemberVO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class sqlTest {
	@Inject
	private MemberDAO memberdao;
	
	/*@Test
	public void memberWrite() throws Exception {
		//batis에 선언된 SQL 참조
		//INSERT INTO member(userid, userpw, username, useremail) 
		//values (#{userid}, #{userpw}, #{username}, #{useremail})
		MemberVO membervo = new MemberVO();
		
		membervo.setUserid("okok");
		membervo.setUserpw("1234");
		membervo.setUsername("테스트");
		membervo.setUseremail("test@naver.com");
		
		memberdao.insertMember(membervo); //삽입
		System.out.println("삽입성공");*/
	
	@Test
	public void memberDelete() throws Exception {
		memberdao.deleteMember("okok");
		System.out.println("삭제성공");
	}
	
	@Test
	public void memberUpdate() throws Exception {
		//batis에 선언된 SQL 참조
		//INSERT INTO member(userid, userpw, username, useremail) 
		//values (#{userid}, #{userpw}, #{username}, #{useremail})
		MemberVO membervo = new MemberVO();
		
		membervo.setUserid("okok");
		membervo.setUserpw("2345");
		membervo.setUsername("수정");
		membervo.setUseremail("test@naver.com");
		
		memberdao.updateMember(membervo);//수정
 
	}
	
	@Test
	@Transactional
	public void memberList() throws Exception {
		List<MemberVO> list = memberdao.memberList();
		
		
		//Assert.assertTrue(user.size()>0);
		System.out.println("조회성공");
	}
	
	@Test
	public void memberView() throws Exception {
		memberdao.view("ldh900814");
		System.out.println("조회성공");
	}


	
	
	@Test
	public void checkPw() throws Exception {
		memberdao.checkPw("ldh900814", "Ehdgus233$");		
		
		System.out.println("아이디 확인성공");
	}
	
	@Test
	public void loginCheck() throws Exception {
		//batis에 선언된 SQL 참조
		//INSERT INTO member(userid, userpw, username, useremail) 
		//values (#{userid}, #{userpw}, #{username}, #{useremail})
		MemberVO membervo = new MemberVO();
		
		membervo.setUserid("ldh900814");
		membervo.setUserpw("Ehdgus233$");
		membervo.setAdmin("1");
		
		memberdao.loginCheck(membervo); 
		System.out.println("존재함 확인성공");
	}
	

}