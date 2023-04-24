package com.itwill.my_real_korea.service.ticket.aws;

import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.ObjectMetadata;


public interface Aws3UploadService { // 인터페이스 분리함으로써 테스트 시 의존성을 끊음 

	void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName);
	
	String getFileUrl(String fileName);

	//String getFileUrl1(MultipartFile file);

}	
