package mvc.service.adminService;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import mvc.dto.Claim;
import mvc.util.Paging;

@Service
public class PdfServiceImpl implements PdfService {

	@Autowired AdminService adminService;
//	@Autowired Paging paging;
	
	@Override
	public String createClaimListPdf() {
		
		String result = "";
		
		try {
			// pdf 문서 객체
			Document document = new Document(PageSize.A4, 30, 30, 30, 30);
			
			PdfWriter pdfwriter = PdfWriter.getInstance(document, new FileOutputStream("E:/ClaimList.pdf"));
			
			document.open();
			// 폰트 지정(windows/fonts 폴더안에 있는 파일들의 속성에 있는 파일명으로 적는다.)
			BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			
			// 폰트 설정
			Font font = new Font(baseFont, 12);
			
			// 테이블 생성 - ()안은 컬럼 수
			PdfPTable table = new PdfPTable(7);
			
			// 텍스트 - web의 <P>에 해당된다.
			Chunk chunk = new Chunk("신고목록", font);
			
			// 문단
			Paragraph ph = new Paragraph(chunk);
			
			// 가운데 정렬
			ph.setAlignment(Element.ALIGN_CENTER);
			
			document.add(ph);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			
			// 페이지 넘기기
//			document.newPage();

			// 테이블의 각 셀
			PdfPCell cell1 = new PdfPCell(
					new Phrase("신고글 번호", font));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell2 = new PdfPCell(
					new Phrase("게시글 번호", font));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell3 = new PdfPCell(
					new Phrase("신고자", font));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell4 = new PdfPCell(
					new Phrase("피신고자", font));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell5 = new PdfPCell(
					new Phrase("신고 일시", font));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell6 = new PdfPCell(
					new Phrase("신고 사유", font));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell7 = new PdfPCell(
					new Phrase("신고 상태", font));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			// 테이블에 셀 추가 - 여기까지가 기본 틀 작성
			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			table.addCell(cell5);
			table.addCell(cell6);
			table.addCell(cell7);
			
			// for문으로 정보 넣기
			List<Claim> items = adminService.getClaimListForPdf();
			
			for(int i = 0; i < items.size(); i++ ) {
				Claim claim = items.get(i);
				PdfPCell cellClmno = new PdfPCell(new Phrase(""+claim.getClmno(), font));
				table.addCell(cellClmno).setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cellBodno = new PdfPCell(new Phrase(""+claim.getBodno(), font));
				table.addCell(cellBodno).setHorizontalAlignment(Element.ALIGN_CENTER);

				PdfPCell cellClmfromid = new PdfPCell(new Phrase(claim.getClmfromid(), font));
				table.addCell(cellClmfromid).setHorizontalAlignment(Element.ALIGN_CENTER);

				PdfPCell cellClmtoid = new PdfPCell(new Phrase(claim.getClmtoid(), font));
				table.addCell(cellClmtoid).setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cellClmdate = new PdfPCell(new Phrase(""+claim.getClmdate(), font));
				table.addCell(cellClmdate).setHorizontalAlignment(Element.ALIGN_CENTER);
		
				PdfPCell cellClmreason = new PdfPCell(new Phrase(""+claim.getClmreason(), font));
				table.addCell(cellClmreason).setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cellClmcondition = new PdfPCell(new Phrase(""+claim.getClmcondition(), font));
				table.addCell(cellClmcondition).setHorizontalAlignment(Element.ALIGN_CENTER);
			}
			
			// document(pdf)에 테이블 추가
			document.add(table);

			// pdf 파일로 저장!!
			document.close();
			
			result="pdf 파일 생성!!";
			
		} catch (Exception e) {
			e.printStackTrace();
			result="pdf 파일 생성 실패!!!!";

		}
		return result;
	}

}
