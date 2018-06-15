package mvc.service.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.adminDao.AdminDao;
import mvc.dto.Advertising;
import mvc.dto.Answer;
import mvc.dto.Board;
import mvc.dto.Claim;
import mvc.dto.Comment;
import mvc.dto.Files;
import mvc.dto.Member;
import mvc.dto.Notice;
import mvc.dto.NoticeFile;
import mvc.dto.Payment;
import mvc.dto.Question;
import mvc.util.Paging;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired AdminDao adminDao;

	@Override
	public List selectAllBoard() {
		
		return adminDao.selectAllBoard();
	}

	@Override
	public int getTotalBoard() {
		
		int getTotalBoard = adminDao.getTotalBoard();
		
		return getTotalBoard;
	}
	
	@Override
	public int getSearchTotalBoard(Paging searchContent) {
		
		int getSearchTotalBoard = adminDao.getSearchTotalBoard(searchContent);
		
		return getSearchTotalBoard;
	}

	@Override
	public List getPagingBoardList(Paging paging) {
		
		return adminDao.pagingBoardList(paging);
	}
	
	@Override
	public List getSearchPagingBoardList(Paging searchContent) {

		return adminDao.searchPagingBoardList(searchContent);
	}

	@Override
	public void deleteBoardByBoardno(Board board) {

			adminDao.deleteBoardByBoardno(board);
	}

	@Override
	public Board selectBoardByBoardno(Board board) {

		return adminDao.selectBoardByBoardno(board);
	}
	
	@Override
	public Files selectFilesByBoardno(Board board) {

		return adminDao.selectFilesByBoardno(board);
	}
	
	
	@Override
	public int getTotalMember() {

		int getTotalMember = adminDao.getTotalMember();
		
		return getTotalMember;
	}

	@Override
	public int getSearchTotalMember(Paging searchContent) {

		int getTotalMember = adminDao.getSearchTotalMember(searchContent);
		
		return getTotalMember;
	}
	
	@Override
	public List getPagingMemberList(Paging paging) {

		return adminDao.pagingMemberList(paging);
	}
	
	@Override
	public List getSearchPagingMemberList(Paging paging) {

		return adminDao.searchPagingMemberList(paging);
	}

	@Override
	public void updateMemberStatus(Member member) {
		
		adminDao.updateMemberStatus(member);
	}

	@Override
	public void updatePauseAccount(Member member) {
		
		adminDao.updatePauseAccount(member);
	}
	
	@Override
	public int getTotalNotice() {
		int getTotalNotice = adminDao.getTotalNotice();
		
		return getTotalNotice;
	}
	
	@Override
	public int getSearchTotalNotice(Paging searchContent) {
		int getTotalNotice = adminDao.getSearchTotalNotice(searchContent);
		
		return getTotalNotice;
	}
	
	@Override
	public List getPagingNoticeList(Paging paging) {

		return adminDao.pagingNoticeList(paging);
	}
	
	@Override
	public List getSearchPagingNoticeList(Paging searchContent) {

		return adminDao.searchPagingNoticeList(searchContent);
	}

	@Override
	public void deleteNoticeByNoticeno(Notice notice) {
		adminDao.deleteNoticeByNoticeno(notice);
		
	}

	@Override
	public Notice selectNoticeByNoticeno(Notice notice) {
		
		return adminDao.selectNoticeByNoticeno(notice);
	}
	
	@Override
	public void noticeWrite(Notice notice) {
		adminDao.insertNotice(notice);
	}

	@Override
	public void uploadNoticeFile(NoticeFile noticeFile) {
		
		adminDao.insertNoticeFile(noticeFile);
	}

	@Override
	public NoticeFile downloadNoticeFile(Notice notice) {

		return adminDao.selectNoticeFile(notice);
	}

	@Override
	public String getSavedNoticeFileName(NoticeFile noticefile) {

		return adminDao.getSavedNoticeFileName(noticefile);
	}
	
	@Override
	public void updateNoticeByNoticeno(Notice notice) {
		adminDao.updateNoticeByNoticeno(notice);
	}
	
	@Override
	public int getTotalQna() {
		int getTotalQna = adminDao.getTotalQna();

		return getTotalQna;
	}
	
	@Override
	public int getSearchTotalQna(Paging searchContent) {
		int getTotalQna = adminDao.getSearchTotalQna(searchContent);
		
		return getTotalQna;
	}

	@Override
	public List getPagingQnaList(Paging paging) {

		return adminDao.pagingQnaList(paging);
	}
	
	@Override
	public List getSearchPagingQnaList(Paging searchContent) {

		return adminDao.searchPagingQnaList(searchContent);
	}

	@Override
	public Question selectQuestionByqusno(Question question) {

		return adminDao.selectQuestionByqusno(question);
	}

	@Override
	public Answer selectAnswerByqusno(Question question) {

		return adminDao.selectAnswerByqusno(question);
	}

	@Override
	public int getMemberQna(Question question) {

		int getMemberQna = adminDao.getMemberQna(question);

		return getMemberQna;
	}

	@Override
	public List getPagingMemberQnaList(Question question, Paging paging) {

//		return adminDao.pagingMemberQnaList(question, paging);
		return adminDao.pagingMemberQnaList(question);
	}

	@Override
	public void insertQnaAnswer(Answer answer) {

		adminDao.insertQnaAnswer(answer);
	}

	@Override
	public int getTotalBoardClaim() {

		int getTotalClaim = adminDao.getTotalBoardClaim();

		return getTotalClaim;
	}
	
	@Override
	public int getSearchTotalBoardClaim(Paging searchContent) {

		int getTotalClaim = adminDao.getSearchTotalBoardClaim(searchContent);

		return getTotalClaim;
	}

	@Override
	public List getPagingBoardClaimList(Paging paging) {

		return adminDao.pagingBoardClaimList(paging);
	}
	
	@Override
	public List getSearchPagingBoardClaimList(Paging searchContent) {

		return adminDao.searchPagingBoardClaimList(searchContent);
	}
	
	@Override
	public void updateClmCondition(Claim claim) {

		adminDao.updateClmCondition(claim);
	}

	@Override
	public List getClaimListForPdf() {

		return adminDao.ClaimListForPdf();
	}

	@Override
	public int getTotalAdvertising() {

		int getTotalAdvertising = adminDao.getTotalAdvertising();
		
		return getTotalAdvertising;
	}

	@Override
	public int getSearchTotalAdvertising(Paging searchContent) {

		int getTotalAdvertising = adminDao.getSearchTotalAdvertising(searchContent);
		
		return getTotalAdvertising;
	}

	@Override
	public List getPagingAdvertisingList(Paging paging) {

		return adminDao.pagingAdvertisingList(paging);
	}
	
	@Override
	public List getSearchPagingAdvertisingList(Paging searchContent) {

		return adminDao.searchPagingAdvertisingList(searchContent);
	}

	@Override
	public void updateAdvApprove(Advertising advertising) {
		
		adminDao.updateAdvApprove(advertising);
	}

	@Override
	public int getTotalPayment() {

		int getTotalPayment = adminDao.getTotalPayment();
		
		return getTotalPayment;
	}
	
	@Override
	public int getSearchTotalPayment(Paging searchContent) {

		int getTotalPayment = adminDao.getSearchTotalPayment(searchContent);
		
		return getTotalPayment;
	}

	@Override
	public List getPagingPaymentList(Paging paging) {

		return adminDao.pagingPaymentList(paging);
	}

	@Override
	public List getSearchPagingPaymentList(Paging searchContent) {

		return adminDao.searchPagingPaymentList(searchContent);
	}

	@Override
	public void updatePayCondition(Payment payment) {

		adminDao.updatePayCondition(payment);
	}

	@Override
	public List getCommentListByBoardno(Board board) {

		return adminDao.getCommentListByBoardno(board);
	}





}
