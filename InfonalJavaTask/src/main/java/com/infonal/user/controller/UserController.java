package com.infonal.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infonal.user.dtl.UserList;
import com.infonal.user.model.User;
import com.infonal.user.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;


	@RequestMapping
	public String getUsersPage() {
		return "users";
	}
	@RequestMapping(value = "/getAllUser")
	public @ResponseBody UserList getUsers() {

		UserList userList = new UserList();
		userList.setUsers(userService.getAllUser());
		return userList;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody User create(@RequestParam String name,
			@RequestParam String surname, @RequestParam Integer phoneNumber) {

		User newUser = new User();
		newUser.setName(name);
		newUser.setSurName(surname);
		newUser.setPhoneNumber(phoneNumber);

		return userService.add(newUser);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody User update(@RequestParam String name,
			@RequestParam String surName, @RequestParam Integer phoneNumber) {

		User user = new User();
		user.setName(name);
		user.setSurName(surName);
		user.setPhoneNumber(phoneNumber);

		return userService.edit(user);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Boolean delete(@RequestParam String name) {

		User user = new User();
		user.setName(name);

		return userService.delete(user);
	}
}
