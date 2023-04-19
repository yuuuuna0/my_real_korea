package com.itwill.my_real_korea.config;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.mail.Session;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

//@Log4j2
//@Service
//@ServerEndpoint(value="/ws/chat")
//public class WebSocketChat {
//	
//	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
//
//	@OnOpen
//	public void onOpen(Session session) {
//		if (!clients.contains(session)) {
//			clients.add(session);
//			log.info("OnOpen : session open" + session);
//		} else {
//			log.info("이미 연결된 session");
//		}
//	}
//
//	@OnClose
//	public void OnClose(Session session) {
//		clients.remove(session);
//		log.info("OnClose:");
//	}
//
//	@OnMessage
//	public void onMessage(String message, Session session) {
//		log.info("OnMessage:" + message);
//		for (Session s : clients) {
//            log.info("send data : {}", message);
//
//            s.getBasicRemote().sendText(message);
//        }
//	}
//}