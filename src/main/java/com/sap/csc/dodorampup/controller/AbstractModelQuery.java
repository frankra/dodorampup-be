package com.sap.csc.dodorampup.controller;

import java.io.Serializable;
import java.util.List;

import com.sap.csc.dodorampup.model.AbstractModel;
import com.sap.csc.dodorampup.repository.AbstractModelRepository;

public class AbstractModelQuery<ID extends Serializable, T extends AbstractModel<ID>, R extends AbstractModelRepository<ID, T>> {
	
	protected R repository;

	public AbstractModelQuery(R repository) {
        this.repository = repository;
    }

	public List<T> findAll() {
		return repository.findAll();
	}

	public T findOne(ID id) {
		T instance = repository.findOne(id);
		return instance;
	}
	
	public R getRepository() {
		return repository;
	}


}
