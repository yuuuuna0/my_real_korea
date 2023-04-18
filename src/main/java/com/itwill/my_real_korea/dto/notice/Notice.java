package com.itwill.my_real_korea.dto.notice;
/*
이름          널?       유형             
----------- -------- -------------- 
N_NO        NOT NULL NUMBER         
N_TITLE     NOT NULL VARCHAR2(1000) 
N_CONTENT   NOT NULL VARCHAR2(2000) 
N_DATE               DATE           
N_READCOUNT          NUMBER         
N_IMG                VARCHAR2(500)  
USER_ID              VARCHAR2(50)   
 */


import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notice {
	private int nNo;
	private String nTitle;
	private String nContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date nDate;
	private int nReadcount;
	private String nImg;
	/* FK */
	private String userId;
	
	private String uploadFile;

	public Notice(int nNo, String nTitle, String nContent, Date nDate, int nReadcount, String nImg, String userId) {
		super();
		this.nNo = nNo;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nDate = nDate;
		this.nReadcount = nReadcount;
		this.nImg = nImg;
		this.userId = userId;
	}
	
}
