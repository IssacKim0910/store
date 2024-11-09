package test.store.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final IpCheckInterceptor ipCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // IpCheckInterceptor를 모든 요청에 대해 적용
        registry.addInterceptor(ipCheckInterceptor).addPathPatterns("/**");
    }
}
