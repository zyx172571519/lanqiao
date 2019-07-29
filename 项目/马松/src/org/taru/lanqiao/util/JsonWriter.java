package org.taru.lanqiao.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.vo.JsonResult;

import com.google.gson.Gson;

/**
 * JsonWriter工具类
 * 专门把对象转换成Json，且写入到客户端
 * @author Administrator
 *
 */
public class JsonWriter {

	/**
	 * 专门把结果写入到客户端，以Json的形式
	 * @param response
	 * @param result
	 * @throws IOException
	 */
	public static  void  writer(HttpServletResponse  response,JsonResult  result) throws IOException{
		response.setContentType("application/json");
		PrintWriter  pw =response.getWriter();
		Gson  gson =new Gson();  
		String json =gson.toJson(result);
		pw.write(json);  
		pw.flush();
		pw.close();
	}
}
