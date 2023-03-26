package com.itwill.my_real_korea.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatMsg {

	private int msgNo;
	private String msgContent;
	private Date msgSendTime;
	private int msgRead;
	/* FK */
	private int roomNo;
	/* FK */
	private String userId;
	
}
