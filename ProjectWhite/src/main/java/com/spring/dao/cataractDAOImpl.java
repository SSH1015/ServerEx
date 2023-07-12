package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.domain.cataractVO;

@Repository
public class cataractDAOImpl implements cataractDAO {
		
		@Inject
		SqlSession sqlSession;
		
		@Override
		public List<cataractVO> cataractList(){ //여러상품의 정보를 조회
			return sqlSession.selectList("cataract.CtList");
		}
		
		//상품 등록
		@Override
		public void insertCt(cataractVO vo) { //한명의 정보를 저장
			sqlSession.insert("cataract.Ctinsert", vo);
		}
		
		//상품상세(수정시 필요)
		@Override
		public cataractVO viewCt(int c_num) { //한명의 정보를 조회
			return sqlSession.selectOne("cataract.Ctview", c_num);
		}
		
		@Override
		public void updateCt(cataractVO vo) {
			sqlSession.update("cataract.CtupdateArticle", vo);
		}
		
		@Override
		public void deleteCt(int c_num) {
			sqlSession.delete("cataract.deleteArticle", c_num);
		}
		
		//검색 분류(searchoption), 검색어(keyword)
		@Override
		public List<cataractVO> listAll(int start, int end, String searchOption, String keyword){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("searchOption", searchOption);
			map.put("keyword", keyword);
			map.put("start", start);
			map.put("end", end);

			return sqlSession.selectList("cataract.listAll", map);
		}
		
		@Override
		public int countArticle(String searchOption, String keyword) {
			   Map<String, String> map = new HashMap<String, String>();
		        map.put("searchOption", searchOption);
		        map.put("keyword", keyword);
		        
				return sqlSession.selectOne("cataract.countArticle", map);
		}
		
	
}
