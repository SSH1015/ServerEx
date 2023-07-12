<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>백내장이란?</title>
<%@ include file="./include/member_header.jsp" %> <!-- 해당파일을 연결 -->
</head>
<body>
<%@ include file="./include/member_menu.jsp" %>
       
        <!-- Home Section -->
        <section id="home" class="home">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 ">
                    


        <!-- About Section -->
        <section id="aboutus" class="margin-top-120">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="head_title text-center margin-top-80">
                            <h1>백내장이란?</h1>
                        </div><!-- End of head title -->

                        <div> 
                            <div class="row">
                                <div class="col-sm-6">
                                    <div>
                                        <img src="assets/images/abbout.jpg" alt="" />
                                    </div>


                                </div>

                                <div class="col-sm-5 ">
                                    <div class="single_about">
                                        <div class="separator2"></div>
                                        <p>눈의 검은 자와 홍채 뒤에는 투명한 안구 조직인 수정체가 존재하며 눈의 주된 굴절 기관으로 작용합니다. </p>

                                        <p>눈으로 들어온 빛은 수정체를 통과하면서 굴절되어 망막에 상을 맺게 되는데, 백내장은 이러한 수정체가 혼탁해져 빛을 제대로 통과시키지 못하게 되면서 안개가 낀 것처럼 시야가 뿌옇게 보이게 되는 질환을 말합니다.  </p>

                                        <p></p>
                                        
                                        <p>백내장이 진행되면 독서 및 운전 등의 일상생활이 어려우며, 안경 등으로 시력교정이 되지 않습니다. 백내장이 있으면 안개가 낀 것처럼 사물이 흐려 보입니다. 또한 사물이 이중으로 보이거나, 멀리 있는 사람을 알아보지 못할 수 있습니다. 특히 밝은 날은 야외에서 더욱 흐리게 보이거나 눈부심이 있을 수 있습니다.</p>
										
										<div class="separator2"></div>
										
										<h5>지금 바로 백내장 자가진단 서비스를 이용해보세요.</h5>
                                        <a href="${path}/login" class="btn btn-default">get in touch</a>
                                    </div>
                                </div>

                           
        </section><!-- End of about Section -->                         


       
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
        
        <script src="resources/js/plugins.js"></script>
        <script src="resources/js/main.js"></script>

    </body>
</html>