package com.bitacademy.guestbook.vo;

public class GuestbookVo {

	private Long no;
	private String name;
	private String password;
	private String message;
	private String datetime;
	
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "GuestBookDao [no=" + no + ", name=" + name + ", password=" + password + ", message=" + message
				+ ", datetime=" + datetime + "]";
	} 
	
	
	
}
