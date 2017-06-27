package com.ai.demos.model;

public class User {

	private String name;
	
	private String pwd;
	
	private String session;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
	
	public String toString(){
		String str = "name=" + getName() + ",pwd=" + getPwd() + ",session=" + getSession();
		return str;
	}
}
