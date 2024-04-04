package com.knock.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;


@Data
public class WorkflowTriggerRequestDto {

	String typeName;
	String key;
	Object actor;
	List<RecipientDto> recipients;
	String cancellationKey;
	String tenant;
	Map<String, Object> data;

}
