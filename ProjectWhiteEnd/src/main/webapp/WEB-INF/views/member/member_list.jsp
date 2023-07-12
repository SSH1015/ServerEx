<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<%@ include file="../include/member_header.jsp" %> <!-- 해당파일을 연결 -->

</head>
<body>
<%@ include file="../include/member_menu.jsp" %>

        <!-- Work Section -->
        <section id="board" class="work sections">
            <div class="container">
                <div class="row">
                    <div class="main_mix_content text-center margin-top-120">
                        <div class="head_title">
                            <h1>회원 List</h1>
                        </div><!-- End of head title -->
                        
            <div class="container mt-3"> 
			  <table class="table table-hover">
			    <thead>
					<tr>
						<th style="text-align:center;">아이디</th>
						<th style="text-align:center;">이름</th>
						<th style="text-align:center;">이메일</th>
						<th style="text-align:center;">회원가입일자</th>
						<th style="text-align:center;">관리자</th>
					</tr>
						<c:forEach var="row" items="${list}">
					<tr>
						<td>${row.userid}</td>
							<!-- 회원정보 상세조회를 위해 a태그추가 -->
						<td>
							<a href="${path}/member/view?userid=${row.userid}">${row.username}</a>	
						<td>${row.useremail}</td>
						<td>${row.userregdate}</td>
						<td>${row.admin}</td>
					</tr>
			</c:forEach>
			</thead>
		</table>
	</div>

		
			

   
        <!-- START SCROLL TO TOP  -->

        <div class="scrollup">
            <a href="#"><i class="fa fa-chevron-up"></i></a>
        </div>


        <!-- jQuery -->
        <script src="assets/js/vendor/jquery-1.11.2.min.js"></script>

        <!-- jQuery Bootstrap js  -->
        <script src="assets/js/vendor/bootstrap.min.js"></script>

        <!-- jQuery easing js  -->
        <script src="assets/js/jquery.easing.1.3.js"></script>

        <!-- jQuery masonry js  -->
        <script src="assets/js/masonry/masonry.min.js"></script>
        <script type="text/javascript">
            $('.mixcontent').masonry();
        </script>

        <!-- jQuery Mixitup  -->
        <script src="assets/js/jquery.mixitup.min.js"></script>
        <script type="text/javascript">
//            jQuery('#').mixItUp({
//                selectors: {
//                    target: '.tile',
//                    filter: '.filter'
//                },
//                animation: {
//                    animateResizeContainer: false,
//                    effects: 'fade scale'
//                }
//
//            });

            //           $('.mixitupId').mixItUp();
        </script>



        <!-- jQuery plugins  -->
        <script src="assets/js/plugins.js"></script>

        <!-- jQuery Main js  -->
        <script src="assets/js/main.js"></script>
        
        
	</section>
    </body>
</html>
