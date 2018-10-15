package com.example.demo4.pojo;

public class Mobile {
	int  id;
	static {
		System.out.println("--static-----");
	}
	String str=str11();
	static String staticString=staticString();
	public Mobile() {
		super();
		System.out.println("-Mobile()---super()------after------");
	}

	public String str11(){
		System.out.println("-str()-----");
		return "str";
	}
	public static String staticString(){
		System.out.println("--staticString()-----");
		return "staticString";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}