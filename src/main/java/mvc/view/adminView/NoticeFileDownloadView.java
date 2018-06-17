package mvc.view.adminView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class NoticeFileDownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		File notfile = (File)model.get("downNoticeFile");

		System.out.println("NoticeFileDownView - path :"+ notfile.getPath());
		System.out.println("NoticeFileDownView - file :"+ notfile.getName());
		System.out.println("NoticeFileDownView - exist :"+ notfile.exists());
		
		resp.setContentType("application/octet-stream");
		resp.setContentLength((int)notfile.length());
		
		String filename = URLEncoder.encode(notfile.getName().substring(0, notfile.getName().lastIndexOf("_")), "utf-8");
		
		filename = filename.replace("+", "%20");
		filename = filename.replace("%5B", "[");
		filename = filename.replace("%5D", "]");
		filename = filename.replace("%21", "!");
		filename = filename.replace("%23", "#");
		filename = filename.replace("%24", "$");
		filename = filename.replace("%25", "%");
		filename = filename.replace("%26", "&");
		filename = filename.replace("%27", "'");
		filename = filename.replace("%28", "(");
		filename = filename.replace("%29", ")");
		filename = filename.replace("%2B", "+");
		filename = filename.replace("%2C", ",");
		filename = filename.replace("%40", "@");
		filename = filename.replace("%5E", "^");
		
		System.out.println(filename);
		
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Content-Disposition", "attachment; filename=\""+ filename +"\";");
		resp.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = resp.getOutputStream();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(notfile);
			FileCopyUtils.copy(fis, out);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null)	fis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		out.flush();
	}

}
