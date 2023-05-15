cgi-servlet-spring-springboot

1. 서블릿-클래스로 제공(추상 클래스, 인터페이스)
2. 사용의 편의성을 위해서 동일한 이름으로 사용하고, 내용은 사용자가 작성
3. 인터페이스
  - Servlet 인터페이스 : init(), service(), destory(), - 생명주기
  					   getServletInfo, getServletConfgi()
  					   서블릿을 준비에서 사용, 종료까지를 관리
  - ServletConfig 인터페이스
  					: getInitParameter(), getInitPameterNames(),
  					  getServletContext(), getServletName()
  					  서블렛에 값을 전달
  - GenericServlet 클래스 : service()에 대한 오버라이딩
  						   사용자가 필요한 프로그램을 작성
  - HttpServlet 클래스 : doGet(), doPost()
  				        클라이언트가 요청할 때 처리하는 부분
  				        
서블릿은 한 주소가 하나의 패키지(파일)로 구성

서블릿을 사용 시 제대로 구동일 안될 때는 프로젝트 -> build path ->
configure build path->Libraries->class path->add->톰캣에 있는 서블릿 선택