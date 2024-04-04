package com.knock.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionGroupDto {
	private String subscriptionGroupId;
	private String collectionName;
	private Map<String, Object> properties;
}