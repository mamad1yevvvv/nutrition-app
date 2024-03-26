package com.example.nutritionapp.nutrition.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Center{

	@JsonProperty("x")
	private int x;

	@JsonProperty("y")
	private int y;

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
}