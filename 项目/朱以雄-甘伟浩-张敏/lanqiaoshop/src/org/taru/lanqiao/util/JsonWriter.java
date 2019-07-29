package org.taru.lanqiao.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import org.taru.lanqiao.vo.JsonResult;;

/**
 * 
 * @author Administrator
 *		json¸ñÊ½×ª»»
 */
public class JsonWriter {
	
	public static void writer(HttpServletResponse res,JsonResult result) throws IOException {
		//PrintWriter out=res.getWriter();
		res.setContentType("application/json");
		Gson gson =new Gson();
		String json =gson.toJson(result);
		res.getWriter().write(json);
		res.getWriter().close();
	}

}
