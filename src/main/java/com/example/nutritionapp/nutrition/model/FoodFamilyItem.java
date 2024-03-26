package com.example.nutritionapp.nutrition.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodFamilyItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("prob")
	private Object prob;

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public Object getProb(){
		return prob;
	}
}