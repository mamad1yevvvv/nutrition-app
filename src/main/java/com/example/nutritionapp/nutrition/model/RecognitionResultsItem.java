package com.example.nutritionapp.nutrition.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RecognitionResultsItem{

	@JsonProperty("prob")
	private Object prob;

	@JsonProperty("foodType")
	private FoodType foodType;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("foodFamily")
	private List<FoodFamilyItem> foodFamily;

	@JsonProperty("subclasses")
	private List<Object> subclasses;

	public Object getProb(){
		return prob;
	}

	public FoodType getFoodType(){
		return foodType;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public List<FoodFamilyItem> getFoodFamily(){
		return foodFamily;
	}

	public List<Object> getSubclasses(){
		return subclasses;
	}
}