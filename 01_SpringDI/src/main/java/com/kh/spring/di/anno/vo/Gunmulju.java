package com.kh.spring.di.anno.vo;

import org.springframework.stereotype.Component;

@Component("gun")
public class Gunmulju implements Job {

	@Override
	public void work(String place) {
		System.out.println(place + "에서 골프 연습 중입니다.");

	}

}
