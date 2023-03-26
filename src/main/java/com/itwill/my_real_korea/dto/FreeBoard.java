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

public class FreeBoard {
	private int fBoNo;
	private String fBoTitle;
	private String fBoContent;
	private String fBoImg;
	private Date fBoDate;
	private int fBoCount;
	private int city_no;
	private String user_id;
}
