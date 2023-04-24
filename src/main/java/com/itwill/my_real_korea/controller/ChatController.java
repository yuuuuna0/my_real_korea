package com.itwill.my_real_korea.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.If;
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

	@LoginCheck
	@GetMapping("/chat")
	public String getChat(HttpServletRequest request, 
							Model model,
							@RequestParam(required = false, value = "receiverId") String receiverId) {

		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		String userId = loginUser.getUserId();
		String senderId = userId;
		String roomName = "";
		/*
		receiverId는 채팅 시작 클릭버튼에 hidden으로 해당 프로필유저의 아이디걸어놓은거 가져오기
		 */
		if (session != null) {
			String name = session.toString().substring(session.toString().indexOf("@"));
			session.setAttribute("sessionId", name);
		} 
		// 채팅방 이름 생성
		roomName = senderId+"&"+receiverId;
		// receiverId가 포함된 이름의 채팅방들
		//List<ChatRoom> findChatRoomList = chatService.selectByRoomNameWith(receiverId);
		ChatRoom findChatRoom = chatService.selectByRoomName(roomName);
		if (findChatRoom == null) {
			// receiverId 포함된 방 없다면 새로 생성
			// roomName 같은 거 없으면 방 생성
			ChatRoom newChatRoom = new ChatRoom(roomName);
			chatService.insertChatRoom(newChatRoom);
			model.addAttribute("roomName", roomName);
		} else {
			// receiverId가 포함된 이름의 채팅방이 있다면, 그 채팅방 이름을 주기 (임의로)
			//model.addAttribute("roomName", findChatRoomList.get(0).getRoomName());
			model.addAttribute("roomName", findChatRoom.getRoomName());
		}
		
		// senderId 가 포함된 이름의 채팅방들 
		List<ChatRoom> myChatRoomList = chatService.selectByRoomNameWith(senderId);
		
		if(myChatRoomList.size() != 0) {
			// senderId 가 포함된 이름의 채팅방들 
			model.addAttribute("myChatRoomList", myChatRoomList);
		}
		
		System.out.println(">>>> roomName :"+ roomName);
		model.addAttribute("receiverId", receiverId);
		model.addAttribute("senderId", senderId);
		//세션에 채팅방 이름 저장
		session.setAttribute("chatRoomName", roomName);
		
		log.info("@ChatController, getChat()");
		return "chat";
	}

	@GetMapping("/chat/master")
	public String enterChatAsMaster(HttpServletRequest request) {

		log.info("@ChatController, enterChatAsMaster()");
		return "/chat";
	}
	
	
	
}
