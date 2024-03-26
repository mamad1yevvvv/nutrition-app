package com.example.nutritionapp.nutrition.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OccasionInfo{

	@JsonProperty("translation")
	private String translation;

	@JsonProperty("id")
	private Object id;

	public String getTranslation(){
		return translation;
	}

	public Object getId(){
		return id;
	}
}