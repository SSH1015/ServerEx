package com.spring.member.service;

import java.util.List;

import com.spring.member.vo.boardVO;

public interface boardService {
	public List<boardVO> selectList()  throws Exception;
    public void insert(boardVO vo)  throws Exception;
	public boardVO view(int bno) throws Exception;
    public void update(boardVO vo) throws Exception;
	public void delete(int bno) throws Exception;
	
	//추가(응용) 게시글에 추가적인 작업- 검색, 페이지, 조회수
	public void increaseViewcnt(int bno) throws Exception; //게시글 증가
	public List<boardVO> listAll(String searchOption, String keyword) throws Exception;
}
