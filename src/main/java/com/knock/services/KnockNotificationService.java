package com.knock.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.knock.dto.RecipientDto;
import com.knock.dto.WorkflowTriggerRequestDto;
import com.knock.knockclient.KnockClientfactory;

import app.knock.api.model.WorkflowTriggerRequest;
import app.knock.api.model.WorkflowTriggerResponse;

@Service
public class KnockNotificationService {

	public WorkflowTriggerResponse triggerNotification(WorkflowTriggerRequestDto workflowTriggerRequestDto) {

		return KnockClientfactory.getKnockClient().workflows()
				.trigger(buildfWorkFlowTriggerRequest(workflowTriggerRequestDto));
	}

	private WorkflowTriggerRequest buildfWorkFlowTriggerRequest(WorkflowTriggerRequestDto request) {
		List<Object> recipientList = new ArrayList<Object>();

		for (RecipientDto recipient : request.getRecipients()) {
			recipientList
					.add(Map.of("id", recipient.getId(), "name", recipient.getName(), "email", recipient.getEmail()));
		}

		return WorkflowTriggerRequest.builder().key(request.getKey()).data(request.getData())
				.tenant(request.getTenant()).recipients(new ArrayList<Object>()).recipients(recipientList).build();
	}

}
