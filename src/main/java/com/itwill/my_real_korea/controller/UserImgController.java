//userImg 수정에 사용되는 controller
package com.itwill.my_real_korea.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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

	//이미지 출력
	@GetMapping(value = "upload-dir/{filename}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE})
	@ResponseBody
	public Resource showUserImage(@PathVariable String filename) throws MalformedURLException {
		// 파일 경로에서 파일 이름 추출
		String fname = new File(filename).getName();
		// UrlResource로 이미지 파일을 읽어서 @ResponseBody로 이미지 바이너리 반환
		return new UrlResource("file:" + storageService.getFullPath(fname));
	}

	
	/******************** 1. original 파일 이름으로 업로드 ********************/
	/*
	@PostMapping("/user-img-modify-action")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		
		User loginUser = (User) session.getAttribute("loginUser");
		loginUser = userService.findUser(loginUser.getUserId());
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
	*/
	/*********************************************************************/	

	/******************** 2. 파일 이름 변경 후 업로드 ********************/
	
	@PostMapping("/user-img-modify-action")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			HttpSession session, RedirectAttributes redirectAttributes) throws Exception {

		User loginUser = (User) session.getAttribute("loginUser");
		loginUser = userService.findUser(loginUser.getUserId());
		
		//original file의 확장자 추출
		String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
		//새 이름 설정
		String newFileName = "user_" + UUID.randomUUID().toString().substring(0, 18) + "." + extension;
		//변경된 파일 이름으로 저장
		storageService.store(file, newFileName); 
		//변경된 파일 이름으로 userImgUrl 수정
		String imageUrl = newFileName; 
		System.out.println(">>> imageUrl : "+imageUrl);
		
		UserImg userImg = userImgService.findUserImg(loginUser.getUserId());
		userImg.setUserImgUrl(imageUrl);
		userImgService.updateUserImg(userImg);
		redirectAttributes.addFlashAttribute("message",
		        "You successfully uploaded " + file.getOriginalFilename() + "!");
		
		return "redirect:/user-view";
	}

	/*********************************************************************/	

	/*
	 * 이제 필요없는 메소드
	 * 
	//파일 업로드 테스트 폼
	@GetMapping("/uploadForm")
	public String listUploadedFiles(Model model) throws IOException {
		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(UserImgController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));

		return "uploadForm";
	}
	
	//파일 다운로드
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws IOException {
	Resource file = storageService.loadAsResource(filename);
	String extension = StringUtils.getFilenameExtension(file.getFilename());
	String newFileName = "user_" + UUID.randomUUID().toString() + "." + extension;
	File renamedFile = new File(file.getFile().getParent(), newFileName);
	file.getFile().renameTo(renamedFile);
	file = storageService.loadAsResource(newFileName);
	return ResponseEntity.ok()
		    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
		    .body(file);
	}
	*/
	
	@ExceptionHandler(FileUploadNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(FileUploadNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
