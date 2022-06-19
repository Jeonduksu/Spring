package com.test06;

public class Developer {
	//부모의 클래스를 필드로 가진다.
	//상속받으면 이저 관계
	//객체를받으면 해저 관계
	private Emp emp;
	private String dept;

	public Developer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Developer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return emp+", dept=" + dept;
	}
	
	
}
