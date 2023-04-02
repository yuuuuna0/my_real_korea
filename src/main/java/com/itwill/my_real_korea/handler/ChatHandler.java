package com.itwill.my_real_korea.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2 //log 변수를 사용하여 로그 기록 가능
public class ChatHandler extends TextWebSocketHandler{

	private static List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	/* payload : 전송되는 데이터 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();
		log.info("payload : " + payload);
		
		// 등록된 세션을 돌면서 메세지 전달
		for (WebSocketSession sess : sessionList) {
			sess.sendMessage(message);
		}
	}
	
	/* 채팅 유저 접속 시 호출되는 메소드 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("#ChattingHandler, afterConnectionEstablished");
		sessionList.add(session);
		log.info(session.getPrincipal().getName() + " 님이 입장하셨습니다.");
		
	}
	
	
	/* 채팅 유저 접속 해제 시 호출되는 메소드 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("#ChattingHandler, afterConnectionClosed");
		sessionList.remove(session);
		log.info(session.getPrincipal().getName() + " 님이 퇴장하셨습니다.");
	}
	
	
	
	
}
