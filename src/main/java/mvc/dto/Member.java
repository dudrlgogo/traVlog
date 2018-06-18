package mvc.dto;

import java.util.Date;

public class Member {

	private String memid;
	//mempw 를 mempassword로 수정
	private String mempassword;

	private int memage;
	private String memnick;

	private String memsex;
	private String mememail;
	private String memphone;
	
	//포스팅 팔로워 팔로잉 수 추가

	private int memposting;
	private int memfollwing;
	private int memfollower;
	
	//검색용 단어 저장
	private String search;
	
	// 추가된 친구들
	private int memstatus;	// 회원상태
	private int claimed;	// 회원의 게시물이 신고당한 횟수
	private int memclaimed;	// 회원이 신고당한 횟수	
	private Date mempausetime;	// 계정정지  회원의 계정정지 기간
	

	public int getMemposting() {
		return memposting;
	}

	public void setMemposting(int memposting) {
		this.memposting = memposting;
	}

	public int getMemfollower() {
		return memfollower;
	}

	public void setMemfollower(int memfollower) {
		this.memfollower = memfollower;
	}

	public int getMemfollwing() {
		return memfollwing;
	}

	public void setMemfollwing(int memfollwing) {
		this.memfollwing = memfollwing;
	}

	public String getMempassword() {
		return mempassword;
	}

	public void setMempassword(String mempassword) {
		this.mempassword = mempassword;
	}

	public int getMemage() {
		return memage;
	}

	public void setMemage(int memage) {
		this.memage = memage;
	}

	public String getMemnick() {
		return memnick;
	}

	public void setMemnick(String memnick) {
		this.memnick = memnick;
	}

	public String getMemsex() {
		return memsex;
	}

	public void setMemsex(String memsex) {
		this.memsex = memsex;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public String getMememail() {
		return mememail;
	}

	public void setMememail(String mememail) {
		this.mememail = mememail;
	}

	public String getMemphone() {
		return memphone;
	}

	public void setMemphone(String memphone) {
		this.memphone = memphone;
	}

	public String toString() {
		return "member=[ " + "memid: " + memid + ", mempw: " + mempassword + ", memnick: " + memnick + ", memsex: "
				+ memsex + ", memage: " + memage + ", mememail: " + mememail + ", memphone: "
				+ memphone +", search: "+ search + " ]";
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	public int getMemstatus() {
		return memstatus;
	}

	public void setMemstatus(int memstatus) {
		this.memstatus = memstatus;
	}

	public int getClaimed() {
		return claimed;
	}

	public void setClaimed(int claimed) {
		this.claimed = claimed;
	}

	public int getMemclaimed() {
		return memclaimed;
	}

	public void setMemclaimed(int memclaimed) {
		this.memclaimed = memclaimed;
	}

	public Date getMempausetime() {
		return mempausetime;
	}

	public void setMempausetime(Date mempausetime) {
		this.mempausetime = mempausetime;
	}

}
