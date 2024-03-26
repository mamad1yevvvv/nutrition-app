package com.example.nutritionapp.nutrition.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContainedBbox{

	@JsonProperty("w")
	private int w;

	@JsonProperty("h")
	private int h;

	@JsonProperty("x")
	private int x;

	@JsonProperty("y")
	private int y;

	public int getW(){
		return w;
	}

	public int getH(){
		return h;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
}