package org.taru.lanqiao.vo;

/**
 * /**
 * 
 * @author Administrator
 *		返回JSON数据类型
 */

public class JsonResult {
	private String status;
	private String message;
	private Object data;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public JsonResult(String status, String message) {
		this.status = status;
		this.message = message;
	}
	public JsonResult(String status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

}
