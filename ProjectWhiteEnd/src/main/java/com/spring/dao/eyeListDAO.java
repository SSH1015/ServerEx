package com.spring.dao;

import java.util.List;


import com.spring.domain.eyeListVO;

public interface eyeListDAO {
	public List<eyeListVO> eyeList();
	
	//검색 분류(searchoption), 검색어(keyword)
		public List<eyeListVO> listAll(int start, int end, String searchOption, String keyword);
		
		public int countArticle(String searchOption, String keyword);
}
