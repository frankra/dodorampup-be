package com.sap.csc.dodorampup.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.sap.csc.dodorampup.model.AbstractModel;
import com.sap.csc.dodorampup.model.User;
import com.sap.csc.dodorampup.repository.AbstractModelRepository;

@Controller
@Transactional
public abstract class AbstractModelOperator<ID extends Serializable, T extends AbstractModel<ID>, R extends AbstractModelRepository<ID, T>> {

	protected R repository;

	private Logger logger = LoggerFactory.getLogger(AbstractModelOperator.class);

	@Autowired(required = false)
	private HttpServletRequest request;

	public AbstractModelOperator(R repository) {
		this.repository = repository;
	}

	public R getRepository() {
		return repository;
	}

	protected T beforeCreate(T instance) {
		return instance;
	}

	public T create(T instance) {

		loadReferences(instance);

		instance = validate(instance);

		instance = beforeCreate(instance);
		
		instance = repository.save(instance);

		instance = afterCreate(instance);

		logger.info(this.getCurrentUserINumber() + " created " + instance.getClass().getSimpleName() + " ID: "
				+ instance.getId());

		return instance;
	}

	/**
	 * @param instance
	 */

	protected void loadReferences(T instance) {
	}

	protected T afterCreate(T instance) {
		return instance;
	}

	protected T validate(T instance) {
		return instance;

	}

	protected void beforeUpdate(T existingInstance, T updatedInstance) {
	}

	public T update(ID id, T updatedInstance) {
		T existingInstance = repository.findOne(id);

		loadReferences(updatedInstance);

		beforeUpdate(existingInstance, updatedInstance);

		existingInstance = updateFields(existingInstance, updatedInstance);

		existingInstance = validate(existingInstance);
		
		existingInstance = repository.save(existingInstance);

		existingInstance = afterUpdate(existingInstance);

		logger.info(this.getCurrentUserINumber() + " updated " + existingInstance.getClass().getSimpleName() + " ID: "
				+ existingInstance.getId());

		return existingInstance;
	}

	public void afterRemoveAssociations(T instance) {
		afterUpdate(instance);
	}

	protected abstract T updateFields(T existingInstance, T updatedInstance);

	protected T afterUpdate(T instance) {
		return instance;
	}

	protected void beforeDelete(T instance) {
		removeReferences(instance);
	}

	protected void removeReferences(T instance) {
	}

	public T delete(ID id) {
		T instance = repository.findOne(id);
		return delete(instance);
	}

	public T delete(T instance) {

		beforeDelete(instance);

		repository.delete(instance);

		afterDelete(instance);

		logger.info(this.getCurrentUserINumber() + " deleted " + instance.getClass().getSimpleName() + " ID: "
				+ instance.getId());

		return instance;
	}

	public void checkDeletePermission(T instance) {
	}

	protected void afterDelete(T instance) {
	}

	protected void updateReferences(T deInstance, T paraInstance) {
	}

	private String getCurrentUserINumber() {
		try {
			User currentUser = (User) request.getSession().getAttribute("CurrentUser");
			return currentUser.getINumber();
		} catch (Exception e) {
			return new String("Unknown");
		}
	}
}