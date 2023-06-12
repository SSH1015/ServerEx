package com.spring.member.controller;

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

import com.spring.member.service.memberService;
import com.spring.member.vo.MemberVO;

//servlet doGet(request,response), doPost 메소드를 사용
//Spring에서 doGet, doPost 사용 않하고, 일반메소드에 어노테이션을 연결사용
//컨트롤영역 어노테이션 선언 -View와 연결
@Controller
public class memberController {
	@Inject
	memberService memberservice;
	
	//요청에 따른 페이지연결 RequestMapping 어노테이션으로 연결
	//RequestMapping("맵핑주소"),RequestMapping(value="맵핑주소", method=RequestMethod.GET/POST)
	@RequestMapping("member/list") //menu.jsp에 연결
	public String memberList(Model model) { //Model 앞페이지의 정보
		//목록을 조회를 해서 전달
		List<MemberVO> list = memberservice.memberList();
		model.addAttribute("list", list); //member_list.jsp에 items에 선언된 이름과 동일
		
		return "member_list";
	}
	
	@RequestMapping("member/write")
	public String memberwriteView() { //Model 앞페이지의 정보
		
		return "member_write";
	}
	
	//ModelAttribute : View에서 값을 전달받을 때(request)
	@RequestMapping(value="member/write", method=RequestMethod.POST)
	public String memberInsert(@ModelAttribute MemberVO vo) { //Model 앞페이지의 정보
		//서비스로 저장작업
				
		memberservice.insertMember(vo); //서버스를 통해 회원등록
		
		return "redirect:/member/list";  //목록으로 이동
	}
	
	//member_list.jsp->a href="member/view" 선언한 내용과 동일
	//userid 인수값, model-화면처리가 필요하면
	@RequestMapping("member/view") 
	public String memberView(String userid, Model model) {
		//페이지 연결 환인 후
		//서비스 연결(값을 전달시 addAttribute)
		//dto = member_view.jsp value에 {dto.userio}
		model.addAttribute("dto", memberservice.viewMember(userid)); //session영역에 저장
		
		return "member_view";
	}
	
	@RequestMapping(value="member/update", method=RequestMethod.POST)
	public String memberUpdate(@ModelAttribute MemberVO vo) {
		//서비스 연결
		memberservice.updateMember(vo);
		//return "페이지이름"
		//맵핑이 존재해서 맵핑으로 이동
		return "redirect:/member/list";
	}

	//RequestParam을 이용해서 전달받은 값의 일부분 추출해서 사용이 가능
	@RequestMapping(value="member/delete", method=RequestMethod.POST)
	public String memberDelete(@RequestParam String userid, @RequestParam String userpw, Model model) {
		//아이디와 비밀번호 확인
		boolean result = memberservice.checkPw(userid, userpw);
		//정상이면 삭제, 비정상적이면 목록으로 이동
		if(result) { //참이면(아이디와 비밀번호가 맞으면)
			memberservice.deleteMember(userid); //삭제처리
			return "redirect:/member/list";
		} else {
			model.addAttribute("message", "비밀번호 불일치");
			
			model.addAttribute("dto", memberservice.viewMember(userid)); //회원조회
			return "member_view"; //member_view.jsp에 전달
		}			
	}
	
	@RequestMapping("login")
	public String login() {
		return "login";
			
	}
	
	//Model 데이터값을 주고받기 위해서 Model영역에 HttpSession 사용
	//Model과 유사한 ModelAndView
	@RequestMapping("loginCheck")
	public ModelAndView loginCheck(@ModelAttribute MemberVO vo, HttpSession session) {
		boolean result = memberservice.loginCheck(vo, session);
		
		ModelAndView mav = new ModelAndView(); //전달할 페이지의 정보
		if(result == true) {  //if(result)
			mav.setViewName("main"); //home.jsp로 이동
			mav.addObject("msg", "success"); //addAttribute와 동일
		} else { //로그인 실패
			mav.setViewName("login"); //home.jsp로 이동
			mav.addObject("msg", "failure"); //addAttribute와 동일			
		}
		return mav;
			
	}
	
	@RequestMapping("loginout")
	public ModelAndView loginout(HttpSession session) {
		//session.invalidate();
		memberservice.logout(session); //섹션값을 제거
		
		ModelAndView mav = new ModelAndView(); //전달할 페이지의 정보
		
		mav.setViewName("login"); //home.jsp로 이동
		mav.addObject("msg", "logout"); //addAttribute와 동일			
		
		return mav;
			
	}
	
}
