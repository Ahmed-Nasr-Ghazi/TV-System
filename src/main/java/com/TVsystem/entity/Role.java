	package com.TVsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Role {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "username")
	private String userName;

	@Column(name = "authority")
	private String authority;

	public Role() {
	}
	
	public Role(String string, String authority) {
		super();
		this.userName = string;
		this.authority = authority;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Role [userName=" + userName + ", authority=" + authority + "]";
	}

	
	
}
