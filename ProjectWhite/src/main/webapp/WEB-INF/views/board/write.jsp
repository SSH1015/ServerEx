<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">

<title>게시글 작성</title>
<%@ include file="../include/member_header.jsp" %> <!-- 해당파일을 연결 -->

</head>
<body>
<%@ include file="../include/member_menu.jsp" %>

<%@ include file="../include/sessionCheck.jsp" %>
        <!-- Work Section -->
        <section id="board" class="work sections">
            <div class="container">
                <div class="row">
                    <div class="main_mix_content text-center margin-top-120">
                        <div class="head_title">
                            <h1>게시판 작성</h1>
                        </div><!-- End of head title -->
                        
      <form name="form1" method="post" action="${path}/board/insert">
            <div class="container mt-3" style="width:1000px;"> 
				  <table class="table table-hover">
				    <thead>
   			 		   <tr><input type="hidden" name="writer" value="${sessionScope.userid}"></tr>
   			 		   <tr>
							<th style="text-align:center;">제목</th>
							<td><input name="title" id="title" size="80" placeholder="제목을 입력하세요"></td>
						</tr>
						<tr>
							<th style="text-align:center;">내용</th>
							<td><textarea name="content" id="content" rows="6" cols="80" placeholder="내용을 입력하세요"></textarea></td>
						</tr>
						<tr>
							<th style="text-align:center;">작성자</th>
							<td style="text-align:left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.username}</td>	
						</tr>
					</thead>
				</table>
				</div>
				<div>
					<button type="button" id="btnSave" class="btn btn-primary">확인</button>
					<button type="reset" class="btn btn-primary">취소</button>
				</div>
			</form>
           
           
           
           
           
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
        
        <script>
	$(document).ready(function(){
		$("#btnSave").click(function(){
			// var title = document.form1.title.value; ==> name 속성으로 처리할 경우
			// var content = document.form1.content.value; ==> content 속성으로 처리할 경우
			// var writer = document.form1.writer.value; ==> writer 속성으로 처리할 경우
			var title = $("#title").val();
			var content = $("#content").val();
			// var writer = $("#writer").val();
			if(title == ""){
				alert("제목을 입력하세요");
				document.form1.title.focus();
				return;
			}
			if(content == ""){
				alert("내용을 입력하세요");
				document.form1.content.focus();
				return;
			}
			/*if(writer==""){
				alert("이름을 입력하세요");
				document.form1.writer.focus();
				return;
			}*/
			document.form1.submit();
		});
		
	});
	
</script>
	</section>
    </body>
</html>
