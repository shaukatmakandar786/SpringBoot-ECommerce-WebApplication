package com.shopme.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserService {

	@Autowired
	private UserRepository repository;
	
	final private RoleRepository roleRepository;
	
	final private PasswordEncoder passwordEncoder;
	
	public List<User> listAll(){
		
		 Iterable<User> findAll = repository.findAll();
		 
		 return (List<User>) findAll;
	}
	
	public List<Role> listRoles()
	{
		  Iterable<Role> findAll = roleRepository.findAll();
		  
		  return (List<Role>) findAll;
	}

	public void save(User user) {
		encodePassword(user);
		User save = repository.save(user);
		
	}
	
	private void encodePassword(User user)
	{
		String encode = passwordEncoder.encode(user.getPassword());
		user.setPassword(encode);
	}
	
}
