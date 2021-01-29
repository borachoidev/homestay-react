package com.bitcamp.korea_tour.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.korea_tour.model.AdminDto;
import com.bitcamp.korea_tour.model.service.AdminService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AdminAuthInterceptor implements HandlerInterceptor, SessionNames {
	private final AdminService adminService;
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        AdminDto loginAdmin= (AdminDto) session.getAttribute(ADMIN);
        AdminDto admin=adminService.getAdminDataByNum(loginAdmin.getAdminNum());
 
        if(ObjectUtils.isEmpty(admin)){
            response.sendRedirect("home/alertauth");
            return false;
        }else {
        	return true;
        }
        
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        
    }
}
