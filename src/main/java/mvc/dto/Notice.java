package mvc.dto;

import java.util.Date;

public class Notice {
	
	private int notno;	// 공지사항 번호
	private String nottitle;	// 공지사항 제목
	private String notname;		// 공지사항 작성자
	private String notcontent;	// 공지사항 내용
	private Date notdate;	// 공지사항 작성일시
	
	
	public int getNotno() {
		return notno;
	}

	public void setNotno(int notno) {
		this.notno = notno;
	}

	public String getNottitle() {
		return nottitle;
	}

	public void setNottitle(String nottitle) {
		this.nottitle = nottitle;
	}

	public String getNotname() {
		return notname;
	}

	public void setNotname(String notname) {
		this.notname = notname;
	}


	public String getNotcontent() {
		return notcontent;
	}

	public void setNotcontent(String notcontent) {
		this.notcontent = notcontent;
	}

	public Date getNotdate() {
		return notdate;
	}

	public void setNotdate(Date notdate) {
		this.notdate = notdate;
	}

	@Override
	public String toString() {
		return "Notice [notno="+notno
				+", nottitle="+nottitle
				+", notname="+notname
				+", notcontent="+notcontent
				+", notdate="+notdate
				+"]";
	}
	
}
