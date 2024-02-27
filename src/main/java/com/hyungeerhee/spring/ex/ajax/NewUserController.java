package com.hyungeerhee.spring.ex.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyungeerhee.spring.ex.jsp.domain.User;
import com.hyungeerhee.spring.ex.jsp.service.UserService;

@Controller
@RequestMapping("/ajax/user")
public class NewUserController {
	
	@Autowired
	private UserService userService;
	
	// response가 html로 화면 구성을 위한 페이지
	// VIEW
	@GetMapping("/list")
	public String userList(Model model) {
		
		List<User> userList = userService.getUserList();
		
		model.addAttribute("userList", userList);
		
		return "/ajax/user/list";
	}
	
	// response 가 json 데이터 형태인 페이지
	// API 
	@GetMapping("/create")
	@ResponseBody
	public Map<String, String> createUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email) {
		int count = userService.addUser(name,  birthday,  email);
		
		// 성공실패 여부
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) { // 성공
			resultMap.put("result",  "success");
		} else { // 실패
			resultMap.put("result", "success");
		}
		
		return resultMap;
		
	}
	
	@GetMapping("/input")
	public String inputUser() {
		return "ajax/user/input";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
