package com.example.nutritionapp.nutrition.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProcessedImageSize{

	@JsonProperty("width")
	private int width;

	@JsonProperty("height")
	private int height;

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}
}