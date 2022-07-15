package com.shopme.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopme.common.entity.Role;
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
		List<Role> listRoles = userService.listRoles();
		User user=new User();
		user.setEnabled(true);
		model.addAttribute("user", user);
		model.addAttribute("listRoles",listRoles);
		return "user_form";
	}
	
	@PostMapping("/users/save")
	public String saveUser(User user,RedirectAttributes redirectAttributes) {
		
		userService.save(user);
		System.out.println(user);
		redirectAttributes.addFlashAttribute("message","The user has been saved successfully.");
		return "redirect:/users";
	}
}
