package com.sap.csc.dodorampup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "SysUser")
public class User extends AbstractModel<Long> {

	private static final long serialVersionUID = 7096653216365507869L;

	@Column(unique = true)
	@JsonView(View.Summary.class)
	private String iNumber;

	@Column
	@JsonView(View.Summary.class)
	private String firstName;

	@Column
	@JsonView(View.Summary.class)
	private String lastName;

	@Column
	@JsonView(View.Summary.class)
	private String email;

	public User() {
		super();
	}

	public String getINumber() {
		return iNumber;
	}

	public void setINumber(String iNumber) {
		this.iNumber = iNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}