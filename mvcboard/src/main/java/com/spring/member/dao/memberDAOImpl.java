package com.spring.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.member.vo.MemberVO;
//느슨한 결합(연동)
//DAO Repository 어노테이션을 선언해서 데이터베이스 처리부분이라고 선언

@Repository
public class memberDAOImpl implements memberDAO {
	//DAO 데이터베이스 처리를 위해 SqlSession 이용
	@Inject
	SqlSession sqlSession;
	String mapper = "memberMapper.";
		
	public List<MemberVO> memberList() {
		//mybatis에서 제공하는 메소드 insert,update,delete,select, selectList(모두조회), selectOne(1개조회)
		
		//return sqlSession.selectList("memberMapper.memberList"); //사용할 맵퍼명과 전달할 값 
		return sqlSession.selectList(mapper+"memberList"); //사용할 맵퍼명과 전달할 값
	}
	
	
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(mapper+"memberInsert", vo); //사용할 맵퍼명과 전달할 값

	}

	@Override
	public MemberVO viewMember(String userid) {
		// ""안에는 mapper에 사용할 id 이름, userid가 전달할 값
		return sqlSession.selectOne(mapper+"memberView", userid); //1개의 값만 조회
	}
	@Override
	public void deleteMember(String userid) {
		sqlSession.delete(mapper+"memberDelete", userid);
	}
	
	public boolean checkPw(String userid, String userpw) {
		boolean result = false; //임의로 결과는 실패로 선언
		//파이썬에서 사전 (키, 값)===>Map
		//VO를 사용하지 않고 여러값을 동시에 전달
		//Map<키데이터형, 값데이터형>
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid); //Map(키이름, 값)에 추가
		map.put("userpw", userpw);
		
		int count = sqlSession.selectOne(mapper+"checkPw", map); //데이터베이스 처리
		if(count == 1) result = true;
		
		return result;
	}

	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update(mapper+"memberUpdate", vo);

	}

	//로그인 체크
	public boolean loginCheck(MemberVO vo) {
		String name = sqlSession.selectOne(mapper+"loginCheck", vo);
		//정상적으로 조회가 되었으면 회원이름이 존재, 조회를 실패하면 회원이름은 없음
		//return (name==null)?false:true;
		
		if(name == null) {
			return false;
		} else {
			return true;
		}
	}
		
	//로그아웃(불필요한 메소드는 삭제 가능)
	public void logout(HttpSession session) {
		
	}
}
