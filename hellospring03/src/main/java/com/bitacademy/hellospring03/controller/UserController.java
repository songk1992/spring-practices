package com.bitacademy.hellospring03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.hellospring03.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
//	public String join(String name, String email, String password) {
	public String join(UserVo vo) {
		// 폼이름과 객체 이름이 일치해야 받을수 있음
		System.out.println("UserController:join2" + vo);
		return "redirect:/";
	}
	
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam(value="n") String name ){
			
			/*
			 *  만일 n 이라는 parameter가 전달되지 않으면 400 BAD REQUEST 오류 발생
			 * 
			 */
			
			
		System.out.println("---" + name + "---");
		return "UserController:update";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(
			@RequestParam(value="n",required=true, defaultValue="3") String name,
			@RequestParam(value="a",required=true, defaultValue="0") int age) {
		System.out.println("---" + name + "---");
		return "UserController:update";
	}
}
