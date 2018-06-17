package mvc.dto;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	private int bodno;
	private String bodtitle;
	private String bodcontent;
	private String bodhashtag;
	private Date boddate;
	private int bodrecommend;
	private String bodname;
	
	//여행 시작일, 마지막일 추가
	private Date startdate;
	private Date enddate;

	//추천인 추가
	private String memnick;
	private int recommendCnt;

	private int isExistsLikeData;
	
	//보관 추가
	private int pinCnt;
	private int isExistsPinData;
	
	public int getRecommendCnt() {
		return recommendCnt;
	}

	public void setRecommendCnt(int recommendCnt) {
		this.recommendCnt = recommendCnt;
	}
	
	//무한 스크롤을 위한 number 추가
	private int rnum;
	
	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	//file을 여러개 받기 위해 추가함.
	private List<MultipartFile> upload;
	
	// (관리자)게시물별로 신고당한 수 확인용
	private int claimed;

	public int getBodno() {
		return bodno;
	}

	public void setBodno(int bodno) {
		this.bodno = bodno;
	}

	public String getBodtitle() {
		return bodtitle;
	}

	public void setBodtitle(String bodtitle) {
		this.bodtitle = bodtitle;
	}

	public String getBodcontent() {
		return bodcontent;
	}

	public void setBodcontent(String bodcontent) {
		this.bodcontent = bodcontent;
	}

	public String getBodhashtag() {
		return bodhashtag;
	}

	public void setBodhashtag(String bodhashtag) {
		this.bodhashtag = bodhashtag;
	}

	public Date getBoddate() {
		return boddate;
	}

	public void setBoddate(Date boddate) {
		this.boddate = boddate;
	}

	public int getBodrecommend() {
		return bodrecommend;
	}

	public void setBodrecommend(int bodrecommend) {
		this.bodrecommend = bodrecommend;
	}

	public String getBodname() {
		return bodname;
	}

	public void setBodname(String bodname) {
		this.bodname = bodname;
	}
	

	public String getMemnick() {
		return memnick;
	}

	public void setMemnick(String memnick) {
		this.memnick = memnick;
	}

	public int getIsExistsLikeData() {
		return isExistsLikeData;
	}

	public void setIsExistsLikeData(int isExistsLikeData) {
		this.isExistsLikeData = isExistsLikeData;
	}

	public int getPinCnt() {
		return pinCnt;
	}

	public void setPinCnt(int pinCnt) {
		this.pinCnt = pinCnt;
	}

	public int getIsExistsPinData() {
		return isExistsPinData;
	}

	public void setIsExistsPinData(int isExistsPinData) {
		this.isExistsPinData = isExistsPinData;
	}

	@Override
	public String toString() {
		return "BOARD =[ "
				+"BODNO : "+bodno
				+", BODTITLE : "+bodtitle
				+", BODCONTENT : "+bodcontent
				+", BODHASHTAG : "+bodhashtag
				+", BODDATE : "+boddate
				+", BODRECOMMEND : "+bodrecommend
				+", start,end date : "+startdate+","+enddate
				+", BODNAME : "+bodname
				+", ISEXISTSLIKEDATE :"+isExistsLikeData+"]";
	}

	public List<MultipartFile> getUpload() {
		return upload;
	}

	public void setUpload(List<MultipartFile> upload) {
		this.upload = upload;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	public int getClaimed() {
		return claimed;
	}

	public void setClaimed(int claimed) {
		this.claimed = claimed;
	}

}
