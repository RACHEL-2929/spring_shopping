package com.vam.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.AuthorVO;
import com.vam.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AuthorMapperTests {

	@Autowired
	private AuthorMapper authorMapper;

	/*
	 * @Test public void authorEnroll() {
	 * 
	 * AuthorVO author = new AuthorVO(); author.setNationId("01");
	 * author.setAuthorName("test"); author.setAuthorIntro("test intro");
	 * 
	 * 
	 * authorMapper.authorEnroll(author); }
	 */

	/* 작가 목록 테스트 */
	/*
	 * @Test public void authorGetListTest() throws Exception{
	 * 
	 * Criteria cri = new Criteria(3,10); // 3페이지 & 10개 행 표시 cri.setKeyword("폴");
	 * 
	 * List<AuthorVO> list = authorMapper.authorGetList(cri);
	 * 
	 * for(int i = 0; i < list.size(); i++) { System.out.println("list" + i +
	 * ".........." + list.get(i)); }
	 * 
	 * }
	 */

	/*
	 * 작가 총 수
	 * 
	 * @Test public void authorGetTotalTest() {
	 * 
	 * Criteria cri = new Criteria(); cri.setKeyword("폴");
	 * 
	 * int total = authorMapper.authorGetTotal(cri);
	 * 
	 * System.out.println("total......." + total); }
	 */

	/*
	 * 작가 상세 페이지
	 * 
	 * @Test public void authorGetDetailTest() {
	 * 
	 * int authorId = 30;
	 * 
	 * AuthorVO author = authorMapper.authorGetDetail(authorId);
	 * 
	 * System.out.println("author......." + author);
	 * 
	 * }
	 */
	
	/* 작가 정보 수정 */
	@Test
	public void authorModifyTest() {
		
		AuthorVO author = new AuthorVO();
				
		author.setAuthorId(1);
		System.out.println("수정 전...................." + authorMapper.authorGetDetail(author.getAuthorId()));
		
		author.setAuthorName("수정");
		author.setNationId("01");
		author.setAuthorIntro("소개 수정 하였습니다.");
		
		authorMapper.authorModify(author);
		System.out.println("수정 후...................." + authorMapper.authorGetDetail(author.getAuthorId()));
		
	}

}
