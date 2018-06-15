package mvc.dto;

import java.util.Date;

public class Payment {

	private int payno;	// 결제번호
	private int advno;	// 광고번호
	private String payid;	// 아이디
	private Date paystart;	// 신청일
	private Date payend;	// 완료일
	private String paytitle;	// 결제이름
	private int payprice;	// 결제금액
	private String payway;	// 결제수단
	private int paycondition;	// 결제상태
	
	public int getPayno() {
		return payno;
	}

	public void setPayno(int payno) {
		this.payno = payno;
	}

	public int getAdvno() {
		return advno;
	}

	public void setAdvno(int advno) {
		this.advno = advno;
	}

	public String getPayid() {
		return payid;
	}

	public void setPayid(String payid) {
		this.payid = payid;
	}

	public Date getPaystart() {
		return paystart;
	}

	public void setPaystart(Date paystart) {
		this.paystart = paystart;
	}

	public Date getPayend() {
		return payend;
	}

	public void setPayend(Date payend) {
		this.payend = payend;
	}

	public String getPaytitle() {
		return paytitle;
	}

	public void setPaytitle(String paytitle) {
		this.paytitle = paytitle;
	}

	public int getPayprice() {
		return payprice;
	}

	public void setPayprice(int payprice) {
		this.payprice = payprice;
	}

	public String getPayway() {
		return payway;
	}

	public void setPayway(String payway) {
		this.payway = payway;
	}

	public int getPaycondition() {
		return paycondition;
	}

	public void setPaycondition(int paycondition) {
		this.paycondition = paycondition;
	}

	@Override
	public String toString() {
		
		return "Payment [payno="+payno
				+", advno="+advno
				+", payid="+payid
				+", paystart="+paystart
				+", payend="+payend
				+", paytitle="+paytitle
				+", payprice="+payprice
				+", payway="+payway
				+", paycondition="+paycondition
				+"]";
	}
}
