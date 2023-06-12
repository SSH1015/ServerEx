<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--공통적은 파일을 include 폴더에 넣어 두고 필요할 때마다 include로 연결해서 사용 -->
<%@ include file="../include/member_header.jsp" %> <!-- 해당파일을 연결 -->
<script>
    $(document).ready(function(){ //문서내에서 이벤트가 발생했을 때
        
        //listReply(); // **댓글 목록 불러오기
        listReply(); // ** json 리턴방식
        
        // ** 댓글 쓰기 버튼 클릭 이벤트 (ajax로 처리)
        //sucess - 완전성공, error - 오류처리, complete - 수행 후
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
        $("#btnDelete").click(function(){
            if(confirm("삭제하시겠습니까?")){
                document.form1.action = "${path}/board/delete";
                document.form1.submit();
            }
        });
    });
    
    //문서상에서 이벤트(click)가 발생했을 때 btnUpdate에서 특정이벤트발생시 처리하는 방법
    $(document).on("click", "#btnUpdate",function(){         
            var title = $("#title").val();
            var content = $("#content").val();
            //var writer = $("#writer").val();
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

            document.form1.action="${path}/board/update"
            // 폼에 입력한 데이터를 서버로 전송
            document.form1.submit();                  
    });
    
  	//문서상에서 이벤트(click)가 발생했을 때 btnUpdate에서 onclick에서 함수를 지정해서 동작
  	//button 태그에서 
    function update(){         
            var title = $("#title").val();
            var content = $("#content").val();
            //var writer = $("#writer").val();
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

            document.form1.action="${path}/board/update"
            // 폼에 입력한 데이터를 서버로 전송
            document.form1.submit();                  
    };    
    
    // Controller방식
    // **댓글 목록1
    function listReply(){
        $.ajax({
            type: "get",
            url: "${path}/reply/list?bno=${dto.bno}",
            success: function(result){
            // responseText가 result에 저장됨.
                $("#listReply").html(result);
            }
        });
    }
    
</script>
</head>
<body>
<!-- 처음 실행되는 화면  -->
<!-- JSTL-if, foreach 등 자바명령어를 태그화 시켜놓은 형식 -->
<!-- EL-전달받은 변수(값)을 쉽게 처리하는 형식 $ 대괄호안에 변수명을 기재 %=변수 대신-->
<%@ include file="../include/member_menu.jsp" %> <!-- 해당파일을 연결 -->

<!-- TODO: 읽어온 데이터를 화면에 출력 value에 가져온 값을 출력-->
<!-- 컨트롤에서 보내는 변수를 확인 -->
<!-- TODO: 수정과 삭제버튼은 스크립트로 처리 -->
<h2>게시글 상세</h2> 
<form name="form1" method="post" action="${path}/board/update">
	<div>		
		<input type="hidden" name="writer" value="${dto.writer}">
	</div>
	<div>		
		번호 <input name="bno" value="${dto.bno}" readonly>
	</div>
	<div>
		제목 <input name="title" id="title" value="${dto.title}"> <!-- boardVO를 참고해서 이름 지정 -->		 
	</div>
	<div>
	<!-- textarea은 value가 없음 textarea /textarea사이에 작성 -->
		내용 <textarea name="content" id="content" cols="80" rows="4">${dto.content}</textarea>
	</div>
	<div>
		이름 ${dto.username}
	</div>
	<!-- 작성자가 상세페이지 클릭했을 때 수정,삭제버튼 화면에 나타내고, 작성자가 아니면 수정/삭제버튼은 화면에서 숨긴다. -->
	<c:if test="${dto.writer == sessionScope.userid  }">
		<div>
			<button type="button" id="btnUpdate">수정</button>  <!-- document.ready/document.on -->
			<button type="button" onclick="update()">수정2</button> <!-- function에 적용 -->
			<button type="button" id="btnDelete">삭제</button>
		</div>
	</c:if>
</form>
<!-- 댓글입력창(로그인된 상태에서만 댓글 입력창을 표시) -->
<div style="width:650px, text-align:center">
	<br> <!-- 일반게시판에 로그인시 댓글등록처리 -->
	<c:if test="${sessionScope.userid != null }">
		<textarea rows="5" cols="80" id="replytext" placeholder="댓글을 입력하세요"></textarea>
		<br>
		<button type="button" id="btnReply">댓글작성</button>
	</c:if>
</div>
<!-- 댓글 출력 -->
<div id="listReply"></div>

</body>
</html>