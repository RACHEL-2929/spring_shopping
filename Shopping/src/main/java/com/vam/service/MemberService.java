package com.vam.service;


import com.vam.model.MemberVO;

public interface MemberService {

	public void memberJoin(MemberVO member);

	public int idCheck(String memberId);

	public MemberVO memberLogin(MemberVO member);
}
