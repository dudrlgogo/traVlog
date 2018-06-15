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

		// 로그인 시 session에 회원상태 값(일반,계정블록,관리자)을 확인 하는 메소드로 샅태값 저장 필요 
		} else if( (Integer)session.getAttribute("memstatus") != 9 ) {
			logger.info("접근금지: 권한이 없는 계정으로 접속!!");
			response.sendRedirect("/Manage_Page/Error.do");			
			return false;
		}

		return true;
	}
	
}
