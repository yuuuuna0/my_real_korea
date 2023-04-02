package com.itwill.my_real_korea.dto.chat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.socket.WebSocketSession;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/*
 이름        널?       유형            
--------- -------- ------------- 
ROOM_NO   NOT NULL NUMBER        
ROOM_NAME NOT NULL VARCHAR2(100) 
SEND_TIME          DATE          
NOT_READ           NUMBER        
FROM_ID            VARCHAR2(50)  
TO_ID              VARCHAR2(50)  

 */

@Data
@NoArgsConstructor
@ToString
public class ChatRoom {

	private int roomNo;
	private String roomName;
	/* FK */
	private String fromId;
	/* FK */
	private String toId;
	/* list<ChatMsg>  - ChatMsg 의 정보를 가져오기 위함 (1:N)*/
	private List<ChatMsg> chatMsgList;
	
	// 입장한 채팅 유저들의 세션 정보 리스트
	private Set<WebSocketSession> sessions = new HashSet<>();
	
	/* 웹소켓 stomp 
	private HashMap<String, String> userlist = new HashMap<String, String>();
	*/
	
	public ChatRoom(int roomNo, String roomName, String fromId, String toId) {
		super();
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.fromId = fromId;
		this.toId = toId;
		this.chatMsgList = new ArrayList<>();
	}
	

}
