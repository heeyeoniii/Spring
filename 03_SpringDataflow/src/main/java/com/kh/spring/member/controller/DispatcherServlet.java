package com.kh.spring.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	@Override 
	public void init() { // 객체 최초 생성 시
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 사용자의 요청 url 주소 추출
		String url = request.getRequestURI();
		// -> httpL//localhost:8180/spring/login.do
		
		String path = url.substring(url.lastIndexOf("/"));
		// -> login.do
		
		// System.out.println("path : " + path);
		
		// 2. HandlerMapping으로 path 정보 보내고 Controller 받아오기
		Controller ctr = handlerMapping.setController(path);
		
		// 3. 조회한 Controller 실행하고 view 이름 받아오기
		String viewName = ctr.handleRequest(request, response); // loginSuccess / loginFail
		
		// 4. 받아온 viewName으로 viewResolver에게 전달하기
		String view = "";
		
		view = viewResolver.getView(viewName);
		
		// 5. 생성한 화면 주소를 사용자에게 전달하기
		response.sendRedirect(view);		
	}
}
