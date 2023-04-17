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
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.exception.ExistedUserException;
import com.itwill.my_real_korea.service.user.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//회원 가입 폼
	@GetMapping(value = "/user-write", produces = "application/json;charset=UTF-8")
	public String user_write() {
		return "user-write";
	}
	
	//아이디 중복 체크
	@PostMapping("/idCheck")
	@ResponseBody
	public int countExistId(@RequestParam("userId") String userId) throws Exception {
		int existCount = userService.countExistId(userId);
		return existCount;
	}
	
	//회원 가입 액션
	@PostMapping(value = "user-write-action", produces = "application/json;charset=UTF-8")
	public String user_write_action(@ModelAttribute("fuser") User user, Model model) throws Exception {
		String forward_path = "";
		try {
			userService.create(user);
			userService.updateMailKey(user);
			forward_path="redirect:index";
		}catch (ExistedUserException e) {
			model.addAttribute("msg", e.getMessage());
			forward_path="user-write";
		}
		return forward_path;
	}
	
	
	//로그인 폼
	@GetMapping(value = "/user-login", produces = "application/json;charset=UTF-8")
	public String user_login(HttpServletRequest request, Model model) {
	    HttpSession session = request.getSession();
	    
	    String prevPage = request.getHeader("Referer");
	    if (prevPage == null || prevPage.contains("/user-login") || prevPage.contains("/user-auth")) {
	        prevPage = request.getContextPath() + "/index";
	    }
	    session.setAttribute("prevPage", prevPage);
	    model.addAttribute("prevPage", prevPage);
	    return "user-login";
	}

	/*
	 * REST로 변경
	 * 
		//로그인 액션
		@PostMapping(value = "user-login-action", produces = "application/json;charset=UTF-8")
		public String user_login_action(@ModelAttribute("fuser") User user, Model model, 
											HttpServletRequest request, HttpServletResponse response) throws Exception {
			HttpSession session = request.getSession();
			String forwardPath = "";
		    try {
		        User authUser = userService.login(user.getUserId(), user.getPassword());
		        if (authUser.getMailAuth() != 1) {
		        	session.setAttribute("authUser", authUser);
		        	forwardPath = "user-auth";
		        } else {
		            User loginUser = userService.login(user.getUserId(), user.getPassword());
		            session.setAttribute("loginUser", loginUser);
		            String prevPage = (String) session.getAttribute("prevPage");
		            if (prevPage == null || prevPage.contains("/user-login") || prevPage.contains("/user-auth")) {
		                prevPage = request.getContextPath() + "/index";
		            }
		            session.removeAttribute("prevPage");
		            response.sendRedirect(prevPage);
		            return null;
		        }
		    } catch (UserNotFoundException e) {
		        e.printStackTrace();
		        model.addAttribute("msg1", e.getMessage());
		        session.setAttribute("prevPage", request.getHeader("Referer"));
		        forwardPath = "user-login";
		    } catch (PasswordMismatchException e) {
		        e.printStackTrace();
		        model.addAttribute("msg2", e.getMessage());
		        session.setAttribute("prevPage", request.getHeader("Referer"));
		        forwardPath = "user-login";
		    }
		    return forwardPath;
		}
	 */	
	
	
	/*
	 * REST로 변경
	 * 
		//회원 인증 폼 (이메일로 전송된 인증코드)
		@LoginCheck
		@GetMapping(value = "/user-auth")
		public String user_auth(HttpServletRequest request) throws Exception {
			HttpSession session = request.getSession();
			User authUser = (User) session.getAttribute("authUser");
			System.out.println(">> authUser : "+authUser);
			authUser = userService.findUser(authUser.getUserId());
			session.setAttribute("authUser", authUser);
			return "user-auth";
		}
	 */
	
	

	//회원 인증 액션
	@PostMapping(value = "user-auth-action", produces = "application/json;charset=UTF-8")
	public String user_auth_action(@RequestParam("mailAuthKey") String mailAuthKey, HttpSession session) throws Exception {
	    String forwardPath = "";
	        User authUser = (User) session.getAttribute("authUser");
	        if(authUser.getMailKey() == Integer.parseInt(mailAuthKey)) {
	        	userService.updateMailAuth(authUser);
	        	/*
	        	 * 확인용
	        	System.out.println("mailAuthKey : "+mailAuthKey);
	        	System.out.println("authUser.getMailKey() : "+authUser.getMailKey());
	        	 */
	        	session.removeAttribute("authUser");
	        	forwardPath = "user-login";
	        }else {
	        	forwardPath = "user-auth";
	        }
	    return forwardPath;
	}
	
	/***************************ID, Password 찾기********************************/

	//아이디, 비밀번호 찾기 폼
	@GetMapping(value = "/user-find", produces = "application/json;charset=UTF-8")
	public String user_find() {
		return "user-find";
	}
	
/*
 * REST
 * 
	//아이디 찾기 액션
	@PostMapping(value = "/user-find-id-action", produces = "application/json;charset=UTF-8")
	public String user_find_id_action(@RequestParam("name") String name, @RequestParam("email") String email, Model model) throws Exception {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		String userId = userService.findIdByEmailName(email,name);
		if(userId != null) {
			model.addAttribute("userId", userId);
			model.addAttribute("msg", "회원님의 아이디는 "+userId+" 입니다.");
		}else {
			model.addAttribute("msg", "일치하는 회원 정보가 없습니다.");
		}
		return "user-find-id";
	}
 */
	

/*
 * REST	
 *
	//비밀번호 찾기 액션 (이메일로 임시 비밀번호 발송)
	@PostMapping(value = "/user-find-pw-action", produces = "application/json;charset=UTF-8")
	public String user_find_pw_action(@RequestParam("userId") String userId, @RequestParam("email") String email, Model model) throws Exception {
		User user = new User();
		user.setUserId(userId);
		user.setEmail(email);
		int matchCount = userService.findIdByIdEmail(userId, email);
		if(matchCount == 1) {
			userService.sendTempPassword(userId, email);
			model.addAttribute("msg", "이메일로 임시 비밀번호가 발송되었습니다.");
		}else {
			model.addAttribute("msg", "일치하는 회원 정보가 없습니다.");
		}
		return "user-find-pw";
	}
 */	
	
	/*********************************************************/

	//회원 정보 보기
	@LoginCheck
	@GetMapping(value = "/user-view", produces = "application/json;charset=UTF-8")
	public String user_view(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		System.out.println(">> loginUser : "+loginUser);
		if (loginUser == null) {
			session.setAttribute("requestUrl", request.getRequestURL().toString());
			return "redirect:user-login";
		}
		loginUser = userService.findUser(loginUser.getUserId());
		request.setAttribute("loginUser", loginUser);
		return "user-view";
	}
	
	
	
	
	//회원 정보 수정 폼
	@LoginCheck
	@PostMapping("/user-modify")
	public String user_modify(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		loginUser = userService.findUser(loginUser.getUserId());
		request.setAttribute("loginUser", loginUser);
		return "user-modify";
	}

	
	//회원 정보 수정 액션
	@LoginCheck
	@PostMapping("user-modify-action")
	public String user_modify_action(@ModelAttribute User user,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		userService.update(user);
//		System.out.println(">> user : "+user);
		User loginUser = userService.findUser(user.getUserId());
		session.setAttribute("loginUser", loginUser);
//		System.out.println(">> loginUser : "+loginUser);
		return "redirect:user-view";
	}
	
	//회원 탈퇴 액션
	@LoginCheck
	@PostMapping("user-remove-action")
	public String user_remove_action(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		userService.remove(loginUser.getUserId());
		request.getSession(false).invalidate();
		return "redirect:index";
	}
	
	//로그아웃 액션
	@LoginCheck
	@RequestMapping("user-logout-action")
	public String user_logout_action(HttpServletRequest request) {
		request.getSession(false).invalidate();
		return "redirect:index";
	}
	
	//GET 방식으로 요청시 index 화면으로
	@GetMapping({
				"user-write-action",
				"user-login-action",
				"user-modify",
				"user-modify-action",
				"user-remove-action"
				})
	public String user_get() {
		return "redirect:index";
	}
	
	//error 발생시 error 화면으로
	@ExceptionHandler(Exception.class)
	public String user_exception_handler(Exception e) {
		return "error";
	}

}





