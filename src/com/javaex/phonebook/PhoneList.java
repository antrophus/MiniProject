package com.javaex.phonebook;

public class PhoneList {
	
	//필드
	private String name;
	private String hp;
	private String company;
	
	//생성자
	public PhoneList() {
		super();
	}
	public PhoneList(String name, String hp, String company) {
		super();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	//메소드 gs
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	//메소드 일반
	@Override
	public String toString() {
		return "PhoneList [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
	
	public void showInfo() {
		System.out.println();
		
	}


}
