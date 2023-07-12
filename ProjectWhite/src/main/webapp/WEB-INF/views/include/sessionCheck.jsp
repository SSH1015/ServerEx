<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${sessionScope.userid == null}">
	<script>
	alert("로그인 하신 후에 사용해주세요");
	location.href="${path}/login";
	
	</script>


</c:if>