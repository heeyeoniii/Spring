package com.kh.aop.memo.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.aop.memo.model.dao.MemoDAO;

@Service
public class MemoServiceImpl implements MemoService {

	@Autowired
	MemoDAO memoDAO;
	
	@Override
	public List<Map<String, String>> selectMemoList() {
		
		return memoDAO.selectMemoList();
	}

	@Override
	public int insertMemo(Map<String, String> map) {
		
		return memoDAO.insertMemo(map);
	}

	@Override
	public int deleteMemo(Map<String, String> map) {
		
		return memoDAO.deleteMemo(map);
	}

}
