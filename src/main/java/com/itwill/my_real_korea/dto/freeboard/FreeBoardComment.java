package com.itwill.my_real_korea.dto.freeboard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@ToString

public class FreeBoardComment {
	private int fCommentNo;
	private String fCommentContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fCommentDate;
	/* FK */
	private int fBoNo;
	private String UserId;
}
