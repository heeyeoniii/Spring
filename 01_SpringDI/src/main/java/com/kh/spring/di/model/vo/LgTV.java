package com.kh.spring.di.model.vo;

public class LgTV implements TV {

	@Override
	public void turnOn() {
		System.out.println("전원을 켭니다!");
		
	}

	@Override
	public void turnOff() {
		System.out.println("전원을 종료합니다!");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("소리를 낮춥니다!");
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		
	}
	
	/*
	public void turnOn() {
		System.out.println("전원을 켭니다!");
	}
	
	public void turnOff() {
		System.out.println("전원을 종료합니다!");
	}
	
	public void soundUp() {
		System.out.println("소리를 높입니다!");
	}
	
	public void soudDown() {
		System.out.println("소리를 낮춥니다!");
	}
	*/
}
