package com.kh.spring.di.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kh.spring.di.model.vo.BeanFactory;
import com.kh.spring.di.model.vo.TV;
import com.kh.spring.di.model.vo.TvMgr;

public class DependencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DependencyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 일반 TV를 서블릿에서 호출해 사용할 경우
		
		/*
		LgTV tv = new LgTV();
		
		
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soudDown();	
		*/
		
		/*
		SamsungTV tv = new SamsungTV();
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		*/		
		
		// LgTV -> SamsungTV로 변경 시
		// 해당 객체와 관련된 모든 메소드까지 변경해야 한다.
		// 이렇게 하나의 객체가 다른 코드에 끼치는 영향력을
		// 객체 결합도(의존성)라고 부른다.
		// 위와 같이 한번의 객체 변경으로 많은 코드를 바꾸는 것을 '결합도가 높다'고 표현한다.

		// 결합도가 높은 코드는 코드 내용 변경 시
		// 관련된 모든 소스 코드를 수정해야 하기 때문에
		// 개발, 유지보스에 많은 시간을 들이게 된다.
		
		// 2. 결합도를 낮추기 위한 강제성 -> 인터페이스 활용하기
		/*
		TV tv = new LgTV();
		// TV tv = new SamsungTV();
		
		tv.turnOn();
		tv.turnOff();
		tv.volumeUp();
		tv.volumeDown();		
		*/
		
		// 위의 방식으로 구현하면 객체가 변함에 따른
		// 메소드 변경의 영향력은 낮으나, 개발자가 매번
		// 소스코드를 수정하여 new를 통한 생성자를 호출해야 한다.
		
		// 3. BeanFactory 사용하기(전략 디자인 패턴)
		/*
		TV tv = (TV)BeanFactory.getBean(request.getParameter("name"));
		
		System.out.println(tv);
		
		tv.turnOn();
		tv.turnOff();
		tv.volumeUp();
		tv.volumeDown();
		*/
		
		// 4. 스프링이 다 한다!
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("/sample-context.xml");
		
		TV tv = (ctx.getBean("tvmgr", TvMgr.class)).getTv();
		
		System.out.println(tv);
		
		tv.turnOn();
		tv.turnOff();
		tv.volumeUp();
		tv.volumeDown();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
