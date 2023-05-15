/*
 * 1. 클래스에서 서블릿을 작성하고
 * 2. web.xm1에 서블릿을 등록(맵핑)시켜
 * 3. 서블릿을 구동하는 연습
 */

package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet { //Ctrl-Shift-O
	//마우스 오른쪽 버튼->Source(자동생성)->override... 서블릿 메서드
	//하나의 클래스 init()~doGet~doPost~destory() 존재
	
	//서블릿을 최초의 실행했을 때 처리되는 메서드
	//초기설정값 지정
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("최초 1회만 init 메서드 호출");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("외부에서 요청이 들어왔을 때 메서드 호출");
	}
	
	//서블릿이 소멸될 때 처리되는 메서드
	//자원을 반환
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("서블릿을 종료되기 전에 메서드 호출");
	}
	


	

}
