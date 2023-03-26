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
	private int f_bo_no;
	private String f_bo_title;
	private String f_bo_content;
	private String f_ba_img;
	private Date f_bo_date;
	private int f_bo_count;
	private int city_no;
	private String user_id;
}
