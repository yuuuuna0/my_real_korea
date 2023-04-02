package com.itwill.my_real_korea.service.freeboard;

import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardListPageMakerDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FreeBoardServiceImplTest {

    @Autowired
    private FreeBoardService freeBoardService;

    @Disabled
    @Test
    void insert() throws Exception {
        FreeBoard freeBoard = new FreeBoard(
                2,"질문있습니다"
                ,"어디로가야하나요",null
                ,0,1,"id2");
        int insert = freeBoardService.insertBoard(freeBoard);
        assertThat(insert).isEqualTo(1);
    }

    @Disabled
    @Test
    void update() throws Exception {
        FreeBoard updateFreeBoard = new FreeBoard(
                2,"수정테스트"
                ,"유럽여행 어디로 갈까요",null
                ,0,1,"id2");
        freeBoardService.updateFreeBoard(updateFreeBoard);
    }

    @Test
    @Disabled
    void delete() throws Exception {
        int deleteFreeBoard = freeBoardService.deleteFreeBoard(7);
        assertThat(deleteFreeBoard).isEqualTo(1);
    }
    @Disabled
    @Test
    void selectByNo() throws Exception {
        FreeBoard freeBoard = freeBoardService.selectByNo(6);
        System.out.println("freeBoard = " + freeBoard);
    }
    @Disabled
    @Test
    void increaseReadCount()throws Exception {
        int increaseReadCount = freeBoardService.increaseReadCount(6);
        assertThat(increaseReadCount).isEqualTo(1);
    }
    @Disabled
    @Test
    void selectNoticeCount() throws Exception {
        int count = freeBoardService.selectFreeBoardCount();
        System.out.println("count = " + count);
    }
    @Disabled
    @Test
    void selectSearchCount() throws Exception {
        int searchCount = freeBoardService.selectSearchCount("맛집");
        System.out.println("searchCount = " + searchCount);
    }
    @Disabled
    @Test
    void getTitleString() throws Exception {
        FreeBoard freeBoard = new FreeBoard(
                2,"12345678901234567"
                ,"유럽여행 어디로 갈까요",null
                ,0,1,"id2");
        String titleString = freeBoardService.getTitleString(freeBoard);
        System.out.println("titleString = " + titleString);
    }



    @Disabled
    @Test
    void selectSearchFreeBoardList() throws Exception {
        List<FreeBoard> freeBoards = freeBoardService.selectSearchFreeBoardList(1, 5, "맛집");
        System.out.println("freeBoards = " + freeBoards);

    }
    @Disabled
    @Test
    void selectSearchFreeBoardList2() throws Exception {
        FreeBoardListPageMakerDto freeBoardListPageMakerDto =
                freeBoardService.selectSearchFreeBoardList(1, "맛집");
        System.out.println("freeBoardListPageMakerDto = " + freeBoardListPageMakerDto);
    }
    @Disabled
    @Test
    void selectAll() throws Exception {
        List<FreeBoard> freeBoardList = freeBoardService.selectAll(1,5);
        System.out.println("freeBoardList = " + freeBoardList);
    }

    @Test
    void selectAll2() throws Exception {
        freeBoardService.selectAll(1);
        System.out.println("freeBoardListPageMakerDto = " + freeBoardService.selectAll(1));
    }





}