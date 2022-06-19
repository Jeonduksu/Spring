package com.edu.entity;

import org.springframework.stereotype.Component;

@Component
public class Rectangle extends Shape{
	
	//직사각형
	public Rectangle() {
		super();
	}

	public Rectangle(String title, int width, int height) {
		super(title, width, height);
	}

	
	@Override
	public void viewSize() {
		System.out.println(getTitle() + "의 넓이 : " + (getWidth()*getHeight()));
	}

}
