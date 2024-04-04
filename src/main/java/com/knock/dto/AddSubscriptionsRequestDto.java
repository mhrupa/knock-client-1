package com.knock.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class AddSubscriptionsRequestDto {

	private String typeName;
	private String collectionName;
	private String subscriptionGroupId;

	private List<RecipientDto> recipients;

	private Map<String, Object> properties;
}
