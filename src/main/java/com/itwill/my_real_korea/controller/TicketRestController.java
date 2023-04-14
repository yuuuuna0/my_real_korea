package com.itwill.my_real_korea.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.service.ticket.TicketImgService;
import com.itwill.my_real_korea.service.ticket.TicketService;
import com.itwill.my_real_korea.util.PageMakerDto;

import io.swagger.annotations.ApiOperation;

//@RestController
public class TicketRestController {

    private final TicketService ticketService;
    private final TicketImgService ticketImgService;

    //@Autowired
    public TicketRestController(TicketService ticketService, TicketImgService ticketImgService) {
        this.ticketService = ticketService;
        this.ticketImgService = ticketImgService;
    }

    /*티켓 리스트 - 정렬 -> rest*/
    //키워드, 지역별 - 필터 + 가격순, 날짜별 정렬 - 화면에 어떻게 넘길 지 생각하기 ㅠ
    @ApiOperation(value = "티켓-필터-정렬")
    //@ResponseBody
    @GetMapping(value = "/ticket-list-sort", produces = "application/json;charset=UTF-8")
    public Map<String, Object> ticketList(@RequestParam (required = false, defaultValue = "1") int currentPage, 
    										@RequestParam(required = false, defaultValue = "0") int cityNo, 
    										@RequestParam(required = false, defaultValue = "")String sortOrder,
    										@PathVariable String keyword) {
        Map<String, Object> ticketMap = new HashMap<>();
        int code = 1;
        String msg = "성공";
        PageMakerDto<Ticket> ticketList = null; // null로 넣음
        try {
            /*
                필터링 ->  tiNoDESC : 최신 순 / tiPriASC, tiPriDESC : 가격 순
             */
        	//keyword가 있으면 -> 보여줌 cityNo -> 있으면 보여줌 sortOrder -> 정렬
            ticketList = ticketService.selectByTicketAllSort(currentPage, keyword, cityNo, sortOrder);
            if (ticketList.getTotRecordCount() != 0 && ticketList != null) {
                code = 1;
                msg = "성공";
            } else {
                code = 2;
                msg = "검색 조건에 해당하는 티켓이 없습니다.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            code = 3;
            msg = "오류";
        }

        ticketMap.put("code", code);
        ticketMap.put("msg", msg);
        ticketMap.put("ticketList", ticketList);

        return ticketMap;
    }
    
   /* @LoginCheck
    @PostMapping(value="ticket-review-write-action", produces="application/json;charset=UTF-8")
	public Map <String, Object> ticketReviewWriteAction(){
		
    	return "";
	}*/

}
