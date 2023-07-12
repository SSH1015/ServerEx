<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
 
        <div class='preloader'><div class='loaded'>&nbsp;</div></div>
        <header id="main_menu" class="header navbar-fixed-top">            
            <div class="main_menu_bg">
                <div class="container">
                    <div class="row">
                        <div class="nave_menu">
                            <nav class="navbar navbar-default" id="navmenu">
                                <div class="container-fluid">
                                    <!-- Brand and toggle get grouped for better mobile display -->
                                    <div class="navbar-header">
                                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                            <span class="sr-only">Toggle navigation</span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                            <span class="icon-bar"></span>
                                        </button>
                                        <a class="navbar-brand" href="http://localhost:8080/">
                                            <img src="assets/images/cataract.png"/>
                                        </a>
                                    </div>

                                    <!-- Collect the nav links, forms, and other content for toggling -->

								
                                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                        <ul class="nav navbar-nav navbar-right">
                                        
                                        <c:choose>
											<c:when test="${sessionScope.admin == '1'}">  <!-- 관리자메뉴 -->
												<li><a href="${path}/about">백내장이란?</a></li>
						    	         	    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">백내장 자가진단</a>
									           		<ul class="dropdown-menu">
											           	<li><a href="${path}/cataract/list">백내장 자가진단</a></li>
											            <li><a href="${path}/eyeList/list">가까운 위치의 병원 찾기</a></li>
									            	</ul>
									            </li>
									            <li><a href="${path}/board/list">고객 게시판</a></li>
										    	<li><a href="${path}/member/list">회원관리</a><li>
										    	<c:set var="path" value="${pageContext.request.contextPath}"/>
										    	<li><a href="${path}/logout">로그아웃</a></li>
											</c:when>
            
                                
									        <c:when test="${sessionScope.admin == '0'}">  <!-- 회원메뉴 -->
									    		<li><a href="${path}/about">백내장이란?</a></li>
						    	         	    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">백내장 자가진단</a>
									           		<ul class="dropdown-menu">
											           	<li><a href="${path}/cataract/list">백내장 자가진단</a></li>
											            <li><a href="${path}/eyeList/list">가까운 위치의 병원 찾기</a></li>
									            	</ul>
									            </li>
												<li><a href="${path}/board/list">고객 게시판</a></li>
									          	<li><a href="${path}/member/view?userid=${sessionScope.userid}">내 정보수정</a></li>
								          		<c:set var="path" value="${pageContext.request.contextPath}"/>
									              <li><a href="${path}/logout">로그아웃</a></li>
											</c:when>
											
											 <c:otherwise>
											 <c:set var="path" value="${pageContext.request.contextPath}"/>
									            <li><a href="${path}/about">백내장이란?</a></li>
									            <li><a href="${path}/board/list">고객 게시판</a></li>
									            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">회원</a>
									                 <ul class="dropdown-menu">
									                     <li><a href="${path}/login">로그인</a></li>
									                     <li><a href="${path}/member/write">회원가입</a></li>
									                 </ul>
									            </li> 
											 
											 </c:otherwise>
										</c:choose>   
							         	
                                        
                                        
                                        
     
                                        </ul> 
                                    </div>

                                </div>
                            </nav>
                        </div>	
                    </div>

                </div>

            </div>
        </header> <!--End of header -->