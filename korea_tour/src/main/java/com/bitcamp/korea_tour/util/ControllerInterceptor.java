package com.bitcamp.korea_tour.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ControllerInterceptor implements WebMvcConfigurer {
	
	private final UserAuthInterceptor userInterceptor;
	private final AdminAuthInterceptor adminInterceptor;
	private final RestInterceptor restInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userInterceptor)
				.addPathPatterns("/tourmypage")
				.addPathPatterns("/tourmypage/**")
				.addPathPatterns("/placeanswer")
				.addPathPatterns("/api/place/detail/course/**")
				.addPathPatterns("/api/courseplaces")
				.addPathPatterns("/api/place/detail/photo")
				.addPathPatterns("/api/place/detail/photo")
				;
		registry.addInterceptor(adminInterceptor)
				.addPathPatterns("/admin/**");
		
	}
}
