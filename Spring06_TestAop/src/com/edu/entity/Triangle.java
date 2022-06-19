package com.edu.entity;

import org.springframework.stereotype.Component;

@Component
public class Triangle extends Shape{
	
	//삼각형
	public Triangle() {
		super();
	}

	public Triangle(String title, int width, int height) {
		super(title, width, height);
	}

	@Override
	public void viewSize() {
		System.out.println(getTitle() + "의 넓이 : " + (getWidth()*getHeight())/2);
	}

}
