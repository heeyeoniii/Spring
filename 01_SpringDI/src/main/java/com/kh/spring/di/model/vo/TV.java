package com.kh.spring.di.model.vo;

// 인터페이스 : 미완성 메소드들만 모여있는 개체
// 상속받은 자식이 미완성 메소드를 구현해야 한다.

public interface TV {
	
	// public abstract void turnOn();
	void turnOn();
	
	void turnOff();
	
	void volumeUp();
	
	void volumeDown();	
}