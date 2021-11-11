package com.kh.spring.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public Member selectOne(Member m) {
		
		System.out.println("[DAO]::DAO 도착!");
		
		return sqlSession.selectOne("memberSQL.loginMember", m);
	}
}
