package com.kh.spring.di.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kh.spring.di.anno.vo.Person;

public class DependencyAnno extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DependencyAnno() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext ctx = new GenericXmlApplicationContext("/anno-di-context.xml");
		
		Person p = (Person)ctx.getBean("person");
		
		System.out.println(p);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
