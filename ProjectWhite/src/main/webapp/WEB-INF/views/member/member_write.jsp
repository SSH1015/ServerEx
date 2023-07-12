<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
                            <h1>회원가입</h1>
                        </div><!-- End of head title -->
  	
			<form name="form1" method="post" action="${path}/member/insert">
				 <div class="container mt-3" style="width:500px;"> 
				  <table class="table table-hover">
				    <thead>
			 		   <tr>
							<th style="text-align:center;">아이디</th>
							<td><input type="text" name="userid" id="userid"></td>
						</tr>
						<tr>
							<th style="text-align:center;">비밀번호</th>
							<td><input type="password" name="userpw" id="userpw" ></td>
						</tr>
						<tr>
							<th style="text-align:center;">이름</th>
							<td><input type="text" name="username" id="username"></td>
						</tr>
						<tr>
							<th style="text-align:center;">이메일</th>
							<td><input type="email" name="useremail"  id="useremail"></td>
						</tr>
						<tr>
						 	<td colspan="2" align="center">
						 		<input value="확인" id="btnUpdate" class="btn btn-primary">
						 		<input type="reset" value="취소" class="btn btn-primary">
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
           var userid = $("#userid").val();
           var userpw = $("#userpw").val();
           var username = $("#username").val();
           var useremail = $("#useremail").val();
           //var writer = $("#writer").val();
           if (userid == "") {
               alert("아이디를 입력하세요");
               document.form1.title.focus();
               return;
           }
           if (userpw == "") {
               alert("비밀번호를 입력하세요");
               document.form1.content.focus();
               return;
           }
           if (username == "") {
               alert("이름을 입력하세요");
               document.form1.content.focus();
               return;
           }
           if (useremail == "") {
               alert("이메일을 입력하세요");
               document.form1.content.focus();
               return;
           }
          if(confirm("회원가입 하시겠습니까?")) {
				//메세지창 alert("aa") - if ~ else ~ 사용할 때 정확한 처리위치 확인
				//문서에 form1 id에 action을 지정
				document.form1.action = "${path}/member/insert";
				//form1 id를 submit 처리
				document.form1.submit();
			}

           document.form1.action = "${path}/member/insert";
           // 폼에 입력한 데이터를 서버로 전송
           document.form1.submit();
       });
        
       function update() {
    	   var userid = $("#userid").val();
           var userpw = $("#userpw").val();
           var username = $("#username").val();
           var useremail = $("#useremail").val();
           if (userid == "") {
               alert("아이디를 입력하세요");
               document.form1.title.focus();
               return;
           }
           if (userpw == "") {
               alert("비밀번호를 입력하세요");
               document.form1.content.focus();
               return;
           }
           if (username == "") {
               alert("이름을 입력하세요");
               document.form1.content.focus();
               return;
           }
           if (useremail == "") {
               alert("이메일을 입력하세요");
               document.form1.content.focus();
               return;
           }
    	    

    	    document.form1.action = "${path}/member/insert";
    	    // 폼에 입력한 데이터를 서버로 전송
    	    document.form1.submit();
    	};

	
	
</script>

</body>
</html>