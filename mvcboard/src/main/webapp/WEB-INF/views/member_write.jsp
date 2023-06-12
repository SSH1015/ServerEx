<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
<!--공통적은 파일을 include 폴더에 넣어 두고 필요할 때마다 include로 연결해서 사용 -->
<%@ include file="./include/member_header.jsp" %> <!-- 해당파일을 연결 -->
</head>
<body>
<!-- 처음 실행되는 화면  -->
<!-- JSTL-if, foreach 등 자바명령어를 태그화 시켜놓은 형식 -->
<!-- EL-전달받은 변수(값)을 쉽게 처리하는 형식 $ 대괄호안에 변수명을 기재 %=변수 대신-->
<%@ include file="./include/member_menu.jsp" %> <!-- 해당파일을 연결 -->
<h2>회원 등록폼</h2>
<div class="container mt-3">
<form name="form1" method="post" action="${path}/member/write"> <!-- member_list에서 member/write사용(get) -->
    <div class="mb-3 mt-3">
      <label for="userid">아이디</label>
      <input type="text" id="userid" name="userid"></td>	
    </div>
	<div class="mb-3">
      <label for="userpw">비밀번호</label>
      <input type="text" id="userpw" name="userpw"></td>	
    </div>	
	<div class="mb-3">
      <label for="username">이름</label>
      <input type="text" id="username" name="username"></td>	
    </div>
	<div class="mb-3">
      <label for="useremail">이메일</label>
      <input type="text" id="useremail" name="usermeail"></td>	
    </div>	
	<button type="submit" class="btn btn-primary">등록</button>
	<button type="reset" class="btn btn-primary">삭제</button>

</form>
</div>
</body>
</html>