package com.Autonation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Autonation.Binding.User;
import com.Autonation.Service.UserService;

@RestController

@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/home")
	public String getHome() {
		String str = "Autonation Usa";
		return str;
	}
	
	
	
	@PostMapping(value = "/register", consumes = { "application/json" })
	public ResponseEntity<String> register(@RequestBody User user) {
		System.err.println("register");//
		User newUser = userService.userRegister(user);// If the user already exists, it returns null.
		if (newUser == null)
			return new ResponseEntity<>("User Already Exits", HttpStatus.OK);

		return new ResponseEntity<String>("User Created", HttpStatus.CREATED);

	}

	@PostMapping(value = "/login", consumes = { "application/json" })
	public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {

		String payload = userService.login(email, password);
		return new ResponseEntity<String>(payload, HttpStatus.OK);
	}
	
	

}
