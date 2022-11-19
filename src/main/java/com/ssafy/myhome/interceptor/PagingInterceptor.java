package com.ssafy.myhome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssafy.myhome.util.PageNavigationForPageHelper;


@Component
public class PagingInterceptor implements HandlerInterceptor{

	@Value("${paging.perpage}")
	int per;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String pageStr=request.getParameter("page");
		int page=pageStr==null?1:Integer.parseInt(pageStr);
		
		PageHelper.startPage(page, per);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// request.getContextPath() : application의 경로(http://localhost:8080
        // request.getServletPath(): 현재 호출된 servlet(controller의 경로)
		Object listObj=modelAndView.getModel().get("list");


		System.out.println(listObj);
		if(listObj!=null) {
			Page<?> list = (Page<?>)listObj;
			PageNavigationForPageHelper helper= new PageNavigationForPageHelper(list, request.getServletPath()+"?page");
			modelAndView.addObject("list",helper);
		}
		// 무슨 의미??
	}
}
