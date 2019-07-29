package org.taru.lanqiao.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.vo.JsonResult;

import com.google.gson.Gson;

/**
 * JsonWriter������
 * ר�ŰѶ���ת����Json����д�뵽�ͻ���
 * @author Administrator
 *
 */
public class JsonWriter {

	/**
	 * ר�Űѽ��д�뵽�ͻ��ˣ���Json����ʽ
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
