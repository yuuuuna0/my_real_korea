package com.itwill.my_real_korea.dto.chat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ChatRoom {

	private int roomNo;
	private String roomName;
	private Date sendTime;
	private int notRead;
	/* FK */
	private String fromId;
	/* FK */
	private String toId;
	/* list<ChatMsg>  - ChatMsg 의 정보를 가져오기 위함 (1:N)*/
	private List<ChatMsg> chatMsgList;
	
	
	public ChatRoom(int roomNo, String roomName, Date sendTime, int notRead, String fromId, String toId) {
		super();
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.sendTime = sendTime;
		this.notRead = notRead;
		this.fromId = fromId;
		this.toId = toId;
		this.chatMsgList = new ArrayList<>();
	}
	

	

}
