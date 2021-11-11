package com.kh.spring.member.controller;

public class ViewResolver {
	// 서비스 작업 수행 후 컨트롤러에서 
	// 프론트 컨트롤러(DispatcherServlet)로 
	// 사용자에게 보여줄 화면을 전달하는 객체
	
	public String prefix; // 경로 접두사 : ex) /WEB-INF/member
	public String suffix; // 경로 접미사 : ex) .jsp
	
	// /WEB-INF/member/loginSuccess.jsp
	// /WEB-INF/member/loginFail.jsp
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		return prefix + viewName + suffix;	
	}
	
}
