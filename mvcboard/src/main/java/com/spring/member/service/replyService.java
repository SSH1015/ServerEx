package com.spring.member.service;

import java.util.List;

import com.spring.member.vo.replyVO;

public interface replyService {
	//게시물에 해당하는 댓글 조회
	public List<replyVO> List(int bno)  throws Exception;
	//게시물을 등록
    public void insert(replyVO vo)  throws Exception;
    //게시물을 수정
    public void update(replyVO vo) throws Exception;
    //게시물을 삭제
	public void delete(int bno) throws Exception;
}
