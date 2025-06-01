package com.example.TenderManagementApplication.model;



import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class UserModel implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "Username")
	private String username;
	@Column(name = "Companyname")
	private String companyName;
	@Column(name = "password")
	private String password;
	@Column(name = "emial", unique = true)
	private String email;
	@ManyToOne
	@JoinColumn(name = "role" , referencedColumnName = "id",unique = false)
	private RoleModel role;
	
	public UserModel() {
		super();
	}
	
	public UserModel(int id, String username, String companyName, String password, String email, RoleModel role) {
		super();
		this.id = id;
		this.username = username;
		this.companyName = companyName;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	
	
	
	public UserModel(String username, String companyName, String password, String email, RoleModel role) {
		super();
		this.username = username;
		this.companyName = companyName;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public UserModel(int id, String username, String password, String email, RoleModel role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public UserModel(String username, String password, String email, RoleModel role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public UserModel(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return List.of(new SimpleGrantedAuthority("ROLE_"+this.getRole().getRolename()));
				
				
	}
	
	
	

}
