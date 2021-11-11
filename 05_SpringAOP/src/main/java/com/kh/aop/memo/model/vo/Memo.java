package com.kh.aop.memo.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Memo implements Serializable {
	
	private int memoNo;
	private String memo;
	private String password;
	private Date memoDate;
}
