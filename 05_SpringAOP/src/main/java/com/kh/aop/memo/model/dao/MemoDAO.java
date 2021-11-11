package com.kh.aop.memo.model.dao;

import java.util.List;
import java.util.Map;

public interface MemoDAO {
	List<Map<String, String>> selectMemoList();

    int insertMemo(Map<String, String> map);
    
    int deleteMemo(Map<String, String> map);

}
