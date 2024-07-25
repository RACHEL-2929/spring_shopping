package com.vam.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.vam.model.MemberVO;

public class AdminInterceptor implements HandlerInterceptor{

	//adminCk가 1인지 확인
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//session에 모든 member의 모든 정보 들어 있음 member
		MemberVO lvo = (MemberVO)request.getSession().getAttribute("member");
		
		//관리자가 아니라면
		if (lvo == null || lvo.getAdminCk() == 0) {
			response.sendRedirect("/main");
			return false;
		}
		
		//관리자라면 true로 리턴
		return true;
}

	
	
	
}
