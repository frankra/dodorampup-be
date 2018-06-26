package com.sap.csc.dodorampup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sap.csc.dodorampup.model.User;
import com.sap.csc.dodorampup.repository.UserRepository;

@Component
public class UserController extends AbstractModelOperator<Long, User, UserRepository> {


	@Autowired
	public UserController(UserRepository repository) {
		super(repository);
	}

	@Override
	protected User updateFields(User existingInstance, User updatedInstance) {
		return updatedInstance;
	}

}
