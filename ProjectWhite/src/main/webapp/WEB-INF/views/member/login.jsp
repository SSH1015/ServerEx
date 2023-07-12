<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%@ include file="../include/member_header.jsp" %> <!-- 해당파일을 연결 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
		$("document").ready(function(){
				$("#btnLogin").click(function(){
					// 태그.val() : 태그에 입력된 값
					// 태그.val("값") : 태그의 값을 변경
					var userid=$("#userid").val();
					var userpw=$("#userpw").val();
					
					if(userid == ""){
						alert("아이디를 입력하세요");
						$("#userid").focus(); // 입력포커스로 이동
						return;
					}
					
					if(userpw == ""){
						alert("아이디를 입력하세요");
						$("#userpw").focus();
						return;
					} else {					
						document.form1.action="${path}/loginCheck";
						document.form1.submit();
					}
				}
				
				);
			}
			
			);

		</script> 
</head>
<body>
<%@ include file="../include/member_menu.jsp" %>

 

        <!-- Contact Section -->
        <section id="contact" class="contactus margin-top-120">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="main_contact sections">
                            <div class="head_title text-center">
                                <h1>login</h1>
                            </div>
							
							
							
                            <div class="row">
                                <div class="contact_contant">
                                    <div class="col-sm-6 col-xs-12">
                                        <div class="single_message_right_info">
                                            <ul>
                                                <li><i class="fa fa-map-marker"></i> <span>경기도 부천시 부천로 29번길 7, 12층(본관)</span></li>

                                                <li><i class="fa fa-mobile-phone"></i> <span>+82 10-2057-8903</span></li>

                                                <li><i class="fa fa-envelope-o"></i> <span>cataract@naver.com</span></li>
                                            </ul>
                                        </div>
                                    </div><!-- End of col-sm-6 -->

                                    <div class="col-sm-6 col-xs-12">
                                        <div class="single_contant_left margin-top-60">
                                            <form name="form1" method="post">
                                                <div class="form-group">
                                                    <label for="userid">id</label>
                                                    <input type="text" class="form-control" name="userid" id="userid">
                                                </div>

                                                <div class="form-group">
                                                    <label>pw</label>
                                                    <input type="password" class="form-control" name="userpw" id="userpw">
                                                </div>
												<button type="submit" id="btnLogin" class="btn btn-primary">로그인</button>
												<button type="button" class="btn btn-primary" onclick="location.href='${path}/member/write';">회원가입</button>
                                                <!--</div>--> 
                                            </form>
                                        </div>
                                    </div>
                                </div> <!-- End of messsage contant-->
                            </div>
                        </div>
                    </div>
                </div><!-- End of row -->
            </div><!-- End of container -->
        </section><!-- End of contact Section -->


        <!-- Maps Section -->
        
        <section id="maps" class="maps ">
            <div class="ourmap"></div>
        </section><!-- End of Maps Section -->




        <!-- START SCROLL TO TOP  -->

        <div class="scrollup">
            <a href="#"><i class="fa fa-chevron-up"></i></a>
        </div>

        <script src="<%=request.getContextPath() %>/resources/js/vendor/jquery-1.11.2.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/js/vendor/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/js/jquery.easing.1.3.js"></script>

        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB_ffEuRRivwAyMl_II_x0UlRZnWTHDdas"></script>
        <script src="<%=request.getContextPath() %>/resources/js/gmaps.min.js"></script>
        <script>
            var map = new GMaps({
                el: '.ourmap',
                lat: 37.48694,
                lng: 126.78298,
                scrollwheel: false,
                zoom: 15,
                zoomControl: true,
                panControl: false,
                streetViewControl: false,
                mapTypeControl: false,
                overviewMapControl: false,
                clickable: false ,
                styles: [{'stylers': [{'hue': '#000'}, {saturation: -200},
                            {gamma: 0.50}]}]
            });
            map.addMarker({
                lat: 37.48694,
                lng: 126.78298
            });

        </script>
        
        <script src="<%=request.getContextPath() %>/resources/js/plugins.js"></script>
        <script src="<%=request.getContextPath() %>/resources/js/main.js"></script>
    </body>
</html>
