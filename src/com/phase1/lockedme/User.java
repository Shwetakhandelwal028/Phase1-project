package com.phase1.lockedme;

import java.io.Serializable;

public class User implements Serializable {

	private String name;
	private String siteName;
	private String username;
	private String password;

	public User() {
	}

	public User(String name, String siteName, String username, String password) {
		super();
		this.name = name;
		this.siteName = siteName;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
