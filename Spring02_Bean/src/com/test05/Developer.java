package com.test05;

public class Developer extends Emp{
	private String dept;

	public Developer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Developer(String name,int salary) {
		super(name,salary);
	}
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString()+", dept=" + dept + "]";
	}
	
	
}
