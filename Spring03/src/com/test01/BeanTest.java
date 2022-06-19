package com.test01;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanTest {
	private MyClass myClass;
	
	public BeanTest() {
		System.out.println("기본생성자(no-args)");
	}
	
	public BeanTest(Date date) {
		System.out.println("날짜 생성자(data: "+ date+")");
	}
	
	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
		System.out.println("setMyClass() 호출");
	}
	
	public void setDate(Date date) {
		System.out.println("setDate() 호출: " + date);
	}
	
	public void setNumber(int num) {
		System.out.println("setNumber() 호출: " + num);
	}
	
	public void setArray(String[] arr) {
		System.out.println("setStudent() 호출");
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public void setList(List<String> list) {
		System.out.println("setList() 호출");
		for(String val : list) {
			System.out.println(val);
		}
	}
	
	public void setSet(Set<String> set) {
		System.out.println("setSet() 호출");
		for(String val : set) {
			System.out.println(val);
		}
	}
	
	public void setMap(Map<String,String> map) {
		System.out.println("setMap() 호출");
		Collection<String> values = map.values();
		for(String val: values) {
			System.out.println(val);
		}
	}
	
	public void setScore(List<Score> list) {
		System.out.println("setScore()호출");
		for(Score s: list) {
			System.out.println(s);
		}
	}
}
