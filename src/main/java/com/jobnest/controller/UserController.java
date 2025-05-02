package com.jobnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobnest.dvo.User;
import com.jobnest.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public User register(@RequestBody User u) {
		return userService.register(u);
	}

	@PostMapping("/login")
	public User login(@RequestBody User u) {
		return userService.login(u.getEmail(), u.getPassword());
	}

	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestBody User u) {
		userService.forgotPassword(u.getEmail(), u.getPassword());
		return "Password updated successfully.";
	}

	@GetMapping
	public List<User> getAll() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@GetMapping("/email/{email}")
	public User getByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}
}
