<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 내용</title>
<!--공통적은 파일을 include 폴더에 넣어 두고 필요할 때마다 include로 연결해서 사용 -->
<%@ include file="../include/member_header.jsp" %> <!-- 해당파일을 연결 -->
</head>

<body>
<%@ include file="../include/member_menu.jsp" %>
	
        <!-- Service Section -->
        <section id="work" class="work sections margin-top-120">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="head_title text-center">
                            <h1>회원 상세 내용</h1>
                        </div><!-- End of head title -->
  	
			<form name="form1" method="post">
				 <div class="container mt-3" style="width:500px;"> 
				  <table class="table table-hover">
				    <thead>
			 		   <tr>
							<th style="text-align:center;">아이디</th>
							<td><input type="text" name="userid" value="${dto.userid}" readonly="readonly"></td>
						</tr>
						<tr>
							<th style="text-align:center;">비밀번호</th>
							<td><input type="password" name="userpw" id="userpw" value="${dto.userpw}"></td>
						</tr>
						<tr>
							<th style="text-align:center;">이름</th>
							<td><input type="text" name="username" value="${dto.username}"></td>
						</tr>
						<tr>
							<th style="text-align:center;">이메일</th>
							<td><input type="email" name="useremail"  id="useremail" value="${dto.useremail}"></td>
						</tr>
						<tr>
							<th style="text-align:center;">회원가입일자</th>
							<td>
							<fmt:formatDate value="${dto.userregdate}" pattern="yyyy-MM-dd"/>
							</td>
						</tr>
						<tr>
							<th style="text-align:center;">회원정보수정</th>
							<td>
							<fmt:formatDate value="${dto.userupdatedate}" pattern="yyyy-MM-dd"/>
							</td>
						</tr>
						<tr>
						 	<td colspan="2" align="center">
						 		<input type="button" value="수정" id="btnUpdate" class="btn btn-primary">
						 		<input type="button" value="삭제" id="btnDelete" class="btn btn-primary">
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
       $(document).on("click", "#btnUpdate", function() {
           var userpw = $("#userpw").val();
           var useremail = $("#useremail").val();
           //var writer = $("#writer").val();
           if (userpw == "") {
               alert("비밀번호를 입력하세요");
               document.form1.title.focus();
               return;
           }
           if (useremail == "") {
               alert("이메일을 입력하세요");
               document.form1.content.focus();
               return;
           }
          if(confirm("수정하시겠습니까?")) {
				//메세지창 alert("aa") - if ~ else ~ 사용할 때 정확한 처리위치 확인
				//문서에 form1 id에 action을 지정
				document.form1.action = "${path}/member/update";
				//form1 id를 submit 처리
				document.form1.submit();
			}

           document.form1.action = "${path}/member/update";
           // 폼에 입력한 데이터를 서버로 전송
           document.form1.submit();
       });
        
       function update() {
    	    var userpw = $("#userpw").val();
            var useremail = $("#useremail").val();
    	    if (userpw == "") {
                alert("비밀번호를 입력하세요");
    	        document.form1.title.focus();
    	        return;
    	    }
    	    
    	    if (useremail == "") {
                alert("이메일을 입력하세요");
    	        document.form1.content.focus();
    	        return;
    	    }
    	    
    	    

    	    document.form1.action = "${path}/member/update";
    	    // 폼에 입력한 데이터를 서버로 전송
    	    document.form1.submit();
    	};

	
	
	
	$("document").ready(		
			function() { //메소드 생성
				//btnUpdate id를 가지고 있는 버튼을 클릭했을 때
				$("#btnDelete").click(					
					function(){
						if(confirm("삭제하시겠습니까?")) {
							//메세지창 alert("aa") - if ~ else ~ 사용할 때 정확한 처리위치 확인
							//문서에 form1 id에 action을 지정
							document.form1.action = "${path}/member/delete";
							//form1 id를 submit 처리
							document.form1.submit();
						}
					}
				
				);
			}	
		);	
	
</script>

</body>
</html>