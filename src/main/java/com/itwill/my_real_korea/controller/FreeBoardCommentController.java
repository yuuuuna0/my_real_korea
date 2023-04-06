package com.itwill.my_real_korea.controller;

import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import com.itwill.my_real_korea.service.freeboard.FreeBoardCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FreeBoardCommentController {
    @Autowired
    private FreeBoardCommentService freeBoardCommentService;


    @LoginCheck
    @PostMapping("/freeboard-comment-write-action")
    public String freeBoardCommentWriteAction(@ModelAttribute FreeBoardComment freeBoardComment, RedirectAttributes redirectAttributes) throws Exception {
        try {
            freeBoardCommentService.insertComment(freeBoardComment);
            redirectAttributes.addAttribute("fBoNo", freeBoardComment.getFBoNo());
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:freeboard-detail";
    }

    @LoginCheck
    @GetMapping("/freeboard-comment-modify-form")
    public String freeBoardCommentModifyForm(Integer fCoNo, Model model) throws Exception {
        try {
            FreeBoardComment freeBoardComment = freeBoardCommentService.selectByfCoNo(fCoNo);
            model.addAttribute("freeBoard", freeBoardComment);

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "freeboard-modify-form";
    }

    @LoginCheck
    @PatchMapping("/freeboard-comment-modify-action")
    public String freeBoardCommentModifyAction(@ModelAttribute FreeBoardComment freeBoardComment, RedirectAttributes redirectAttributes) throws Exception {
        freeBoardCommentService.updateComment(freeBoardComment);
        redirectAttributes.addAttribute("fBoNo", freeBoardComment.getFBoNo());
        return "redirect:freeboard-detail";
    }



    @DeleteMapping("/free-board-comment-delete-action")
    public String freeBoardCommentDeleteAction(@ModelAttribute FreeBoardComment freeBoardComment, RedirectAttributes redirectAttributes) throws Exception {
        freeBoardCommentService.deleteComment(freeBoardComment.getFCoNo());
        redirectAttributes.addAttribute("fBoNo", freeBoardComment.getFBoNo());
        return "redirect:freeboard-detail";
    }


}
