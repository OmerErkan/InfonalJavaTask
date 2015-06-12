package com.infonal.user.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infonal.user.model.User;
import com.infonal.user.repository.UserRepository;
import com.infonal.user.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User add(User user) {
		user.setUserId(UUID.randomUUID().toString());
		return userRepository.save(user);
	}

	public User edit(User user) {
		User editUser = userRepository.findByName(user.getName());

		if (editUser == null) {
			return null;
		}

		editUser.setName(user.getName());
		editUser.setSurName(user.getSurName());
		editUser.setPhoneNumber(user.getPhoneNumber());
		return userRepository.save(editUser);

	}

	public boolean delete(User user) {
		User deleteUser = userRepository.findByName(user.getName());

		if (deleteUser == null) {
			return false;
		}
		userRepository.delete(deleteUser);
		return true;
	}

	public User getUser(User user) {
		return user;
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

}
