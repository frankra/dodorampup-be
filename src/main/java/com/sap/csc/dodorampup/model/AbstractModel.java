package com.sap.csc.dodorampup.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;


/**
 * Root model for all entities, contains the logging methods and also an auto
 * generated ID
 * 
 * @author I834469, I834660
 *
 */
@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractModel<ID extends Serializable> implements Serializable {

	private static final long serialVersionUID = -3275552243704225648L;

	@TableGenerator(
	        name="idSequence", 
	        table="ID_GEN", 
	        pkColumnName="GEN_KEY", 
	        valueColumnName="GEN_VALUE", 
	        pkColumnValue="CURRENT_ID", 
	        allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="idSequence")
	@JsonView(View.Summary.class)
	protected ID id;

	public ID getId() {
		return id;
	}
	
	public void setId(ID id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		ID objId = ((AbstractModel<ID>) obj).getId();
		
		if (this.id == null && objId == null) {
			return true;
		}
		
		if (this.id != null && objId != null) {
			if (this.id.equals(objId)) {
				return true;
			}
		}
		
		return false;
	}

}