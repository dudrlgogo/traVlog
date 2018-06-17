package mvc.dto;

import java.util.Date;

public class Advertising {

	private int advno;	// 광고 번호
	private String advid;	// 아이디
	private Date advdate;	// 신청일
	private int advapprove;	// 승인여부
	private String advtitle;	// 광고 제목
	private int advprice;	// 광고 금액
	private Date advstart;	// 광고 시작일
	private Date advend;	// 광고 종료일
	private String advcontent;	// 광고 내용
	private String advfile;	// 파일

	
	public int getAdvno() {
		return advno;
	}

	public void setAdvno(int advno) {
		this.advno = advno;
	}

	public String getAdvid() {
		return advid;
	}

	public void setAdvid(String advid) {
		this.advid = advid;
	}

	public Date getAdvdate() {
		return advdate;
	}

	public void setAdvdate(Date advdate) {
		this.advdate = advdate;
	}

	public int getAdvapprove() {
		return advapprove;
	}

	public void setAdvapprove(int advapprove) {
		this.advapprove = advapprove;
	}

	public String getAdvtitle() {
		return advtitle;
	}

	public void setAdvtitle(String advtitle) {
		this.advtitle = advtitle;
	}

	public int getAdvprice() {
		return advprice;
	}

	public void setAdvprice(int advprice) {
		this.advprice = advprice;
	}

	public Date getAdvstart() {
		return advstart;
	}

	public void setAdvstart(Date advstart) {
		this.advstart = advstart;
	}

	public Date getAdvend() {
		return advend;
	}

	public void setAdvend(Date advend) {
		this.advend = advend;
	}

	public String getAdvcontent() {
		return advcontent;
	}

	public void setAdvcontent(String advcontent) {
		this.advcontent = advcontent;
	}

	public String getAdvfile() {
		return advfile;
	}

	public void setAdvfile(String advfile) {
		this.advfile = advfile;
	}


	@Override
	public String toString() {

		return "Advertising [advno="+advno
				+", advid="+advid
				+", advdate="+advdate
				+", advapprove="+advapprove
				+", advtitle="+advtitle
				+", advprice="+advprice
				+", advstart="+advstart
				+", advend="+advend
				+", advcontent="+advcontent
				+", advfile="+advfile
				+"]";
	}

}
