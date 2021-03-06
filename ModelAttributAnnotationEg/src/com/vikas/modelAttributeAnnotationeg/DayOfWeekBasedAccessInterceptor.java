package com.vikas.modelAttributeAnnotationeg;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//if we need to to stop website for maintainenace purposes then we need to use Interceptor concept
public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	// TODO Auto-generated method stub
	Calendar cal = Calendar.getInstance();
	int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
	if (dayOfWeek == 1) {// 1 is sunday..
		response.getWriter()
				.write("This website is under maintenace on sunday. Please visit us on anyother day!!");
		return false;
	}
	return true;
}
}
