package kr.kh.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("user");
		
		//로그인이 안되어 있을 때 자동 로그인을 할지말지를 결정 
		if(user == null) {
			//loginCookie 정보를 가져옴
			Cookie cookie = WebUtils.getCookie(request, "loginCookie");
			//loginCookie가 null이 아니면 =>이전에 자동로그인을 체크했으면  
			if(cookie != null) {
				//쿠키에 있는 세션 정보와 일치하는 회원 정보를 가져옴 
				String session_id = cookie.getValue();
				user = memberService.getMemberBySession(session_id);
				//회원 정보가 있으면 세션에 저장(자동로그인 성공)
				if(user != null) {
					session.setAttribute("user", user);
				}
			}
		}
		
		return true;
	}
	
}
