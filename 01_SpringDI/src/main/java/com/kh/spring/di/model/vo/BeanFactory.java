package com.kh.spring.di.model.vo;

public class BeanFactory {
	public static Object getBean(String beanName) {
		TV tv = null;
		
		if(beanName.equals("samsung")) {
			tv = new SamsungTV();
		} else {
			tv = new LgTV();
		}
		
		return tv;
	}

}
