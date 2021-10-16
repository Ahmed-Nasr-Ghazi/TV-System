package com.TVsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name="email")
	@NotBlank(message = "required")
	@Email
	private String email;
	
	@Column(name = "username")
	@NotBlank(message = "required")
	private String userName;
	
	@Column(name="password")
	@NotBlank(message = "required")
	private String password;
	
	@Column(name="phone")
	@NotBlank(message = "required")
	@Pattern(regexp="^[0-9]{10}", message = "incorrect number")
	private String phone;
	
	@Column(name="enabled")
	private int enabled;

	
	public User(){
		
	}

	public User(String email, String userName, String password) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
	}



	@Override
	public String toString() {
		return "User [email=" + email + ", userName=" + userName + ", password=" + password + ", phone=" + phone
				+ ", enabled=" + enabled + "]";
	}

	public User(String email, String userName, String password, String phone) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
	}



	public User(@NotBlank(message = "required") @Email String email, @NotBlank(message = "required") String userName,
			@NotBlank(message = "required") String password,
			@NotBlank(message = "required") @Pattern(regexp = "^[0-9]{10}", message = "incorrect number") String phone,
			int enabled) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.enabled = enabled;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
