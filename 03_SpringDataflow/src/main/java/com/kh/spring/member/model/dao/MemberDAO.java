package com.kh.spring.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kh.spring.member.model.vo.Member;

public class MemberDAO {
	SqlSessionTemplate sqlSession;
	
	public MemberDAO() {
		ApplicationContext ctx = new GenericXmlApplicationContext("/root-context.xml");
	
		sqlSession = (SqlSessionTemplate)ctx.getBean("sqlSession");
	}
	
	public Member selectOne(Member m) {
		
		
		System.out.println("[DAO] member : " + m);
	
		// 네임스페이스.쿼리ID, 전달할 값
		return sqlSession.selectOne("memberSQL.loginMember", m);
	}

}
