package com.itwill.my_real_korea.dto.freeboard;

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
