package com.itwill.my_real_korea.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.exception.ExistedUserException;
import com.itwill.my_real_korea.exception.PasswordMismatchException;
import com.itwill.my_real_korea.exception.UserNotFoundException;
import com.itwill.my_real_korea.service.user.UserService;

import io.swagger.annotations.ApiOperation;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "회원가입 폼")
	@GetMapping(value = "/user-write-form", produces = "application/json;charset=UTF-8")
	public String user_write_form() {
		String forward_path = "user-write-form";
		return forward_path;
	}
	
	@ApiOperation(value = "회원가입 액션")
	@PostMapping(value = "user-write-action", produces = "application/json;charset=UTF-8")
	public String user_write_action(@ModelAttribute("fuser") User user,Model model) throws Exception {
		String forward_path = "";
		try {
			userService.create(user);
			userService.mailKeyUpdate(user);
//			forward_path="redirect:user_login_form";
			forward_path="index";
		}catch (ExistedUserException e) {
			model.addAttribute("msg", e.getMessage());
			forward_path="user-write-form";
		}
		return forward_path;
	}
	
	@ApiOperation(value = "로그인 폼")
	@GetMapping(value = "/user-login-form", produces = "application/json;charset=UTF-8")
	public String user_login_form() {
		String forward_path = "user-login-form";
		return forward_path;
	}
	
	@ApiOperation(value = "로그인 액션")
	@PostMapping(value = "user-login-action", produces = "application/json;charset=UTF-8")
	public String user_login_action(@ModelAttribute("fuser") User user, Model model, HttpSession session) throws Exception {
	    String forwardPath = "";
	    try {
	        User loginUser = userService.login(user.getUserId(), user.getPassword());
	        if (loginUser.getMailAuth() == 0) {
	        	model.addAttribute("authUser", loginUser);
	            forwardPath = "user-auth-form";
	        } else {
	            session.setAttribute("sUserId", loginUser.getUserId());
	            forwardPath = "redirect:index";
	        }
	    } catch (UserNotFoundException e) {
	        e.printStackTrace();
	        model.addAttribute("msg1", e.getMessage());
	        forwardPath = "user-login-form";
	    } catch (PasswordMismatchException e) {
	        e.printStackTrace();
	        model.addAttribute("msg2", e.getMessage());
	        forwardPath = "user-login-form";
	    }
	    return forwardPath;
	}
	
	/************** 수정중 ****************/
	@LoginCheck
	@ApiOperation(value = "메일 인증 폼")
	@PostMapping(value = "/user-auth-form")
	public String user_auth_form(HttpServletRequest request) throws Exception {
		String forward_path = "";
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		User loginUser = userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		forward_path = "user-auth-form";
		return forward_path;
	}
	
	
	@PostMapping("/user-auth-action")
	public String user_auth_action(@ModelAttribute("fuser") User user, 
			@RequestParam(value = "mailAuthKey", required = true) Integer mailAuthKey, Model model) throws Exception {
	    int mailKey = (int) model.getAttribute("mailKey");
	    model.addAttribute("mailKey", mailKey);
	    if(mailKey == mailAuthKey){
	        userService.mailAuthUpdate(user);
	        return "index";
	    }
	    return "user-auth-form";
	}
	
	/*************************************/
	
	
	@LoginCheck
	@ApiOperation(value = "회원 정보 보기")
	@GetMapping(value = "/user-view", produces = "application/json;charset=UTF-8")
	public String user_view(HttpServletRequest request) throws Exception {
	    String forwardPath = "";
	    HttpSession session = request.getSession();
	    String sUserId = (String) session.getAttribute("sUserId");
	    if (sUserId == null) {
	        session.setAttribute("requestUrl", request.getRequestURL().toString());
	        return "redirect:user-login-form";
	    }
	    User loginUser = userService.findUser(sUserId);
	    request.setAttribute("loginUser", loginUser);
	    forwardPath = "user-view";
	    
	    return forwardPath;
	}
	
	
	@LoginCheck
	@PostMapping("/user-modify-form")
	public String user_modify_form(HttpServletRequest request) throws Exception {
		String forwardPath = "";
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		User loginUser=userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		forwardPath="user-modify-form";
		
		return forwardPath;
	}
	
	
	@LoginCheck
	@PostMapping("user-modify-action")
	public String user_modify_action(@ModelAttribute User user,HttpServletRequest request) throws Exception {
		String forwardPath = "";
		userService.update(user);
		forwardPath="redirect:user-view";
		
		return forwardPath;
	}
	
	
	@LoginCheck
	@PostMapping("user-remove-action")
	public String user_remove_action(HttpServletRequest request) throws Exception {
		String forwardPath = "";
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		userService.remove(sUserId);
		request.getSession().invalidate();
		//forwardPath="forward:user_logout_action";
		forwardPath="redirect:index";
		
		return forwardPath;
	}
	
	
	@LoginCheck
	@RequestMapping("user-logout-action")
	public String user_logout_action(HttpServletRequest request) {
		String forwardPath = "";
		request.getSession(false).invalidate();
		forwardPath="redirect:index";
		return forwardPath;
	}
	
	
	/***********GET방식요청시 guest_main redirection*********/
	@GetMapping({
				"user-write-action",
				"user-login-action",
				"user-modify-form",
				"user-modify-action",
				"user-remove-action"
				})
	public String user_get() {
		String forwardPath = "redirect:index";
		return forwardPath;
	}
	
	
	
	
	/****************Local Exception Handler***********/
	@ExceptionHandler(Exception.class)
	public String user_exception_handler(Exception e) {
		return "error";
	}

}
 


