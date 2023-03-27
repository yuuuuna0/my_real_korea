package com.itwill.my_real_korea.dto.chat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
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
}
