package com.sap.csc.dodorampup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sap.csc.dodorampup.model.User;
import com.sap.csc.dodorampup.repository.UserRepository;

@Controller
public class UserQuery extends AbstractModelQuery<Long, User, UserRepository> {
	
	@Autowired
	public UserQuery(UserRepository repository) {
		super(repository);
	}

}