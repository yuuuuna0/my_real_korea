package com.itwill.my_real_korea.dto.freeboard;

import com.itwill.my_real_korea.dto.City;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
 이름             널?       유형             
-------------- -------- -------------- 
F_BO_NO        NOT NULL NUMBER         
F_BO_TITLE     NOT NULL VARCHAR2(500)  
F_BO_CONTENT   NOT NULL VARCHAR2(1000) 
F_BO_DATE               DATE           
F_BO_READCOUNT          NUMBER         
CITY_NO                 NUMBER         
USER_ID                 VARCHAR2(50)   
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class FreeBoard {
	private int fBoNo;
	private String fBoTitle;
	private String fBoContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fBoDate;
	private int fBoCount;
	/* FK */
	private City city;
	private String userId;
	private int commentCount;
	@Builder
	public FreeBoard(int fBoNo, String fBoTitle, String fBoContent, Date fBoDate, int fBoCount,
			String userId) {
		this.fBoNo = fBoNo;
		this.fBoTitle = fBoTitle;
		this.fBoContent = fBoContent;
		this.fBoDate = fBoDate;
		this.fBoCount = fBoCount;
		this.city = new City();
		this.userId = userId;
	}
}