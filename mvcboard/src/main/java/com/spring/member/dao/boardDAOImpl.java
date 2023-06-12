package com.spring.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.member.vo.boardVO;
//저장소
@Repository
public class boardDAOImpl implements boardDAO {
	//DAO 데이터베이스 접근해서 처리 SqlSession
	//빈을 주입
	//mybatis에서 제공하는 메소드를 사용 insert, update, delete, selectlist, selectone
	@Inject
	SqlSession sqlSession;
	
	String  mapper="boardMapper."; //namespace를 지정
	
	
	public List<boardVO> selectList() throws Exception{		
		return sqlSession.selectList(mapper+"selectList");
	}

	@Override
	public void insert(boardVO vo) throws Exception {
		sqlSession.insert(mapper+"insert", vo); //''안에 사용할 id

	}

	@Override
	public boardVO view(int bno) throws Exception {
		return sqlSession.selectOne(mapper+"view", bno);
	}

	@Override
	public void update(boardVO vo) throws Exception {
		sqlSession.update(mapper+"update", vo);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete(mapper+"delete", bno);

	}
	
	//조회수를 증가
	@Override
	public void increaseViewcnt(int bno) throws Exception{
		sqlSession.update(mapper+"increaseViewcnt", bno); //해당게시물의 조회수를 증가
	}

	
	//검색기능
	@Override
	public List<boardVO> listAll(String searchOption, String keyword) throws Exception{
		//2개의 변수를 batis에 전달하기 위해서 map 사용
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);

		return sqlSession.selectList(mapper+"listAll", map);
	}
}
