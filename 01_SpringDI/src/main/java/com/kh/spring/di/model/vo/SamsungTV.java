package com.kh.spring.di.model.vo;

public class SamsungTV implements TV {

	@Override
	public void turnOn() {
		System.out.println("전원이 켜집니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("전원이 꺼집니다.");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("소리를 높입니다.");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("소리를 낮춥니다.");
		
	}
	
	/*
	public void powerOn() {
		System.out.println("전원이 켜집니다.");
	}
	
	public void powerOff() {
		System.out.println("전원이 꺼집니다.");
	}
	
	public void volumeUp() {
		System.out.println("소리를 높입니다.");
	}
	
	public void volumeDown() {
		System.out.println("소리를 낮춥니다.");
	}
	*/

}
