package com.kh.spring.di.anno.vo;

import org.springframework.stereotype.Component;

@Component("prog")
public class Programmer implements Job {

	@Override
	public void work(String place) {
		System.out.println(place + "에서 코딩 중입니다.");

	}

}
