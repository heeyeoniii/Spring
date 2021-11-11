package com.kh.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

public class MemberController implements Controller {
	// 기존의 컨트롤러 인터페이스를 상속받음으로써
	// 자동으로 request, response를 사용하는 메소드가 만들어진다.

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("사용자 로그인 기능 접근");
		
		// 1. 사용자가 입력한 정보 추출
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		Member m = new Member(userId, password);
		
		// 2. 서비스 수행 겍채 생성
		MemberService ms = new MemberService();
		
		m = ms.selectOne(m);
		System.out.println("조회 결과 : " + m);
		
		// 3. 결과 화면 연동
		String page = "";
		
		if(m != null) {
			page = "loginSuccess";
		} else {
			page = "loginFail";
		}
		
		return page;
	}

}
