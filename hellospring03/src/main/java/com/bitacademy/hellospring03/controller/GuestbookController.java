package com.bitacademy.hellospring03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {

	@ResponseBody
	public String list() {
		return "GuestbookController:list";
	}
	
	@ResponseBody
	public String delete() {
		return "GuestbookController:delete";
	}
}
