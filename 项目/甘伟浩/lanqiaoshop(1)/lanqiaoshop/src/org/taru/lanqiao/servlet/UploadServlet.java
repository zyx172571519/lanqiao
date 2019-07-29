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
import org.taru.lanqiao.vo.Constants;
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
				jr = new JsonResult(Constants.STATUS_SUCCESS, "上传成功", filePath);
			}else if(filename.equals("JPG") || filename.equals("PNG") || filename.equals("JPEG") || filename.equals("GIF")) {
				String newFilename = date.getTime() + "." + filename;
				String filePath = path.getPath() + File.separator + newFilename;
				img.write(filePath);
				System.out.println("File Upload : " + filePath);
				jr = new JsonResult(Constants.STATUS_SUCCESS, "上传成功", newFilename);
			}
			else {
				jr = new JsonResult(Constants.STATUS_FAIL, "上传失败，请选择图片");
			}
			JsonWriter.writer(response, jr);
		} else {
			List li = new ArrayList();
			for (Part part : parts) {
				String filename = part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf(".")+1);
				if(filename.equals("jpg") || filename.equals("png") || filename.equals("jpeg") || filename.equals("gif")) {
					// 文件全路径
					String filePath = path.getPath() + File.separator + part.getSubmittedFileName();
					String header = part.getHeader("content-disposition");
					String fileName = getFileName(header);
					part.write(filePath);
					li.add(part.getSubmittedFileName());
				}else if(filename.equals("JPG") || filename.equals("PNG") || filename.equals("JPEG") || filename.equals("GIF")) {
					// 文件全路径
					String filePath = path.getPath() + File.separator + part.getSubmittedFileName();
					String header = part.getHeader("content-disposition");
					String fileName = getFileName(header);
					part.write(filePath);
					li.add(part.getSubmittedFileName());
				}
			}
			if(li.size()>0) {
				jr = new JsonResult(Constants.STATUS_SUCCESS, "上传成功", li);
			}else{
				jr = new JsonResult(Constants.STATUS_FAIL, "上传失败");
			}
			JsonWriter.writer(response, jr);
		}

	}
	
	public String getFileName(String header) {
		
		String[] tempArr1 = header.split(";");
		
		String[] tempArr2 = tempArr1[2].split("=");
		// 获取文件名，兼容各种浏览器的写法
		String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return fileName;
	}
}