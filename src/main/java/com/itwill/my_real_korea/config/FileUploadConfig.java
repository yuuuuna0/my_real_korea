package com.itwill.my_real_korea.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itwill.my_real_korea.util.FileUploadProperties;
import com.itwill.my_real_korea.util.FileUploadService;

@Configuration
@EnableConfigurationProperties(FileUploadProperties.class)
public class FileUploadConfig {

	@Bean
	CommandLineRunner init(FileUploadService storageService) {
		return (args) -> {
			//storageService.deleteAll();
			storageService.init();
		};
	}
	
}
