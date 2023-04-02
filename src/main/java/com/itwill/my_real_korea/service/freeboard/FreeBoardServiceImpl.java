package com.itwill.my_real_korea.service.freeboard;

import com.itwill.my_real_korea.dao.freeboard.FreeBoardDao;
import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.dto.notice.Notice;
import com.itwill.my_real_korea.util.PageMaker;
import com.itwill.my_real_korea.util.PageMakerDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeBoardServiceImpl implements FreeBoardService{
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
    public FreeBoard selectByNo(int no) throws Exception {
        return freeBoardDao.selectByNo(no);
    }

    @Override
    public List<FreeBoard> selectAll(int pageStart, int pageEnd) throws Exception {
        return freeBoardDao.selectAll(pageStart, pageEnd);
    }

    @Override
    public int updateFreeBoard(FreeBoard freeBoard) throws Exception {
        return freeBoardDao.updateBoard(freeBoard);
    }

    @Override
    public int deleteFreeBoard(int no) throws Exception {
        return freeBoardDao.deleteBoard(no);
    }


    @Override
    public int increaseReadCount(int no) throws Exception {
        return freeBoardDao.increaseReadCount(no);
    }

    @Override
    public int selectFreeBoardCount() throws Exception {
        return freeBoardDao.selectFreeBoardCount();
    }

    @Override
    public int selectSearchCount(String keyword) throws Exception {
        return freeBoardDao.selectSearchCount(keyword);
    }

    @Override
    public List<FreeBoard> selectSearchFreeBoardList(int pageStart, int pageEnd, String keyword) throws Exception {
        return freeBoardDao.selectSearchFreeBoardList(pageStart,pageEnd,keyword);
    }

    /*
     * selectAll 수정 - 김민선
     */
    @Override
    public PageMakerDto<FreeBoard> selectAll(int currentPage) throws Exception {
    	// 전체 글의 수
        int totalRecordCount = freeBoardDao.selectFreeBoardCount();
        // paging 계산 (PageMaker)
        PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
        // 게시글 데이터 얻기
        List<FreeBoard> freeBoardList = freeBoardDao.selectAll(pageMaker.getPageBegin(), pageMaker.getPageEnd());
        PageMakerDto<FreeBoard> pageMakerFreeBoardList = new PageMakerDto<FreeBoard>(freeBoardList, pageMaker, totalRecordCount);
        
        return pageMakerFreeBoardList;
    }

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

    @Override
    public PageMakerDto selectSearchFreeBoardList(int currentPage, String keyword) throws Exception {
        int totalRecordCount = freeBoardDao.selectSearchCount(keyword);
        // paging 계산 (PageMaker)
        PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
        // 게시글 데이터 얻기
        List<FreeBoard> freeboareList = freeBoardDao.selectSearchFreeBoardList(pageMaker.getPageBegin(), pageMaker.getPageEnd(),keyword);
        PageMakerDto pageMakerBoardList = new PageMakerDto();
        pageMakerBoardList.itemList =freeboareList;
        pageMakerBoardList.pageMaker = pageMaker;
        return pageMakerBoardList;
    }
}
