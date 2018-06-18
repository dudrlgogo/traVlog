package mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc.dto.Board;
import mvc.dto.Files;
import mvc.dto.Member;
import mvc.dto.Profile;
import mvc.service.MypageService;

@Controller
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);

	@Autowired MypageService mypageService;
	
	@RequestMapping(value = "/traVlog/mypage.do", method = RequestMethod.GET)
	public void mypage(HttpSession session, Model model, Member member) {
		
		logger.info("마이페이지 GET요청");
			
		String memnick = member.getMemnick();
		logger.info(memnick);
		
		Member selectmember = mypageService.selectMember(memnick);
		List selectpage = mypageService.selectPage(memnick);
		List selectpic = mypageService.selectPic(memnick);
		
		model.addAttribute("selectMember", selectmember);
		model.addAttribute("selectpage", selectpage);
		model.addAttribute("selectpic", selectpic);
		
		int boardCount = mypageService.selectmybod((String)session.getAttribute("memid"));
		int followerCount = mypageService.selectflwer((String)session.getAttribute("memid"));
		int followingCount = mypageService.selectflwing((String)session.getAttribute("memid"));
		
		String memid = (String) session.getAttribute("memid");
	
		model.addAttribute("boardCount",boardCount);
		model.addAttribute("followerCount",followerCount);
		model.addAttribute("followingCount",followingCount);
		
		ArrayList<Profile> pf = mypageService.getprofile(memid);
		model.addAttribute("pf", pf);
		
		logger.info("프로필 정보!" + pf);
		
//		// 보관한 글만 보기
//		String memnick = member.getMemnick();
//		List pinnedPic = mypageservice.selectPinnedpic(memnick);
//		
//		model.addAttribute("pinnedPic", pinnedPic);
		
	}
	
	// 마이페이지 내 글 상세보기
	@RequestMapping(value = "/traVlog/mycontent.do", method = RequestMethod.GET)
	public void mycontent(HttpSession session, Model model, int bodno) {
		logger.info("마이페이지 상세보기");
		
		logger.info("board:"+bodno);
		
		Board selectContent = mypageService.selectContent (bodno);
		List selectContentPic = mypageService.selectContentPic(bodno);
		
		model.addAttribute("selectContent", selectContent);
		model.addAttribute("selectContentPic", selectContentPic);
		
	
	}
	

}


