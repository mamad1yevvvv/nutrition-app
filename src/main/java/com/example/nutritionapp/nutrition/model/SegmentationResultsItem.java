package com.example.nutritionapp.nutrition.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SegmentationResultsItem{

	@JsonProperty("contained_bbox")
	private ContainedBbox containedBbox;

	@JsonProperty("polygon")
	private List<Integer> polygon;

	@JsonProperty("center")
	private Center center;

	@JsonProperty("recognition_results")
	private List<RecognitionResultsItem> recognitionResults;

	@JsonProperty("food_item_position")
	private int foodItemPosition;

	public ContainedBbox getContainedBbox(){
		return containedBbox;
	}

	public List<Integer> getPolygon(){
		return polygon;
	}

	public Center getCenter(){
		return center;
	}

	public List<RecognitionResultsItem> getRecognitionResults(){
		return recognitionResults;
	}

	public int getFoodItemPosition(){
		return foodItemPosition;
	}
}