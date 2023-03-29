package com.itwill.my_real_korea.dao.ticket;

import com.itwill.my_real_korea.dto.ticket.TicketImg;
import com.itwill.my_real_korea.mapper.TicketImgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketImgDaoImpl implements TicketImgDao{


    private TicketImgMapper ticketImgMapper;
    @Autowired
    public TicketImgDaoImpl(TicketImgMapper ticketImgMapper) {
        this.ticketImgMapper = ticketImgMapper;
    }
    //이미지 생성
    @Override
    public int insertTicketImg(TicketImg ticketImg) throws Exception {
        return ticketImgMapper.insertTicketImg(ticketImg);
    }
    //이미지 출력
    @Override
    public List<TicketImg> selectAll(int tiNo) {
        return ticketImgMapper.selectAll(tiNo);
    }
    //이미지 수정
    @Override
    public int updateTicketImg(TicketImg ticketImg) {
        return ticketImgMapper.updateTicketImg(ticketImg);
    }
    //이미지 삭제
    @Override
    public int deleteTicketImg(int tiImgNo) {
        return ticketImgMapper.deleteTicketImg(tiImgNo);
    }
}
