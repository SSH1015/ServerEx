<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--공통적은 파일을 include 폴더에 넣어 두고 필요할 때마다 include로 연결해서 사용 -->
<%@ include file="../include/member_header.jsp" %> <!-- 해당파일을 연결 -->
<script>
	$("document").ready(
		function(){ //버튼을 눌렀는지 확인
			$("#btnWrite").click(
				function(){
					location.href = "${path}/board/write"; //해당페이지로 이동
				}		
			); //클릭했을 때
		}		
	
	);
</script>
</head>
<body>
<!-- 처음 실행되는 화면  -->
<!-- JSTL-if, foreach 등 자바명령어를 태그화 시켜놓은 형식 -->
<!-- EL-전달받은 변수(값)을 쉽게 처리하는 형식 $ 대괄호안에 변수명을 기재 %=변수 대신-->
<%@ include file="../include/member_menu.jsp" %> <!-- 해당파일을 연결 -->

<!-- TODO: 검색기능을 추가 -->
<form name="form1" method="post" action="${path}/board/list">
	<select name="searchOption">
		<option value="all">제목+이름</option>
		<option value="title">제목</option>
		<option value="writer">이름</option>
	</select>
	<input name="keyword">
	<input type="submit" value="검색">
</form>
<!-- TODO: 글쓰기 버튼(스크립트를 통해서 board/write 연결) -->
<button type="button" id="btnWrite">글쓰기</button><br>
<!-- TODO: 게시물 목록 -->
<table border="1" width="600px">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>이름</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="row" items="${map.list }"> <!-- 조회한 내용을 출력 -->
		<tr>
			<td>${row.bno }</td>  <!-- var에 선언한 변수와 boardVO에 변수를 조합해서 -->
			
			<!-- 추가 : 로그인 상세페이지 이동가능, 비로그인시 목록확인 -->
			<!-- 제목옆에 () 조회수를 추가 -->
			<c:choose>
				<c:when test="${sessionScope.userid==null }">
					<td>${row.title }</td> <!-- 제목을 클릭하면 상세페이지로 이동 -->
				</c:when>
				<c:otherwise>
				
					<td><a href="${path}/board/view?bno=${row.bno}">${row.title }</a></td> <!-- 제목을 클릭하면 상세페이지로 이동 -->
				</c:otherwise>
			</c:choose>
			<td>${row.writer }</td>
			<td><fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>${row.viewcnt }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>