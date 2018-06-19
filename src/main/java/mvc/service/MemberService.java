package mvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.MemberDao;
import mvc.dao.MessageDao;
import mvc.dao.SettingDao;
import mvc.dto.Advertising;
import mvc.dto.Follow;
import mvc.dto.Member;
import mvc.dto.Message;
import mvc.dto.Question;
import mvc.dto.Report;

@Service
public class MemberService {
	@Autowired MemberDao memberDao;
	@Autowired MessageDao messageDao;
	@Autowired SettingDao settingDao;
	
	//1이면 데이타 일치, 0이면 데이타 없음
	public int memberCheck(Member member) {
		return memberDao.memberCount(member);
	}

	public Member getMemberOne(Member member) {
		return memberDao.getMemberOne(member);
	}

	public void createMember(Member member) {
		memberDao.createMember(member);
	}

	public int idcheck(String memid) {
		return memberDao.idcheck(memid);
	}

	public int nickcheck(String memnick) {
		return memberDao.nickcheck(memnick);
	}

	public String findId(Map<String, Object> paramMap) {
		return memberDao.findId(paramMap);
	}
	
	public String findPw(Map<String, Object> paramMap) {
		return memberDao.findPw(paramMap);
	}

	public ArrayList<Member> MemberInfo(String memid) {
		return memberDao.MemberInfo(memid);
	}

	public String getProfile(String memnick) {
	      return memberDao.getProfile(memnick);
   }

   public int countProfile(String memnick) {
      return memberDao.countProfile(memnick);
   }

   public void followAdmin(Member member) {
      memberDao.followAdmin(member);
   }

   public ArrayList<Advertising> adInfo() {
      return memberDao.adInfo();
   }

	public void insertFollow(Follow insertFollow) {
		memberDao.insertFollow(insertFollow);
	}

	public Member getMemberById(Member member) {
		return memberDao.getMemberById(member);
	}
	
	// 회원정보 상세
	public Member setUserinfo(Member member) {
		return settingDao.setUserinfo(member);
	}

	public Member getUserinfo(Member member) {
		return settingDao.getUserinfo(member);
	}

	// 회원정보 수정
	public void updateUserinfo(Member member) {
		settingDao.updateUserinfo(member);
	}
	
//	// 비번 체크
//	public boolean checkPw(Member member) {
//		return settingDao.checkPw(member);
//	}
	
	// 팔로우목록
	public List getflw(String id) {
		return settingDao.getflw(id);
	}
	
	// 팔로워목록
	public List getflwing(String id) {
		return settingDao.getflwing(id);
	}
	
	
	
	 public void sendingmessage(Message message) {
		  messageDao.sendingmessage(message);
	   }
	/*public void reportProc(Member member,Report report) {
		return memberDao.reportProc(member,report);
	}	*/

	public void report(Report report) {
		memberDao.report(report);
	}

	public void advertising(Advertising advertising) {
		memberDao.advertising(advertising);
		
	}

	public List showadvertising(Advertising advertising) {

		return memberDao.showadvertising(advertising);
	}

	public void qnapage2(Question question) {
	 memberDao.qnapage2(question);
		
	}

	public List showquestion(Question question) {
		return memberDao.showquestion(question);
	
	}

	public void message(Message message) {
		memberDao.message(message);
	}

	public Member getMemberByMemId(Member member) {
		return memberDao.getMemberByMemId(member);
	}

	public Advertising getAdvertisingByAd(Advertising adInfo) {
		return memberDao.getAdvertisingByAd(adInfo);
	}



}
