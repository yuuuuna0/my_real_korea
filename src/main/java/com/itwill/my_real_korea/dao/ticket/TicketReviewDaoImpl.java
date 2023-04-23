package com.itwill.my_real_korea.dao.ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.ticket.TicketReview;
import com.itwill.my_real_korea.mapper.TicketReviewMapper;

@Repository
public class TicketReviewDaoImpl implements TicketReviewDao{

    private final TicketReviewMapper ticketReviewMapper;
    @Autowired
    public TicketReviewDaoImpl(TicketReviewMapper ticketReviewMapper ) {
            this.ticketReviewMapper = ticketReviewMapper;
    }
    @Override
    public int insertTicketReview(TicketReview ticketReview) {
        return ticketReviewMapper.insertTicketReview(ticketReview);
    }
  

    @Override
    public int updateTicketReview(TicketReview ticketReview) {
        return ticketReviewMapper.updateTicketReview(ticketReview);
    }

    @Override
    public int deleteTicketReview(int tiReviewNo) {
        return ticketReviewMapper.deleteTicketReview(tiReviewNo);
    }



    @Override
	public List<TicketReview> selectByTicketReviewNo(int tiNo) {
		return ticketReviewMapper.selectByTicketReviewNo(tiNo);
	}
	@Override
	public List<TicketReview> selectByTicketReviewUser(String userId) {
		return ticketReviewMapper.selectByTicketReviewUser(userId);
	}
	@Override
	public TicketReview selectByTicketReviewOne(int tiReviewNo) {
		return ticketReviewMapper.selectByTicketReviewOne(tiReviewNo);
	}

   
    
    /*
    ---- 페이징 -----
    @Override
    public int selectAllReviewCount() throws Exception {
        return ticketReviewMapper.selectAllReviewCount();
    }
    @Override
    public List<TicketReview> selectByTicketReview(int pageStart, int pageEnd, int tiReviewNo){
        Map<String, Object> ticketReviewList = new HashMap<>();
        ticketReviewList.put("pageStart", pageStart);
        ticketReviewList.put("pageEnd", pageEnd);
        ticketReviewList.put("tiReviewNo", tiReviewNo);
        return ticketReviewMapper.selectByTicketReview(ticketReviewList);
    }

    @Override
    public List<TicketReview> selectByTicketReviewUser(int pageStart, int pageEnd, String userId) {
        Map<String, Object> ticketReviewUserList = new HashMap<>();
        ticketReviewUserList.put("pageStart", pageStart);
        ticketReviewUserList.put("pageEnd", pageEnd);
        ticketReviewUserList.put("userId", userId);
        return ticketReviewMapper.selectByTicketReviewUser(ticketReviewUserList);
    }
    */
	
    @Override
    public int ticketReviewImg(String tiReviewImg, int tiReviewNo) {
        return ticketReviewMapper.ticketReviewImg(tiReviewImg, tiReviewNo);
    }

    @Override
    public int tiReviewImgUpload(String tiReviewImgUpload, int tiReviewNo) {
        return ticketReviewMapper.tiReviewImgUpload(tiReviewImgUpload, tiReviewNo);
    }
	@Override
	public int ticketReviewImgNull(int tiReviewNo) {
		return ticketReviewMapper.ticketReviewImgNull(tiReviewNo);
	}

}
