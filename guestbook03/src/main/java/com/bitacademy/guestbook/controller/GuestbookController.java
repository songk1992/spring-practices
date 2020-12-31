package com.bitacademy.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.guestbook.repository.GuestbookRepository;
import com.bitacademy.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		System.out.println("GET");
		return "redirect:/";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(GuestbookVo vo) {
		System.out.println("POST");
		guestbookRepository.insert(vo);
		return "redirect:/";
	}


	@RequestMapping(value="/deleteform", method=RequestMethod.POST)
	public String deleteform() {
		return "deleteform";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(GuestbookVo vo) {
		guestbookRepository.delete(vo);
		return "redirect:/";
	}
	
}