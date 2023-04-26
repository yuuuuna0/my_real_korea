package com.itwill.my_real_korea.service.freeboard;

import com.itwill.my_real_korea.controller.FreeBoardController;
import com.itwill.my_real_korea.dao.freeboard.FreeBoardDao;
import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.util.PageMaker;
import com.itwill.my_real_korea.util.PageMakerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {
    private FreeBoardDao freeBoardDao;

    @Autowired
    public FreeBoardServiceImpl(FreeBoardDao freeBoardDao) {
        this.freeBoardDao = freeBoardDao;
    }

    @Override
    public int insertBoard(FreeBoard freeBoard) throws Exception {
        return freeBoardDao.insertBoard(freeBoard);
    }


    @Override
    public FreeBoard selectByNo(int fBoNo) throws Exception {
        return freeBoardDao.selectByNo(fBoNo);
    }
    @Override
    public List<FreeBoard> selectByUserId(String userId) throws Exception {
        return freeBoardDao.selectByUserId(userId);
    }

    @Override
    public int updateFreeBoard(FreeBoard freeBoard) throws Exception {
        FreeBoard updateFreeBoard = FreeBoard.builder()
                .fBoTitle(freeBoard.getFBoTitle())
                .fBoContent(freeBoard.getFBoContent())
                .fBoNo(freeBoard.getFBoNo())
                .build();
        City city = freeBoard.getCity();
        updateFreeBoard.setCity(city);
        return freeBoardDao.updateBoard(updateFreeBoard);
    }

    @Override
    public int deleteFreeBoard(int no) throws Exception {
        return freeBoardDao.deleteBoard(no);
    }

    //조회수 증가
    @Override
    public int increaseReadCount(int no) throws Exception {
        return freeBoardDao.increaseReadCount(no);
    }
    //자유게시판 게시글 수
    @Override
    public int selectFreeBoardCount() throws Exception {
        return freeBoardDao.selectFreeBoardCount();
    }
    //키워드로 검색시 게시글수 조회
    @Override
    public int selectSearchCount(String keyword) throws Exception {
        return freeBoardDao.selectSearchCount(keyword);
    }
    //키워드로 검색시 게시글수 조회
    @Override
    public int selectCityNoCount(int cityNo) throws Exception {
    	return freeBoardDao.selectCityNoCount(cityNo);
    }

    @Override
    public PageMakerDto<FreeBoard> selectAll(int currentPage) throws Exception {
        // 전체 글의 수
        int totFreeBoardCount = freeBoardDao.selectFreeBoardCount();
        // paging 계산 (PageMaker)
        PageMaker pageMaker = new PageMaker(totFreeBoardCount, currentPage);
        // 게시글 데이터 얻기
        List<FreeBoard> freeBoardList = freeBoardDao.selectAllOrderByFBoNoDesc(pageMaker.getPageBegin(), pageMaker.getPageEnd());

        PageMakerDto<FreeBoard> pageMakerFreeBoardList = new PageMakerDto<FreeBoard>(freeBoardList, pageMaker, totFreeBoardCount);

        return pageMakerFreeBoardList;
    }

    //자유게시판 최신순 정렬
    @Override
    public PageMakerDto<FreeBoard> selectAllOrderByFBoNoDesc(int currentPage) throws Exception {
        int totalFreeBoardCount = freeBoardDao.selectFreeBoardCount();

        PageMaker pageMaker = new PageMaker(totalFreeBoardCount, currentPage);

        List<FreeBoard> freeBoardList = freeBoardDao.selectAllOrderByFBoNoDesc(pageMaker.getPageBegin(), pageMaker.getPageEnd());

        PageMakerDto<FreeBoard> pageMakerBoardList = new PageMakerDto();

        pageMakerBoardList.setItemList(freeBoardList);
        pageMakerBoardList.setPageMaker(pageMaker);
        return pageMakerBoardList;
    }
    //자유게시판 오래된순 정렬
    @Override
    public PageMakerDto<FreeBoard> selectAllOrderByFBoNoAsc(int currentPage) throws Exception {
        int totalRecordCount = freeBoardDao.selectFreeBoardCount();

        PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);

        List<FreeBoard> freeBoardList = freeBoardDao.selectAllOrderByFBoNoAsc(pageMaker.getPageBegin(), pageMaker.getPageEnd());

        PageMakerDto<FreeBoard> pageMakerBoardList = new PageMakerDto();

        pageMakerBoardList.setItemList(freeBoardList);
        pageMakerBoardList.setPageMaker(pageMaker);
        return pageMakerBoardList;
    }
    //자유게시판 조회수 정렬
    @Override
    public PageMakerDto<FreeBoard> selectAllOrderByReadCountDesc(int currentPage) throws Exception {
        int totalRecordCount = freeBoardDao.selectFreeBoardCount();

        PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);

        List<FreeBoard> freeBoardList = freeBoardDao.selectAllOrderByReadCountDesc(pageMaker.getPageBegin(), pageMaker.getPageEnd());
        PageMakerDto<FreeBoard> pageMakerBoardList = new PageMakerDto();
        pageMakerBoardList.setItemList(freeBoardList);
        pageMakerBoardList.setPageMaker(pageMaker);
        return pageMakerBoardList;
    }

    //자유게시판 타이틀 14글자 제한
    @Override
    public String getTitleString(FreeBoard freeBoard) throws Exception {
        StringBuilder title = new StringBuilder(128);
        String t = freeBoard.getFBoTitle();
        if (t.length() > 15) {
            t = String.format("%s...", t.substring(0, 15));
        }
        title.append(t.replace(" ", "&nbsp;"));
        return title.toString();
    }

    //자유게시판 키워드 검색으로 게시글 리스트 보기
    @Override
    public PageMakerDto<FreeBoard> selectSearchFreeBoardList(int currentPage, String keyword) throws Exception {
        int totalRecordCount = freeBoardDao.selectSearchCount(keyword);
        // paging 계산 (PageMaker)
        PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
        // 게시글 데이터 얻기
        List<FreeBoard> freeboardList = freeBoardDao.selectSearchFreeBoardList(pageMaker.getPageBegin(), pageMaker.getPageEnd(), keyword);
        PageMakerDto<FreeBoard> pageMakerBoardList = new PageMakerDto();
        pageMakerBoardList.setItemList(freeboardList);
        pageMakerBoardList.setPageMaker(pageMaker);
        return pageMakerBoardList;
    }
    //자유게시판 키워드 검색으로 게시글 리스트 보기
    @Override
    public PageMakerDto<FreeBoard> selectFreeBoardCityList(int currentPage, int cityNo) throws Exception {
    	int totalRecordCount = freeBoardDao.selectCityNoCount(cityNo);
    	// paging 계산 (PageMaker)
    	PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
    	// 게시글 데이터 얻기
    	List<FreeBoard> freeboardList = freeBoardDao.selectFreeBoardCityList(pageMaker.getPageBegin(), pageMaker.getPageEnd(), cityNo);
    	PageMakerDto<FreeBoard> pageMakerBoardList = new PageMakerDto();
    	pageMakerBoardList.setItemList(freeboardList);
    	pageMakerBoardList.setPageMaker(pageMaker);
    	return pageMakerBoardList;
    }
}
