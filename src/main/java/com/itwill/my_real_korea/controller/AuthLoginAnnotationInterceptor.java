package com.itwill.my_real_korea.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthLoginAnnotationInterceptor implements HandlerInterceptor {
	public AuthLoginAnnotationInterceptor() {
	}

	@Override
	public boolean preHandle(	HttpServletRequest request, 
								HttpServletResponse response, 
								Object handler) throws Exception {
		if (handler instanceof HandlerMethod == false) {
			return true;
		}
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		LoginCheck loginCheck = handlerMethod.getMethodAnnotation(LoginCheck.class);
		if (loginCheck == null) {
			return true;
		}
		HttpSession session = request.getSession();
		String sUserId = (String) session.getAttribute("sUserId");
		if (sUserId == null) {
		    String requestUrl = request.getRequestURL().toString();
		    session.setAttribute("requestUrl", requestUrl);
		    response.sendRedirect("user_login_form");
		    return false;
		} else {
		    String requestUrl = (String) session.getAttribute("requestUrl");
		    if (requestUrl != null) {
		        session.removeAttribute("requestUrl");
		        response.sendRedirect(requestUrl);
		        return false;
		    }
		}

		return true;
	}

	
}


