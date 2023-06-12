<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 공통으로 선언해서 사용할 라이브러리가 있는 파일 -->
<!-- JSTL 사용을 위한 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 명령어 대체 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- 국가별 설정 -->
<!-- context 경로 -->
<!-- path = xx -> set var="path" value= "xx" -->
<!-- path 변수를 선언해서 전달신호가 온 곳의 경로를 저장 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 스크립트 추가 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1"><!--반응형웹-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>	
</head>