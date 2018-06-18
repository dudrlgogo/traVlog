package mvc.dao;

import java.util.List;

import mvc.dto.Follow;
import mvc.dto.Member;

public interface SettingDao {

	// 회원정보 불러오기
	public Member setUserinfo(Member member);
	
	// 회원정보 수정
	public void updateUserinfo(Member member);
	
	// 회원정보 수정을 위한 비밀번호 확인
//	public boolean checkPw(Member member);
	
	public Member getUserinfo(Member member);
	
	// 팔로잉 목록 가져오기
	public List getflw(String id);
	
	// 팔로워 목록 가져오기
	public List getflwing(String id);
	
}
