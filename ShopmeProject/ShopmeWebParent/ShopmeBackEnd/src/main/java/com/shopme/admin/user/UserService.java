package com.shopme.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.User;


@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> listAll(){
		
		 Iterable<User> findAll = repository.findAll();
		 
		 return (List<User>) findAll;
	}
}
