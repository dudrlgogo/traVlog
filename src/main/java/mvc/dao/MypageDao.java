package mvc.dao;

import java.util.ArrayList;
import java.util.List;

import mvc.dto.Board;
import mvc.dto.Files;
import mvc.dto.Member;
import mvc.dto.Profile;

public interface MypageDao {
	
	// 해당 계정정보 불러오기
	
	public Member selectMember(String memnick);
	
    // 해당 계정 작성글 리스트 불러오기
	
	public List selectPage(String memnick);
	
	// 해당 계정 작성글 사진 불러오기
	
	public List selectPic(String memnick);
	
    // 해당 계정 상세 작성글 내용 불러오기
	
	public Board selectContent(int bodno);
	
	// 해당 계정 상세 사진 불러오기
	
	public List selectContentPic(int bodno);

public ArrayList<Profile> getProfile(String memid); // 프로필 보기
		
	
	public void insertimg(Profile pf); // 프로필 삽입 
	
	public void updatepf(Profile pf); // 프로필수정
	
	
	// 팔로우
//	public void dofollow(String memid);
	
	// 내 팔로잉 수
	public int selectflwing(String memid);
	
	// 내 팔로워 수
	public int selectflwer(String memid);
	
	// 내 게시글 수
	public int selectmybod(String memid);
	
	
	// 보관한 글만 가져오기
//	public List selectPinnedpic(String memnick);
}
