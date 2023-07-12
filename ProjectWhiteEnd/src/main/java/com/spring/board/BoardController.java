package com.spring.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.domain.BoardVO;
import com.spring.service.BoardService;
import com.spring.service.Pager;

@Controller // 현재 클래스를 컨트롤러 빈(bean)으로 등록
@RequestMapping("/board/*")
public class BoardController {
	
	// 의존관계 주입 ->BoardServcieImpl 생성
	// IoC 의존관계 역전
	
	@Inject
	BoardService boardService;
	
	// 01. 게시글 목록
	@RequestMapping("list")
	public ModelAndView boardList(@RequestParam(defaultValue="all") String searchOption,
		 @RequestParam(defaultValue="") String keyword,
		 @RequestParam(defaultValue="1") int curPage) throws Exception{
		//boardservice.selectList() 입력값이 없으면 boardList() 없음
		// 레코드의 갯수 계산
		int count = boardService.countArticle(searchOption, keyword);
		
		// 페이지 나누기 관련 처리
		Pager boardPager = new Pager(count, curPage);
		int start = boardPager.getPageBegin()-1;
		int end = boardPager.getPageEnd();
		
		List<BoardVO> list = boardService.listAll(start, end, searchOption, keyword);
		
		//데이터를 맵에 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);  //리스트전달
		map.put("count", count); // 레코드의 갯수
		map.put("searchOption", searchOption); // 검색옵션
		map.put("keyword", keyword); // 검색키워드
		map.put("boardPager", boardPager);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map); // 맵에 저장된 데이터를 mav에 저장
		mav.setViewName("board/list"); // 뷰를 list.jsp로 설정
		
		return mav; // list.jsp로 List가 전달된다.
	}
		
	
	// 02_01. 게시글 작성화면
	// @RequestMapping("board/write.do")
	// value="", method="전송방식"
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	
	// 02_02. 게시글 작성처리
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute BoardVO vo, HttpSession session) throws Exception{
		// session에 저장된 userid를 writer에 저장
		String writer = (String)session.getAttribute("userid");
		// vo에 writer를 세팅
		vo.setWriter(writer);
		
		boardService.create(vo);
		return "redirect:list";
		
	}
	
	// 03. 게시글 상세내용 조회, 게시글 조회수 증가 처리
	// @RequestParam : get/post 방식으로 전달된 변수 1개
	// HttpSession 세션 객체
	@RequestMapping(value="view", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception{
		//조회수 증가 처리
		boardService.increaseViewcnt(bno, session);
		// 모델(데이터)+ 뷰(화면)를 함께 전달하는 객체
		ModelAndView mav = new ModelAndView();
		// 뷰의 이름
		mav.setViewName("board/view");
		// 뷰에 전달할 데이터
		mav.addObject("dto", boardService.read(bno));
		return mav;
		
	}
	
	// 04. 게시글 수정
	// 폼에서 입력한 내용들은 @ModelAttribute BoardVO vo로 전달됨
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@ModelAttribute BoardVO vo) throws Exception{
		boardService.update(vo);
		return "redirect:list";
		
	}
	// 05. 게시글 삭제
	@RequestMapping("delete")
	public String delete(@RequestParam int bno) throws Exception{
		boardService.delete(bno);
		System.out.println("삭제");
		return "redirect:list";
		
	}
	
	
	
}