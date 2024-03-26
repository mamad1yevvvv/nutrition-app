package com.example.nutritionapp.nutrition.dto;

import com.example.nutritionapp.nutrition.model.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
@Getter
public class ResponseDTO{

	@JsonProperty("occasion")
	private String occasion;

	@JsonProperty("imageId")
	private int imageId;

	@JsonProperty("occasion_info")
	private OccasionInfo occasionInfo;

	@JsonProperty("processed_image_size")
	private ProcessedImageSize processedImageSize;

	@JsonProperty("foodType")
	private FoodType foodType;

	@JsonProperty("segmentation_results")
	private List<SegmentationResultsItem> segmentationResults;

	@JsonProperty("foodFamily")
	private List<FoodFamilyItem> foodFamily;

	@JsonProperty("model_versions")
	private ModelVersions modelVersions;

	}