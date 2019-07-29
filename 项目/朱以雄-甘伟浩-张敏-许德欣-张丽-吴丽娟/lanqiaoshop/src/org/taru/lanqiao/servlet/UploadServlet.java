package org.taru.lanqiao.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.util.Constants;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JsonResult jr;
		File path = new File("E:\\lanqiaoshop-image");
		if (!path.exists()) {
			path.mkdir();
		}
		Collection<Part> parts = request.getParts();
		if (parts.size() == 1) {
			Part img = request.getPart("file");
			String filename = img.getSubmittedFileName().substring(img.getSubmittedFileName().lastIndexOf(".")+1);
			System.out.println(filename);
			Date date = new Date(); 
			if(filename.equals("jpg") || filename.equals("png") || filename.equals("jpeg") || filename.equals("gif")) {
				String filePath = path.getPath() + File.separator + date.getTime() + "." + filename;
				img.write(filePath);
				System.out.println("File Upload : " + filePath);
				jr = new JsonResult(Constants.STATUS_SUCCESS, "涓婁紶鎴愬姛", filePath);
			}else if(filename.equals("JPG") || filename.equals("PNG") || filename.equals("JPEG") || filename.equals("GIF")) {
				String newFilename = date.getTime() + "." + filename;
				String filePath = path.getPath() + File.separator + newFilename;
				img.write(filePath);
				System.out.println("File Upload : " + filePath);
				jr = new JsonResult(Constants.STATUS_SUCCESS, "涓婁紶鎴愬姛", newFilename);
			}
			else {
				jr = new JsonResult(Constants.STATUS_FAIL, "涓婁紶澶辫触锛岃閫夋嫨鍥剧墖");
			}
			JsonWriter.writer(response, jr);
		} else {
			List li = new ArrayList();
			for (Part part : parts) {
				String filename = part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf(".")+1);
				if(filename.equals("jpg") || filename.equals("png") || filename.equals("jpeg") || filename.equals("gif")) {
					// 鏂囦欢鍏ㄨ矾寰�
					String filePath = path.getPath() + File.separator + part.getSubmittedFileName();
					String header = part.getHeader("content-disposition");
					String fileName = getFileName(header);
					part.write(filePath);
					li.add(part.getSubmittedFileName());
				}else if(filename.equals("JPG") || filename.equals("PNG") || filename.equals("JPEG") || filename.equals("GIF")) {
					// 鏂囦欢鍏ㄨ矾寰�
					String filePath = path.getPath() + File.separator + part.getSubmittedFileName();
					String header = part.getHeader("content-disposition");
					String fileName = getFileName(header);
					part.write(filePath);
					li.add(part.getSubmittedFileName());
				}
			}
			if(li.size()>0) {
				jr = new JsonResult(Constants.STATUS_SUCCESS, "涓婁紶鎴愬姛", li);
			}else{
				jr = new JsonResult(Constants.STATUS_FAIL, "涓婁紶澶辫触");
			}
			JsonWriter.writer(response, jr);
		}

	}
	
	public String getFileName(String header) {
		
		String[] tempArr1 = header.split(";");
		
		String[] tempArr2 = tempArr1[2].split("=");
		// 鑾峰彇鏂囦欢鍚嶏紝鍏煎鍚勭娴忚鍣ㄧ殑鍐欐硶
		String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return fileName;
	}
}