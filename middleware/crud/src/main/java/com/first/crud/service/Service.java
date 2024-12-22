	package com.first.crud.service;
	
	
	import org.springframework.beans.factory.annotation.Autowired;

import com.first.crud.DTO.SaveDTO;
import com.first.crud.repo.Repo;
import com.first.crud.entity.User;
	

	@org.springframework.stereotype.Service
	public class Service implements ServiceImp{
	
		
	@Autowired
	private Repo repo;
	
	
	@Override
	public String addUser(SaveDTO saveDTO) {
	    User user = new User(saveDTO.getName(), saveDTO.getMobile(), saveDTO.getEmail());
	    repo.save(user); // Save the user with auto-generated id
	    return String.valueOf(user.getId()); // Return the ID of the saved user
	}
	
	}
