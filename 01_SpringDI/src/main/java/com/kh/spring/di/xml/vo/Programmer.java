package com.kh.spring.di.xml.vo;

public class Programmer implements Job {

	@Override
	public void work(String place) {
		System.out.println(place + "에서 키보드 위의 교향곡을 연주합니다.");
	}
}
