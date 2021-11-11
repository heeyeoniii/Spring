package com.kh.aop.memo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.aop.memo.model.service.MemoService;

@Controller
public class MemoController {
	
	private Logger logger = LoggerFactory.getLogger(MemoController.class);	
	
	@Autowired
	MemoService memoService;
	
	@RequestMapping("/memo/memo.do")
	public String memo(Model model) {
		
		List<Map<String, String>> memoList = memoService.selectMemoList();
		
		model.addAttribute("memoList", memoList);
		logger.debug("메모 목록 접근 확인!");
		logger.info("현재 조회 목록 : " + memoList);
		
		return "memo/memo";
	}
	
	@RequestMapping("/memo/insertMemo.do")
	public String insertMemo(@RequestParam String memo,
			          		  @RequestParam String password) {
		
		Map<String, String> map = new HashMap<String, String>();
		logger.debug("메모 등록 접근!");
		map.put("memo", memo);
		map.put("password", password);
		memoService.insertMemo(map);
		
		return "redirect:/memo/memo.do";
	}
	
	@RequestMapping("/memo/deleteMemo.do")
	public String deleteMemo(@RequestParam String no,
							 @RequestParam String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("no", no);
		map.put("password", password);
		memoService.deleteMemo(map);
		logger.debug("메모 삭제 기능 접근!");
		return "redirect:/memo/memo.do";
	}	
	
}
