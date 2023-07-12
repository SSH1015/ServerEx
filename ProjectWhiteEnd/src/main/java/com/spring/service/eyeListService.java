package com.spring.service;

import java.util.List;


import com.spring.domain.eyeListVO;

public interface eyeListService {
	public List<eyeListVO> eyeList();
	
	//검색 분류(searchoption), 검색어(keyword)
		public List<eyeListVO> listAll(int start, int end, String searchOption, String keyword);
		
		public int countArticle(String searchOption, String keyword);
	
}
