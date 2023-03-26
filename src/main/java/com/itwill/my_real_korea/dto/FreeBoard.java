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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fBoDate;
	private int fBoCount;
	private int cityNo;
	/* FK */
	private String userId;
}
