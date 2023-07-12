package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.domain.MemberVO;

@Repository // 현재 클래스를 스프링에서 관리하는 dao bean으로 등록합니다.
public class MemberDAOImpl implements MemberDAO {
	//SqlSession 객체를 스프링에 생성하여 주입합니다.
	// 의존관계 주입(Dependency Injection) 느슨한 결합
	
	@Inject
	SqlSession sqlSession; // Mybatis 실행객체
	
	// 회원 목록
	@Override
	public List<MemberVO> memberList(){
		return sqlSession.selectList("member.memberList");
	}
	
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("member.insertMember", vo);
	}
	
	// 회원정보 상세조회
	@Override
	public MemberVO view(String userid) {
		return sqlSession.selectOne("member.view", userid);
	}
	
	@Override
	public void deleteMember(String userid) {
		sqlSession.delete("member.deleteMember", userid);
	}
	
	// 회원정보 수정처리
	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update("member.updateMember", vo);
		
	}
	
	// 회원정보 수정 및 삭제를 위한 비밀번호 체크
	@Override
	public boolean checkPw(String userid, String userpw) {
		boolean result = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("userpw", userpw);
		int count = sqlSession.selectOne("member.checkPw", map);
		if(count == 1) result = true;
		return result;
	}

	// 01_01.  회원 로그인 체크
	@Override
	public boolean loginCheck(MemberVO vo) {
		String name = sqlSession.selectOne("member.loginCheck", vo);
		//정상적으로 조회가 되었으면 회원이름이 존재, 조회를 실패하면 회원이름은 없음
		//return (name==null)?false:true;
		
		if(name == null) {
			return false;
		} else {
			return true;
		}
	}
	// 01_02. 회원 로그인 정보
	@Override
	public MemberVO viewMember(MemberVO vo) {
		
		return sqlSession.selectOne("member.viewMember", vo);
	
	}
	
	// 02. 회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		
	}

}
