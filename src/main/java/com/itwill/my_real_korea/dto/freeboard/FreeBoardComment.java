package com.itwill.my_real_korea.dto.freeboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
 이름                널?       유형
----------------- -------- --------------
F_CO_NO           NOT NULL NUMBER
F_COMMENT_CONTENT NOT NULL VARCHAR2(1000)
F_COMMENT_DATE             DATE
F_BO_NO                    NUMBER
USER_ID                    VARCHAR2(50)
 */

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class FreeBoardComment {
	private int fCoNo;
	private String fCommentContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fCommentDate;
	/* FK */
	private int fBoNo;

	private String userId;
}
