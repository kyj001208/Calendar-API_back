package groupware_test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        // CORS 허용할 도메인 설정
        registry.addMapping("/**") // 모든 요청에 대해 CORS 허용
                .allowedOrigins("http://localhost:3000") // React 앱이 실행되는 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드
                .allowedHeaders("*"); // 모든 헤더를 허용
    }

}
