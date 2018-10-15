package com.example.demo4.pojo;

public class Mobile22 extends Mobile{
	int  id;
	static {
		System.out.println("--static--222---");
	}
	String str=str();
	static String staticString=staticString();
	public Mobile22() {
		System.out.println("-Mobile()-222222--super()------after------");
	}

	public String str(){
		System.out.println("-str()---22222--");
		return "str";
	}
	public static String staticString(){
		System.out.println("--staticString()--2222---");
		return "staticString";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}