package com.spring.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.member.service.boardService;
import com.spring.member.vo.boardVO;

@Controller
@RequestMapping("board/*") //board시작하고 뒤에 상관없이(board시작하면 클래스로 진입)
public class boardController {
	@Inject
	boardService boardservice;
	
	//게시글목록
	//메소드는 다른클래스와 동일해도 상관없다.
	//맵핑은 다른클래스의 맵핑과 중복이 되면 안된다.
	//return이 존재하는 메소드는 기본을 String
	//return "페이지이동" : () 인수값에 Model 선언
	//return "redirect-매핑이동" : () 인수값에 Model 선언
	
	//페이지로부터 VO전체를 받아서 가져올 때 @ModelAttribute VO 변수명 받기
	//페이지로부터 값을 받아서 가져올 때 @Requestparam 데이터형 변수명 받기
	@RequestMapping("list")
	//                      페이지 이동
	//조회까지 포함해서 작업
	//RequestParam 값을 받아오는 역할 defaultValue 값이 없을 때 기본값
	public ModelAndView boardList(@RequestParam(defaultValue="all") String searchOption,
			@RequestParam(defaultValue="") String keyword) throws Exception {
		//boardservice.selectList() 입력값이 없으면 boardList() 없음
		ModelAndView mav = new ModelAndView();
		
		//System.out.println("searchOption:"+searchOption);
		//System.out.println("keyword:"+keyword);
		try {
		//List<boardVO> list = boardservice.selectList();
		List<boardVO> list = boardservice.listAll(searchOption, keyword);
		//System.out.println(list.size());
		//조회한 값 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);  //리스트전달
		
		mav.addObject("map", map); //map저장해서 전달
		mav.setViewName("board/list");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
		
	//게시글 등록폼
	@RequestMapping(value = "write", method=RequestMethod.GET)
	public String boardWritePage(Model model) {
		
		return "board/write";  //페이지이면 메소드(Model model)선언
	}

	//게시글 등록(데이터베이스 처리)
	@RequestMapping(value = "write", method=RequestMethod.POST)
	//                                         Model 없으면 페이지가 맵핑 이동
	public String boardWrite(@ModelAttribute boardVO vo) {
		//boardservice.insert(boardVO) 선언되어 있으면 boardWrite(@ModelAttribute boardVO)선언
		System.out.println(vo.getTitle());
		System.out.println(vo.getWriter());
		
		try {
			boardservice.insert(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:list"; //맵핑 메소드() 선언
	}
	
	//게시글 상세보기
	@RequestMapping("view")
	public String boardView(@RequestParam int bno, Model model) {
	//boardservice.view(int bno) 선언되어 있으면 boardVIew(@RequestParam int)변수별로 받기
		try {
			//조회수 증가
			boardservice.increaseViewcnt(bno);
			
			//상세 출력
			boardVO data = boardservice.view(bno);
			model.addAttribute("dto", data); //페이지에 값을 전달
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "board/view";
	}
	
	//게시글 수정(데이터베이스)
	@RequestMapping(value = "update", method=RequestMethod.POST)
	public String boardUpdate(@ModelAttribute boardVO vo, Model model) {
		
		try {
			boardservice.update(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:list";
	}
	
	//게시글 삭제(데이터베이스)
	@RequestMapping("delete")
	public String boardDelete(@RequestParam int bno) {
		try {
			boardservice.delete(bno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:list";
	}
	
	
	//-------------------------------------
	//게시글 수정(데이터베이스)
		//ModelAndView를 선언시 Model를 생략 처리
	/*	public ModelAndView boardUpdate(@ModelAttribute boardVO vo) {
			Map<String, String> map = new HashMap<String, String>
			map.put(변수명, 값); //전달값을 추가->addObjects에 저장
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName ="redirect:board/list"; //이동위치
			mav.addObjects(변수명, 전달할 값); //전달값
			
			return mav;
		} */
}
