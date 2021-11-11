package com.kh.spring.di.anno.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 어노테이션을 활용한 객체 생성 테스트
 * Component 어노테이션은 ()로 별칭을 선언할 수 있으며
 * 혹 선언하지 않는다면 해당 클래스의 앞글자를 소문자로 바꾼
 * 별칭을 기본으로 사용한다.
 * @author USER
 *
 */

@Component
public class Person {
	// Value : 값을 xml 형식으로 바꿔 자동으로 등록해준다.
	@Value("홍길동")
	private String name;
	
	@Autowired
	@Qualifier("prog")
	private Job myJob;

	public Person() {}
	
	public Person(String name, Job myJob) {
		super();
		this.name = name;
		this.myJob = myJob;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", myJob=" + myJob + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Job getMyJob() {
		return myJob;
	}

	public void setMyJob(Job myJob) {
		this.myJob = myJob;
	}
}
