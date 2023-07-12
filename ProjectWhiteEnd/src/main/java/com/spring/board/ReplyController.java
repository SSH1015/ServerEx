package com.spring.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.domain.ReplyVO;
import com.spring.service.ReplyService;
//상세보기 아래 댓글을 표시작업
@Controller
@RequestMapping("/reply/*") //1차폴더
public class ReplyController {
	@Inject
	ReplyService replyservice;
	
	//댓글입력
	@RequestMapping("insert")
	public void insert(@ModelAttribute ReplyVO vo, HttpSession session) throws Exception {
		System.out.println("aaaaa");
		//		현재 로그인 한 아이디기억
		String userid = (String) session.getAttribute("userid");
		vo.setReplyer(userid); //작성자에 현재 사용자 아이디를 저장
		replyservice.insert(vo); //등록작업
	}
	
	//댓글목록
	@RequestMapping("list")
	public ModelAndView list(@RequestParam int bno, ModelAndView mav) throws Exception{
		List<ReplyVO> list = replyservice.List(bno); //목록조회
		
		mav.setViewName("board/replyList"); //이동할 페이지 지정
		mav.addObject("list",list);
		return mav;
	}

}
