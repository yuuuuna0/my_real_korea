package com.itwill.my_real_korea.service.ticket.aws;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "cloud.aws.s3")
@Component
public class S3Component {
	
	String bucket; // 버킷

}
