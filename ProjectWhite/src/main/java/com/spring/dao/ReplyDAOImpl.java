package com.spring.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	@Inject
	SqlSession sqlSession;
	
	
	@Override
	public java.util.List<ReplyVO> List(int bno) throws Exception {
		return sqlSession.selectList("reply.listReply", bno);
	}

	@Override
	public void insert(ReplyVO vo) throws Exception {
		sqlSession.insert("reply.insertReply", vo);

	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub

	}

}