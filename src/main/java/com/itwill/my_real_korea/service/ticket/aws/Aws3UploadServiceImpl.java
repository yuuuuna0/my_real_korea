package com.itwill.my_real_korea.service.ticket.aws;

import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class Aws3UploadServiceImpl implements Aws3UploadService{

	private final AmazonS3 amazonS3;
	private final S3Component component;

	@Override
	public void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName) { // amazonS3를 사용하여 파일 업로드
		amazonS3.putObject(new PutObjectRequest(component.getBucket(), fileName, inputStream, objectMetadata)
				.withCannedAcl(CannedAccessControlList.PublicRead));
		
	}

	@Override
	public String getFileUrl(String fileName) { //업로드한 파일의 URI를 가져오는 메소드
		
		return amazonS3.getUrl(component.getBucket(), fileName).toString();
	}

}
