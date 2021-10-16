package com.TVsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="channels")
public class Channel {

	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="url")
	private String URL;
	
	@Column(name="country")
	private String country;
	
	@Column(name="status")
	private String status;
	
	public Channel() {
		
	}


	public Channel(String name, String uRL, String country) {
		super();
		this.name = name;
		URL = uRL;
		this.country = country;
	}


	public Channel(String name, String uRL, String country, String status) {
		super();
		this.name = name;
		URL = uRL;
		this.country = country;
		this.status = status;
	}


	@Override
	public String toString() {
		return "Channel [name=" + name + ", URL=" + URL + ", country=" + country + "]";
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
