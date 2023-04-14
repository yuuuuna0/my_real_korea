package com.itwill.my_real_korea.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.itwill.my_real_korea.controller.AuthAdminAnnotationInterceptor;
import com.itwill.my_real_korea.controller.AuthLoginAnnotationInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	/********************WebMvcConfigurer재정의*********************
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.jsp");
	}
	*************************************************************/
	/*********************Spring MVC 빈객체등록*********************/
	@Bean
	public MultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	    resolver.setMaxUploadSizePerFile(5242880); // 파일당 최대 업로드 크기 설정
	    return resolver;
	}
	
	
	/*********************Interceptor 등록*********************/
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// @LoginCheck
		AuthLoginAnnotationInterceptor authLoginAnnotationInterceptor = new AuthLoginAnnotationInterceptor();
		registry.addInterceptor(authLoginAnnotationInterceptor)
		.addPathPatterns("/**") // 모든 요청을 처리하도록 등록 후
		.excludePathPatterns("/css/**") // interceptor 의 영향을 받지 않아야 하는 것들 설정
		.excludePathPatterns("/js/**")
		.excludePathPatterns("/image/**");
		
		// @AdminCheck
		AuthAdminAnnotationInterceptor authAdminAnnotationInterceptor = new AuthAdminAnnotationInterceptor();
		registry.addInterceptor(authAdminAnnotationInterceptor)
		.addPathPatterns("/**") // 모든 요청을 처리하도록 등록 후
		.excludePathPatterns("/css/**") // interceptor 의 영향을 받지 않아야 하는 것들 설정
		.excludePathPatterns("/js/**")
		.excludePathPatterns("/image/**");
		
	}
	
	
	
}
