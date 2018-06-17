package mvc.service.adminService;

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

public interface AdminService {

	// 게시판 전체 리스트
	public List selectAllBoard();
	
	// 게시판 페이징 처리
	public int getTotalBoard();

	// 게시판 페이징 처리 + 검색
	public int getSearchTotalBoard(Paging searchContent);
	
	// 페이징 처리된 게시글 전체 조회
	public List getPagingBoardList(Paging paging);

	// 페이징 처리된 게시글 전체 조회 + 검색
	public List getSearchPagingBoardList(Paging searchContent);

	// 게시판 목록 글 삭제
	public void deleteBoardByBoardno(Board board);

	// 게시글 상세보기
	public Board selectBoardByBoardno(Board board);

	// 게시글 상세보기(첨부파일)
	public List selectFilesByBoardno(Board board);	
	
	// 회원 목록 페이징 처리
	public int getTotalMember();

	// 회원 목록 페이징 처리 + 검색
	public int getSearchTotalMember(Paging searchContent);

	// 페이징 처리된 회원 목록 조회
	public List getPagingMemberList(Paging paging);

	// 페이징 처리된 회원 목록 조회 + 검색
	public List getSearchPagingMemberList(Paging paging);
	
	// 회원 상태 변경
	public void updateMemberStatus(Member member);

	// 회원 계정 정지
	public void updatePauseAccount(Member member);

	// 공지사항 목록 페이징 처리
	public int getTotalNotice();

	// 공지사항 목록 페이징 처리 + 검색
	public int getSearchTotalNotice(Paging searchContent);
	
	// 페이징 처리된 공지사항 목록 조회
	public List getPagingNoticeList(Paging paging);

	// 페이징 처리된 공지사항 목록 조회 + 검색	
	public List getSearchPagingNoticeList(Paging searchContent);
	
	// 공지사항 삭제
	public void deleteNoticeByNoticeno(Notice notice);

	// 공지사항 상세보기
	public Notice selectNoticeByNoticeno(Notice notice);
	
	// 공지사항 작성
	public void noticeWrite(Notice notice);

	// 공지사항 파일 업로드
	public void uploadNoticeFile(NoticeFile noticeFile);

	// 공지사항 첨부파일 불러오기
	public NoticeFile downloadNoticeFile(Notice notice);

	// 공지사항 첨부파일2
	public String getSavedNoticeFileName(NoticeFile noticefile);
	
	// 공지사항 수정
	public void updateNoticeByNoticeno(Notice notice);

	// 문의사항 목록 페이징 처리
	public int getTotalQna();
	
	// 문의사항 목록 페이징 처리 + 검색
	public int getSearchTotalQna(Paging searchContent);

	// 페이징 처리된 문의사항 목록 조회
	public List getPagingQnaList(Paging paging);

	// 페이징 처리된 문의사항 목록 조회 + 검색
	public List getSearchPagingQnaList(Paging searchContent);
	
	// 문의사항 상세보기
	public Question selectQuestionByqusno(Question question);

	// 문의답변 상세보기
	public Answer selectAnswerByqusno(Question question);
	
	// 회원별 문의사항 목록 페이징 처리
	public int getMemberQna(Question question);

	// 페이징된 회원별 문의사항 목록 조회
	public List getPagingMemberQnaList(Question question, Paging paging);

	// 문의사항 답변 작성
	public void insertQnaAnswer(Answer answer);

	// 게시물 신고 목록 페이징 처리
	public int getTotalBoardClaim();

	// 게시물 신고 목록 페이징 처리 + 검색
	public int getSearchTotalBoardClaim(Paging searchContent);
	
	// 페이징된 신고 목록 조회
	public List getPagingBoardClaimList(Paging paging);
	
	// 페이징된 신고 목록 조회 + 검색
	public List getSearchPagingBoardClaimList(Paging searchContent);

	// 신고 처리 상태 변경
	public void updateClmCondition(Claim claim);
	
	// pdf 테스트용 신고 목록
	public List getClaimListForPdf();

	// 광고 목록 페이징 처리
	public int getTotalAdvertising();
	
	// 광고 목록 페이징 처리 + 검색
	public int getSearchTotalAdvertising(Paging searchContent);

	// 페이징된 광고 목록 조회
	public List getPagingAdvertisingList(Paging paging);
	
	// 페이징된 광고 목록 조회 + 검색
	public List getSearchPagingAdvertisingList(Paging searchContent);

	// 광고 승인 상태 수정
	public void updateAdvApprove(Advertising advertising);

	// 결제 목록 페이징 처리
	public int getTotalPayment();

	// 결제 목록 페이징 처리 + 검색
	public int getSearchTotalPayment(Paging searchContent);
	
	// 페이징된 결제 목록 조회
	public List getPagingPaymentList(Paging paging);

	// 페이징된 결제 목록 조회 + 검색
	public List getSearchPagingPaymentList(Paging searchContent);

	// 결제 승인, 취소
	public void updatePayCondition(Payment payment);

	// 게시글 상세 페이지 댓글 가져오기
	public List getCommentListByBoardno(Board board);

	// 게시글 상세 페이지 대댓글 가져오기
	public List getCommentsList();


	
}
