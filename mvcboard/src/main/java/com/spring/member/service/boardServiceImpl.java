package com.spring.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.member.dao.boardDAO;
import com.spring.member.vo.boardVO;

//서비스 영역(DAO와 Controller를 연결)
//데이터베이스 작업하고 페이지연동 작업을 제외한 나머지 작업
//유틸리티 사용
@Service
public class boardServiceImpl implements boardService {
	//인터페이스 선언하면 스프링이 해당 인터페이스를 사용하는 클래스를 찾아서 자동으로 연결
	@Inject
	boardDAO boarddao;
	
	public List<boardVO> selectList() throws Exception {		
		return boarddao.selectList();
	}

	
	public void insert(boardVO vo) throws Exception {
		boarddao.insert(vo);
	}

	
	public boardVO view(int bno) throws Exception {		
		return boarddao.view(bno);
	}

	
	public void update(boardVO vo) throws Exception {
		boarddao.update(vo);
	}

	
	public void delete(int bno) throws Exception {
		boarddao.delete(bno);
	}

	//추가(응용) 게시글에 추가적인 작업- 검색, 페이지, 조회수
	public void increaseViewcnt(int bno) throws Exception{
		boarddao.increaseViewcnt(bno);
	}
	public List<boardVO> listAll(String searchOption, String keyword) throws Exception{
		return boarddao.listAll(searchOption, keyword);
	}
}
