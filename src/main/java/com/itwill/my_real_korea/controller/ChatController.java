package com.itwill.my_real_korea.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.my_real_korea.dto.chat.ChatRoom;
import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.service.chat.ChatService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2  //log 변수를 사용하여 로그 기록 가능
public class ChatController {

	@Autowired
	private ChatService chatService;
	
	/*
	"/chat" 경로로 GET 요청이 들어오면 "chat" 뷰를 반환하며, 이 과정에서 로그를 출력
	 */
//	@LoginCheck
//	@GetMapping("/chat")
//	public String chat() {
//		log.info("@ChatController, chat GET()");
//		return "chat";
//	}
	
	@LoginCheck
	@GetMapping("/chat")
	public String getChat(HttpServletRequest request, 
							Model model,
							@RequestParam(required = false) String id) {

		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		System.out.println("chat param id 값 출력 : "  + id);
		
		if (id != null && id.equals("guest")) {
			String name = "guest" + session.toString().substring(session.toString().indexOf("@"));
			session.setAttribute("sessionId", name);
		} else if(id != null && id.equals("master")) {
			String name = "master";
			session.setAttribute("sessionId", name);
		}
		model.addAttribute("userId", userId);
		log.info("@ChatController, getChat()");
		return "chat";
	}

	@GetMapping("/chat/master")
	public String enterChatAsMaster(HttpServletRequest request) {

		log.info("@ChatController, enterChatAsMaster()");
		return "/chat";
	}
	
	
	
}
