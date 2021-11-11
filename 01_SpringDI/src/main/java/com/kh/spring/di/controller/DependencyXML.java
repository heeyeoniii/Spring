package com.kh.spring.di.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kh.spring.di.xml.vo.Person;

public class DependencyXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DependencyXML() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 객체 의존성이란 객체를 생성/사용할 때
		 * 새로운 객체로 값을 처리하는 것이 아니라
		 * 특정 값을 입력받고 그 값으로부터 해당 객체의 정보를 전달받는 것을 의미한다.
		 * 
		 * 1. 생성자를 통한 의존성 주입
		 * Person p = new Person("홍길동", 직업);
		 * 
		 * 2. Setter를 통한 의존성 주입
		 * p.setName("김철수");
		 * 
		 * 3. 다른 메소드를 통한 의존성 주입
		 * Connection con = getConnection();
		 * TV tv = BeanFactory.getBean("OOO");
		 */
		
		// xml에 저장한 객체 받아오기
		// 코드를 실행한 순간 xml 파일을 읽음
		ApplicationContext ctx = new GenericXmlApplicationContext("/xml-di-context.xml");
		
		Person p1 = (Person)ctx.getBean("person1");
		
		System.out.println(p1);
		p1.getMyJob().work("화장실");
		
		Person p2 = (Person)ctx.getBean("person2");
		
		System.out.println(p2);
		p2.getMyJob().work("상사 옆");
		
		// 객체 생성을 스프링이 한다! -> 제어 역전(IoC)
		
		Person p3 = (Person)ctx.getBean("person1");
		
		System.out.println(p3);
		p3.setName("코코");
		
		System.out.println(p1);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
