<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/member_header.jsp" %>
    <meta charset="UTF-8">
    <title>백내장 전문병원 안내</title>
    <style>
        #map-container {
            position: absolute;
            top: 0;
            left: 0;
            height: 400px;
            width: 600px;
            z-index: 9999;
            display: none;
        }

        #map {
            height: 100%;
            width: 100%;
            border: 2px solid #ddd;
            border-radius: 4px;
        }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?key="></script>
<script>
  function showMap(latitude, longitude) {
    var mapContainer = document.getElementById('map-container');
    var map = new google.maps.Map(document.getElementById('map'), {
      center: { lat: latitude, lng: longitude },
      zoom: 14
    });

    var marker = new google.maps.Marker({
      map: map,
      position: { lat: latitude, lng: longitude },
      title: '병원 위치'
    });

    mapContainer.style.display = 'block';

    // Add event listener to hide the map when clicking on whitespace
    mapContainer.addEventListener('click', function (event) {
      if (event.target === mapContainer) {
        hideMap();
      }
    });

    // Add event listener to hide the map when pressing ESC key
    document.addEventListener('keydown', function (event) {
      if (event.key === 'Escape') {
        hideMap();
      }
    });

    function hideMap() {
      mapContainer.style.display = 'none';
    }
  }
</script>


</head>

<body>
<%@include file="../include/member_menu.jsp"%>
<!-- Work Section -->
<section id="board" class="work sections">
    <div class="container">
        <div class="row">
            <div class="main_mix_content text-center margin-top-120">
                <div class="head_title">
                    <h1>백내장 전문 병원목록</h1>
                    <form name="form1" method="post" action="${path}/board/list"></form>
                </div><!-- End of head title -->

                <form id="searchForm" method="get" action="${pageContext.request.contextPath}/eyeList/list"
                      onsubmit="list(document.getElementById('pageInput').value); return false;" style="float:right;">
                    <select name="searchOption" class="table table-hover">
                        <option value="all" ${searchOption == 'all' ? 'selected' : ''}>번호+병원명+주소</option>
                        <option value="c_name" ${searchOption == 'eye_num' ? 'selected' : ''}>번호</option>
                        <option value="c_catecode" ${searchOption == 'eye_list' ? 'selected' : ''}>병원명</option>
                        <option value="c_detail" ${searchOption == 'eye_location' ? 'selected' : ''}>주소</option>
                    </select>

                    <input name="keyword" value="${keyword}">
                    <input type="hidden" name="page" id="pageInput" value="1">
                    <button type="submit">검색</button>
                </form>
                <div id="eye-list">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>번호</th>
                            <th>병원명</th>
                            <th>주소</th>
                            <th>전화번호</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="row" items="${list}">
                            <tr>
                                <td>${row.eye_num}</td>
                                <td>
                                    <a href="javascript:void(0)" onclick="showMap(${row.eye_latitude}, ${row.eye_longitude})">
                                        ${row.eye_list}
                                    </a>
                                </td>
                                <td>${row.eye_location}</td>
                                <td>${row.eye_ringnum}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div id="map-container">
                    <div id="map"></div>
                </div>

                <div class="main_mix_content text-center margin-top-120">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <c:if test="${eyePager.curBlock > 1}">
                                <li class="page-item">
                                    <a class="page-link" href="javascript:list(1)" aria-label="First">
                                        <span aria-hidden="true">&laquo;</span>
                                        <span class="sr-only">First</span>
                                    </a>
                                </li>
                                <li class="page-item">
                                    <a class="page-link" href="javascript:list(${eyePager.prevPage})" aria-label="Previous">
                                        <span aria-hidden="true">&lt;</span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:forEach var="num" begin="${eyePager.blockBegin}" end="${eyePager.blockEnd}">
                                <c:choose>
                                    <c:when test="${num == eyePager.curPage}">
                                        <li class="page-item active">
                                            <a class="page-link" href="javascript:void(0)">${num}</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item">
                                            <a class="page-link" href="/eyeList/list?curPage=${num}">${num}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <c:if test="${eyePager.curBlock <= eyePager.totBlock}">
                                <li class="page-item">
                                    <a class="page-link" href="javascript:list(${eyePager.nextPage})" aria-label="Next">
                                        <span aria-hidden="true">&gt;</span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </li>
                                <li class="page-item">
                                    <a class="page-link" href="javascript:list(${eyePager.totPage})" aria-label="Last">
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
