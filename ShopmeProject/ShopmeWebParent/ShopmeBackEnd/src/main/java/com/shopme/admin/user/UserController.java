package com.shopme.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shopme.common.entity.User;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public String listAll(Model model)
	{
		
		List<User> userList = userService.listAll();
		model.addAttribute("userList",userList);
		
		return "users";
	}
	
	@GetMapping("/users/new")
	public String newUser(Model model) {
		
		User user=new User();
		model.addAttribute("user", user);
		return "user_form";
	}
	
	@GetMapping("/users/save")
	public String saveUser(User user) {
		
		System.out.println(user);
		return "redirect:/users";
	}
}
