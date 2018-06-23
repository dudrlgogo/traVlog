package mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import mvc.service.adminService.AdminService;


public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Autowired AdminService adminService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("Interceptor Activate!!");
		logger.info("Request URI : "+request.getRequestURI());
		
		HttpSession session = request.getSession();
//		int status = session.getAttribute("status");
		
		if( session.getAttribute("login") == null) {
			logger.info("접근금지: 비로그인 상태에서 사용불가");
			response.sendRedirect("/Manage_Page/Error.do");
			return false;
		} else if((Integer)session.getAttribute("memstatus") != 9) {
			logger.info("접근금지: 접속 권한없음!!");
			response.sendRedirect("/Manage_Page/Error.do");			
			return false;
		}

		return true;
	}
	
}
