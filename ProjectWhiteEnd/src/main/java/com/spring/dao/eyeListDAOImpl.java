package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.domain.cataractVO;
import com.spring.domain.eyeListVO;

@Repository
public class eyeListDAOImpl implements eyeListDAO {
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<eyeListVO> eyeList(){
		return sqlSession.selectList("eye.eyeList");
	}
	
	@Override
	public List<eyeListVO> listAll(int start, int end, String searchOption, String keyword){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);

		return sqlSession.selectList("eye.listAll", map);
	}
	
	@Override
	public int countArticle(String searchOption, String keyword) {
		   Map<String, String> map = new HashMap<String, String>();
	        map.put("searchOption", searchOption);
	        map.put("keyword", keyword);
	        
			return sqlSession.selectOne("eye.countArticle", map);
	}

}