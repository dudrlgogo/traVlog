package mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc.dto.Follow;
import mvc.dto.Member;
import mvc.service.MemberService;

@Controller
public class SettingController {
	
	@Autowired MemberService memberservice;

	// 회원정보 보여주기
	@RequestMapping(value="/traVlog/setUserinfo.do", method=RequestMethod.GET)
	public String setUserinfo(Member member, Model model, HttpSession session) {
		member.setMemid((String) session.getAttribute("memid"));
		member = memberservice.getUserinfo(member);
		model.addAttribute("member", member);
		
		return "traVlog/setUserinfo";
	}
	
	@RequestMapping(value="/traVlog/insertprofile.do", method=RequestMethod.GET)
	public String insertprofile(Member member, Model model, HttpSession session) {
		
		member.setMemid((String) session.getAttribute("memid"));
		member = memberservice.getUserinfo(member);
		model.addAttribute("member", member);
		
		return "traVlog/setUserinfo";
	}
	
	
	// 회원정보 변경
	
	@RequestMapping(value="/traVlog/updateUserinfo.do", method=RequestMethod.POST)
	public String updateUserinfo(Member member, HttpSession session) {
		memberservice.updateUserinfo(member);
		return "redirect:/traVlog/setUserinfo.do";	

	}
	
	// 팔로잉, 팔로워 목록 띄우기
	@RequestMapping(value="/traVlog/getflw.do", method=RequestMethod.GET)
	public String getflw(Model model, HttpSession session) {
		String id = (String)session.getAttribute("memid");
		List list = memberservice.getflw(id);
		List list1 = memberservice.getflwing(id);
		
		model.addAttribute("list", list);
		model.addAttribute("list1", list1);
		return "traVlog/getflw";
	}
	
	
}
