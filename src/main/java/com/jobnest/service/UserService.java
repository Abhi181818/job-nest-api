package com.jobnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobnest.dvo.User;
import com.jobnest.exception.ResourceNotFoundException;
import com.jobnest.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User register(User u) {
		if (userRepository.findByEmail(u.getEmail()).isPresent()) {
			throw new ResourceNotFoundException("Email already registered.");
		}
		return userRepository.save(u);
	}

	public User login(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid credentials"));
	}

	public void forgotPassword(String email, String newPassword) {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
		user.setPassword(newPassword);
		userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(int id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
	}

	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
	}
}
