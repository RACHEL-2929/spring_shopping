package com.vam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.AdminMapper;
import com.vam.model.BookVO;
import com.vam.model.CateVO;

import lombok.extern.log4j.Log4j;


@Service
@Log4j
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public void bookEnroll(BookVO book) {
		log.info("(srevice)bookEnroll........");
		adminMapper.bookEnroll(book);
	}

	@Override
	public List<CateVO> cateList() {
		log.info("(srevice)cateList........");

		return adminMapper.cateList();
	}

}
