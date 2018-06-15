package mvc.dto;

import java.util.Date;

public class NoticeFile {

	private int notno;	// 공지사항 번호
	private String nforiginfile;	// 원본 파일
	private String nfsavefile;	// 저장될 파일
	private long nffilesize;	// 파일크기
	private Date nfdate;	// 저장일시
	
	public int getNotno() {
		return notno;
	}
	
	public void setNotno(int notno) {
		this.notno = notno;
	}
	
	public String getNforiginfile() {
		return nforiginfile;
	}
	
	public void setNforiginfile(String nforiginfile) {
		this.nforiginfile = nforiginfile;
	}
	
	public String getNfsavefile() {
		return nfsavefile;
	}
	
	public void setNfsavefile(String nfsavefile) {
		this.nfsavefile = nfsavefile;
	}
	
	public long getNffilesize() {
		return nffilesize;
	}
	
	public void setNffilesize(long nffilesize) {
		this.nffilesize = nffilesize;
	}
	
	public Date getNfdate() {
		return nfdate;
	}
	
	public void setNfdate(Date nfdate) {
		this.nfdate = nfdate;
	}
	
	@Override
	public String toString() {
		
		return "NoticeFile [notno="+notno
				+", nforiginfile="+nforiginfile
				+", nfsavefile="+nfsavefile
				+", nffilesize="+nffilesize
				+", nfdate="+nfdate
				+"]";
	}
}
