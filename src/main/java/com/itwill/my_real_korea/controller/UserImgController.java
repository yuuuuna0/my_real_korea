package com.itwill.my_real_korea.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.itwill.my_real_korea.dto.user.UserImg;
import com.itwill.my_real_korea.service.user.UserImgService;

@Controller
public class UserImgController {
	
	@Autowired
	private UserImgService userImgService;
	
	
	//회원 가입 액션
	@PostMapping(value = "user-img-write-action", produces = "application/json;charset=UTF-8")
	public String user_img_write_action(@ModelAttribute("fuser") UserImg userImg,Model model) throws Exception {
		String forward_path = "";
			userImgService.createUserImg(userImg);
			forward_path="redirect:index";
		return forward_path;
	}
	
	
	//회원 정보 수정 액션
	@LoginCheck
	@PostMapping("user-img-modify-action")
	public String user_img_modify_action(@ModelAttribute UserImg userImg,HttpServletRequest request) throws Exception {
		userImgService.updateUserImg(userImg);
		return "redirect:user-view";
	}
	



}


