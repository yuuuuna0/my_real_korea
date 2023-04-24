package com.itwill.my_real_korea.service.ticket.aws;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.ObjectMetadata;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FileUploadServiceAWS {


	private final Aws3UploadService s3Service;
	
	public String uploadImage(MultipartFile file) { 
	    if (file == null) {
	        return null;
	    }
	    // inputStream으로 AWS S3로 파일 전송하는 로직을 S3Service에 줌
	    String fileName = createFileName(file.getOriginalFilename()); 
	    ObjectMetadata objectMetadata = new ObjectMetadata();
	    objectMetadata.setContentLength(file.getSize());
	    objectMetadata.setContentType(file.getContentType());
	    
	    try(InputStream inputStream = file.getInputStream()) {
	        s3Service.uploadFile(inputStream, objectMetadata, fileName); // 현재 사진 파일 S3 저장
	        
	    } catch(IOException e) {
	        
	        throw new IllegalArgumentException(String.format("파일 변환 중 에러가 발생하였습니다(%s)", 
	                file.getOriginalFilename()));
	    }
	    return s3Service.getFileUrl(fileName); //service에 fileName 넣기
	}
	
	
	//기존 확장자명을 유지, 유니크한 파일의 이름을 생성하는 로직
	private String createFileName(String originalFileName) {
		return UUID.randomUUID().toString().concat(getFileExtension(originalFileName)); // 확장자명은 유효해야함으로 유니크 키 + 확장자로 이름을 바꿔줌 (ex. UUID.PNG)
	}

	//파일 확장자명을 가져오는 로직
	private String getFileExtension(String fileName) {
		try {
			return fileName.substring(fileName.lastIndexOf("."));
		} catch(StringIndexOutOfBoundsException e){
			throw new IllegalArgumentException(String.format("잘못된 형식의 파일(%s) 입니다", fileName));
		}
		
	}


}
