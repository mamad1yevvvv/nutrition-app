package com.example.nutritionapp.nutrition.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModelVersions{

	@JsonProperty("foodrec")
	private String foodrec;

	@JsonProperty("foodType")
	private String foodType;

	@JsonProperty("drinks")
	private String drinks;

	@JsonProperty("ingredients")
	private String ingredients;

	@JsonProperty("segmentation")
	private String segmentation;

	@JsonProperty("foodgroups")
	private String foodgroups;

	@JsonProperty("ontology")
	private String ontology;

	public String getFoodrec(){
		return foodrec;
	}

	public String getFoodType(){
		return foodType;
	}

	public String getDrinks(){
		return drinks;
	}

	public String getIngredients(){
		return ingredients;
	}

	public String getSegmentation(){
		return segmentation;
	}

	public String getFoodgroups(){
		return foodgroups;
	}

	public String getOntology(){
		return ontology;
	}
}