package org.taru.lanqiao.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.vo.JsonResult;

import com.google.gson.Gson;
@WebServlet("/zm/aaa")
public class JsonWriter{
	public static void writer(HttpServletResponse response,JsonResult result) throws IOException{
		response.setContentType("application/json");
		PrintWriter pw=response.getWriter();
		Gson gson=new Gson();
		String json=gson.toJson(result);
		pw.write(json);
		pw.flush();
		pw.close();
	}	
}
