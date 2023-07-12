package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.eyeListDAO;
import com.spring.domain.cataractVO;
import com.spring.domain.eyeListVO;

@Service
public class eyeListServiceImpl implements eyeListService {

	@Inject
	eyeListDAO eyeListDao;
	
	@Override
	public List<eyeListVO> eyeList(){
		return eyeListDao.eyeList();
	}
	
	//검색 분류(searchoption), 검색어(keyword)
	@Override
	public List<eyeListVO> listAll(int start, int end, String searchOption, String keyword){
		return eyeListDao.listAll(start, end, searchOption, keyword);
	}
	
	@Override
	public int countArticle(String searchOption, String keyword) {
		return eyeListDao.countArticle(searchOption, keyword);

}
}
