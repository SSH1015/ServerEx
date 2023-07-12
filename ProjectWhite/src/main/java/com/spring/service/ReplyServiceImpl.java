package com.spring.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.ReplyDAO;
import com.spring.domain.ReplyVO;
@Service
public class ReplyServiceImpl implements ReplyService {
	//DAO를 호출해서 자료를 처리하는 목적
	@Inject
	ReplyDAO replyDao;
	
	@Override
	public java.util.List<ReplyVO> List(int bno) throws Exception {		
		return replyDao.List(bno);
	}

	@Override
	public void insert(ReplyVO vo) throws Exception {
		replyDao.insert(vo);

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
