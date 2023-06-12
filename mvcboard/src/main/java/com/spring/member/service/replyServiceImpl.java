package com.spring.member.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.member.dao.replyDAO;
import com.spring.member.vo.replyVO;
@Service
public class replyServiceImpl implements replyService {
	//DAO를 호출해서 자료를 처리하는 목적
	@Inject
	replyDAO replyDao;
	
	@Override
	public java.util.List<replyVO> List(int bno) throws Exception {		
		return replyDao.List(bno);
	}

	@Override
	public void insert(replyVO vo) throws Exception {
		replyDao.insert(vo);

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
