package mvc.dto;

import java.util.Date;

public class Answer {

	private int qusno;	// 문의사항 번호
	private String anstitle;	// 답변 제목
	private String anscontent;	// 답변 내용
	private Date ansdate;	// 답변 일시
	
	public int getQusno() {
		return qusno;
	}
	public void setQusno(int qusno) {
		this.qusno = qusno;
	}
	public String getAnstitle() {
		return anstitle;
	}
	public void setAnstitle(String anstitle) {
		this.anstitle = anstitle;
	}
	public String getAnscontent() {
		return anscontent;
	}
	public void setAnscontent(String anscontent) {
		this.anscontent = anscontent;
	}
	public Date getAnsdate() {
		return ansdate;
	}
	public void setAnsdate(Date ansdate) {
		this.ansdate = ansdate;
	}
	
	@Override
	public String toString() {
		return "Answer [qusno="+qusno
				+", anstitle="+anstitle
				+", anscontent="+anscontent
				+", ansdate="+ansdate
				+"]";
	}
	
}
