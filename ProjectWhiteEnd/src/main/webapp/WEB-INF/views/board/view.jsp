<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세내용</title>
<!--공통적은 파일을 include 폴더에 넣어 두고 필요할 때마다 include로 연결해서 사용 -->
<%@ include file="../include/member_header.jsp" %> <!-- 해당파일을 연결 -->

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
$(document).ready(function() {
	listReply(); // ** json 리턴방식
    

    $("#btnReply").click(function(){
        var replytext=$("#replytext").val();
        var bno="${dto.bno}"
        var param="replytext="+replytext+"&bno="+bno;
        $.ajax({                
            type: "post",
            url: "${path}/reply/insert",
            data: param,
            complete: function(){
                alert("댓글이 등록되었습니다.");
                listReply();     
            }
        });
        
    });
	

    // 게시글 삭제 버튼 클릭이벤트
    $("#btnDelete").click(function() {
        if (confirm("삭제하시겠습니까?")) {
            document.form1.action = "${path}/board/delete";
            document.form1.submit();
        }
    });

    // 게시글 목록 돌아가기 클릭이벤트
    $("#btnList").click(function() {
        location.href = "${path}/board/list";
    });
});

//문서상에서 이벤트(click)가 발생했을 때 btnUpdate에서 특정이벤트발생시 처리하는 방법
$(document).on("click", "#btnUpdate", function() {
    var title = $("#title").val();
    var content = $("#content").val();
    //var writer = $("#writer").val();
    if (title == "") {
        alert("제목을 입력하세요");
        document.form1.title.focus();
        return;
    }
    if (content == "") {
        alert("내용을 입력하세요");
        document.form1.content.focus();
        return;
    }

    document.form1.action = "${path}/board/update";
    // 폼에 입력한 데이터를 서버로 전송
    document.form1.submit();
});

//문서상에서 이벤트(click)가 발생했을 때 btnUpdate에서 onclick에서 함수를 지정해서 동작
//button 태그에서 
function update() {
    var title = $("#title").val();
    var content = $("#content").val();
    //var writer = $("#writer").val();
    if (title == "") {
        alert("제목을 입력하세요");
        document.form1.title.focus();
        return;
    }
    
    if (content == "") {
        alert("내용을 입력하세요");
        document.form1.content.focus();
        return;
    }

    document.form1.action = "${path}/board/update";
    // 폼에 입력한 데이터를 서버로 전송
    document.form1.submit();
};

// Controller방식
// **댓글 목록1
function listReply() {
    $.ajax({
        type: "get",
        url: "${path}/reply/list?bno=${dto.bno}",
        success: function(result) {
            // responseText가 result에 저장됨.
            $("#listReply").html(result);
        }
    });
}
</script>



</head>
<body>
<%@ include file="../include/member_menu.jsp" %>
	
        <!-- Service Section -->
        <section id="work" class="work sections margin-top-120">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="head_title text-center">
                            <h1>게시판 상세내용</h1>
                        </div><!-- End of head title -->
  	
			<form name="form1" method="post" action="${path}/board/update">
				 <div class="container mt-3" style="width:1000px;"> 
				  <table class="table table-hover">
				    <thead>
				    <tr><input type="hidden" name="writer" value="${dto.writer}"></tr>
			 		   <tr>
							<th style="text-align:center;">번호</th>
							<td>${dto.bno}</td>
						</tr>
						<tr>
							<th style="text-align:center;">제목</th>
							<td><input name="title" id="title" size="80" value="${dto.title}" placeholder="제목을 입력하세요"></td>
						</tr>
						<tr>
							<th style="text-align:center;">내용</th>
							<td><textarea name="content" id="content" rows="4" cols="80" placeholder="내용을 입력해 주세요">${dto.content}</textarea></td>
						</tr>
						<tr>
							<th style="text-align:center;">작성자</th>
							<td>&nbsp;&nbsp;${dto.writer}</td>	
						</tr>
						<tr>
							<th style="text-align:center;">작성일자</th>
							<td>&nbsp;&nbsp;<fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd"/></td>	
						</tr>	
						<tr>
							<th style="text-align:center;">조회수</th>
							<td>&nbsp;&nbsp;${dto.viewcnt}</td>	
						</tr>		
					</thead>
				</table>
				</div>
			
			<div style="width:1000px; text-align:center;">
				<!--  게시물 번호를 hidden으로 처리 -->
					<input type="hidden" name="bno" value="${dto.bno}">
					<!-- 본인이 쓴 게시물만 수정, 삭제가 가능하도록 처리 -->
					<c:if test="${dto.writer == sessionScope.userid}">
						<button type="button" id ="btnUpdate" class="btn btn-primary">수정</button>
						<button type="button" id ="btnDelete" class="btn btn-primary">삭제</button>
					</c:if>
					<c:if test="${sessionScope.admin == '1'}">
						<button type="button" id ="btnDelete" class="btn btn-primary">삭제</button>
					</c:if>
						<!-- 상세보기 화면에서 게시글 목록화면으로 이동 -->
						<button type="button" id="btnList" class="btn btn-primary">목록</button>
					</div>
			</form>
			
			 <div class="container mt-3" style="width:1000px; text-align:center;"> 
			  <table class="table table-hover">
			  <c:if test="${sessionScope.userid != null}">
			    <thead>
					<tr>
						<th>댓글</th>
						<td><textarea rows="5" cols="80" id="replytext" placeholder="댓글을 작성해 주세요"></textarea></td>
					</tr>
				</thead>
				</c:if>
			   </table>
			   <c:if test="${sessionScope.userid != null}">
			   <button type="button" id="btnReply" class="btn btn-primary">댓글 작성</button>
				</c:if>
				<!--  ** 댓글 목록 출력할 위치 -->
				<div id="listReply"></div>
				</div>

				</div>
			</div>
		</div>
	</section>
				



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

</body>
</html>