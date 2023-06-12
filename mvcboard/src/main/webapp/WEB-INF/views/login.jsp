<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
<%@ include file="./include/member_header.jsp" %> <!-- 해당파일을 연결 -->
<script>
	$("document").ready(
		function(){
			$("#btnLogin").click(
				function(){					
					var userid = $("#userid").val(); //id가 userid인 태그의 value값을 읽어온다.
					var userpw = $("#userpw").val();
					
					if(userid == ""){ //null 값이 없는 상태, "" 내용이 비어 있는 상태
						alert("아이디를 입력하세요.");
						$("#userid").focus(); //focus는 해당태그로 커서를 이동
						return; //이후작업 생략하고 종료
					}
					if(userpw == ""){
						alert("비밀번호를 입력하세요.");
						$("#userpw").focus();
						return;
					}
					document.form1.action = "${path}/loginCheck";
					document.form1.submit(); //action이 있으면 submit 동작
					
				}		
			);
			
		}		
	);
</script>
</head>
<body>
<%@ include file="./include/member_menu.jsp" %> <!-- 해당파일을 연결 -->
<h2>로그인</h2>
<div class="container mt-3">
<form name="form1" method="post" action="${path}/loginCheck"> <!-- member_list에서 member/write사용(get) -->
    <div class="mb-3 mt-3">
      <label for="userid">아이디</label>
      <input type="text" id="userid" name="userid"></td>	
    </div>
	<div class="mb-3">
      <label for="userpw">비밀번호</label>
      <input type="text" id="userpw" name="userpw"></td>	
    </div>		
	<button type="button" id="btnLogin" class="btn btn-primary">로그인</button>	
</form>
</div>
</body>
</html>