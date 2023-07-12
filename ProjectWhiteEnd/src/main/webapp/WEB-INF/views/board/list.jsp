<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 게시판</title>
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
                            <h1>고객 게시판</h1>
                        </div><!-- End of head title -->
                        
            <div class="container mt-3"> 
			  <table class="table table-hover">
			    <thead>
					<tr>
						<th style="text-align:center;">번호</th>
						<th style="text-align:center;">제목</th>
						<th style="text-align:center;">ID</th>
						<th style="text-align:center;">작성일</th>
						<th style="text-align:center;">조회수</th>
					</tr>
						<c:forEach var="row" items="${map.list}">
					<tr>
						<td>${row.bno}</td>
							<!-- 게시글 상세보기 페이지로 이동시 게시글 목록페이지에 있는 검색조건, 키워드, 현재페이지 값을 유지하기 위해 -->
						<td>
							<a href="${path}/board/view?bno=${row.bno}&curPage=${map.boardPager.curPage}&searchOption=${map.searchOption}&keyword=${map.keyword}">${row.title}</a>
							<!-- ** 댓글이 있으면 게시글 이름 옆에 출력하기 -->					
							<c:if test="${row.recnt > 0}">
							<span style="color:red;">(${row.recnt})</span>
							</c:if>
						</td>
						<td>${row.writer}</td>
						<td>
						<!-- 원하는 날짜형식으로 출력하기 위해 fmt태그를 사용 -->
						<fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd "/>
						</td>
						<td>${row.viewcnt}</td>	
					</tr>
			</c:forEach>
			

			<tr>
				<td colspan="5">
				<!-- 처음 페이지로 이동 : 현재페이지가 1보다 크면 [처음] 하이퍼링크를 화면에 출력 -->
				<c:if test="${map.boardPager.curBlock>1}">
					<a href="javascript:list('1')">[처음]</a>
				</c:if>
					
				<!--  이전 페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전] 하이퍼링크를 화면에 출력 -->
				<c:if test="${map.boardPager.curBlock>1}">
					<a href="javascript:list('${map.boardPager.prevPage}')">[이전]</a>
				</c:if>
				
				<!-- ** 하나의 블럭 시작페이지로부터 끝페이지까지 반복문 실행 -->
				<c:forEach var="num" begin="${map.boardPager.blockBegin}" end="${map.boardPager.blockEnd}">
					<!-- 현재페이지 이면 하이퍼링크 제거 -->
					<c:choose>
						<c:when test="${num==map.boardPager.curPage}">
							<span style="color:red">${num}</span>&nbsp;
						</c:when>
						<c:otherwise>
							<a href="javascript:list('${num}')">${num}</a>&nbsp;
						</c:otherwise>
					</c:choose>								
				</c:forEach>		
					
				<!--  다음페이지 블록으로 이동 : 현재페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 [다음] 하이퍼링크를 화면에 출력-->
				<c:if test="${map.boardPager.curBlock<=map.boardPager.totBlock}">
					<a href="javascript:list('${map.boardPager.nextPage}')">[다음]</a>
				</c:if>
				
				<!--  끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면[끝] 하이퍼링크를 화면에 출력 -->
				<c:if test="${map.boardPager.curPage <= map.boardPager.totPage}">
					<a href="javascript:list('${map.boardPager.totPage}')">[끝]</a>
				</c:if>
				</td>					
			</tr>
	    </tbody>
	  </table>
	</div>			
		<div class="search-container">
			<form name="form1" method="post" action="${path}/board/list">			
			
			<select class="search-option" name="searchOption">
			<!-- 검색 조건을 검색처리 후 결과화면을 보여주기위해 c:out 출력태그 사용, 삼항연산자 -->		
			<option value="all" <c:out value="${map.searchOption == 'all' || map.searchOption=='' ? 'selected':''}"/> >제목+ID</option>
			<option value="writer" <c:out value="${map.searchOption == 'writer'?'selected':''}"/> >ID</option>
			<!-- <option value="content" <c:out value="${map.searchOption == 'content'?'selected':''}"/> >내용</option> -->
			<option value="title" <c:out value="${map.searchOption == 'title'?'selected':''}"/> >제목</option>
			</select>
			
			<input name="keyword" value="${map.keyword}">
			<input type="submit" value="조회"><br>
			</form>
		</div>
		
			<!--  로그인한 사용자만 글쓰기 버튼을 활성화 -->
			<c:if test="${sessionScope.userid !=null}">
			<button type="button" class="btn btn-primary" onclick="location.href='${path}/board/write';">글쓰기</button>
			</c:if>
			</div>
			</div>
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
        
        <script>


$("document").ready(
		function(){ //버튼을 눌렀는지 확인
			$("#btnWrite").click(	
				function(){
					location.href = "${path}/board/write"; //해당페이지로 이동
				}		
			); //클릭했을 때
		}		
	
	);
	// 원하는 페이지로 이동 시 검색조건, 키워드 값을 유지하기 위해


	function list(page) {
		//&구분, $값을 가져와서 쓰는것
		location.href="${path}/board/list?curPage="+page+"&searchOption=${map.searchOption}"+"&keyword=${map.keyword}";
	}


		</script>
        
	</section>
    </body>
</html>
