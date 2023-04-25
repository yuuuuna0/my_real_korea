package com.itwill.my_real_korea.service.ticket;

import com.itwill.my_real_korea.dao.ticket.TicketReviewDao;
import com.itwill.my_real_korea.dto.ticket.TicketReview;
import com.itwill.my_real_korea.util.PageMaker;
import com.itwill.my_real_korea.util.PageMakerDto;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TicketReviewServiceImpl implements TicketReviewService{

    private final TicketReviewDao ticketReviewDao;

    @Autowired
    public TicketReviewServiceImpl(TicketReviewDao ticketReviewDao) {
        this.ticketReviewDao = ticketReviewDao;
    }

    @Override
    public int insertTicketReview(TicketReview ticketReview) {
        return ticketReviewDao.insertTicketReview(ticketReview);
    }
    
    @Override
	public TicketReview selectByTicketReviewOne(int tiReviewNo) {
		return ticketReviewDao.selectByTicketReviewOne(tiReviewNo);
	}
    //티켓 리뷰 LIST
    @Override
    public List<TicketReview> selectByTicketReviewNo(int tiNo){
    	return ticketReviewDao.selectByTicketReviewNo(tiNo);
    }
    @Override
    public List<TicketReview> selectByTicketReviewUser(String userId){
    	return ticketReviewDao.selectByTicketReviewUser(userId);
    }
    @Override
    public int updateTicketReview(TicketReview ticketReview) {
        return ticketReviewDao.updateTicketReview(ticketReview);
    }

    @Override
    public int deleteTicketReview(int tiReviewNo) {
        return ticketReviewDao.deleteTicketReview(tiReviewNo);
    }

    /*	페이징
    @Override
    public PageMakerDto<TicketReview> selectByTicketReview(int currentPage, int tiReviewNo) throws Exception {
        int totReviewCount = ticketReviewDao.selectAllReviewCount();
        PageMaker pageMaker = new PageMaker(totReviewCount, currentPage);
        List<TicketReview> ticketReviewList
                = ticketReviewDao.selectByTicketReview(pageMaker.getPageBegin(), pageMaker.getPageEnd(), tiReviewNo);
        return new PageMakerDto<TicketReview>(ticketReviewList,pageMaker,totReviewCount);
    }

    @Override
    public PageMakerDto<TicketReview> selectByTicketReviewUser(int currentPage, String userId) throws Exception {
        int totReviewCount = ticketReviewDao.selectAllReviewCount();
        PageMaker pageMaker = new PageMaker(totReviewCount, currentPage);
        List<TicketReview> ticketReviewUserList
                = ticketReviewDao.selectByTicketReviewUser(pageMaker.getPageBegin(),pageMaker.getPageEnd(),userId);
        return new PageMakerDto<TicketReview>(ticketReviewUserList, pageMaker, totReviewCount);
    }
*/
    @Override
    public int ticketReviewImg(String tiReviewImg, int tiReviewNo) {
        return ticketReviewDao.ticketReviewImg(tiReviewImg, tiReviewNo);
    }

    @Override
    public int tiReviewImgUpload(String tiReviewImgUpload, int tiReviewNo) {
        return ticketReviewDao.tiReviewImgUpload(tiReviewImgUpload, tiReviewNo);
    }

	@Override
	public int ticketReviewImgNull(int tiReviewNo) {
		// TODO Auto-generated method stub
		return ticketReviewDao.ticketReviewImgNull(tiReviewNo);
	}

	@Override
	public int calculateTourScore(int tiNo) throws Exception {
		 int ticketScore = 0;
	        int totScore = 0;
	        List<TicketReview> ticketReviewList = ticketReviewDao.selectByTicketReviewNo(tiNo);
	        if(ticketReviewList.size()!=0){
	            for(TicketReview ticketReview : ticketReviewList){
	                totScore+=ticketReview.getTiReviewStar();
	            }
	            ticketScore=totScore/(ticketReviewList.size());
	        }else if (ticketReviewList.size()==0){
	            ticketScore=0;
	        }
	        return ticketScore;
	    }
    
}
