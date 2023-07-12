package com.spring.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.domain.MemberVO;
import com.spring.service.MemberService;

@Controller // 현재 클래스를 스프링에서 관리하는 컨트롤러 bean으로 생
public class MemberController {
	// 로깅을 위한 변수
	// private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;
	
	// 01. 회원 목록
	@RequestMapping("member/list")
	public String memberList(Model model) {
		List<MemberVO> list = memberService.memberList();
		model.addAttribute("list", list);
		return "member/member_list";
	}
	
	// 02_01 회원 등록 페이지로 이동
	@RequestMapping("member/write")
	public String memberWrite() {
		return "member/member_write";
	}
	
	// 02_02 회원등록 처리 후 ==> 회원 목록으로 리다이렉트
	// @ModelAttribute에 폼에서 입력한 데이터가 저장된다
	@RequestMapping("member/insert")
	public String memberInsert(@ModelAttribute MemberVO vo) {
		memberService.insertMember(vo);
		return "redirect:/login";
	}
	
	@RequestMapping("member/view") 
	public String View(String userid, Model model) {
		//페이지 연결 환인 후
		//서비스 연결(값을 전달시 addAttribute)
		//dto = member_view.jsp value에 {dto.userio}
		model.addAttribute("dto", memberService.view(userid)); //session영역에 저장
		
		return "member/member_view";
	}
	
	// 회원정보 수정처리
	@RequestMapping(value="member/update", method=RequestMethod.POST)
	public String memberUpdate(@ModelAttribute MemberVO vo) {
		//서비스 연결
		memberService.updateMember(vo);
		//return "페이지이름"
		//맵핑이 존재해서 맵핑으로 이동
		return "redirect:/";
	}
			
		// 회원정보 삭제처리
	@RequestMapping(value="member/delete", method=RequestMethod.POST)
	public String memberDelete(@RequestParam String userid, @RequestParam String userpw, Model model, HttpSession session) {
		//아이디와 비밀번호 확인
	boolean result = memberService.checkPw(userid, userpw);
	//정상이면 삭제, 비정상적이면 목록으로 이동
	if(result) { //참이면(아이디와 비밀번호가 맞으면)
		memberService.deleteMember(userid); //삭제처리
		return "redirect:/";
	} else {
		model.addAttribute("message", "비밀번호 불일치");
		model.addAttribute("dto", memberService.view(userid)); //회원조회
		session.invalidate();
		return "member/member_view"; //member_view.jsp에 전달
	}			
		
	}
	
	
	// 01. 로그인 화면
	@RequestMapping("login")
	public String login() {
		return "member/login";  // views/member/login.jsp로 포워
	}
	
	// 02. 로그인 처리
	@RequestMapping("loginCheck")
	public ModelAndView loginCheck(@ModelAttribute MemberVO vo, HttpSession session) {
		boolean result = memberService.loginCheck(vo, session);
		
		ModelAndView mav = new ModelAndView(); //전달할 페이지의 정보
		if(result == true) {  //if(result)
			mav.setViewName("main"); //home.jsp로 이동
			mav.addObject("msg", "success"); //addAttribute와 동일
		
		} else { //로그인 실패
			mav.setViewName("member/login"); //home.jsp로 이동
			mav.addObject("msg", "failure"); //addAttribute와 동일			
		}
		return mav;
			
	}
	
	
	// 03 로그아웃 처리
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("msg", "logout");
		return mav;
	}
	
	@RequestMapping("about")
	public String about() {
		return "about";
	}
}
