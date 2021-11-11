package com.kh.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	// 다른 컨트롤러들 구현 시 
	// 공통된 메소드를 구현하도록 강제화시키는 역할

	String handleRequest(HttpServletRequest request, HttpServletResponse response);	
}
