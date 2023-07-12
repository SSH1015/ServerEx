package com.spring.service;

import java.util.List;

import com.spring.domain.ReplyVO;

public interface ReplyService {
	//게시물에 해당하는 댓글 조회
	public List<ReplyVO> List(int bno)  throws Exception;
	//게시물을 등록
    public void insert(ReplyVO vo)  throws Exception;
    //게시물을 수정
    public void update(ReplyVO vo) throws Exception;
    //게시물을 삭제
	public void delete(int bno) throws Exception;
}
