package mvc.controller.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc.service.adminService.PdfService;

@Controller
public class PdfController {

	@Autowired PdfService pdfService;
	
	// 신고 페이지 pdf 출력
	@RequestMapping("/Manage_Page/claimPdfList.do")
	public ModelAndView claimPdfList() throws Exception {

		String result = pdfService.createClaimListPdf();
		
		return new ModelAndView("Manage_Page/pdfresult", "message", result);
	}
	
}
