package com.JÐÐÌìÏÂ.game;

public class User {
	private String name;
	private String pwd;
	private int score;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
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
	
	public User(String name, String pwd,int score) {
		this(name, pwd);
		this.score = score;
	}
	
	public User(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	
	public User() {	}
	
	@Override
	public String toString() {
		return String.format("%10s%25d\n", name,score);
	}
}