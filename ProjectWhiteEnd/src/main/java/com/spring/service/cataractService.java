package com.spring.service;

import java.util.List;

import com.spring.domain.cataractVO;

public interface cataractService {
	
	public List<cataractVO> cataractList(); //여러상품의 정보를 조회
	
	//상품 등록
	public void insertCt(cataractVO vo); //한명의 정보를 저장

	//상품상세(수정시 필요)
	public cataractVO viewCt(int c_num); //한명의 정보를 조회
	
	public void updateCt(cataractVO vo);
	
	public void deleteCt(int c_num);
	
	//검색 분류(searchoption), 검색어(keyword)
	public List<cataractVO> listAll(int start, int end, String searchOption, String keyword);
	
	public int countArticle(String searchOption, String keyword);
}
