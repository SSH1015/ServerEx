package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.cataractDAO;
import com.spring.domain.cataractVO;

@Service
public class cataractServiceImpl implements cataractService {

		@Inject
		cataractDAO cataractDao;
		
		public List<cataractVO> cataractList(){ //여러상품의 정보를 조회
			return cataractDao.cataractList();
		}
		
		//상품 등록
		public void insertCt(cataractVO vo) { //한명의 정보를 저장
			cataractDao.insertCt(vo);									
		}

		//상품상세(수정시 필요)
		public cataractVO viewCt(int c_num) { //한명의 정보를 조회
			return cataractDao.viewCt(c_num);
		}
		
		public void updateCt(cataractVO vo) {
			cataractDao.updateCt(vo);
		}
		
		public void deleteCt(int c_num) {
			cataractDao.deleteCt(c_num);
		}
		
		//검색 분류(searchoption), 검색어(keyword)
		public List<cataractVO> listAll(int start, int end, String searchOption, String keyword){
			return cataractDao.listAll(start, end, searchOption, keyword);
		}
		
		public int countArticle(String searchOption, String keyword) {
			return cataractDao.countArticle(searchOption, keyword);
			
					
		}
}
