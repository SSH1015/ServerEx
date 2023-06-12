package com.spring.member.dao;

import java.util.List;

import com.spring.member.vo.boardVO;

public interface boardDAO {
	//컨트롤의 메소드이름을 활용해서 작성
	/*public String boardList(); 
	public String boardWritePage(); 
	public void boardWrite(); 
	public String boardView(); 
	public void boardUpdate(); 
	public void boardDelete(); */
	
	//Batis의 id를 활용해서 작성(resultType을 활용해서 데이터형)
	//Where을 보고  #{}값을 보고 인수값
	//기본 게시글 작업(삽입,수정,삭제,조회)-CRUD
	public List<boardVO> selectList()  throws Exception;
    public void insert(boardVO vo)  throws Exception;
	public boardVO view(int bno) throws Exception;
    public void update(boardVO vo) throws Exception;
	public void delete(int bno) throws Exception;

	//추가(응용) 게시글에 추가적인 작업- 검색, 페이지, 조회수
	public void increaseViewcnt(int bno) throws Exception; //게시글 증가
	//검색 분류(searchoption), 검색어(keyword)
	public List<boardVO> listAll(String searchOption, String keyword) throws Exception;
}
