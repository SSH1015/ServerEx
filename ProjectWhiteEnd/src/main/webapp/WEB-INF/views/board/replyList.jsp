<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--공통적은 파일을 include 폴더에 넣어 두고 필요할 때마다 include로 연결해서 사용 -->
<%@ include file="../include/member_header.jsp" %> <!-- 해당파일을 연결 -->
</head>
<body>
<!-- 리플 표기  -->
<table style="width:700px">
	<c:forEach var="row" items="${list}">
		<tr>
			<td> <!-- 댓글내용 -->
				${row.replyer }
				(<fmt:formatDate value="${row.re_regdate}" pattern="yyyy-MM-dd HS:mm:ss"/>)
				<br>
				${row.replytext}
			</td>			
		<tr>
	</c:forEach>
</table>
</body>
</html>