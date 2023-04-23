package com.itwill.my_real_korea.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServiceImpl implements FileUploadService {
	
	private final Path rootLocation;

	// 파일을 저장할 디렉토리의 경로 저장 - file.location 을 통해 지정함
	@Autowired
	public FileUploadServiceImpl(FileUploadProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}
	
	// 1. original 파일 이름으로 업로드
	// 업로드 된 파일 저장 (현재는 파일 1개 업로드만 가능하도록 설정해둠)
	@Override
	public void store(MultipartFile file) {
		try {
			if (file.isEmpty()) {
				throw new FileUploadException("파일이 비었습니다.");
			}
			String saveName = this.rootLocation +"/"+ file.getOriginalFilename();
			// 업로드 할 경로 : savePath
			Path savePath = Paths.get(saveName);
			// 서버에 파일 저장, 이미 존재하는 파일이면 덮어씌움
			file.transferTo(savePath);
		}
		catch (IOException e) {
			throw new FileUploadException("파일 업로드에 실패했습니다.", e);
		}
	}
	
	// 2. 파일 이름 변경 후 업로드
	// 업로드 된 파일 저장 (이름 변경 후 저장)
	@Override
	public void store(MultipartFile file, String newFileName) {
		try {
			if (file.isEmpty()) {
				throw new FileUploadException("파일이 비었습니다.");
			}

			byte[] bytes = file.getBytes();
	        Path path = Paths.get(this.rootLocation +"/"+ newFileName);
	        Files.write(path, bytes);
		}
		catch (IOException e) {
			throw new FileUploadException("파일 업로드에 실패했습니다.", e);
		}
	}
	

	// rootLocation 경로 아래 저장된 모든 파일의 경로 가져옴
	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.rootLocation, 1)
				.filter(path -> !path.equals(this.rootLocation))
				.map(this.rootLocation::relativize);
		}
		catch (IOException e) {
			throw new FileUploadException("저장된 파일을 읽을 수 없습니다.", e);
		}

	}
	// 지정된 파일이름 사용, 파일 전체 경로를 반환
	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}
	// 서버에 저장된 파일 전체 경로 String 으로 반환
	@Override
	public String getFullPath(String filename) {
		return this.rootLocation +"/"+ filename;
	}
	// 파일 로드 후 Resource 반환
	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
			else {
				throw new FileUploadNotFoundException(
						"파일을 읽을 수 없습니다: " + filename);

			}
		}
		catch (MalformedURLException e) {
			throw new FileUploadNotFoundException("파일을 읽을 수 없습니다: " + filename, e);
		}
	}
	// 해당 경로에 저장된 모든 파일 삭제
	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	// 파일 업로드를 위한 디렉토리 생성
	@Override
	public void init() {
		try {
			Files.createDirectories(rootLocation);
		}
		catch (IOException e) {
			throw new FileUploadException("디렉토리 생성에 실패했습니다.", e);
		}
	}
}
