package mvc.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import mvc.dto.Advertising;
import mvc.dto.Board;
import mvc.dto.Follow;
import mvc.dto.Member;
import mvc.dto.Message;
import mvc.dto.Payment;
import mvc.dto.Profile;
import mvc.dto.Question;
import mvc.dto.Report;
import mvc.service.MemberService;
import mvc.service.MessageService;
import mvc.service.MypageService;

@Controller
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);

	@Autowired MypageService mypageService;
	@Autowired MemberService memberService;
	@Autowired MessageService messageService;

	
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
		List selectprofile = mypageService.getProfile(selectContent.getBodname());
		
		logger.info("이름:"+selectContent.getBodname());
		logger.info("이름:"+selectprofile.get(0));
		
		model.addAttribute("selectprofile", selectprofile);
		model.addAttribute("selectContent", selectContent);
		model.addAttribute("selectContentPic", selectContentPic);
		
	
	}
	
	// 마이페이지 내 글 삭제
	@RequestMapping(value = "/traVlog/contentdelete.do", method = RequestMethod.GET)
	public String contentdelete(HttpSession session, Model model, int bodno, String memnick) {
		
		logger.info("마이페이지 게시글 삭제");
		
		//로그인한 사용자 아이디 가져오기
		String memid = (String) session.getAttribute("memid");
		mypageService.contentdelete(bodno);
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
	

	   @RequestMapping(value="/traVlog/follow.do", method=RequestMethod.GET)
	   public String follow(HttpSession session, String flwid, String flwnick) {
		   
		  Follow follow = new Follow();
	      String memid = (String) session.getAttribute("memid");
	      
	      follow.setMemid(memid);
	      follow.setFlwid(flwid);
	      
	      if(mypageService.checkfollow(follow) != 1) {
	    	  
	    	    mypageService.dofollow(follow);
	    	    
	      } else {
	    	  
	    	  
	      }
	  
	      String ret = null;
			
			try {
				ret = "redirect:mypage.do?memnick="+URLEncoder.encode(flwnick, "utf-8");
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

	   
	   // 로그아웃
	   @RequestMapping(value="/traVlog/logout.do")
	   public void logout(HttpSession session) {
	      session.invalidate();
	   }
	  
		 //받은 메세지 리스트
		@RequestMapping(value = "/traVlog/getmessage.do", method = RequestMethod.GET)
		public String getmessage(Model model, HttpSession session) {
			String yourId=(String)session.getAttribute("memid");
			List mList = messageService.getMessageList(yourId);
			System.out.println(mList);
			model.addAttribute("mList", mList);
			return "traVlog/getmessage";
		}
		
		
		//받은 메세지함
		@RequestMapping(value = "/traVlog/getmessage.do", method = RequestMethod.POST)
		public String sendmessage(Model model, Message message) {
			model.addAttribute("message",message);
			
			return "traVlog/getmessage";
		}

		
		 //보낸 메세지 리스트
			@RequestMapping(value = "/traVlog/getmessage2.do", method = RequestMethod.GET)
			public String getmessage2(Model model,HttpSession session) {
				String myId = (String)session.getAttribute("memid");
				List sList = messageService.sentMessageList(myId);
				System.out.println(sList);
				model.addAttribute("sList", sList);
				return "traVlog/getmessage2";
			}
		

		
		//보낸 메세지함
		@RequestMapping(value="/traVlog/getmessage2.do", method=RequestMethod.POST)
		public String getmessage2(Model model, Message message) {
			System.out.println("보낸거");
			
			model.addAttribute("message",message);
			
			return "traVlog/getmessage2";
			
		}

		
		
		//메세지 상세보기
		@RequestMapping(value="/traVlog/messageDetail.do")
		public String messageDetail(Message message,Model model) {
			logger.info("처음 메시지 : "+message);
			List m_list = messageService.getMessageDetail(message);
			logger.info("메시지"+m_list);
			
			model.addAttribute("m_list", m_list);
			return "traVlog/messageDetail";
		}
	//	
//		//메세지 보내기
//		@RequestMapping(value="/traVlog/sendmessage.do",method=RequestMethod.GET)
//		public String sendingmessage(Message message,HttpSession session,Member member) {
//			System.out.println("www : "+message);
	////message.setMemid("memid");
	//message.setMesname("mesname");
//			System.out.println("변한 객체 :"+message);
//			memberService.sendingmessage(message);
//			
//			return "traVlog/getmessage2.do";

//		}
		//메세지 보내기
			@RequestMapping(value="/traVlog/sendmessage.do",method=RequestMethod.POST)
			public String sendingmessage(Message message,HttpSession session,Member member) {
				System.out.println("www : "+message);
//				message.setMemid("memid");
				message.setMesname("mesname");
				System.out.println("변한 객체 :"+message);
				memberService.sendingmessage(message);
				
				return "redirect:/traVlog/getmessage2.do";

			}
		
		
		
		
//		//남한테 메세지 보내기 
//				@RequestMapping(value="/traVlog/sendmessage2.do",method=RequestMethod.GET)
//				public void sending(Message message,Model model) {
//					System.out.println("message : "+message);
//					model.addAttribute("message", message);
//				}
//				
	//	
//				//남한테 메세지 보내기 
//		@RequestMapping(value="/traVlog/sendmessage2.do",method=RequestMethod.POST)
//		public String sendmessage2(Message message, HttpSession session) {
//			System.out.println("message :" + message);
//			memberService.message(message);
//			return "redirect:/traVlog/otherpage.do";
//		}

			
	//신고하기
		
		
		@RequestMapping(value="/traVlog/report.do",method=RequestMethod.GET)
		public void repor(Member member,Model model) {
			System.out.println("신고할 사용자 아이디 : "+member);
			model.addAttribute("member", member);
		}
		
		
		@RequestMapping(value="/traVlog/report.do",method=RequestMethod.POST)
		public String report(Report report, HttpSession session) {
			logger.info("신고됐나");
			System.out.println("신고는?: "+ report);
			memberService.report(report);
				return "redirect:/traVlog/report.do";
		}

		
		
		//광고1
				@RequestMapping(value="/traVlog/advertising.do",method=RequestMethod.GET)
				public void advert(Member member,Model model) {
					System.out.println("광고 : "+member);
					model.addAttribute("member", member);
				}
				
		
		//광고2
		@RequestMapping(value="/traVlog/advertising.do",method=RequestMethod.POST)
		public String advertising(Advertising advertising, HttpSession session) {
			System.out.println("광고보내기 :" + advertising);
			memberService.advertising(advertising);
			return "traVlog/advertising";
		}
			
		//광고 내역 보여주기
		@RequestMapping(value="/traVlog/showadvertising.do")
		public String showadvertising(Advertising advertising, Model model,HttpSession session) {
			logger.info("광고내역" + advertising);
			advertising.setAdvid((String)session.getAttribute("memid"));
		List a_list = memberService.showadvertising(advertising);
		logger.info("리스트 :"+ a_list);
		model.addAttribute("a_list", a_list);
		return "traVlog/showadvertising";
		}
		
			
		//결제하기
		@RequestMapping(value="/traVlog/payment.do", method=RequestMethod.GET)
		public void payment(HttpSession session, Model model,Advertising ad) {
			Member member = new Member();
			logger.info((String)session.getAttribute("memid"));
			member.setMemid((String)session.getAttribute("memid")); 
			member = memberService.getMemberByMemId(member);
			Advertising adInfo = new Advertising();
			adInfo.setAdvid((String)session.getAttribute("memid"));
			adInfo.setAdvno(ad.getAdvno());
			adInfo = memberService.getAdvertisingByAd(adInfo);
			
			model.addAttribute("adInfo",adInfo);
			model.addAttribute("member",member);
		}
			
		@RequestMapping(value="/traVlog/payment.do", method=RequestMethod.POST)
		public Map<Object,Object> paymentData(HttpSession session, Model model,Payment payment) {
			logger.info("결제 정보 저장페이지 요청.. 결제정보 : "+payment.toString());
			
			Map<Object,Object> answer = new HashMap<>();
			answer.put("msg", "success");
			return answer;
		}

//		//남의 페이지 보여주기
//		@RequestMapping(value="/traVlog/otherpage.do")
//		public String otherpage(Model model, Member member) {
//			model.addAttribute("member",member);
//		return "traVlog/otherpage";
//		}


		//Qna 페이지 (질문 페이지)
		@RequestMapping(value="/traVlog/qnapage2.do", method=RequestMethod.GET)
		public void qnapage(Member member, Model model) {
			System.out.println("문의");
			model.addAttribute("member",member);
			
		}

		//Qna 페이지 (질문 페이지)
		@RequestMapping(value="/traVlog/qnapage2.do",method=RequestMethod.POST)
		public String qnapage2(Question question, HttpSession session) {
			System.out.println("질문보내기 :" + question);
		memberService.qnapage2(question);
		return "redirect:/traVlog/qnapage2.do";
		}
		
		
		//질문 내역 보여주기
		@RequestMapping(value="/traVlog/showquestion.do")
		public String showquestion(Question question, Model model) {
			logger.info("질문내역" + question);
		List q_list = memberService.showquestion(question);
		logger.info("질문리스트 :"+ q_list);
		model.addAttribute("q_list", q_list);
		return "traVlog/showquestion";
		}


}


