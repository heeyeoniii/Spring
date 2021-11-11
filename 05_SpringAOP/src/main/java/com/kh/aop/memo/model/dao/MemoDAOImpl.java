package com.kh.aop.memo.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemoDAOImpl implements MemoDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<Map<String, String>> selectMemoList() {
		
		return sqlSession.selectList("memoSQL.selectMemoList");
	}

	@Override
	public int insertMemo(Map<String, String> map) {
		
		return sqlSession.insert("memoSQL.insertMemo", map);
	}

	@Override
	public int deleteMemo(Map<String, String> map) {
		
		return sqlSession.delete("memoSQL.deleteMemo", map);
	}

}
