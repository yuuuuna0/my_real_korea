package com.itwill.my_real_korea.dto.freeboard;

import com.itwill.my_real_korea.util.PageMaker;
import lombok.Data;

import java.util.List;
@Data
public class FreeBoardListPageMakerDto {
	private List<FreeBoard> itemList;
	private PageMaker pageMaker;
}
