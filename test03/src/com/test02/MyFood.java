package com.test02;

public class MyFood {
	private Food favoriteFood;
	private Food unfavoriteFood;
	public MyFood() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyFood(Food favoriteFood, Food unfavoriteFood) {
		super();
		this.favoriteFood = favoriteFood;
		this.unfavoriteFood = unfavoriteFood;
	}
	public Food getFavoriteFood() {
		return favoriteFood;
	}
	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}
	public Food getUnfavoriteFood() {
		return unfavoriteFood;
	}
	public void setUnfavoriteFood(Food unfavoriteFood) {
		this.unfavoriteFood = unfavoriteFood;
	}
	@Override
	public String toString() {
		return "MyFood [favoriteFood=" + favoriteFood + ", unfavoriteFood=" + unfavoriteFood + "]";
	}
	
}
