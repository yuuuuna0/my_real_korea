package com.itwill.my_real_korea.service.tripboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ej_final_project.dao.TripBoardCommentDao;
import com.itwill.ej_final_project.dto.TripBoardComment;

@Service
public class TripBoardCommentServiceImpl implements TripBoardCommentService {
	@Autowired
	private TripBoardCommentDao tripBoardCommentDao;
	
	public TripBoardCommentServiceImpl() {
		System.out.println(">>> TripBoardCommentServiceImpl 기본 생성자 호출");
	}
	
	/*
	 * 댓글 추가
	 */
	public int insertTripBoardComment(TripBoardComment tripBoardComment) throws Exception {
		return tripBoardCommentDao.insertTripBoardComment(tripBoardComment);
	}
	
	
	
}
