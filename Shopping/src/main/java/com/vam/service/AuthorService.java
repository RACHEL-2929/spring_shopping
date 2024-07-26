package com.vam.service;


import java.util.List;

import com.vam.model.AuthorVO;
import com.vam.model.Criteria;


public interface AuthorService {

	public void authorEnroll(AuthorVO author);

	public List<AuthorVO> authorGetList(Criteria cri);

	public int authorGetTotal(Criteria cri);
	
	public AuthorVO authorGetDetail(int authorId);
	
	public int authorModify(AuthorVO author);


}
