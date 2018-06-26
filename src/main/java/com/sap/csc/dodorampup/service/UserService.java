package com.sap.csc.dodorampup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.csc.dodorampup.model.User;
import com.sap.csc.dodorampup.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public User getUserById(Long userId) {
		if (userId != null) {
			return repository.findOne(userId);
		}
		return null;
	}

	public List<User> getUsersByIds(List<Long> userIdList) {
		List<User> userList = new ArrayList<User>();
		if(userIdList != null) {
			for(Long id: userIdList){
				userList.add(repository.findOne(id));
			}
		}

		return userList;
	}
	
}
