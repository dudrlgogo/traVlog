package mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.MypageDao;
import mvc.dto.Board;
import mvc.dto.Files;
import mvc.dto.Member;
import mvc.dto.Profile;

@Service
public class MypageService {

	@Autowired MypageDao mypageDao;
	
	// 해당 계정 정보 불러오기
	
	public Member selectMember(String memnick) {
		
		return mypageDao.selectMember(memnick);
	}
	
	// 해당 계정 작성글 리스트 불러오기
	
	public List selectPage(String memnick) {
		
		return mypageDao.selectPage(memnick);
	}
		
	// 해당 계정 작성글 사진 불러오기
		
	public List selectPic(String memnick) {
		
		return mypageDao.selectPic(memnick);
	}
	
	// 해당 계정 상세 작성글 내용 불러오기
	
	public Board selectContent(int bodno) {
		
		return mypageDao.selectContent(bodno);
	}
		
	// 해당 계정 상세 사진 불러오기
		
	public List selectContentPic(int bodno) {
		
		return mypageDao.selectContentPic(bodno);
	}

	// 프로필 보기
		public ArrayList<Profile> getProfile(String memnick) {
			return mypageDao.getProfile(memnick);
		}
		
		// 프로필 등록
		public void insertimg(Profile profile) {
			mypageDao.insertimg(profile);
		}

		// 프로필수정
		public void updatepf(Profile profile) {
			mypageDao.updatepf(profile);
		}
		
		// 팔로우하기
//		public void dofollow(String memid) {
//			mypageDao.dofollow(memid);
//		}
		
		// 내 팔로잉 수 불러오기
		public int selectflwing(String memid) {
			return mypageDao.selectflwing(memid);
		}
		
		// 내 팔로워 수 불러오기
		public int selectflwer(String memid) {
			return mypageDao.selectflwer(memid);
		}
		
		// 내 보관글 수 불러오기
		public int selectmybod(String memid) {
			return mypageDao.selectmybod(memid);
		}
		
		// 내가 보관한 글 목록
//		public List selectPinnedpic(String memnick) {
//			return mypageDao.selectPinnedpic(memnick);
//		}
	
}
