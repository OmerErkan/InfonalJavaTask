package com.infonal.user.daos;

import java.util.List;

import com.infonal.user.model.User;

public interface UserDao { // An interface for database 
	public void add(User user);
	public void edit(User user);
	public void delete(int userId);
	public User getUser(int userId);
	public List getAllUsert();

}
