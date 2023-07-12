<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>백내장 목록</title>
    <%@ include file="../include/member_header.jsp" %>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function list(page) {
            document.getElementById("pageInput").value = page;
            document.getElementById("searchForm").submit();
        }
    </script>
    <style>
        .btn-group {
            margin-bottom: 10px;
        }
        .btn-group .btn {
            margin-right: 10px;
        }
        .search-button {
            padding: 5px 10px;
            font-size: 14px;
        }
    </style>
 
</head>
<body>
    <%@ include file="../include/member_menu.jsp"%>
    <!-- Work Section -->
    <section id="board" class="work sections">
        <div class="container">
            <div class="row">
                <div class="main_mix_content text-center margin-top-120">
                    <div class="head_title">
                        <h1>백내장 자가진단</h1>
                        <form name="form1" method="post" action ="${path}/board/list"></form>
                    </div><!-- End of head title -->
	

	
 						<div class="btn-group" style="float: right; ">                        
                        	 <input type="submit" class="btn btn-primary" value="백내장 정보 등록" onclick="location.href='${pageContext.request.contextPath}/cataract/insert'">
                        </div>
                        
                        	
                        <div id="container mt-3">
                            <table class="table table-hover" width="1100">
                                <thead>
                                    <tr>
                                        <th style="text-align:center;">번호</th>
                                        <th style="text-align:center;">사진</th>
                                        <th style="text-align:center;">나이</th>
                                        <th style="text-align:center;">좌/우 시력</th>
                                        <th style="text-align:center;">증상</th>
                                        <th style="text-align:center;">작성날짜</th>
                                        <th style="text-align:center;">판정결과</th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="row" items="${list}">
                                        <tr>
                                            <td style="vertical-align: middle;"><a href="${pageContext.request.contextPath}/cataract/view?c_num=${row.c_num}">${row.c_num}</a></td>
                                            <td style="vertical-align: middle;"><img src="https://eyetext.s3.ap-northeast-2.amazonaws.com/${row.c_img}" alt="사진" style="width: 100px; height: 100px;"></td>
                                            <td style="vertical-align: middle;">${row.c_name}</td>
                                            <td style="vertical-align: middle;">${row.c_catecode}</td>
                                            <td style="vertical-align: middle;">${row.c_detail}</td>
                                            <!--<td><fmt:formatDate value="${row.c_updatedate}" pattern="yyyy-MM-dd HH:mm:ss"/><td>-->
                                            <td style="vertical-align: middle;">${row.c_regdate}</td> 
                                       

									
                                         	<td style="vertical-align: middle;">
                                            	<c:if test="${cata == '0'}">
									            백내장이 의심됩니다.<br>
									            "가까운 병원찾기"로 이동하여 치료를 권장합니다.
									            </c:if>
									            <c:if test="${cata == '1'}">
									            정상입니다. 눈 건강관리를 잘 하셨습니다!
									            </c:if>
									      	</td>
                                        </tr>
                          	          </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        
                        
                       

                        <form id="searchForm" method="get" action="${pageContext.request.contextPath}/cataract/list" onsubmit="list(document.getElementById('pageInput').value); return false;" style="float: right;">
                            <select name="searchOption" class="search-option">
                                <option value="all" ${searchOption == 'all' ? 'selected' : ''}>백내장 이름+카테고리+내용</option>
                                <option value="c_name" ${searchOption == 'c_name' ? 'selected' : ''}>백내장 이름</option>
                                <option value="c_catecode" ${searchOption == 'c_catecode' ? 'selected' : ''}>카테고리</option>
                                <option value="c_detail" ${searchOption == 'c_detail' ? 'selected' : ''}>내용</option>
                            </select>
                            <input name="keyword" value="${keyword}">
                            <button type="submit">검색</button>
                            <input type="hidden" name="page" id="pageInput" value="1">
                        </form>
						
						
                        <div class="main_mix_content text-center margin-top-120">
                            <nav aria-label="Page navigation">
                                <ul class="pagination">
                                    <c:if test="${cataractPager.curBlock > 1}">
                                        <li class="page-item">
                                            <a class="page-link" href="javascript:list(1)" aria-label="First">
                                                <span aria-hidden="true">&laquo;</span>
                                                <span class="sr-only">First</span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link" href="javascript:list(${cataractPager.prevPage})" aria-label="Previous">
                                                <span aria-hidden="true">&lt;</span>
                                                <span class="sr-only">Previous</span>
                                            </a>
                                        </li>
                                    </c:if>
                                    <c:forEach var="num" begin="${cataractPager.blockBegin}" end="${cataractPager.blockEnd}">
                                        <c:choose>
                                            <c:when test="${num == cataractPager.curPage}">
                                                <li class="page-item active">
                                                    <a class="page-link" href="javascript:void(0)">${num}</a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="page-item">
                                                    <a class="page-link" href="/cataract/list?curPage=${num}">${num}</a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <c:if test="${cataractPager.curBlock <= cataractPager.totBlock}">
                                        <li class="page-item">
                                            <a class="page-link" href="javascript:list(${cataractPager.nextPage})" aria-label="Next">
                                                <span aria-hidden="true">&gt;</span>
                                                <span class="sr-only">Next</span>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a class="page-link" href="javascript:list(${cataractPager.totPage})" aria-label="Last">
                                                <span aria-hidden="true">&raquo;</span>
                                                <span class="sr-only">Last</span>
                                            </a>
                                        </li>
                                    </c:if>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>




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
