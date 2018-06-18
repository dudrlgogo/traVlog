package mvc.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.pdf.qrcode.Encoder;

import mvc.dto.Board;
import mvc.dto.Member;
import mvc.dto.Profile;
import mvc.service.MemberService;
import mvc.service.MypageService;

@Controller
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);

	@Autowired MypageService mypageService;
	@Autowired MemberService memberService;
	
	@Autowired ServletContext context;
	
	@RequestMapping(value = "/traVlog/mypage.do", method = RequestMethod.GET)
	public void mypage(HttpSession session, Model model, Member member) {
		
		logger.info("마이페이지 GET요청");
			
		String memnick = member.getMemnick();
		logger.info(memnick);
		
		Member selectmember = mypageService.selectMember(memnick);
		List selectprofile = mypageService.getProfile(memnick);
		List selectpage = mypageService.selectPage(memnick);
		List selectpic = mypageService.selectPic(memnick);
		
		model.addAttribute("selectMember", selectmember);
		model.addAttribute("selectprofile", selectprofile);
		model.addAttribute("selectpage", selectpage);
		model.addAttribute("selectpic", selectpic);
		
		int boardCount = mypageService.selectmybod((String)session.getAttribute("memid"));
		int followerCount = mypageService.selectflwer((String)session.getAttribute("memid"));
		int followingCount = mypageService.selectflwing((String)session.getAttribute("memid"));
		
		String memid = (String) session.getAttribute("memid");
	
		model.addAttribute("boardCount",boardCount);
		model.addAttribute("followerCount",followerCount);
		model.addAttribute("followingCount",followingCount);
		
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
	
	// 마이페이지 내 글 삭제
	@RequestMapping(value = "/traVlog/contentdelete.do", method = RequestMethod.GET)
	public String contentdelete(HttpSession session, Model model, int bodno, String memnick) {
		
		logger.info("마이페이지 게시글 삭제");
		
		//로그인한 사용자 아이디 가져오기
		String memid = (String) session.getAttribute("memid");
		logger.info(memid);
		logger.info(memnick);
	
		String ret = null;
		try {
			ret = "redirect:mypage.do?memnick="+URLEncoder.encode(memnick, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	// 프로필 작성폼
	   @RequestMapping(value="/traVlog/settingprofile.do", method=RequestMethod.GET)
	   public String settingprofileproc(Profile pf, Model model) {
	      model.addAttribute("profile", pf);
	      return "traVlog/settingprofile";
	   }
	   
	   @RequestMapping(value="/traVlog/insertprofile.do", method=RequestMethod.POST)
	   public String insertpf(Profile pf, HttpSession session, MultipartFile profileimg) {
	      logger.info("프로필 작성 POST 요청");
	      
	      String memnick = (String) session.getAttribute("memnick");
	            
	      String uID = UUID.randomUUID().toString().split("-")[0];
	            
	      // 파일 저장경로
	      String realpath = context.getRealPath("/resources/profileImage");
	      
	      // 파일이 저장될 이름
	      String stored = uID+"-"+profileimg.getOriginalFilename();
	      File dest = new File(realpath, stored);
	      System.out.println(dest);
	      
	      // 파일 업로드
	      try {
	         profileimg.transferTo(dest);
	      } catch (IllegalStateException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      
	      // DB에 기록 
	      
	      pf.setmemnick(memnick);
	      pf.setPfOriginfile(profileimg.getOriginalFilename());
	      pf.setPfSavefile(stored);
	      pf.setPf_Size((int)profileimg.getSize());
	      mypageService.insertimg(pf);
	      
	      String ret = null;
	      try {
	    	  ret = "redirect:mypage.do?memnick="+URLEncoder.encode(memnick, "utf-8");
	      } catch (UnsupportedEncodingException e) {
	    	  e.printStackTrace();
	      }
	      
	      return ret;
	   }
	   
	   // 프로필수정폼
	      @RequestMapping(value="/traVlog/changeprofile.do", method=RequestMethod.GET)
	      public String updatepfForm(Profile pf, Model model) {
	         model.addAttribute("pf", pf);
	         return "traVlog/settingprofile";
	      }
	   
	   @RequestMapping(value="/traVlog/updateprofile.do", method=RequestMethod.POST)
	   public String updatepf(Profile pf, HttpSession session) {
		   mypageService.updatepf(pf);
	      return "redirect:/traVlog/settingprofile.do";
	   }
	   
	   // 팔로우
	//   @RequestMapping(value="/traVlog/follow.do", method=RequestMethod.GET)
	//   public void dofollow() {}
	//   
	//   @RequestMapping(value="/traVlog/follow.do", method=RequestMethod.POST)
	//   public String dofollowproc(HttpSession session, String memid) {
//	      memid = (String) session.getAttribute("memid");
//	      mypageservice.dofollow(memid);
//	      return "traVlog/mypage";
	//   }
	   
	   
	   // 로그아웃
	   @RequestMapping(value="/traVlog/logout.do")
	   public void logout(HttpSession session) {
	      session.invalidate();
	   }

}


