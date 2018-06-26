package com.sap.csc.dodorampup.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sap.csc.dodorampup.model.User;

@Repository
public interface UserRepository extends AbstractModelRepository<Long, User> {

	public User findByINumber(String iNumber);

	public List<User> findAll();

}