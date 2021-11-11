package com.kh.spring.di.xml.vo;

public class Gunmulju implements Job {

	@Override
	public void work(String place) {
		System.out.println(place + "에서 월세를 독촉합니다.");		
	}	
}
