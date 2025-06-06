package com.example.TenderManagementApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class RoleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String rolename;
	
	public RoleModel(int id, String rolename) {
		super();
		this.id = id;
		this.rolename = rolename;
	}

	public RoleModel(String rolename) {
		super();
		this.rolename = rolename;
	}

	public RoleModel(int id) {
		super();
		this.id = id;
	}

	public RoleModel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
	
}
