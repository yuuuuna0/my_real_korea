package com.itwill.my_real_korea.dto.freeboard;

import com.itwill.my_real_korea.util.PageMaker;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FreeBoardListPageMakerDto {
	private List<FreeBoard> itemList;
	private PageMaker pageMaker;
}
