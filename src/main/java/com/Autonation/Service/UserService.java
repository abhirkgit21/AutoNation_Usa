package com.Autonation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Autonation.Binding.User;
import com.Autonation.Repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public User userRegister(User user) {// This method ensures that users with the same email
											// cannot be registered multiple times,
											// which is a common requirement in user registration systems.

		User user1 = userRepo.findByEmail(user.getEmail());

		if (user1 != null)
			return null;
		else
			return userRepo.save(user);
	}

	public String login(String email, String Password) {

		User user = userRepo.findByEmailAndPassword(email, Password).orElseThrow(()-> new RuntimeException("Invalid Username and Password....!"));
		
		if(user == null)
			throw new RuntimeException("Invalid");
		
		return "Logged In Successfully....!";

	}
	
}