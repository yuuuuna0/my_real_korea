package com.itwill.my_real_korea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itwill.my_real_korea.service.ticket.TicketReviewService;
import org.springframework.web.bind.annotation.*;

import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.service.ticket.TicketImgService;
import com.itwill.my_real_korea.service.ticket.TicketService;
import com.itwill.my_real_korea.util.PageMakerDto;

import io.swagger.annotations.ApiOperation;

//@RestController
public class TicketRestController {

    private final TicketService ticketService;
    private final TicketImgService ticketImgService;
    private final TicketReviewService ticketReviewService;

    //@Autowired
    public TicketRestController(TicketService ticketService, TicketImgService ticketImgService,
                                TicketReviewService ticketReviewService) {
        this.ticketService = ticketService;
        this.ticketImgService = ticketImgService;
        this.ticketReviewService = ticketReviewService;
    }

    @PostMapping(value = "/ticket-list-sort", produces = "application/json;charset=UTF-8")
    public Map<String, Object> ticketList(@RequestBody Map<String,String> map){
        Map<String, Object> ticketMap = new HashMap<>();
        int code = 1;
        String msg = "성공";
        PageMakerDto<Ticket> data = null;
        int currentPage = Integer.parseInt(map.get("currentPage"));
        int cityNo = Integer.parseInt(map.get("cityNo"));
        String keyword = map.get("keyword");
        String sortOrder = map.get("sortOrder");

        try {
            PageMakerDto<Ticket> ticketPage
                    = ticketService.selectByTicketAllSort(currentPage,keyword, cityNo, sortOrder);
            data = ticketPage;
            code = 1;
            msg = "성공";
        } catch (Exception e){
            e.printStackTrace();
            code = 2;
            msg = "관리자에게 문의하세요.";
        }
        ticketMap.put("code", code);
        ticketMap.put("msg", msg);
        ticketMap.put("data", data);
        return ticketMap;
    }


























    /*티켓 리스트 - 정렬 -> rest
    키워드, 지역별 - 필터 + 가격순, 날짜별 정렬 - 화면에 어떻게 넘길 지 생각하기 ㅠ
    @ApiOperation(value = "티켓-필터-정렬")
    // queryString이 key1=value1&key2=value2 라면 json은 key1:value1,key2:value2 값 형태를 가짐.
    // json은 직렬화기 때문에 @RequestBody 를 사용해야함.
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
            if (ticketList.getTotRecordCount() != 0 && ticketList != null) {
                ticketList = ticketService.selectByTicketAllSort(currentPage, keyword, cityNo, sortOrder);
                List<Ticket> tempTicketList = ticketList.getItemList();
                List<Ticket> ticketList1 = new ArrayList<>();
                for(Ticket ticket: tempTicketList){
                    int ticketScore = ticketReviewService.calculateTourScore(ticket.getTiNo());
                    ticket.setTiScore(ticketScore);
                    ticketList1.add(ticket);
                }
                code = 1;
                msg = "성공";
                data = ticketList;
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
        ticketMap.put("data", data);

        return ticketMap;
    }*/
    
   /* @LoginCheck
    @PostMapping(value="ticket-review-write-action", produces="application/json;charset=UTF-8")
	public Map <String, Object> ticketReviewWriteAction(){
		
    	return "";
	}*/

}
