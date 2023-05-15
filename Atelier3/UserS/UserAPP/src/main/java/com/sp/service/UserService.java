package com.sp.service;

import java.util.Optional;

import com.sp.model.User;
import com.sp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository uRepository;
	
	public void addUser(User u) {
		uRepository.save(u);
	}
	
	public User updateUser(User u) {
		return uRepository.save(u);
	}
	
	public User getUser(String surname) {
		Optional<User> uOpt = uRepository.findBySurname(surname);
        return uOpt.orElseThrow(() -> new IllegalArgumentException("User with surname " + surname + " not found"));

	}
	
	public User getUser(int id) {
        Optional<User> uOpt = uRepository.findById(id);
        return uOpt.orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found"));
	}
}
