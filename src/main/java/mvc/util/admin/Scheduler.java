package mvc.util.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import mvc.dao.adminDao.AdminDao;

@Component
public class Scheduler {

	private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);

	@Autowired AdminDao adminDao;
	
	// 스케쥴러(초0~59, 분0~59, 시1~24, 일1~31, 월1~12, 요일1~7, <옵션>년1970~2099)
	// 휴면계정 전환(매일 04시)
	@Scheduled(cron = "0 0 4 * * ?") 
//	@Scheduled(cron = "*/30 * * * * *") 
	public void updateInactiveAccount() { 
		
//		System.out.println("스케쥴링 테스트1");
//		System.out.println("스케쥴링 테스트2");
//		System.out.println("스케쥴링 테스트3");
		
		logger.info("매일 04시 휴면계정 전환 확인!!");
		
		adminDao.updateUnusedAccount();
	}

	// 7일간 사용정지 계정 -> 정지기간 만료 후 일반 계정 상태로 전환(매일 06시)
	@Scheduled(cron = "0 0 6 * * ?")
	public void updateReturnToNomalAccount() {
		
		logger.info("매일 06시 정지 상태 계정의 정지기간을 체크하여 기간만료 시 일반계정으로 전환");
		// 정지기간 만료를 체크하여 계정상태 '일반'으로 변경
		adminDao.updatePauseStatusReset();
		// 정지기간 만료 시 초기화
		adminDao.updatePauseTimeReset();
	}
	
	// 광고 기간 만료(매일 0시 30초)
	@Scheduled(cron = "30 0 0 * * ?")
	public void updateAdvertisingEnd() {
		
		logger.info("매일 00시 30초 만료된 광고 확인 및 상태 전환");
		
		adminDao.updateAdvertisingEnd();
	}
	
	// 광고 시작(매일 0시 정각)
	@Scheduled(cron = "0 0 0 * * ?")
	public void updateAdvertisingStart() {
		
		logger.info("매일 01시 새로 시작되는 광고 적용");
		
		adminDao.updateAdvertisingStart();
	}
	
	
	
}
