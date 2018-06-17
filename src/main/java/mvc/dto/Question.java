package mvc.dto;

import java.util.Date;

public class Question {

	private int qusno;	// 문의사항 번호
	private String memid;	// 문의사항 작성자
	private String qustitle;	// 문의사항 제목
	private String qusname;		// 작성자 닉네임?
	private String quscontent;	// 문의 내용
	private Date qusdate;	// 작성일시
	
	private int answered;
	
	
	public int getQusno() {
		return qusno;
	}
	public void setQusno(int qusno) {
		this.qusno = qusno;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getQustitle() {
		return qustitle;
	}
	public void setQustitle(String qustitle) {
		this.qustitle = qustitle;
	}
	public String getQusname() {
		return qusname;
	}
	public void setQusname(String qusname) {
		this.qusname = qusname;
	}
	public String getQuscontent() {
		return quscontent;
	}
	public void setQuscontent(String quscontent) {
		this.quscontent = quscontent;
	}
	public Date getQusdate() {
		return qusdate;
	}
	public void setQusdate(Date qusdate) {
		this.qusdate = qusdate;
	}
	
	public int getAnswered() {
		return answered;
	}
	public void setAnswered(int answered) {
		this.answered = answered;
	}

	
	@Override
	public String toString() {

		return "Question [qusno="+qusno
				+", memid="+memid
				+", qustitle="+qustitle
				+", qusname="+qusname
				+", quscontent="+quscontent
				+", qusdate="+qusdate
				+"]";
	}
	
}
