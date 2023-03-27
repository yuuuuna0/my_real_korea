package com.itwill.my_real_korea.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class FreeBoardComment {
	private int fCommentNo;
	private String fCommentContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fCommentDate;
	private int fBoNo;
	/* FK */
	private String UserId;
}
