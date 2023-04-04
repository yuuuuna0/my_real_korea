package com.itwill.my_real_korea.dao.freeboard;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;
import java.util.List;

//import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.my_real_korea.dao.freeboard.FreeBoardDao;
import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.freeboard.FreeBoard;

@SpringBootTest
@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class FreeBoardDaoImplTest {
    @Autowired
    private FreeBoardDao freeBoardDao;
    @Test
    void insertBoard() throws Exception {
        FreeBoard freeBoard = new FreeBoard(2,"date test","content",new Date(2022/01/18),12, new City(3, "강원", 3, 3),"user2");
        int insertBoard = freeBoardDao.insertBoard(freeBoard);
        assertThat(insertBoard).isEqualTo(1);
    }

    @Test
    void selectByNo() throws Exception {
        FreeBoard freeBoard = freeBoardDao.selectByNo(3);
        assertThat(freeBoard).isNotNull();
        System.out.println(freeBoard);

    }

    @Test
    void selectAllOrderByFBoNoDesc() throws Exception {
        List<FreeBoard> freeBoardList = freeBoardDao.selectAllOrderByFBoNoDesc(1, 8);
        System.out.println(freeBoardList);
    }

    @Test
    void selectAllOrderByFBoNoAsc() throws Exception {
        List<FreeBoard> freeBoardList = freeBoardDao.selectAllOrderByFBoNoAsc(1, 5);
        System.out.println(freeBoardList);
    }

    @Test
    void selectAllOrderByReadCountDesc() {
        List<FreeBoard> freeBoardList = freeBoardDao.selectAllOrderByReadCountDesc(1,5);
        System.out.println(freeBoardList);
    }

    @Test
    void updateBoard() throws Exception {
        FreeBoard freeBoard = new FreeBoard(2,"@update","content",new Date(),9,new City(3,"강원",1,1),"user2");
        int updateBoard = freeBoardDao.updateBoard(freeBoard);
        assertThat(updateBoard).isEqualTo(1);
    }
    @Test
    void deleteBoard() throws Exception {
        freeBoardDao.deleteBoard(8);
    }

    @Test
    void increaseReadCount() throws Exception {
        int i = freeBoardDao.increaseReadCount(1);
        assertThat(i).isEqualTo(1);
    }

    @Test
    void selectFreeBoardCount() throws Exception {
        int selectFreeBoardCount = freeBoardDao.selectFreeBoardCount();
        System.out.println(selectFreeBoardCount);
    }

    @Test
    void selectSearchCount() throws Exception {
        int selectSearchCount = freeBoardDao.selectSearchCount("맛집");
        System.out.println(selectSearchCount);
    }

    @Test
    void selectSearchFreeBoardList() throws Exception {
        List<FreeBoard> freeBoardList = freeBoardDao.selectSearchFreeBoardList(1,4,"맛집");
        System.out.println(freeBoardList);
    }
}