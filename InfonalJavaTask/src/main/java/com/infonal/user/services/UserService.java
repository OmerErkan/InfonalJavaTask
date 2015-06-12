package com.infonal.user.services;

import java.util.List;

import com.infonal.user.model.User;

public interface UserService {
	public User add(User user);
	public User edit(User user);
	public boolean delete(User user);
	public User getUser(User user);
	public List<User> getAllUser();

}
