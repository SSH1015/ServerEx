package com.spring.ProjectWhite;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//테스트를 위해서 함께 사용할 클래스
@RunWith(SpringJUnit4ClassRunner.class)
//참고할 환경파일의 위치를 지정(외부에 선언된 환경을 이용->주입)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class DBTest {
	//Inject 일반적으로 변수선언시 사용 DAO, VO 선언
	//주입(환경파일에 있는 정보를 자동으로 연결해서 사용)
	@Inject 
	private DataSource ds;
	//메소드는 사용자 마음대로 작성
	//Test 오류검사를 위한 확인 프로그램
	@Test
	public void DataSourceTest() throws Exception {
		//데이터베이스명, 아이디(권한제한), 비밀번호 오류
		//드라이버가 충돌
		ds.getConnection();
		System.out.println("드라이버 연결");
	}
}

