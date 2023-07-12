package com.spring.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.domain.cataractVO;
import com.spring.domain.eyeListVO;
import com.spring.service.Pager;
import com.spring.service.eyeListService;

@Controller
@RequestMapping("/eyeList/*")
public class eyeListController {

	@Inject
	eyeListService eyelistservice;
	
	// 백내장 관리
		@RequestMapping(value="list", method = RequestMethod.GET)
		public ModelAndView cataractList(@RequestParam(defaultValue = "eye_num") String searchOption,
		        @RequestParam(defaultValue = "") String keyword,
		        @RequestParam(defaultValue = "1") int curPage) throws Exception {
			
		    // 레코드의 갯수 계산	  
		    int count = eyelistservice.countArticle(searchOption, keyword);

		    // 페이지 나누기 관련 처리
		    Pager eyePager = new Pager(count, curPage);
		    int start = eyePager.getPageBegin() - 1;
		    int end = eyePager.getPageEnd();
		    
		    List<eyeListVO> list = eyelistservice.listAll(start, end, searchOption, keyword);
		    
		    ModelAndView mav = new ModelAndView();
		    
		    Map<String, Object> map = new HashMap<String, Object>();
		    mav.addObject("list", list); 
		    mav.addObject("count", count); 
		    mav.addObject("searchOption", searchOption);
		    mav.addObject("keyword", keyword);
		    mav.addObject("eyePager", eyePager);

		    //System.out.println("ddddd");	  
		    mav.addObject("map", map);
		    mav.setViewName("eyeList/eyelist");
		    return mav;
		}

}
