package com.spring.mvcboard;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//참고할 환경파일의 위치를 지정(외부에 선언된 환경을 이용->주입)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class MapperTest {
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void SessionFactoryTest() {
		//사용할 테이블에 접근
		System.out.println("sqlFactory정보: "+sqlFactory);
	}
	
	@Test
	public void SessionTest() {
		//테이블을 열어서 SQL사용할 상태
		sqlFactory.openSession();
		System.out.println("세션이 정상적으로 동작하였습니다.");
	}
}
