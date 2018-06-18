package mvc.dao.adminDao;

import java.util.List;

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

public interface AdminDao {


	public List selectAllBoard();

	public int getTotalBoard();
	
	public int getSearchTotalBoard(Paging searchContent);
	
	public List pagingBoardList(Paging paging);
	
	public List searchPagingBoardList(Paging searchContent);

	public void deleteBoardByBoardno(Board board);

	public Board selectBoardByBoardno(Board board);

	public List selectFilesByBoardno(Board board);
	
	public int getTotalMember();
	
	public int getSearchTotalMember(Paging searchContent);

	public List pagingMemberList(Paging paging);

	public List searchPagingMemberList(Paging paging);
	
	public void updateMemberStatus(Member member);

	public void updatePauseAccount(Member member);

	public int getTotalNotice();

	public int getSearchTotalNotice(Paging searchContent);
	
	public List pagingNoticeList(Paging paging);

	public List searchPagingNoticeList(Paging searchContent);
	
	public void deleteNoticeByNoticeno(Notice notice);

	public Notice selectNoticeByNoticeno(Notice notice);
	
	public void updateNoticeByNoticeno(Notice notice);

	public int getTotalQna();

	public int getSearchTotalQna(Paging searchContent);
	
	public List pagingQnaList(Paging paging);
	
	public List searchPagingQnaList(Paging searchContent);

	public void insertNotice(Notice notice);

	public Question selectQuestionByqusno(Question question);

	public Answer selectAnswerByqusno(Question question);

	public int getMemberQna(Paging searchContent);

//	public List pagingMemberQnaList(Question question, Paging paging);
	public List pagingMemberQnaList(Paging paging);

	public void insertQnaAnswer(Answer answer);

	public void insertNoticeFile(NoticeFile noticeFile);

	public NoticeFile selectNoticeFile(Notice notice);

	public String getSavedNoticeFileName(NoticeFile noticefile);

	public int getTotalBoardClaim();

	public int getSearchTotalBoardClaim(Paging searchContent);
	
	public List pagingBoardClaimList(Paging paging);
	
	public List searchPagingBoardClaimList(Paging searchContent);
	
	public void updateClmCondition(Claim claim);

	public List ClaimListForPdf();

	public int getTotalAdvertising();

	public int getSearchTotalAdvertising(Paging searchContent);
	
	public List pagingAdvertisingList(Paging paging);
	
	public List searchPagingAdvertisingList(Paging searchContent);

	public void updateAdvApprove(Advertising advertising);

	public int getTotalPayment();

	public int getSearchTotalPayment(Paging searchContent);
	
	public List pagingPaymentList(Paging paging);

	public List searchPagingPaymentList(Paging searchContent);
	
	public void updatePayCondition(Payment payment);

	public void updateUnusedAccount();

	public void updateAdvertisingStart();

	public void updateAdvertisingEnd();

	public void updatePauseStatusReset();

	public void updatePauseTimeReset();

	public List getCommentListByBoardno(Board board);

	public List getCommentsListByCommentno(Board board);











	
	
}
