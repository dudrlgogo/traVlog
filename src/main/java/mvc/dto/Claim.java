package mvc.dto;

public class Claim {

	private int clmno; /* 신고글번호 */
	private int bodno; /* 게시글번호 */
	private String clmfromid;	// (신고자)닉네임
	private String clmtoid;	// 피신고자 닉네임
	private String clmdate; /* 신고일 */
	private int clmreason; /* 신고사유 */
	private int clmcondition; /* 신고상태 */
	
	private String bodtitle;	// 신고당한 게시글 제목
	
	public int getClmno() {
		return clmno;
	}

	public void setClmno(int clmno) {
		this.clmno = clmno;
	}

	public int getBodno() {
		return bodno;
	}

	public void setBodno(int bodno) {
		this.bodno = bodno;
	}

	public String getClmfromid() {
		return clmfromid;
	}

	public void setClmfromid(String clmfromid) {
		this.clmfromid = clmfromid;
	}

	public String getClmtoid() {
		return clmtoid;
	}

	public void setClmtoid(String clmtoid) {
		this.clmtoid = clmtoid;
	}

	public String getClmdate() {
		return clmdate;
	}

	public void setClmdate(String clmdate) {
		this.clmdate = clmdate;
	}

	public int getClmreason() {
		return clmreason;
	}

	public void setClmreason(int clmreason) {
		this.clmreason = clmreason;
	}

	public int getClmcondition() {
		return clmcondition;
	}

	public void setClmcondition(int clmcondition) {
		this.clmcondition = clmcondition;
	}

	public String getBodtitle() {
		return bodtitle;
	}

	public void setBodtitle(String bodtitle) {
		this.bodtitle = bodtitle;
	}


	@Override
	public String toString() {
		return "Claim [ clmNo : " + clmno
				+ "bodNo : " + bodno
				+ "clmfromid : " + clmfromid
				+ "clmtoid : " + clmtoid
				+ "clmDate : " + clmdate
				+ "clmReason : " + clmreason
				+ "clmCondition : " + clmcondition 
				+ "bodtitle : " + bodtitle 
				+ "]";
	}
}
