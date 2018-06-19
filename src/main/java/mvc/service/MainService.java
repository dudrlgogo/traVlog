package mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dto.Member;
import mvc.dto.FollowingRec;
import mvc.dto.HashTag;
import mvc.dto.LatLng;
import mvc.dao.MainDao;

@Service
public class MainService {
	@Autowired MainDao mainDao;
	

	public ArrayList<HashTag> topHash() {
		return mainDao.topHash();
	}


	public ArrayList<Member> topMember() {
		return mainDao.topMember(); 
	}


	public ArrayList<FollowingRec> recommend(Member member) {
		return mainDao.recMember(member); 
	}
	
	public int countRecMember(Member member) {
		return mainDao.countRecMember(member);
	}

	public ArrayList<FollowingRec> follower(Member member) {
		return mainDao.follower(member);
	}
	
	public int countFolMember(String memid) {
		return mainDao.countFolMember(memid);
	}

	public ArrayList<FollowingRec> admin() {
		return mainDao.admin();
	}


	public List<Member> getMemberListBySearch(Member member) {
		return mainDao.getMemberListBySearch(member);
	}
}
