package com.itwill.my_real_korea.config;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.websocket.Session;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@ServerEndpoint(value="/ws/chat")
public class WebSocketChat {
	
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

	private static Map<String, Session> userSessions = new HashMap();
	
	String userId = "";
	String userKey = "";
	
	// 웹소켓 연결 시
	@OnOpen
	public void onOpen(Session session) {
		String chatId = "";
		String roomNo = "";
		String queryStr = (String)session.getQueryString();
		String key= "";
		// 세션의 URI 쿼리스트링에서 chatID와 roomNo 얻기
		if(queryStr.contains("&")) {
			String[] qStrArray = queryStr.split("&");
			chatId = qStrArray[0].trim();
			roomNo = qStrArray[1].trim();
			key = chatId + "&"+ roomNo;
		}else {
			chatId = (String)session.getQueryString();
			key = chatId;
		}
		// userKey = key = 채팅아이디&채팅방번호 or 채팅아이디
		this.userKey = key;
		
		System.out.println("연결 세션:" + session);
		System.out.println("채팅아이디:" + chatId);
		// key String값에 session 넣기
		userSessions.put(key, session);
		System.out.println(userSessions);
		
//		if (!clients.contains(session)) {
//			clients.add(session);
//			log.info("OnOpen : session open" + session);
//		} else {
//			log.info("이미 연결된 session");
//		}
	}

	// 웹소켓 연결 끊길 때
	@OnClose
	public void OnClose(Session session) {
		System.out.println("socket 닫기 : " + userKey);
		userSessions.remove(userKey);
		System.out.println(userSessions);
//		clients.remove(session);
//		log.info("OnClose:");
	}

	// 웹소켓 메세지 보낼 때
	@OnMessage
	public void onMessage(String message, Session session) {
		
		
		
		
		
		
		
		
		
		
//		log.info("OnMessage:" + message);
//		for (Session s : clients) {
//            log.info("send data : {}", message);
//
//            try {
//				s.getBasicRemote().sendText(message);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//        }
	}
}