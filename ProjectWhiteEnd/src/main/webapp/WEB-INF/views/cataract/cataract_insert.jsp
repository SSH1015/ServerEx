<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>백내장 정보 등록</title>
    <%@ include file="../include/member_header.jsp" %>
    
    
    
</head>
<body>
    <%@ include file="../include/member_menu.jsp"%>
    <!-- Work Section -->
        <section id="work" class="work sections margin-top-120">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="head_title text-center">
                            <h1>백내장 자가진단</h1>
                        </div><!-- End of head title -->

        <form action="${path}/cataract/insert" method="post" enctype="multipart/form-data">
       	 <div class="container mt-3"> 
				  <table class="table table-hover" style="width:550px; margin-left: auto; margin-right: auto; text-align:center;">
				    <thead>
			 		   <tr>
							<th style="text-align:center;">나이</th>
							<td style="text-align:center;"><input type="text" name="c_name" id="c_name" size="35"></td>
						</tr>
						<tr>
							<th style="text-align:center;">좌/우 시력</th>
							<td style="text-align:center;"><input type="text" name="c_catecode" id="c_catecode" size="35" ></td>
						</tr>
						<tr>
							<th style="text-align:center;">증상</th>
							<td style="text-align:center;"><textarea name="c_detail" id="c_detail" rows="4" cols="35"></textarea></td>
						</tr>
						<tr>
							<th style="text-align:center;">첨부파일</th>
							<td style="text-align:center;"><input type="file" name="file"></td>
						</tr>
						<tr>
						 	<td colspan="2" align="center" >
						 		<input type="submit" value="확인" class="btn btn-primary">
					 		</td>
				 		</tr>
					</thead>
				</table>
			</div>
		</form>
        
        






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
