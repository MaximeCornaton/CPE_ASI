package com.sp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.sp.model.User;

@Service
public class UserDao {
	
	private List<User> myUserList;
	
	public UserDao() {
		myUserList = new ArrayList<>();
		createUserList();
	}
	
	private void createUserList() {
		User user1 = new User("Paul", "Paulo","caca");
		User user2 = new User("Maxime", "Flutter","caca");
		User user3 = new User("Valentin", "Chien","caca");
			
		myUserList.add(user1);
		myUserList.add(user2);
		myUserList.add(user3);
	}
	
	public List<User> getUserList(){
		return new ArrayList<>(this.myUserList);
	}
	
	public User getUserByName(String name) {
		for(User userBean : myUserList) {
			if(userBean.getName().equals(name)) {
				return userBean;
			}
		}
		return null;
	}
	
	public User addUser(String name, String surname, String password) {
		User u = new User(name,surname,password);
		this.myUserList.add(u);
		return u;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(User userBean : myUserList) {
			str = str + userBean + "\n";
		}
		return str;
	}

}
