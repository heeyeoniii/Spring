package com.kh.spring.member.model.service;

import com.kh.spring.member.model.dao.MemberDAO;
import com.kh.spring.member.model.vo.Member;

public class MemberService {
	
	public Member selectOne(Member m) {
		MemberDAO memberDAO = new MemberDAO();
		
		return memberDAO.selectOne(m);
		
	}

}
