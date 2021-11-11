package com.kh.spring.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.dao.MemberDAO;
import com.kh.spring.member.model.vo.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	// 회원 조회용 메소드
	public Member selectOne(Member m) {		
		System.out.println("[서비스]::멤버 서비스 도착!");
		
		return memberDAO.selectOne(m);
	}
}
