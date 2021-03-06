package com.kh.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.spring.exception.MemberException;
import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

@Controller
@SessionAttributes({"member"})
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	@RequestMapping("/member/memberEnroll.do")
	public String memberEnroll() {
		System.out.println("회원 가입(memberEnroll.do) 접근 확인");

		return "member/memberEnroll";
	}
	
	@RequestMapping("/member/memberEnrollEnd.do")
	public String memberEnrollEnd(Member m, Model model) { // HttpServletRequest/RequestParam/
		
		System.out.println("받아온 정보 확인 : " + m);
		
		String pass1 = m.getPassword(); // 원래 비밀번호
		String pass2 = bcryptPasswordEncoder.encode(pass1); // 비밀번호 암호화
		
		System.out.println(pass1 + " / " + pass2);
		
		m.setPassword(pass2);
		try {
			// 1. 서비스로 비지니스(업무) 로직 수행하기
			int result = memberService.insertMember(m);
			
			// 2. 처리 결과에 따른 화면 처리
			String loc = "/"; // / : welcome-file
			String msg = "";
			
			if(result > 0) {
				msg = "회원 가입 성공!";
			} else {
				msg = "회원 가입 실패!";
			}
			
			model.addAttribute("loc", loc);
			model.addAttribute("msg", msg);		
			
		} catch(Exception e) {
			System.out.println("회원 가입 시 에러 발생!");
			System.out.println("Err :: " + e.getMessage());
			
			// 우리가 발생한 에러에 대해 직접 처리할 수도 있다.
			throw new MemberException(e.getMessage());
		}
		
		return "common/msg";
	}
	
	@RequestMapping("/member/memberLogin.do")
	public String memberLogin(@RequestParam String userId, 
							  @RequestParam String password,
							  Model model) { // Model : HttpServletRequest / HttpServletResponse
		
		System.out.println("로그인 기능 접근 확인!");
		
		// 아이디를 통해 회원 정보 조회
		Member result = memberService.selectOneMember(userId);
		
		String loc = "/";
		String msg = "";
		
		if(result != null) {
			// 아이디가 있다면
			if(bcryptPasswordEncoder.matches(password, result.getPassword())) {
				// 비밀번호 비교 : bcrypt에서 비교를 위한 메소드를 제공해준다.
				msg = "로그인 성공!";
				
				// model은 기본적으로 객체를 request 영역에 저장한다.
				// @ SessionAttributes 어노테이션을 통해 세션에 저장할 수 있다.
				model.addAttribute("member", result);
			
			} else {
				msg = "비밀번호가 일치하지 않습니다!";
			}
			
		} else {
			msg = "존재하지 않는 아이디입니다!";
		}
		
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";
	}
	
	@RequestMapping("/member/memberLogout.do")
	public String memberLogout(SessionStatus status) {
		// 세션 무효화 : HttpSession -> session.invalidate();
		
		if(!status.isComplete()) {
			status.setComplete(); // 세션을 끝내라
		}
	
		return "redirect:/";
	}
	
	@RequestMapping("/member/memberView.do")
	public String memberView(@RequestParam String userId, Model model) {
		Member result = memberService.selectOneMember(userId);
		
		model.addAttribute("member", result);
		
		return "member/memberView";
	}
	
	@RequestMapping("/member/memberUpdate.do")
	public String memberUpdate(Member member, Model model) {		
		int result = memberService.updateMember(member);
		
		String loc = "/";
		String msg = "";
		
		if(result > 0) {
			msg = "회원 정보 수정 완료";
			model.addAttribute("member", member);
		} else {
			msg = "회원 정보 수정 실패";
		}
		
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";
	}
	
	@RequestMapping("/member/memberDelete.do")
	public String memberDelete(Member member, SessionStatus status, Model model) {
		// 1. 탈퇴할 회원 아이디 가져오기
		// 2. 탈퇴한 회원 로그아웃 시키기
		int result = memberService.deleteMember(member.getUserId());
		
		String loc = "/";
		String msg = "";
		
		if(result > 0) {
			msg = "회원 탈퇴 완료";
			status.setComplete();
		} else {
			msg = "회원 탈퇴 실패";
		}
		
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";
	}
	
	/*
	// 1. 일반 문자열로 구현하는 방법(stream 방식)
	@RequestMapping("/member/checkIdDuplicate.do")
	public void checkIdDuplicate(
				@RequestParam String userId,
				HttpServletResponse response
			) throws IOException {
		
		int check = memberService.checkIdDuplicate(userId);
		
		boolean data = (check == 0 ? true : false);
		
		response.getWriter().print(data);
		
		// 만약 Gson을 사용한다면
		// new Gson().toJson(보낼 객체, response.getWriter());		
	}
	*/
	
	// 2. jackson 사용 방법
	@RequestMapping("/member/checkIdDuplicate.do")
	@ResponseBody
	public Map<String, Object> checkIdDuplicate(@RequestParam String userId) {
		new Gson().fromJson();
		Map<String, Object> map = new HashMap<String, Object>();
		
		int check = memberService.checkIdDuplicate(userId);
		
		if(check == 0) {
			map.put("isUsable", true);
		} else {
			map.put("isUsable", false);
		}
		
		return map;
	}
	
}
