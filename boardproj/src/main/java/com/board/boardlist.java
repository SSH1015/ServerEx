package com.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 게시판 목록
 * 1. 디자인(화면구현-입력/출력)
 * 2. 데이터베이스 설정
 * 3. 데이터베이스 작업
 */

@WebServlet("/list")
public class boardlist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 목록은 get방식
	 * 1. 입력 페이지 없음
	 * 2. 결과 페이지
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//뼈대 복사 후에는 해당 페이지의 세부디자인
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>게시판</title>");
		out.print("<body>");
		out.print("<h1>게시물목록</h1>");		
		out.print("<table border=1>"); //표작업은 제목부분으로 모양잡기
		out.print("<tr>"); //한줄에
		out.print("<td width=200>게시물번호</td>"); //4칸으로 구성
		out.print("<td width=200>게시물제목</td>");
		out.print("<td width=400>내용</td>");
		out.print("<td width=200>등록일</td>");
		out.print("</tr>");
		//이곳에서 데이터베이스의 목록이 반복적으로 출력되는 부분
		//뼈대 준비, 마무리
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;	//질의어 응답하기 위해
		
		//데이터베이스 뼈대
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/servlet",
					"sample", "1234"
					);
			stmt = conn.createStatement(); //문법생성
			//모든 필드를 가져온다. order by정렬을 내림차순으로
			sql = "select * from board order by tno DESC";  
			rs = stmt.executeQuery(sql);  //rs로 받아서 저장
			
			//결과를 화면에 출력
			while(rs.next()) {
				out.print("<tr>"); //한줄에
				out.print("<td width=200>"+rs.getInt("tno")+"</td>"); //4칸으로 구성
				out.print("<td width=200>"+rs.getString("tsubject")+"</td>");
				out.print("<td width=400>"+rs.getString("tcontent")+"</td>");
				out.print("<td width=200>"+rs.getDate("tcredate")+"</td>");
				out.print("</tr>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{rs.close();} catch(Exception e) {}
			try{conn.close();} catch(Exception e) {}
			try{stmt.close();} catch(Exception e) {}
		}
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		out.close(); //뼈대 작성 후 단위테스트 
		
	}

}
