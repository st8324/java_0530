package kr.kh.edu.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.edu.service.MemberService;
import kr.kh.edu.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	MemberService memberService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		
		//회원 정보가 있는지 확인
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");
		if(user == null) {
			return;
		}
			
		//있으면 세션에 저장
		request.getSession().setAttribute("user", user);
		
		//자동 로그인 체크를 안했으면 
		if(!user.isAutoLogin()) {
			return;
		}
		
		//자동 로그인 체크를 했으면 
		String sessionId = request.getSession().getId();
		//쿠키 생성
		Cookie cookie = new Cookie("edu", sessionId);
		//쿠키 경로와 만료 시간을 설정
		cookie.setPath("/");
		int time = 60 * 60 * 24 * 7; // 60 * 60 * 24 * 7 == 7일을 초로 환산
		cookie.setMaxAge(time);
		//화면으로 쿠키 정보를 전달
		response.addCookie(cookie);
		
		//DB 회원 정보에 쿠키 정보를 추가
		Date date = new Date(System.currentTimeMillis() + time * 1000);
		user.setMe_session_id(sessionId);
		user.setMe_session_limit(date);
		memberService.updateMemberSession(user);
		
	}
}



