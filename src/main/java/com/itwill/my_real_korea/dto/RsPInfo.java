package com.itwill.my_real_korea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
이름          널?       유형           
----------- -------- ------------ 
RS_P_NO     NOT NULL NUMBER       
RS_P_NAME            VARCHAR2(50) 
RS_P_EMAIL           VARCHAR2(50) 
RS_P_PHONE          VARCHAR2(50) 
USER_ID              VARCHAR2(50) 
P_NO                 NUMBER  
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RsPInfo {
	private int rsPNo;
	private String rsPName;
	private String rsPEmail;
	private String rsPPhone;
	private String userId;
	private int pNo;
}
