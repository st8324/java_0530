package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(
		HttpServletRequest request,
		HttpServletResponse respose,
		Object handler,
		ModelAndView mv) {
		
		MemberVO user = (MemberVO)mv.getModel().get("user");
		
		if(user != null ) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}
	}
}
