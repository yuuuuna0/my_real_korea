package com.itwill.my_real_korea.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
/*
일반적으로 클래스들은 Spring의 의해 bean으로 등록되고 해당 인스턴스는 Singleton으로 관리되지만, 
@ServerEndPoint Annotation이 달린 클래스들은 
WebSocket이 생성될 때마다 인스턴스가 생성되고 JWA구현에 의해 관리되기 때문에 
내부에 Autowired가 설정된 멤버들이 정상적으로 초기화가 되지 않는다.
이때 이를 연결해 주고 초기화해 주는 클래스.
 */
@Component
public class EndpointConfig {
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
