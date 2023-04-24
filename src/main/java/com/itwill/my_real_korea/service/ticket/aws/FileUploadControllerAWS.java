package com.itwill.my_real_korea.service.ticket.aws;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class FileUploadControllerAWS {
	
	private final FileUploadServiceAWS fileUploadServiceAWS;
	
	//@RequestPart -> multipart/form-data 요청
	@PostMapping(value="/upload", consumes = "multipart/form-data")
	public String uploadImage(@RequestBody MultipartFile file) {
		return fileUploadServiceAWS.uploadImage(file);
	}

}
