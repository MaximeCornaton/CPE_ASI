package com.sp.service;

import java.util.Optional;
import java.util.Set;

import com.sp.model.User;
import com.sp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository uRepository;
	
	
	public UserService() {
		
	}
	
	public void addUser(User u) {
		User createdUser = uRepository.save(u);
		System.out.println(createdUser);
	}
	
	public User updateUser(User u) {
		User updatedUser = uRepository.save(u);
		return updatedUser;
	}
	
	public User getUser(String surname) {
		Optional<User> uOpt = uRepository.findBySurname(surname);
		if(uOpt.isPresent()) {
			return uOpt.get();
		}
		else {
			return null;
		}
	}
	
	
	public User getUser(int id) {
		Optional<User> uOpt = uRepository.findById(id);
		if(uOpt.isPresent()) {
			return uOpt.get();
		}
		else {
			return null; 
		}
	}
}
