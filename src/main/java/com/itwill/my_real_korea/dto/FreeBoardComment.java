package com.itwill.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class FreeBoardComment {
	private int fCommentNo;
	private String fCommentContent;
	private Date fCommentDate;
	private int fBoNo;
	private String user_id;
}
