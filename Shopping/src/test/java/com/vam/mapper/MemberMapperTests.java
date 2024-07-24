package com.vam.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTests {

	@Autowired
	private MemberMapper membermapper;
	
	/*
	 * @Test public void memberJoin() { MemberVO member = new MemberVO();
	 * member.setMemberId("test"); member.setMemberPw("test");
	 * member.setMemberName("test"); member.setMemberMail("test");
	 * member.setMemberAddr1("test"); member.setMemberAddr2("test");
	 * member.setMemberAddr3("test"); membermapper.memberJoin(member); }
	 */
	
	//아이디 중복검사
	/*
	 * @Test public void memberIdChk() { String id = "test"; String id2 = "2222";
	 * membermapper.idCheck(id); membermapper.idCheck(id2); }
	 */
	
	//로그인 쿼리 테스트
	@Test
	public void memberLogin() {
		MemberVO member = new MemberVO();
		member.setMemberId("test");
		member.setMemberPw("test");
		
		
		System.out.println("결과 : " + membermapper.memberLogin(member));
		
	}
}
