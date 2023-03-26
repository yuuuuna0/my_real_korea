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
	private int f_comment_no;
	private String f_comment_content;
	private Date f_comment_date;
	private int f_bo_no;
	private String user_id;
}
