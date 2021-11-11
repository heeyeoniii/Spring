package com.kh.spring.member.controller;

import java.util.HashMap;

public class HandlerMapping {
	// 일반 컨트롤러 객체와 사용자가 요청한 url 주소를 
	// 1:1로 매핑(매칭)시키는 역할 수행
	
	// ex) "/login.do" -> MemberController
	
	// 필드 변수
	private HashMap<String, Controller> mapping;
	
	// 생성자
	public HandlerMapping() {
		mapping = new HashMap<String, Controller>();
	
		mapping.put("/login.do", new MemberController());
		
	}
	
	// 메소드
	public Controller setController(String path) { // login.do
		// 특정 url이 오면 해당 컨트롤러를 찾아주는 메소드
		
		return mapping.get(path);
	}

}
