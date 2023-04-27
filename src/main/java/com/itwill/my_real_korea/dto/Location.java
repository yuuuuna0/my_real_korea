package com.itwill.my_real_korea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
	private double lat;
	private double lng;
	private int toNo;
	private int tiNo;
}
