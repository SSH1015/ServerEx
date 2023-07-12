package com.spring.dao;

import java.util.List;

import com.spring.domain.ReplyVO;

//댓글처리하기 위한 인터페이스
public interface ReplyDAO {
	//게시물에 해당하는 댓글 조회
	public List<ReplyVO> List(int bno)  throws Exception;
	//게시물을 등록
    public void insert(ReplyVO vo)  throws Exception;
    //게시물을 수정
    public void update(ReplyVO vo) throws Exception;
    //게시물을 삭제
	public void delete(int bno) throws Exception;
}
