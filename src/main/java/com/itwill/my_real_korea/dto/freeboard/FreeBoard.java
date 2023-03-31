package com.itwill.my_real_korea.dto.freeboard;

import com.itwill.my_real_korea.dto.City;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder

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
}
