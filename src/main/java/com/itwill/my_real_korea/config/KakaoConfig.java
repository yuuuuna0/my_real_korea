package com.itwill.my_real_korea.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:sns.properties")
public class KakaoConfig {

}
