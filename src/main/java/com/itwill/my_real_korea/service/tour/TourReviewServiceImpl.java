package com.itwill.my_real_korea.service.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.tour.TourReviewDao;
import com.itwill.my_real_korea.dao.user.UserDao;
import com.itwill.my_real_korea.dto.tour.TourReview;
import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.util.PageMaker;
import com.itwill.my_real_korea.util.PageMakerDto;
@Service
public class TourReviewServiceImpl implements TourReviewService {
	private TourReviewDao tourReviewDao;
	private UserDao userDao;
	
	public TourReviewServiceImpl(TourReviewDao tourReviewDao,UserDao userDao) {
		this.tourReviewDao=tourReviewDao;
		this.userDao=userDao;
	}
	
	@Override
	public int insertTourReview(TourReview tourReview) throws Exception {
		// 투어상품 후기 추가
		return tourReviewDao.insertTourReview(tourReview);
	}

	@Override
	public int updateTourReview(TourReview tourReview) throws Exception {
		// 투어 후기 수정
		return tourReviewDao.updateTourReview(tourReview);
	}

	@Override
	public int deleteTourReview(int toReviewNo) throws Exception {
		//투어 후기 번호로 후기 삭제
		return tourReviewDao.deleteTourReview(toReviewNo);
	}

	@Override
	public List<TourReview> findByUserId(String userId) throws Exception {
		//사용자가 작성한 후기 전체 보기
		//게시글 데이터 얻기
		return tourReviewDao.selectByUserId(userId);
	}

	@Override
	public List<TourReview> findByToNo(int toNo) throws Exception {
		// 투어 상품번호로 후기 전체 보기
		List<TourReview> tourReviewList=tourReviewDao.selectByToNo(toNo);
		for (TourReview tourReview : tourReviewList) {
			tourReview.setUsers(userDao.findUser(tourReview.getUsers().getUserId()));
		}
		return tourReviewList;
	}

	@Override
	public int calculateTourScore(int toNo) throws Exception {
		// 투어 평점 구하기
		List<TourReview> tourReviewList=tourReviewDao.selectByToNo(toNo);
		int tourScore=0;
		int totScore=0;
		if(tourReviewList.size()!=0) {
			for (TourReview tourReview : tourReviewList) {
				totScore+=tourReview.getToReviewStar();
			}
			tourScore=totScore/(tourReviewList.size());
		} else if(tourReviewList.size()==0) {
			tourScore=0;
		}
		return tourScore;
	}

	@Override
	public int updateToReviewUpload(String toReviewUpload, int toReviewNo) throws Exception {
		return tourReviewDao.updateToReviewUpload(toReviewUpload, toReviewNo);
	}

	@Override
	public int updateToReviewImg(String toReviewImg, int toReviewNo) throws Exception {
		return tourReviewDao.updateToReviewImg(toReviewImg, toReviewNo);
	}

}
