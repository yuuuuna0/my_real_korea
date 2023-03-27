package com.itwill.my_real_korea.dto.chat;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatRoomListView {

	private int roomNo;
	private String roomName;
	private Date sendTime;
	private int notRead;
	private String msgContent;
	private String youId;
}
