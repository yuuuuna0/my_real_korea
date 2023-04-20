package com.itwill.my_real_korea.controller;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.service.city.CityService;
import com.itwill.my_real_korea.service.freeboard.FreeBoardCommentService;
import com.itwill.my_real_korea.service.freeboard.FreeBoardService;
import com.itwill.my_real_korea.service.user.UserService;
import com.itwill.my_real_korea.util.PageMakerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FreeBoardController {

    private FreeBoardService freeBoardService;
    private FreeBoardCommentService freeBoardCommentService;
    private UserService userService;
    private CityService cityService;

    @Autowired
    public FreeBoardController(FreeBoardService freeBoardService, FreeBoardCommentService freeBoardCommentService, UserService userService, CityService cityService) {
        this.freeBoardService = freeBoardService;
        this.freeBoardCommentService = freeBoardCommentService;
        this.userService = userService;
        this.cityService = cityService;
    }

    @GetMapping(value = "/freeboard-list")
    public String freeBoardList(@RequestParam(required = false, defaultValue = "1") int pageNo, Model model) throws Exception {

        try {
            PageMakerDto<FreeBoard> freeBoardListPage = freeBoardService.selectAll(pageNo);
            List<FreeBoard> tempFreeBoardList = freeBoardListPage.getItemList();
            List<FreeBoard> freeBoardList = new ArrayList<>();
            for (FreeBoard freeBoard : tempFreeBoardList) {
                int commentCount = freeBoardCommentService.selectByfBoNo(freeBoard.getFBoNo()).size();
                freeBoard.setCommentCount(commentCount);
                freeBoardList.add(freeBoard);
            }
            model.addAttribute("freeBoardListPage", freeBoardListPage);
            model.addAttribute("freeBoardList", freeBoardList);
            model.addAttribute("pageNo", pageNo);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "freeboard-list";
    }

    @GetMapping(value = "/freeboard-list-fBoNo-asc")
    public String freeBoardListFBoNoAsc(@RequestParam(required = false, defaultValue = "1") int pageNo, Model model) {
        try {
            PageMakerDto<FreeBoard> freeBoardListPage = freeBoardService.selectAllOrderByFBoNoAsc(pageNo);
            List<FreeBoard> freeBoardList = freeBoardListPage.getItemList();
            model.addAttribute("freeBoardList", freeBoardList);
            model.addAttribute("pageNo", pageNo);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "freeboard-list";
    }

    @GetMapping(value = "/freeboard-list-fBoNo-desc")
    public String freeBoardListFBoNoDesc(@RequestParam(required = false, defaultValue = "1") int pageNo, Model model) {
        try {
            PageMakerDto<FreeBoard> freeBoardListPage = freeBoardService.selectAllOrderByFBoNoDesc(pageNo);
            List<FreeBoard> freeBoardList = freeBoardListPage.getItemList();
            model.addAttribute("freeBoardList", freeBoardList);
            model.addAttribute("pageNo", pageNo);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "freeboard-list";
    }

    @GetMapping(value = "/freeboard-list-readCount-desc")
    public String freeBoardListReadCountDesc(@RequestParam(required = false, defaultValue = "1") int pageNo, Model model) {
        try {
            PageMakerDto<FreeBoard> freeBoardListPage = freeBoardService.selectAllOrderByReadCountDesc(pageNo);
            List<FreeBoard> freeBoardList = freeBoardListPage.getItemList();
            model.addAttribute("freeBoardList", freeBoardList);
            model.addAttribute("pageNo", pageNo);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "freeboard-list";
    }

    @GetMapping(value = "/freeboard-list-search")
    public String freeBoardSearchList(@RequestParam(required = false, defaultValue = "1") int pageNo, Model model) {
        try {
            PageMakerDto<FreeBoard> freeBoardListPage = freeBoardService.selectAllOrderByReadCountDesc(pageNo);
            freeBoardListPage.getItemList();
            model.addAttribute("freeBoardList", freeBoardListPage);
            model.addAttribute("pageNo", pageNo);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "freeboard-list";
    }

    @GetMapping("/freeboard-detail")
    public String freeBoardDetail(@RequestParam Integer fBoNo, Model model, HttpSession session) throws Exception {
        if (fBoNo == null) {
            return "freeboard-list";
        }
        try {
            if (session != null) {
                User loginUser = (User) session.getAttribute("loginUser");
                model.addAttribute("loginUser", loginUser);
            }
////
            FreeBoard freeBoard = freeBoardService.selectByNo(fBoNo);
            List<FreeBoardComment> freeBoardCommentList = freeBoardCommentService.selectByfBoNo(fBoNo);
            freeBoardService.increaseReadCount(freeBoard.getFBoNo());
            int selectCommentCount = freeBoardCommentService.selectCommentCount(fBoNo);


            model.addAttribute("freeBoard", freeBoard);
            model.addAttribute("freeBoardCommentList", freeBoardCommentList);
            model.addAttribute("fBoNo", fBoNo);
            model.addAttribute("selectCommentCount", selectCommentCount);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "freeboard-detail";
    }

    //    @LoginCheck
    @GetMapping("/freeboard-write-form")
    public String freeBoardWriteForm(HttpSession session, Model model) throws Exception {
        if (session != null) {
            User loginUser = (User) session.getAttribute("loginUser");
            model.addAttribute("loginUser", loginUser);
        }
        List<City> allCity = cityService.findAllCity();
        model.addAttribute(allCity);


////
        return "freeboard-write-form";
    }

    @LoginCheck
    @PostMapping("/freeboard-write-action")
    public String freeBoardWriteAction(@ModelAttribute FreeBoard freeBoard, RedirectAttributes redirectAttributes) throws Exception {
        try {
            freeBoardService.insertBoard(freeBoard);
            redirectAttributes.addAttribute("fBoNo", freeBoard.getFBoNo());
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/freeboard-detail";
    }

    @LoginCheck
    @GetMapping("/freeboard-modify-form")
    public String freeBoardModifyForm(Integer fBoNo, Model model) throws Exception {
        if (fBoNo == null) {
            return "freeboard-list";
        }
        try {
            FreeBoard freeBoard = freeBoardService.selectByNo(fBoNo);
            model.addAttribute("freeBoard", freeBoard);

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "freeboard-modify-form";
    }

    @LoginCheck
    @PatchMapping("/freeboard-modify-action")
    public String freeBoardModifyAction(@ModelAttribute FreeBoard freeBoard, RedirectAttributes redirectAttributes) throws Exception {

        freeBoardService.updateFreeBoard(freeBoard);
        redirectAttributes.addAttribute("fBoNo", freeBoard.getFBoNo());

        return "redirect:freeboard-detail";
    }

    @LoginCheck
    @PostMapping("/freeboard-delete-action")
    public String freeBoardDeleteAction(@RequestParam Integer fBoNo) throws Exception {
        freeBoardService.deleteFreeBoard(fBoNo);
        return "redirect:freeboard-list";
    }

}
