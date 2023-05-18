package com.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection; //데이터베이스 컨넥터를 연결
import java.sql.DriverManager; //데이터베이스 드라이버(사용)
import java.sql.PreparedStatement;
import java.sql.ResultSet; //질의어를 통해서 얻은 결과값
import java.sql.SQLException;
import java.sql.Statement; //질의어를 통해서 데이터베이스 지시

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 게시판 수정 목록
 */

@WebServlet("/update")
public class boardupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>게시판</title>");
		out.print("<body>");
		out.print("<h3>게시물 수정</h3>");
		out.print("<form method='post' action='update'>");
		//out.print("<form method='get' action='add'>"); //움직이고 있는지 확인
		out.print("<table border=1>");
		out.print("<tr>"); //기본키에 필요한 부분만 추가
		out.print("<td width=100>번호</td>");
		out.print("<td width=200><input type='number' name='tno'></td>");	
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td width=100>제목</td>"); //불필요한 부분은 제거
		out.print("<td width=200><input type='text' name='tsubject'></td>");	
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td width=100>내용</td>");
		out.print("<td width=200><textarea name='tcontent' cols='50' rows='5'></textarea></td>");	
		out.print("</tr>");
		out.print("<tr><td colspan='2'>");
		out.print("<input type='submit' value='수정'>");
		out.print("<input type='reset' value='지우기'>");
		out.print("</td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
		out.close(); //뼈대 작성 후 단위테스트 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//--------------------------------------------------------
		
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement stmt = null;
		//ResultSet rs = null;
		String sql = null;	//질의어 응답하기 위해
		
		//데이터베이스 뼈대
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/servlet",
					"sample", "1234"
					);
			//SQL문을 수정에 맞게 수정, 값 설정(+,-)
			sql = "UPDATE board SET tsubject=?, tcontent=? where tno=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, request.getParameter("tsubject"));
			stmt.setString(2, request.getParameter("tcontent"));
			stmt.setInt(3, Integer.parseInt(request.getParameter("tno")));
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			//return;   //오류 보고싶을 때 
			
		} finally {
			//try{rs.close();} catch(Exception e) {}
			try{conn.close();} catch(Exception e) {}
			try{stmt.close();} catch(Exception e) {}
		}
		//----------------------------------------------------
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>게시판</title>");
		out.print("<body>");
		out.print("<h3>게시글을 수정하였습니다.</h3>");
		out.print("</body>");
		out.print("</html>");
		out.close(); //뼈대 작성 후 단위테스트 
		
	}

}
