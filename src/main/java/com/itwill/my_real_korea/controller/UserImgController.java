//userImg 수정에 사용되는 controller
package com.itwill.my_real_korea.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.dto.user.UserImg;
import com.itwill.my_real_korea.service.user.UserImgService;
import com.itwill.my_real_korea.service.user.UserService;
import com.itwill.my_real_korea.util.FileUploadNotFoundException;
import com.itwill.my_real_korea.util.FileUploadService;

@Controller
public class UserImgController {

	private final FileUploadService storageService;
	
	@Autowired
	private UserImgService userImgService;
	@Autowired
	private UserService userService;

	@Autowired
	public UserImgController(FileUploadService storageService) {
		this.storageService = storageService;
	}

	//이제 필요없는 메소드 (testForm)
	@GetMapping("/uploadForm")
	public String listUploadedFiles(Model model) throws IOException {

		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(UserImgController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));

		return "uploadForm";
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	
	@PostMapping("/user-img-modify-action")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
	        HttpSession session, RedirectAttributes redirectAttributes) throws Exception {

	    String sUserId = (String) session.getAttribute("sUserId");
	    User loginUser = userService.findUser(sUserId);
	    System.out.println(">>> loginUser : "+loginUser);
		storageService.store(file);

	    //userImgUrl 수정
	    String imageUrl = file.getOriginalFilename();
	    System.out.println(">>> imageUrl : "+imageUrl);
	    UserImg userImg = userImgService.findUserImg(loginUser.getUserId());
	    userImg.setUserImgUrl(imageUrl);
	    userImgService.updateUserImg(userImg);
	    redirectAttributes.addFlashAttribute("message",
	            "You successfully uploaded " + file.getOriginalFilename() + "!");

	    return "redirect:/user-view";
	}

	@ExceptionHandler(FileUploadNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(FileUploadNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
