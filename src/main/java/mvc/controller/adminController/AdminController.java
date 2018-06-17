package mvc.controller.adminController;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mvc.dto.Advertising;
import mvc.dto.Answer;
import mvc.dto.Board;
import mvc.dto.Claim;
import mvc.dto.Member;
import mvc.dto.Notice;
import mvc.dto.NoticeFile;
import mvc.dto.Payment;
import mvc.dto.Question;
import mvc.service.adminService.AdminService;
import mvc.util.Paging;

@Controller
@SessionAttributes({"nick", "id"})
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired AdminService adminService;
	@Autowired ServletContext context;
	
	// 관리자 페이지 사용제한
	@RequestMapping(value="/Manage_Page/Error.do", method=RequestMethod.GET)
	public String adminError() {
		logger.info("관리자 페이지 잘못된 접근");
		
		return "Manage_Page/adminError";
	}
	
	//	관리자 페이지 - 메인(회원 관리)
	@RequestMapping(value="/Manage_Page/home.do", method=RequestMethod.GET)
	public String adminMember(@RequestParam(defaultValue="0") int curPage, Model model, Paging searchContent) {
		
		logger.info("관리자 페이지 - 메인(회원 관리)");
		
		// 회원 목록
		int totalCount = adminService.getSearchTotalMember(searchContent);
		
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearchContent(searchContent.getSearchContent());
		model.addAttribute("paging", paging);
		
		List list = adminService.getSearchPagingMemberList(paging);
		model.addAttribute("list", list);
		
		// 페이징용
		model.addAttribute("url", "/Manage_Page/home.do");
		
		return "Manage_Page/home";
	}
	
	// 회원상태(일반/계정블록/휴면계정) 변경
	@RequestMapping(value="/Manage_Page/updateMemberStatus.do", method=RequestMethod.GET)
	public String adminMemberUpdate(Member member) {

		
		logger.info("관리자 페이지 - 회원 상태 수정");
		
		adminService.updateMemberStatus(member);
		
		return "redirect:/Manage_Page/home.do";
	}

	@RequestMapping(value="/Manage_Page/updateMemberStatusPause.do", method=RequestMethod.GET)
	public String adminMemberUpdatePause(Member member) {
		
		logger.info("관리자 페이지 - 회원 상태 수정");
		
		adminService.updateMemberStatus(member);
		adminService.updatePauseAccount(member);
		
		return "redirect:/Manage_Page/home.do";
	}

	
	
	
	// 관리자 페이지 - 게시판 관리
	@RequestMapping(value="/Manage_Page/boardManage.do", method=RequestMethod.GET)
	public String adminBoard(@RequestParam(defaultValue="0") int curPage, Model model, Paging searchContent) {
		
		logger.info("관리자 게시판 관리 페이지");

		// 게시판 목록
		int totalCount = adminService.getSearchTotalBoard(searchContent);
		
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearchContent(searchContent.getSearchContent());
		model.addAttribute("paging", paging);
		
		List list = adminService.getSearchPagingBoardList(paging);
		model.addAttribute("list", list);
		
		// 페이징용
		model.addAttribute("url", "/Manage_Page/boardManage.do");
		
		return "Manage_Page/adminBoard";
	}
	
	// 게시판 관리 - 글 삭제
	@RequestMapping(value="/Manage_Page/deleteBoard.do", method=RequestMethod.GET)
	public String deleteBoard(Board board) {
	
		adminService.deleteBoardByBoardno(board);
		
		logger.info("게시물 삭제 정상 동작!!");
		
		return "redirect:/Manage_Page/boardManage.do";
	}
	
	// 게시판 관리 - 글 상세보기
	@RequestMapping(value="/Manage_Page/boardView.do", method=RequestMethod.GET)
	public String boardView(Board board, Model model) {
		
		logger.info("게시글 상세보기!!");

		// 게시글 번호로 해당 게시글 불러오기
		model.addAttribute("boardView", adminService.selectBoardByBoardno(board));
		// 게시글 번호로 해당 게시글의 첨부파일 불러오기(별도 처리 및 테스트 필요)
		model.addAttribute("boardFileView", adminService.selectFilesByBoardno(board));
		
		// 게시글 번호로 해당 게시글의 댓글 불러오기
		model.addAttribute("boardComentView", adminService.getCommentListByBoardno(board));

		// 대댓글 불러오기
		model.addAttribute("boardComentsView", adminService.getCommentsList());
		
		return "Manage_Page/boardView";
	}
	
	// 관리자 페이지 - 공지사항
	@RequestMapping(value="/Manage_Page/noticeManage.do", method=RequestMethod.GET)
	public String noticeBoard(@RequestParam(defaultValue="0") int curPage, Model model, Paging searchContent) {
		
		logger.info("관리자 공지사항 페이지");
		
		// 공지사항 목록
//		int totalCount = adminService.getTotalNotice();
		int totalCount = adminService.getSearchTotalNotice(searchContent);
		
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearchContent(searchContent.getSearchContent());
		model.addAttribute("paging", paging);
		
		List list = adminService.getSearchPagingNoticeList(paging);
		model.addAttribute("list", list);
		
		// 페이징용
		model.addAttribute("url", "/Manage_Page/noticeManage.do");
		
		return "Manage_Page/adminNotice";
	}
	
	// 공지사항 관리 - 공지사항 삭제
	@RequestMapping(value="/Manage_Page/deleteNotice.do", method=RequestMethod.GET)
	public String deleteNotice(Notice notice) {
	
		adminService.deleteNoticeByNoticeno(notice);
		
		logger.info("공지사항 삭제 정상 동작!!");
		
		return "redirect:/Manage_Page/noticeManage.do";
	}
	
	// 공지사항 상세보기
	@RequestMapping(value="/Manage_Page/noticeview.do", method=RequestMethod.GET)
	public String noticeView(Notice notice, Model model) {
		
		logger.info("공지사항 상세보기!!");
		
//		Notice notcheck = new Notice();
//		notcheck.setNotno(notice.getNotno());
		
		model.addAttribute("noticeView", adminService.selectNoticeByNoticeno(notice));
		
		NoticeFile noticefile = adminService.downloadNoticeFile(notice);
		model.addAttribute("noticeFile", noticefile);
		
		return "Manage_Page/noticeView";
	}
	
	// 공지사항 작성 폼
	@RequestMapping(value="/Manage_Page/noticeWrite.do", method=RequestMethod.GET)
	public String noticeWrite(HttpSession session) {
		
		logger.info("공지사항 작성 폼!!");
		
//		session.setAttribute("notname", getAttribute("memnick"));
		
		
		return "Manage_Page/noticeWrite";
	}
	
	// 공지사항 작성
	@RequestMapping(value="/Manage_Page/noticeWrite.do", method=RequestMethod.POST)
	public String noticeWriteProc(Notice notice, HttpSession session, MultipartFile file) {
		
		// 고유 식별자
		String uID = UUID.randomUUID().toString().split("_")[0];
		
		// 파일이 저장될 경로
		String realpath = context.getRealPath("upload");

		// 파일이 저장될 이름
		String stored = file.getOriginalFilename()+"_"+uID;

		File dest = new File(realpath, stored);
		
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// DB에 저장
		NoticeFile noticeFile = new NoticeFile();
		noticeFile.setNforiginfile(file.getOriginalFilename());
		noticeFile.setNfsavefile(stored);
		noticeFile.setNffilesize(file.getSize());
		
		adminService.noticeWrite(notice);
		
		adminService.uploadNoticeFile(noticeFile);
		
		return "redirect:/Manage_Page/noticeManage.do";
	}
	
	// 공지사항 수정 폼
	@RequestMapping(value="/Manage_Page/noticeUpdate.do", method=RequestMethod.GET)
	public String noticeUpdate(Notice notice, Model model) {
		
		model.addAttribute("noticeView", adminService.selectNoticeByNoticeno(notice));
		
		return "Manage_Page/noticeUpdate";
	}

	// 공지사항 수정
	@RequestMapping(value="/Manage_Page/noticeUpdate.do", method=RequestMethod.POST)
	public String noticeUpdateProc(Notice notice) {
		
		adminService.updateNoticeByNoticeno(notice);
		
		return "redirect:/Manage_Page/noticeManage.do";
	}
	
	// 공지사항 첨부파일 다운로드
	@RequestMapping(value="/Manage_Page/nfdownload.do", method=RequestMethod.GET)
	public ModelAndView noticeFileDownload(NoticeFile noticefile) {
		
		String path = context.getRealPath("upload");
		String filename = adminService.getSavedNoticeFileName(noticefile);
		
		File notfile = new File(path, filename);
		
		return new ModelAndView("nfdownload", "downNoticeFile", notfile);
	}
	
	
	// 관리자 페이지 - 문의사항 관리
	@RequestMapping(value="/Manage_Page/qnaManage.do", method=RequestMethod.GET)
	public String adminQna(@RequestParam(defaultValue="0") int curPage, Model model, Paging searchContent) {
		
		// 문의사항 목록
		int totalCount = adminService.getSearchTotalQna(searchContent);
		
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearchContent(searchContent.getSearchContent());
		model.addAttribute("paging", paging);
		
		List list = adminService.getSearchPagingQnaList(paging);
		model.addAttribute("list", list);
		
		// 페이징용
		model.addAttribute("url", "/Manage_Page/qnaManage.do");
		
		return "Manage_Page/adminQna";
	}
	
	// 문의사항 상세보기
	@RequestMapping(value="/Manage_Page/qnaView.do", method=RequestMethod.GET)
	public String qnaView(Question question, Answer answer, Model model) {
		
		logger.info("문의사항 상세보기!!");
		
		model.addAttribute("qusView", adminService.selectQuestionByqusno(question));
		model.addAttribute("ansView", adminService.selectAnswerByqusno(question));
		
		return "Manage_Page/qnaView";
	}

	// 회원별 문의사항 목록 보기
	@RequestMapping(value="/Manage_Page/memberQnaList.do", method=RequestMethod.GET)
	public String memberQnaList(@RequestParam(defaultValue="0") int curPage, Question question, Model model) {
		
		// 문의사항 목록
		int totalCount = adminService.getMemberQna(question);
		
		Paging paging = new Paging(totalCount, curPage);
		model.addAttribute("paging", paging);		
		
		List list = adminService.getPagingMemberQnaList(question, paging);
		model.addAttribute("list", list);
		
		return "Manage_Page/adminMemberQna";
	}
	
	// 문의사항 답변 작성 폼
	@RequestMapping(value="/Manage_Page/qnaAnswer.do", method=RequestMethod.GET)
	public String qnaAnswer(Answer answer, Question question, Model model) {
		
		logger.info("문의사항 답변 작성 폼!!");

		model.addAttribute("qusView", adminService.selectQuestionByqusno(question));
		
		return "Manage_Page/qnaAnswer";
	}

	// 문의사항 작성
	@RequestMapping(value="/Manage_Page/qnaAnswer.do", method=RequestMethod.POST)
	public String qnaAnswerProc(Answer answer) {
		
		logger.info("문의사항 답변 작성!!");

		System.out.println("[Test] 타이틀: "+answer.getAnstitle());
		System.out.println("[Test] 내용: "+answer.getAnscontent());
		System.out.println("[Test] 글번호: "+answer.getQusno());
		
		adminService.insertQnaAnswer(answer);
		
		return "redirect:/Manage_Page/qnaManage.do";
	}
	
	// 관리자 페이지 - 신고 관리
	@RequestMapping(value="/Manage_Page/claimManage.do", method=RequestMethod.GET)
	public String adminClaim(@RequestParam(defaultValue="0") int curPage, Model model, Paging searchContent) {
		
		// 게시물 신고 목록
		int totalBoardCount = adminService.getSearchTotalBoardClaim(searchContent);
		
		Paging paging = new Paging(totalBoardCount, curPage);
		paging.setSearchContent(searchContent.getSearchContent());
		model.addAttribute("paging", paging);		

		List list = adminService.getSearchPagingBoardClaimList(paging);
		model.addAttribute("list", list);
		
		// 회원 신고 목록
//		int totalMemberCount = adminService.getTotalMemberClaim();
//		
//		Paging mempaging = new Paging(totalMemberCount, curPage);
//		model.addAttribute("mempaging", mempaging);		
//
//		List memlist = adminService.getPagingMemberClaimList(paging);
//		model.addAttribute("memlist", memlist);
		
		// 페이징용
		model.addAttribute("url", "/Manage_Page/claimManage.do");
		
		return "Manage_Page/adminClaim";
	}

	// 신고 관리 - 신고 처리 상태 변경
	@RequestMapping(value="/Manage_Page/updateClmCondition.do", method=RequestMethod.GET)
	public String updateClmCondition(Claim claim) {

		logger.info("관리자 페이지 - 신고 처리 상태 수정");
		
		adminService.updateClmCondition(claim);
		
		return "redirect:/Manage_Page/claimManage.do";		
	}
	
	
	// 관리자 페이지 - 광고 관리
	@RequestMapping(value="/Manage_Page/advManage.do", method=RequestMethod.GET)
	public String adminAdvertising(@RequestParam(defaultValue="0") int curPage, Model model, Paging searchContent) {

		// 신고 목록 페이징
//		int totalCount = adminService.getTotalAdvertising();
		int totalCount = adminService.getSearchTotalAdvertising(searchContent);
		
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearchContent(searchContent.getSearchContent());
		model.addAttribute("paging", paging);		

		List list = adminService.getSearchPagingAdvertisingList(paging);
		model.addAttribute("list", list);
		
		// 페이징용
		model.addAttribute("url", "/Manage_Page/advManage.do");
		
		return "Manage_Page/adminAdvertising";
	}
	
	// 광고 관리 - 광고 승인 상태 수정
	@RequestMapping(value="/Manage_Page/updateAdvApprove.do", method=RequestMethod.GET)
	public String adminAdvApprove(Advertising advertising) {

		logger.info("관리자 페이지 - 광고 승인 상태 수정");
		
//		System.out.println(advertising);
		adminService.updateAdvApprove(advertising);
		
		return "redirect:/Manage_Page/advManage.do";
	}
	
	// 관리자 페이지 - 결제 관리
	@RequestMapping(value="/Manage_Page/paymentManage.do", method=RequestMethod.GET)
	public String adminPayment(@RequestParam(defaultValue="0") int curPage, Model model, Paging searchContent) {
		
		// 결제 목록 페이징
//		int totalCount = adminService.getTotalPayment();
		int totalCount = adminService.getSearchTotalPayment(searchContent);
		
		Paging paging = new Paging(totalCount, curPage);
		paging.setSearchContent(searchContent.getSearchContent());		
		model.addAttribute("paging", paging);		

		List list = adminService.getSearchPagingPaymentList(paging);
		model.addAttribute("list", list);
		
		// 페이징용
		model.addAttribute("url", "/Manage_Page/paymentManage.do");
		
		return "Manage_Page/adminPayment";
	}

	// 결제 관리 - 결제 승인, 취소
	@RequestMapping(value="/Manage_Page/updatePaycondition.do", method=RequestMethod.GET)
	public String adminPayCondition(Payment payment) {

		logger.info("관리자 페이지 - 광고 승인 상태 수정 및 처리일시 등록");
		
		adminService.updatePayCondition(payment);
		
		return "redirect:/Manage_Page/paymentManage.do";
	}
	
}	// class END
