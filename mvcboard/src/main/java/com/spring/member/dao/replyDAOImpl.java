package com.spring.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.member.vo.replyVO;

@Repository
public class replyDAOImpl implements replyDAO {
	@Inject
	SqlSession sqlSession;
	
	String mapper = "replyMapper.";
	
	@Override
	public java.util.List<replyVO> List(int bno) throws Exception {
		return sqlSession.selectList(mapper+"listReply", bno);
	}

	@Override
	public void insert(replyVO vo) throws Exception {
		sqlSession.insert(mapper+"insertReply", vo);

	}

	@Override
	public void update(replyVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub

	}

}
