package com.vam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.MemberMapper;
import com.vam.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberMapper membermapper;
	
	
	@Override
	public void memberJoin(MemberVO member){
		membermapper.memberJoin(member);
	}


	@Override
	public int idCheck(String memberId){
		return membermapper.idCheck(memberId);
	}


	@Override
	public MemberVO memberLogin(MemberVO member) {
		return membermapper.memberLogin(member);
	}

}
