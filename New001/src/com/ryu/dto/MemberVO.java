package com.ryu.dto;

public class MemberVO {
	private String id;
	private String pass;
	private String name;
	private int age;
	private String email;
		
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVO(String id, String pass, String name, int age, String email) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pass=" + pass + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}
	
	
}
