package com.itwill.my_real_korea.util;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileUploadService {

	void init();

	// 1. original 파일 이름으로 업로드
	void store(MultipartFile file);
	
	// 2. 파일 이름 변경 후 업로드
	void store(MultipartFile file, String newFileName);

	Stream<Path> loadAll();

	Path load(String filename);

	Resource loadAsResource(String filename);

	void deleteAll();

	String getFullPath(String filename);

}
