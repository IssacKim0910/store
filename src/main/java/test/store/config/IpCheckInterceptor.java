package test.store.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class IpCheckInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(IpCheckInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String ipAddress = request.getRemoteAddr();
        String requestUri = request.getRequestURI();
        String requestURL = request.getRequestURL().toString();

        if (!requestUri.endsWith(".css") && !requestUri.endsWith(".js") && !requestUri.endsWith(".jpg") && !requestUri.endsWith(".png")) {
            logger.info("IP: {}, 요청 URL: {}", ipAddress, requestURL);
        }
        return true; // 요청 처리 계속 진행
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        // 상태 코드가 400 이상일 경우 에러 로그 출력
        if (response.getStatus() >= 400) {
            String ipAddress = request.getRemoteAddr();
            String requestURL = request.getRequestURL().toString();
            logger.error("오류 발생 - 상태 코드: {}, IP: {}, 요청 URL: {}", response.getStatus(), ipAddress, requestURL);
        }
    }
}
