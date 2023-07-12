<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
   <%@ include file="../include/member_header.jsp" %>
    <meta charset="UTF-8">
    <title>백내장 상세 정보</title>

</head>

<body>
 <%@ include file="../include/member_menu.jsp"%>
    <!-- Work Section -->
    <section id="board" class="work sections">
        <div class="container">
            <div class="row">
                <div class="main_mix_content text-center margin-top-120">
                    <div class="head_title">
                        <h1>백내장 상세정보</h1>
                        <form name="form1" method="post" action ="${path}/board/list"></form>
                    </div><!-- End of head title -->
<div class="container px-5 my-5">
    <div class="row gx-5 justify-content-center my-5">		
		<table class="table">
         	<tr>
                <th>번호</th>
                <td>${dto.c_num}</td>
            </tr>
            <tr>
                <th>백내장 사진</th>
                <td><img src="${pageContext.request.contextPath}/resources/cataract/${dto.c_img}" alt="사진" style="width: 100px; height: 100px;"></td>
            </tr>
            <tr>
                <th>백내장 명</th>
                <td>${dto.c_name}</td>
            </tr>
            <tr>
                <th>카테고리 이름</th>
                <td>${dto.c_catecode}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td>${dto.c_detail}</td>
            </tr>
            <tr>
                <th>등록일</th>
                <td><fmt:formatDate value="${dto.c_updatedate}" pattern="yyyy-MM-dd HH:mm:ss"/><td>
            </tr>
        </table>

        <button class="btn btn-primary" onclick="location.href='${path}/cataract/list'">목록으로 돌아가기</button>
    </div>
</div>
<!-- START SCROLL TO TOP  -->
        <div class="scrollup">
            <a href="#"><i class="fa fa-chevron-up"></i></a>
        </div>

        <script src="<%=request.getContextPath() %>/resources/js/vendor/jquery-1.11.2.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/js/vendor/bootstrap.min.js"></script>

        <script src="<%=request.getContextPath() %>/resources/js/jquery.easing.1.3.js"></script>
        <script src="<%=request.getContextPath() %>/resources/js/masonry/masonry.min.js"></script>
        <script type="text/javascript">
            $('.mixcontent').masonry();
        </script>

        <script src="<%=request.getContextPath() %>/resources/js/jquery.sliderPro.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function ($) {
                $('#example3').sliderPro({
                    width: 960,
                    height: 200,
                    fade: true,
                    arrows: false,
                    buttons: true,
                    fullScreen: false,
                    shuffle: true,
                    smallSize: 500,
                    mediumSize: 1000,
                    largeSize: 3000,
                    thumbnailArrows: true,
                    autoplay: false,
                    thumbnailsContainerSize: 960

                });
            });
        </script>
        <script src="<%=request.getContextPath() %>/resources/js/plugins.js"></script>
        <script src="<%=request.getContextPath() %>/resources/js/main.js"></script>
</body>
</html>

