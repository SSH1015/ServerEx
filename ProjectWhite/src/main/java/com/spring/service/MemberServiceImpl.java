package com.spring.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.spring.dao.MemberDAO;
import com.spring.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
		
		@Inject
		MemberDAO memberDao;
		
		@Override
		public List<MemberVO> memberList(){
			return memberDao.memberList();
		}
		
		@Override
		public void insertMember(MemberVO vo) {
			memberDao.insertMember(vo);
		}
		
		@Override
		public MemberVO view(String userid) {
			return memberDao.view(userid);
		}
		
		@Override
		public void deleteMember(String userid) {
			memberDao.deleteMember(userid);
			
		}
		
		// 04. 회원정보 수정처리
		@Override
		public void updateMember(MemberVO vo) {
			memberDao.updateMember(vo);
			
			
		}
		// 06. 회원정보 수정 및 삭제를 위한 비밀번호 체크
		@Override
		public boolean checkPw(String userid, String userpw) {
			return memberDao.checkPw(userid, userpw);
		}
		
		// 01_01. 회원 로그인 체크
		@Override
		public boolean loginCheck(MemberVO vo, HttpSession session) {
			System.out.println(vo.getUserid());
			System.out.println(vo.getUserpw());
			boolean result = memberDao.loginCheck(vo);
			
			if(result) { //정상적인 로그인이면
				//로그인된 회원의 정보를 읽어온다.
				MemberVO vo2 = memberDao.view(vo.getUserid());
				session.setAttribute("userid", vo2.getUserid()); //섹션영역에 아이디와 이름을 저장
				session.setAttribute("username", vo2.getUsername());
				session.setAttribute("admin", vo2.getAdmin());
			}
			return result;
			
		}
		
		@Override
		public MemberVO viewMember(MemberVO vo) {
		return memberDao.viewMember(vo);
			
		}
		
		@Override
		// 02. 회원 로그아웃
		public void logout(HttpSession session) {
			// 세션변수 개별 삭제
			// session.removeAttribute("userid");
			// 세션 정보를 초기화 시킴
			session.invalidate();
			
		}
}
